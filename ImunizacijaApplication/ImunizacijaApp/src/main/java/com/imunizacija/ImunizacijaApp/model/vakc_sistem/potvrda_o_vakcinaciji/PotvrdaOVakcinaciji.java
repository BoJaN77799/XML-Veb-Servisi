//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.08 at 06:14:28 PM CET 
//


package com.imunizacija.ImunizacijaApp.model.vakc_sistem.potvrda_o_vakcinaciji;

import com.imunizacija.ImunizacijaApp.model.vakc_sistem.IdentifiableEntity;
import com.imunizacija.ImunizacijaApp.model.vakc_sistem.util.Doza;
import com.imunizacija.ImunizacijaApp.model.vakc_sistem.util.LicniPodaciJMBG;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Podaci_o_primaocu" type="{http://www.vakc-sistem.rs/util}Licni_podaci_JMBG"/&gt;
 *         &lt;element name="Podaci_o_vakcini"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Zdravstvena_ustanova"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="Doza" type="{http://www.vakc-sistem.rs/util}Doza" maxOccurs="unbounded"/&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;element name="Datum_naredne_doze" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Podaci_o_potvrdi"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Datum_izdavanja" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="QRCode"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Sifra_potvrde" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "podaciOPrimaocu",
    "podaciOVakcini",
    "podaciOPotvrdi"
})
@XmlRootElement(name = "Potvrda_o_vakcinaciji")
public class PotvrdaOVakcinaciji implements IdentifiableEntity {

    @XmlElement(name = "Podaci_o_primaocu", required = true)
    protected LicniPodaciJMBG podaciOPrimaocu;
    @XmlElement(name = "Podaci_o_vakcini", required = true)
    protected PotvrdaOVakcinaciji.PodaciOVakcini podaciOVakcini;
    @XmlElement(name = "Podaci_o_potvrdi", required = true)
    protected PotvrdaOVakcinaciji.PodaciOPotvrdi podaciOPotvrdi;
    @XmlAttribute(name = "Sifra_potvrde", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger sifraPotvrde;

    @Override
    public String getXmlId() {
        return sifraPotvrde.toString();
    }

    @Override
    public void setXmlId(String id) {
        this.sifraPotvrde = new BigInteger(id);
    }

    /**
     * Gets the value of the podaciOPrimaocu property.
     *
     * @return
     *     possible object is
     *     {@link LicniPodaciJMBG }
     *
     */
    public LicniPodaciJMBG getPodaciOPrimaocu() {
        return podaciOPrimaocu;
    }

    /**
     * Sets the value of the podaciOPrimaocu property.
     *
     * @param value
     *     allowed object is
     *     {@link LicniPodaciJMBG }
     *
     */
    public void setPodaciOPrimaocu(LicniPodaciJMBG value) {
        this.podaciOPrimaocu = value;
    }

    /**
     * Gets the value of the podaciOVakcini property.
     *
     * @return
     *     possible object is
     *     {@link PotvrdaOVakcinaciji.PodaciOVakcini }
     *
     */
    public PotvrdaOVakcinaciji.PodaciOVakcini getPodaciOVakcini() {
        return podaciOVakcini;
    }

    /**
     * Sets the value of the podaciOVakcini property.
     *
     * @param value
     *     allowed object is
     *     {@link PotvrdaOVakcinaciji.PodaciOVakcini }
     *
     */
    public void setPodaciOVakcini(PotvrdaOVakcinaciji.PodaciOVakcini value) {
        this.podaciOVakcini = value;
    }

    /**
     * Gets the value of the podaciOPotvrdi property.
     *
     * @return
     *     possible object is
     *     {@link PotvrdaOVakcinaciji.PodaciOPotvrdi }
     *
     */
    public PotvrdaOVakcinaciji.PodaciOPotvrdi getPodaciOPotvrdi() {
        return podaciOPotvrdi;
    }

    /**
     * Sets the value of the podaciOPotvrdi property.
     *
     * @param value
     *     allowed object is
     *     {@link PotvrdaOVakcinaciji.PodaciOPotvrdi }
     *
     */
    public void setPodaciOPotvrdi(PotvrdaOVakcinaciji.PodaciOPotvrdi value) {
        this.podaciOPotvrdi = value;
    }

    /**
     * Gets the value of the sifraPotvrde property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSifraPotvrde() {
        return sifraPotvrde;
    }

    /**
     * Sets the value of the sifraPotvrde property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSifraPotvrde(BigInteger value) {
        this.sifraPotvrde = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Datum_izdavanja" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="QRCode"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;minLength value="1"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "datumIzdavanja",
        "qrCode"
    })
    public static class PodaciOPotvrdi {

        @XmlElement(name = "Datum_izdavanja", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar datumIzdavanja;
        @XmlElement(name = "QRCode", required = true)
        protected String qrCode;

        /**
         * Gets the value of the datumIzdavanja property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDatumIzdavanja() {
            return datumIzdavanja;
        }

        /**
         * Sets the value of the datumIzdavanja property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDatumIzdavanja(XMLGregorianCalendar value) {
            this.datumIzdavanja = value;
        }

        /**
         * Gets the value of the qrCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getQRCode() {
            return qrCode;
        }

        /**
         * Sets the value of the qrCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQRCode(String value) {
            this.qrCode = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Zdravstvena_ustanova"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;minLength value="1"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;sequence&gt;
     *           &lt;element name="Doza" type="{http://www.vakc-sistem.rs/util}Doza" maxOccurs="unbounded"/&gt;
     *         &lt;/sequence&gt;
     *         &lt;element name="Datum_naredne_doze" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "zdravstvenaUstanova",
        "doze",
        "datumNaredneDoze"
    })
    public static class PodaciOVakcini {

        @XmlElement(name = "Zdravstvena_ustanova", required = true)
        protected String zdravstvenaUstanova;
        @XmlElement(name = "Doza", required = true)
        protected List<Doza> doze;
        @XmlElement(name = "Datum_naredne_doze")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar datumNaredneDoze;

        /**
         * Gets the value of the zdravstvenaUstanova property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getZdravstvenaUstanova() {
            return zdravstvenaUstanova;
        }

        /**
         * Sets the value of the zdravstvenaUstanova property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setZdravstvenaUstanova(String value) {
            this.zdravstvenaUstanova = value;
        }

        /**
         * Gets the value of the doze property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the doze property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDoze().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Doza }
         * 
         * 
         */
        public List<Doza> getDoze() {
            if (doze == null) {
                doze = new ArrayList<Doza>();
            }
            return this.doze;
        }

        /**
         * Gets the value of the datumNaredneDoze property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDatumNaredneDoze() {
            return datumNaredneDoze;
        }

        /**
         * Sets the value of the datumNaredneDoze property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDatumNaredneDoze(XMLGregorianCalendar value) {
            this.datumNaredneDoze = value;
        }

    }

}