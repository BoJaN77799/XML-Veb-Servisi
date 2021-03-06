package com.sluzbenik.SluzbenikApp.controllers;

import com.sluzbenik.SluzbenikApp.service.DZSService;
import com.sluzbenik.SluzbenikApp.service.IzvestajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/generisanje")
public class GenDocumentsController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DZSService dzsService;

    @Autowired
    private IzvestajService izvestajService;

    @GetMapping(value = "/pdf/{docType}/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generatePDF(@PathVariable String docType, @PathVariable String id) {
        if (docType.equals("dzs")){ //uga buga
            try {
                byte[] pdfBytes = dzsService.generateDZSPDF(id);
                return new ResponseEntity<>(pdfBytes, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } else if (docType.equals("izvestaji")) {
            try {
                byte[] pdfBytes = izvestajService.generateIzvestajPDF(id);
                return new ResponseEntity<>(pdfBytes, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/pdf");
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);

        try {
            ResponseEntity<byte[]> entity = restTemplate.getForEntity("http://localhost:9001/api/" + docType + "/generatePDF/" + id,
                    byte[].class);
            return new ResponseEntity<>(entity.getBody(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/xhtml/{docType}/{id}", produces = MediaType.TEXT_XML_VALUE)
    public ResponseEntity<String> generateHTML(@PathVariable String docType, @PathVariable String id) {
        if (docType.equals("dzs")){ //uga buga
            try {
                return new ResponseEntity<>(dzsService.generateDZSHTML(id), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>("Error HTML transforming.", HttpStatus.NOT_FOUND);
            }
        } else if (docType.equals("izvestaji")) {
            try {
                return new ResponseEntity<>(izvestajService.generateIzvestajHTML(id), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/html");
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:9001/api/" + docType + "/generateHTML/" + id,
                    String.class);
            return new ResponseEntity<>(entity.getBody(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/json/{docType}/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> generateJSON(@PathVariable String docType, @PathVariable String id) {
        if (docType.equals("dzs")){ //uga buga
            try {
                return new ResponseEntity<>(dzsService.generateDZSJSON(id), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>("Error HTML transforming.", HttpStatus.NOT_FOUND);
            }
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/html");
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:9001/api/" + docType + "/generateJSON/" + id,
                    String.class);
            return new ResponseEntity<>(entity.getBody(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/rdf/{docType}/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> generateRDF(@PathVariable String docType, @PathVariable String id) {
        if (docType.equals("dzs")){ //uga buga
            try {
                return new ResponseEntity<>(dzsService.generateDZSRDFTriplets(id), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>("Error HTML transforming.", HttpStatus.NOT_FOUND);
            }
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/html");
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:9001/api/" + docType + "/generateRDFTriplets/" + id,
                    String.class);
            return new ResponseEntity<>(entity.getBody(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
