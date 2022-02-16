package com.imunizacija.ImunizacijaApp.controllers;

import com.imunizacija.ImunizacijaApp.model.vakc_sistem.saglasnost_za_imunizaciju.Saglasnost;
import com.imunizacija.ImunizacijaApp.service.SaglasnostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("api/saglasnost")
public class SaglasnostController {

    @Autowired
    private SaglasnostService saglasnostService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Saglasnost> findOne(@PathVariable String id) {
        Saglasnost saglasnost = saglasnostService.findOneById(id);
        if(saglasnost == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(saglasnost, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/kreirajNovuSaglasnost", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> createNewConsent(@RequestBody String saglasnost) {
        saglasnostService.createNewConsent(saglasnost);
        return new ResponseEntity<>("Saglasnost uspesno podneta!", HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> updateConsent(@RequestBody String saglasnost) {
        saglasnostService.updateConsent(saglasnost);
        return new ResponseEntity<>("Saglasnost uspesno dopunjena!", HttpStatus.OK);
    }
}
