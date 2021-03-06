package com.imunizacija.ImunizacijaApp.controllers;

import com.imunizacija.ImunizacijaApp.model.app_users.KorisniciListDTO;
import com.imunizacija.ImunizacijaApp.model.app_users.RegistrationDTO;
import com.imunizacija.ImunizacijaApp.model.app_users.UserException;
import com.imunizacija.ImunizacijaApp.model.dto.comunication_dto.DzsList;
import com.imunizacija.ImunizacijaApp.model.dto.rdf_dto.DocumentsOfUserDTO;
import com.imunizacija.ImunizacijaApp.model.dto.rdf_dto.DocumentsOfUserWithDZSDTO;
import com.imunizacija.ImunizacijaApp.repository.rdfRepository.RdfRepository;
import com.imunizacija.ImunizacijaApp.security.UserTokenState;
import com.imunizacija.ImunizacijaApp.model.vakc_sistem.korisnik.Korisnik;
import com.imunizacija.ImunizacijaApp.repository.xmlRepository.KorisnikRepository;
import com.imunizacija.ImunizacijaApp.security.TokenUtils;
import com.imunizacija.ImunizacijaApp.security.auth.JwtAuthenticationRequest;
import com.imunizacija.ImunizacijaApp.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RestTemplate restTemplate;


    //todo izbrisati ova dva dole kasnije
    //sluze samo kao endpoint za dodavanje nekih basic korisnika, jos nisam napravio registraciju

    @Autowired
    KorisnikRepository korisnikRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Korisnik> findOne(@PathVariable String id) {
        Korisnik korisnik = korisnikService.findOneById(id);
        if(korisnik == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(korisnik, HttpStatus.OK);
    }

    @PostMapping("/test-create-citizen")
    public String createUserCitizenTest() throws UserException{
        //endpoint za kreiranje basic gradjanina
        Korisnik korisnik = new Korisnik();
		korisnik.setKorisnikID("12345");
		korisnik.setIme("Djura");
		korisnik.setPrezime("Peric");
		korisnik.setTipKorisnika("CITIZEN");
		korisnik.setEmail("djura123@gmail.com");
		korisnik.setLozinka(passwordEncoder.encode("djura123"));

		korisnikRepository.insertUser(korisnik);

		return "Gucci citizen";
    }

    @PostMapping("/test-create-doctor")
    public String createUserDoctorTest() throws UserException{
        //endpoint za kreiranje basic doktora
        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnikID("123456");
        korisnik.setIme("Djura");
        korisnik.setPrezime("Peric");
        korisnik.setTipKorisnika("DOCTOR");
        korisnik.setEmail("djura1234@gmail.com");
        korisnik.setLozinka(passwordEncoder.encode("djura123"));

        korisnikRepository.insertUser(korisnik);

        return "Gucci doctor";
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<KorisniciListDTO> getAll(){
        KorisniciListDTO listDTO = new KorisniciListDTO();
        try {
            listDTO.setKorisnikBasicInfoDTOListFromKorisnici(korisnikService.getCitizens());
            return new ResponseEntity<>(listDTO, HttpStatus.OK);
        } catch (UserException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping(value = "/dokumentacija/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<DocumentsOfUserDTO> getDocumentationForUserByOfficial(@PathVariable String id){
        return new ResponseEntity<>(korisnikService.getDocumentsOfUser(id), HttpStatus.OK);
    }

    @GetMapping(value = "/dokumentacija_za_korisnika/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<DocumentsOfUserWithDZSDTO> getDocumentationForUserByUser(@PathVariable String id){
        try {
            DocumentsOfUserDTO documentsOfUserDTO = korisnikService.getDocumentsOfUser(id);
            ResponseEntity<DzsList> entity = restTemplate.getForEntity("http://localhost:9000/api/dzs/odKorisnika/" + id, DzsList.class);
            if (entity.getBody() == null){
                throw new RuntimeException("Error");
            }
            DocumentsOfUserWithDZSDTO documentsOfUserWithDZSDTO = new DocumentsOfUserWithDZSDTO(documentsOfUserDTO);
            documentsOfUserWithDZSDTO.setDzsList(entity.getBody().getDzsList());
            return new ResponseEntity<>(documentsOfUserWithDZSDTO, HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/registracija", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> registerUser(@RequestBody RegistrationDTO registrationDTO) {
        try {
            Korisnik korisnik = korisnikService.registerUser(registrationDTO);
        } catch (UserException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Uspesno registrovan!", HttpStatus.CREATED);
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<UserTokenState> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
                                                                    HttpServletResponse response) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()));

        // Ubaci korisnika u trenutni security kontekst
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Kreiraj token za tog korisnika
        Korisnik user = (Korisnik) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getKorisnikID(), user.getTipKorisnika(), user.getEmail());
        int expiresIn = tokenUtils.getExpiredIn();

        // Vrati token kao odgovor na uspesnu autentifikaciju
        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
    }

}
