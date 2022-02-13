import { Drzavljanstvo } from "src/modules/shared/models/Drzavljanstvo";
import { Kontakt } from "src/modules/shared/models/Kontakt";
import { LicniPodaciDetaljnije } from "src/modules/shared/models/LicniPodaci";

export interface Saglasnost {
    Saglasnost: {
        "@": {},
        Drzavljanstvo: Drzavljanstvo,
        Licni_podaci: LicniPodaciDetaljnije,
        Kontakt: Kontakt,
        Zaposlenje: { Radni_status: string, Zanimanje: string },
        Izjava: { Saglasan: string, Imunoloski_lek: string },
        Datum: string
    }
}