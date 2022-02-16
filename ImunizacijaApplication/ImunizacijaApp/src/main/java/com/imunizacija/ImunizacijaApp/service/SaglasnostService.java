package com.imunizacija.ImunizacijaApp.service;


import com.google.zxing.WriterException;
import com.imunizacija.ImunizacijaApp.model.vakc_sistem.saglasnost_za_imunizaciju.Saglasnost;
import com.imunizacija.ImunizacijaApp.model.dto.comunication_dto.SearchResults;
import org.xmldb.api.base.XMLDBException;

import javax.xml.transform.TransformerException;
import java.io.IOException;

public interface SaglasnostService {

    Saglasnost findOneById(String id);

    void createNewConsent(String Saglasnost);

    byte[] generateSaglasnostPDF(String id) throws Exception;

    String generateSaglasnostHTML(String id) throws TransformerException, IOException, WriterException;

    SearchResults searchUserDocumentsJmbg(String jmbg, String searchText) throws XMLDBException;

    SearchResults searchUserDocumentsPasos(String brojPasosa, String searchText) throws XMLDBException;
}
