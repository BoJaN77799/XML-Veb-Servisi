package com.imunizacija.ImunizacijaApp.service;

import com.imunizacija.ImunizacijaApp.model.dto.comunication_dto.SearchResults;
import com.imunizacija.ImunizacijaApp.model.vakc_sistem.potvrda_o_vakcinaciji.PotvrdaOVakcinaciji;
import com.imunizacija.ImunizacijaApp.model.vakc_sistem.saglasnost_za_imunizaciju.Saglasnost;
import org.xmldb.api.base.XMLDBException;

import javax.mail.MessagingException;
import javax.xml.datatype.DatatypeConfigurationException;

public interface PotvrdaService {
    PotvrdaOVakcinaciji findOneById(String id);

    byte[] generatePotvrdaPDF(String id) throws Exception;

    String generatePotvrdaHTML(String id) throws Exception;

    void generatePotvrdaOVakcinaciji(Saglasnost s) throws DatatypeConfigurationException, MessagingException;

    SearchResults searchDocuments(String userId, String searchText) throws XMLDBException;
}
