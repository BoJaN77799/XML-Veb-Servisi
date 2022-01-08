//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.08 at 06:14:28 PM CET 
//


package com.imunizacija.ImunizacijaApp.model.vakc_sistem.interesovanje;

import com.imunizacija.ImunizacijaApp.model.vakc_sistem.IdentifiableEntity;
import com.imunizacija.ImunizacijaApp.model.vakc_sistem.util.Drzavljanstvo;
import com.imunizacija.ImunizacijaApp.model.vakc_sistem.util.Kontakt;

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
 *         &lt;element name="Drzavljanstvo" type="{http://www.vakc-sistem.rs/util}Drzavljanstvo"/&gt;
 *         &lt;element name="Ime"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="2"/&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Prezime"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="2"/&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Kontakt" type="{http://www.vakc-sistem.rs/util}Kontakt"/&gt;
 *         &lt;element name="Opstina_vakcinisanja"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="Vakcina" maxOccurs="unbounded"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;attribute name="Tip" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/sequence&gt;
 *         &lt;element name="Dobrovoljni_davalac"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="Da"/&gt;
 *               &lt;enumeration value="Ne"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Datum" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *       &lt;/sequence&gt;
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
    "drzavljanstvo",
    "ime",
    "prezime",
    "kontakt",
    "opstinaVakcinisanja",
    "vakcine",
    "dobrovoljniDavalac",
    "datum"
})
@XmlRootElement(name = "Interesovanje")
public class Interesovanje implements IdentifiableEntity {

    @XmlElement(name = "Drzavljanstvo", required = true)
    protected Drzavljanstvo drzavljanstvo;
    @XmlElement(name = "Ime", required = true)
    protected String ime;
    @XmlElement(name = "Prezime", required = true)
    protected String prezime;
    @XmlElement(name = "Kontakt", required = true)
    protected Kontakt kontakt;
    @XmlElement(name = "Opstina_vakcinisanja", required = true)
    protected String opstinaVakcinisanja;
    @XmlElement(name = "Vakcina", required = true)
    protected List<Interesovanje.Vakcina> vakcine;
    @XmlElement(name = "Dobrovoljni_davalac", required = true)
    protected String dobrovoljniDavalac;
    @XmlElement(name = "Datum", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlAttribute(name = "Id", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger id;

    @Override
    public String getXmlId() {
        return id.toString();
    }

    @Override
    public void setXmlId(String id) {
        this.id = new BigInteger(id);
    }

    /**
     * Gets the value of the drzavljanstvo property.
     *
     * @return
     *     possible object is
     *     {@link Drzavljanstvo }
     *
     */
    public Drzavljanstvo getDrzavljanstvo() {
        return drzavljanstvo;
    }

    /**
     * Sets the value of the drzavljanstvo property.
     *
     * @param value
     *     allowed object is
     *     {@link Drzavljanstvo }
     *
     */
    public void setDrzavljanstvo(Drzavljanstvo value) {
        this.drzavljanstvo = value;
    }

    /**
     * Gets the value of the ime property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIme(String value) {
        this.ime = value;
    }

    /**
     * Gets the value of the prezime property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Sets the value of the prezime property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPrezime(String value) {
        this.prezime = value;
    }

    /**
     * Gets the value of the kontakt property.
     *
     * @return
     *     possible object is
     *     {@link Kontakt }
     *
     */
    public Kontakt getKontakt() {
        return kontakt;
    }

    /**
     * Sets the value of the kontakt property.
     *
     * @param value
     *     allowed object is
     *     {@link Kontakt }
     *
     */
    public void setKontakt(Kontakt value) {
        this.kontakt = value;
    }

    /**
     * Gets the value of the opstinaVakcinisanja property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOpstinaVakcinisanja() {
        return opstinaVakcinisanja;
    }

    /**
     * Sets the value of the opstinaVakcinisanja property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOpstinaVakcinisanja(String value) {
        this.opstinaVakcinisanja = value;
    }

    /**
     * Gets the value of the vakcine property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vakcine property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVakcine().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Interesovanje.Vakcina }
     *
     *
     */
    public List<Interesovanje.Vakcina> getVakcine() {
        if (vakcine == null) {
            vakcine = new ArrayList<Interesovanje.Vakcina>();
        }
        return this.vakcine;
    }

    /**
     * Gets the value of the dobrovoljniDavalac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDobrovoljniDavalac() {
        return dobrovoljniDavalac;
    }

    /**
     * Sets the value of the dobrovoljniDavalac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDobrovoljniDavalac(String value) {
        this.dobrovoljniDavalac = value;
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
     *       &lt;attribute name="Tip" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Vakcina {

        @XmlAttribute(name = "Tip", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String tip;

        /**
         * Gets the value of the tip property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTip() {
            return tip;
        }

        /**
         * Sets the value of the tip property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTip(String value) {
            this.tip = value;
        }

    }

}
