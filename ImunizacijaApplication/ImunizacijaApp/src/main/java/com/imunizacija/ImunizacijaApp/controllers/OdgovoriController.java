package com.imunizacija.ImunizacijaApp.controllers;

import com.imunizacija.ImunizacijaApp.service.IzvestajiService;
import com.imunizacija.ImunizacijaApp.service.OdgovoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/odgovori")
public class OdgovoriController {

    @Autowired
    private OdgovoriService odgovoriService;

    @Autowired
    private IzvestajiService izvestajiService;

    @Autowired
    private RestTemplate restTemplate;

    //server.port = 9001
    @GetMapping(value = "/dobaviTermin")
    public ResponseEntity<String> getTermin() {
//        OdgovorTerminDTO odgovorTerminDTO = new OdgovorTerminDTO();
//        odgovorTerminDTO.setIndikator("Ne");
//        odgovorTerminDTO.setGrad("Beograd");
//        odgovorTerminDTO.getVakcine().add("Pfizer");
//        odgovorTerminDTO.getVakcine().add("Sputnik V");
//        odgovorTerminDTO.setEmail("manager2@maildrop.cc");
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", "application/xml");
//        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
//        HttpEntity<OdgovorTerminDTO> requestUpdate = new HttpEntity<>(odgovorTerminDTO, headers);
//
//        ResponseEntity<OdgovorTerminDTO> entity = restTemplate.exchange("http://localhost:9000/api/sistemski-magacin/dobaviTermin",
//                HttpMethod.POST, requestUpdate, OdgovorTerminDTO.class);
//
//        odgovoriService.azurirajOdgovor(entity.getBody());
//        return new ResponseEntity<>(entity.getBody(), HttpStatus.OK);

//        OdgovorTerminDTO odgovorTerminDTO = new OdgovorTerminDTO();
//        odgovorTerminDTO.setEmail("manager@maildrop.cc");
//        odgovoriService.izbrisiOdgovor(odgovorTerminDTO);

        this.izvestajiService.createReport("2022-02-15", "2022-02-17");
        return new ResponseEntity<>("bravo", HttpStatus.OK);
    }
}