//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.12 at 12:35:17 PM CET 
//


package com.sluzbenik.SluzbenikApp.model.vakc_sistem.digitalni_zeleni_sertifikat;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.sluzbenik.SluzbenikApp.model.vakc_sistem.IdentifiableEntity;
import com.sluzbenik.SluzbenikApp.model.vakc_sistem.util.DozaSaUstanovom;
import com.sluzbenik.SluzbenikApp.model.vakc_sistem.util.LicniPodaciJMBG;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Podaci_o_primaocu" type="{http://www.vakc-sistem.rs/util}Licni_podaci_JMBG"/>
 *         &lt;element name="Podaci_o_sertifikatu">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Broj_sertifikata">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;pattern value="[0-9]{7}"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Datum_izdavanja_sertifikata" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="Qr_kod">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;sequence>
 *           &lt;element name="Doza" type="{http://www.vakc-sistem.rs/util}Doza_sa_ustanovom" maxOccurs="unbounded"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="Id_sluzbenika" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="(0[1-9]|[12]\d|3[01])(0[1-9]|1[0-2])\d{3}\d{2}\d{4}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "podaciOPrimaocu",
    "podaciOSertifikatu",
    "doze"
})
@XmlRootElement(name = "Digitalni_zeleni_sertifikat")
public class DigitalniZeleniSertifikat implements IdentifiableEntity {

    @XmlElement(name = "Podaci_o_primaocu", required = true)
    protected LicniPodaciJMBG podaciOPrimaocu;
    @XmlElement(name = "Podaci_o_sertifikatu", required = true)
    protected PodaciOSertifikatu podaciOSertifikatu;
    @XmlElement(name = "Doza", required = true)
    protected List<DozaSaUstanovom> doze;
    @XmlAttribute(name = "Id_sluzbenika", required = true)
    protected String idSluzbenika;

    @Override
    public String getXmlId() {
        return podaciOSertifikatu.getBrojSertifikata();
    }

    @Override
    public void setXmlId(String id) {
        podaciOSertifikatu.setBrojSertifikata(id);
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
     * Gets the value of the podaciOSertifikatu property.
     * 
     * @return
     *     possible object is
     *     {@link PodaciOSertifikatu }
     *     
     */
    public PodaciOSertifikatu getPodaciOSertifikatu() {
        return podaciOSertifikatu;
    }

    /**
     * Sets the value of the podaciOSertifikatu property.
     * 
     * @param value
     *     allowed object is
     *     {@link PodaciOSertifikatu }
     *     
     */
    public void setPodaciOSertifikatu(PodaciOSertifikatu value) {
        this.podaciOSertifikatu = value;
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
     * {@link DozaSaUstanovom }
     * 
     * 
     */
    public List<DozaSaUstanovom> getDoze() {
        if (doze == null) {
            doze = new ArrayList<DozaSaUstanovom>();
        }
        return this.doze;
    }

    /**
     * Gets the value of the idSluzbenika property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSluzbenika() {
        return idSluzbenika;
    }

    /**
     * Sets the value of the idSluzbenika property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSluzbenika(String value) {
        this.idSluzbenika = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Broj_sertifikata">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;pattern value="[0-9]{7}"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Datum_izdavanja_sertifikata" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="Qr_kod">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "brojSertifikata",
        "datumIzdavanjaSertifikata",
        "qrKod"
    })
    public static class PodaciOSertifikatu {

        @XmlElement(name = "Broj_sertifikata", required = true)
        protected String brojSertifikata;
        @XmlElement(name = "Datum_izdavanja_sertifikata", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar datumIzdavanjaSertifikata;
        @XmlElement(name = "Qr_kod", required = true)
        protected String qrKod;

        /**
         * Gets the value of the brojSertifikata property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBrojSertifikata() {
            return brojSertifikata;
        }

        /**
         * Sets the value of the brojSertifikata property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBrojSertifikata(String value) {
            this.brojSertifikata = value;
        }

        /**
         * Gets the value of the datumIzdavanjaSertifikata property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDatumIzdavanjaSertifikata() {
            return datumIzdavanjaSertifikata;
        }

        /**
         * Sets the value of the datumIzdavanjaSertifikata property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDatumIzdavanjaSertifikata(XMLGregorianCalendar value) {
            this.datumIzdavanjaSertifikata = value;
        }

        /**
         * Gets the value of the qrKod property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getQrKod() {
            return qrKod;
        }

        /**
         * Sets the value of the qrKod property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQrKod(String value) {
            this.qrKod = value;
        }

    }

}
