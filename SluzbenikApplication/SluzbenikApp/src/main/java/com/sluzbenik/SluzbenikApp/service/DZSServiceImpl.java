package com.sluzbenik.SluzbenikApp.service;


import com.sluzbenik.SluzbenikApp.model.dto.comunication_dto.SearchResults;
import com.sluzbenik.SluzbenikApp.model.vakc_sistem.digitalni_zeleni_sertifikat.DigitalniZeleniSertifikat;
import com.sluzbenik.SluzbenikApp.model.vakc_sistem.exception.DzsException;
import com.sluzbenik.SluzbenikApp.model.vakc_sistem.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.sluzbenik.SluzbenikApp.repository.rdfRepository.DzsExtractMetadata;
import com.sluzbenik.SluzbenikApp.repository.rdfRepository.DzsRdfRepository;
import com.sluzbenik.SluzbenikApp.repository.rdfRepository.RdfRepository;
import com.sluzbenik.SluzbenikApp.repository.xmlFileReaderWriter.GenericXMLReaderWriter;
import com.sluzbenik.SluzbenikApp.repository.xmlRepository.GenericXMLRepository;
import com.sluzbenik.SluzbenikApp.repository.xmlRepository.id_generator.IdGeneratorDZS;

import com.sluzbenik.SluzbenikApp.transformers.XML2HTMLTransformer;
import com.sluzbenik.SluzbenikApp.transformers.XSLFOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.xmldb.api.base.XMLDBException;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;

import static com.sluzbenik.SluzbenikApp.repository.Constants.*;
import static com.sluzbenik.SluzbenikApp.transformers.Constants.*;

@Service
public class DZSServiceImpl implements DZSService {

    @Autowired
    RdfRepository rdfRepository;

    @Autowired
    private GenericXMLRepository<DigitalniZeleniSertifikat> repository;

    @Autowired
    private GenericXMLReaderWriter<DigitalniZeleniSertifikat> repositoryReaderWriter;

    @Autowired
    GenericXMLReaderWriter<PotvrdaOVakcinaciji> potvrdaGenericReaderWriter;

    @Autowired
    DzsExtractMetadata dzsExtractMetadata;

    @Autowired
    private DzsRdfRepository dzsRdfRepository;

    @Autowired
    MailService mailService;

    @Autowired
    private XSLFOTransformer transformerXML2PDF;

    @Autowired
    private XML2HTMLTransformer transformerXML2HTML;

    @Autowired
    private RestTemplate restTemplate;

    public static final String URL_RESOURCE_ROOT = "dzs/";

    private static final String ID_PATH = "Broj_sertifikata";

    @PostConstruct
    private void postConstruct(){
        this.repository.setRepositoryParams(PACKAGE_PATH_DZS, COLLECTION_PATH_DZS, new IdGeneratorDZS(), DZS_NAMESPACE_PATH2);
        this.repositoryReaderWriter.setRepositoryParams(PACKAGE_PATH_DZS, XML_SCHEMA_PATH_DZS);
        this.potvrdaGenericReaderWriter.setRepositoryParams(PACKAGE_PATH_POTVRDA, XML_SCHEMA_PATH_POTVRDA);
    }

    @Override
    public DigitalniZeleniSertifikat findOneById(String id) {
        return repository.retrieveXML(id);
    }

    @Override
    public byte[] generateDZSPDF(String id) throws Exception {
        String resourceUrl = URL_ROOT + URL_RESOURCE_ROOT + id;
        return transformerXML2PDF.generatePDF(repository.retrieveXMLAsDOMNode(id), DZS_XSL_FO_PATH, resourceUrl);
    }

    @Override
    public String generateDZSHTML(String id) throws Exception {
        String resourceUrl = URL_ROOT + URL_RESOURCE_ROOT + id;
        String htmlString = transformerXML2HTML.generateHTML(repository.retrieveXMLAsDOMNode(id), DZS_XSL_PATH, resourceUrl);
        return htmlString;
    }

    @Override
    public void createDZS(String zahtevID, String idSluzbenika, String potvrdaXML, String userEmail) throws DzsException, DatatypeConfigurationException {
        PotvrdaOVakcinaciji potvrdaOVakcinaciji = potvrdaGenericReaderWriter.checkSchema(potvrdaXML);
        if (potvrdaOVakcinaciji == null)
            throw new DzsException("Nevalidan dokument potvrde dobavljen sa servisa!");

        DigitalniZeleniSertifikat dzs = new DigitalniZeleniSertifikat();

        DigitalniZeleniSertifikat.PodaciOPrimaocu podaciOPrimaocu = new DigitalniZeleniSertifikat.PodaciOPrimaocu();
        podaciOPrimaocu.setDrzavljanstvo(potvrdaOVakcinaciji.getPodaciOPrimaocu().getDrzavljanstvo());
        podaciOPrimaocu.setIme(potvrdaOVakcinaciji.getPodaciOPrimaocu().getIme());
        podaciOPrimaocu.setPrezime(potvrdaOVakcinaciji.getPodaciOPrimaocu().getPrezime());
        podaciOPrimaocu.setPol(potvrdaOVakcinaciji.getPodaciOPrimaocu().getPol());
        podaciOPrimaocu.setDatumRodjenja(potvrdaOVakcinaciji.getPodaciOPrimaocu().getDatumRodjenja());

        dzs.setPodaciOPrimaocu(podaciOPrimaocu);
        dzs.setIdSluzbenika(idSluzbenika);

        DigitalniZeleniSertifikat.PodaciOSertifikatu podaciOSertifikatu = new DigitalniZeleniSertifikat.PodaciOSertifikatu();

        podaciOSertifikatu.setDatumIzdavanjaSertifikata(DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.now().toString()));
        podaciOSertifikatu.setQrKod("qrkodic");

        dzs.setPodaciOSertifikatu(podaciOSertifikatu);
        dzs.getDoze().addAll(potvrdaOVakcinaciji.getPodaciOVakcini().getDoze());

        String dzsId = repository.storeXML(dzs, true);
        dzsExtractMetadata.extract(dzs, zahtevID, potvrdaOVakcinaciji.getXmlId());

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> requestUpdate = new HttpEntity<>(dzsId+"|"+potvrdaOVakcinaciji.getXmlId(), headers);
        ResponseEntity<String> entity = restTemplate
                .exchange("http://localhost:9001/api/potvrda/metapodaciODigitalnomZelenomSertifikatu",
                        HttpMethod.POST, requestUpdate, String.class);
        System.out.println("Odgovor: " + entity.getBody());
        // poziv na imunizaciju i sacuvati u rdf-potvrde idDzs-a

        try {
            mailService.sendDzs(this.generateDZSHTML(dzsId+".xml"), this.generateDZSPDF(dzsId+".xml"), userEmail);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while sending mail!");
        }
    }

    @Override
    public SearchResults searchDocuments(String userId, String searchText) throws XMLDBException {
        SearchResults searchResults;
        searchResults = repository.searchDocuments(userId, searchText, ID_PATH);
        this.dzsRdfRepository.getDzsWithReferences(searchResults);
        return searchResults;
    }

    @Override
    public List<String> getDzsOfUser(String id) {
        return rdfRepository.getDZSFromUser(id);
    }
    
    @Override
    public String generateDZSJSON(String id) throws IOException {
        return this.rdfRepository.generateJSON(DZS_NAMESPACE_PATH, id, DZS_NAMED_GRAPH_URI);
    }

    @Override
    public String generateDZSRDFTriplets(String id) {
        return this.rdfRepository.generateRDFTriplets(DZS_NAMESPACE_PATH, id, DZS_NAMED_GRAPH_URI);
    }
}
