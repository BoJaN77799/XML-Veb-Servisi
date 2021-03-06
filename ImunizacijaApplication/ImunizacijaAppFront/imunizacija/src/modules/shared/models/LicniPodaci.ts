import { Adresa } from "./Adresa";
import { Drzavljanstvo } from "./Drzavljanstvo";

export /* abstract */ interface LicniPodaci {
    Ime: { "@": { }, 
        "#": string},
    Prezime: { "@": { },
        "#": string},
    Datum_rodjenja: { "@": { },
        "#": string},
    Pol: { "@": { }, 
        "#": string},
}

export interface LicniPodaciJmbg extends LicniPodaci {
    JMBG: { "@": { },
        "#": string},
}

export interface LicniPodaciJmbgBrPasosa extends LicniPodaciJmbg {
    Broj_pasosa: { "@": { },
        "#": string},
}

export interface LicniPodaciDetaljnije extends LicniPodaci {
    Ime_roditelja: { "@": { },
        "#": string},
    Mesto_rodjenja: { "@": { },
        "#": string},
    Adresa: Adresa  
}

export interface Podnosilac extends LicniPodaci {
    Drzavljanstvo: Drzavljanstvo
}