//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.04 at 10:57:53 PM CET 
//


package com.sluzbenik.SluzbenikApp.model.vakc_sistem.izvestaj;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="Broj_dokumenata_o_interesovanju"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;minInclusive value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Broj_pristiglih_zahteva_za_DZS"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;minInclusive value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Broj_izdatih_zahteva_za_DZS"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;minInclusive value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Broj_primljenih_vakcina"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;minInclusive value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Broj_primnljenih_novovakcinisanih"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;minInclusive value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Proizvodjaci"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Vakcina" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;nonNegativeInteger"&gt;
 *                           &lt;attribute name="Naziv_proizvodjaca" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Datum" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Od" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *       &lt;attribute name="Do" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "brojDokumenataOInteresovanju",
    "brojPristiglihZahtevaZaDZS",
    "brojIzdatihZahtevaZaDZS",
    "brojPrimljenihVakcina",
    "brojPrimnljenihNovovakcinisanih",
    "proizvodjaci",
    "datum"
})
@XmlRootElement(name = "Izvestaj")
public class Izvestaj {

    @XmlElement(name = "Broj_dokumenata_o_interesovanju")
    protected int brojDokumenataOInteresovanju;
    @XmlElement(name = "Broj_pristiglih_zahteva_za_DZS")
    protected int brojPristiglihZahtevaZaDZS;
    @XmlElement(name = "Broj_izdatih_zahteva_za_DZS")
    protected int brojIzdatihZahtevaZaDZS;
    @XmlElement(name = "Broj_primljenih_vakcina")
    protected int brojPrimljenihVakcina;
    @XmlElement(name = "Broj_primnljenih_novovakcinisanih")
    protected int brojPrimnljenihNovovakcinisanih;
    @XmlElement(name = "Proizvodjaci", required = true)
    protected Izvestaj.Proizvodjaci proizvodjaci;
    @XmlElement(name = "Datum", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlAttribute(name = "Od", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar od;
    @XmlAttribute(name = "Do", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar _do;
    @XmlAttribute(name = "Id", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger id;

    /**
     * Gets the value of the brojDokumenataOInteresovanju property.
     * 
     */
    public int getBrojDokumenataOInteresovanju() {
        return brojDokumenataOInteresovanju;
    }

    /**
     * Sets the value of the brojDokumenataOInteresovanju property.
     * 
     */
    public void setBrojDokumenataOInteresovanju(int value) {
        this.brojDokumenataOInteresovanju = value;
    }

    /**
     * Gets the value of the brojPristiglihZahtevaZaDZS property.
     * 
     */
    public int getBrojPristiglihZahtevaZaDZS() {
        return brojPristiglihZahtevaZaDZS;
    }

    /**
     * Sets the value of the brojPristiglihZahtevaZaDZS property.
     * 
     */
    public void setBrojPristiglihZahtevaZaDZS(int value) {
        this.brojPristiglihZahtevaZaDZS = value;
    }

    /**
     * Gets the value of the brojIzdatihZahtevaZaDZS property.
     * 
     */
    public int getBrojIzdatihZahtevaZaDZS() {
        return brojIzdatihZahtevaZaDZS;
    }

    /**
     * Sets the value of the brojIzdatihZahtevaZaDZS property.
     * 
     */
    public void setBrojIzdatihZahtevaZaDZS(int value) {
        this.brojIzdatihZahtevaZaDZS = value;
    }

    /**
     * Gets the value of the brojPrimljenihVakcina property.
     * 
     */
    public int getBrojPrimljenihVakcina() {
        return brojPrimljenihVakcina;
    }

    /**
     * Sets the value of the brojPrimljenihVakcina property.
     * 
     */
    public void setBrojPrimljenihVakcina(int value) {
        this.brojPrimljenihVakcina = value;
    }

    /**
     * Gets the value of the brojPrimnljenihNovovakcinisanih property.
     * 
     */
    public int getBrojPrimnljenihNovovakcinisanih() {
        return brojPrimnljenihNovovakcinisanih;
    }

    /**
     * Sets the value of the brojPrimnljenihNovovakcinisanih property.
     * 
     */
    public void setBrojPrimnljenihNovovakcinisanih(int value) {
        this.brojPrimnljenihNovovakcinisanih = value;
    }

    /**
     * Gets the value of the proizvodjaci property.
     * 
     * @return
     *     possible object is
     *     {@link Izvestaj.Proizvodjaci }
     *     
     */
    public Izvestaj.Proizvodjaci getProizvodjaci() {
        return proizvodjaci;
    }

    /**
     * Sets the value of the proizvodjaci property.
     * 
     * @param value
     *     allowed object is
     *     {@link Izvestaj.Proizvodjaci }
     *     
     */
    public void setProizvodjaci(Izvestaj.Proizvodjaci value) {
        this.proizvodjaci = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

    /**
     * Gets the value of the od property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOd() {
        return od;
    }

    /**
     * Sets the value of the od property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOd(XMLGregorianCalendar value) {
        this.od = value;
    }

    /**
     * Gets the value of the do property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDo() {
        return _do;
    }

    /**
     * Sets the value of the do property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDo(XMLGregorianCalendar value) {
        this._do = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
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
     *         &lt;element name="Vakcina" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;nonNegativeInteger"&gt;
     *                 &lt;attribute name="Naziv_proizvodjaca" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
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
        "vakcina"
    })
    public static class Proizvodjaci {

        @XmlElement(name = "Vakcina", required = true)
        protected List<Izvestaj.Proizvodjaci.Vakcina> vakcina;

        /**
         * Gets the value of the vakcina property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the vakcina property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVakcina().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Izvestaj.Proizvodjaci.Vakcina }
         * 
         * 
         */
        public List<Izvestaj.Proizvodjaci.Vakcina> getVakcina() {
            if (vakcina == null) {
                vakcina = new ArrayList<Izvestaj.Proizvodjaci.Vakcina>();
            }
            return this.vakcina;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;nonNegativeInteger"&gt;
         *       &lt;attribute name="Naziv_proizvodjaca" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Vakcina {

            @XmlValue
            @XmlSchemaType(name = "nonNegativeInteger")
            protected BigInteger value;
            @XmlAttribute(name = "Naziv_proizvodjaca", required = true)
            protected String nazivProizvodjaca;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setValue(BigInteger value) {
                this.value = value;
            }

            /**
             * Gets the value of the nazivProizvodjaca property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNazivProizvodjaca() {
                return nazivProizvodjaca;
            }

            /**
             * Sets the value of the nazivProizvodjaca property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNazivProizvodjaca(String value) {
                this.nazivProizvodjaca = value;
            }

        }

    }

}
