//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.04 at 10:57:53 PM CET 
//


package com.sluzbenik.SluzbenikApp.model.vakc_sistem.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Doza_sa_ustanovom complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Doza_sa_ustanovom"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.vakc-sistem.rs/util}Doza"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Ustanova"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Doza_sa_ustanovom", propOrder = {
    "ustanova"
})
public class DozaSaUstanovom
    extends Doza
{

    @XmlElement(name = "Ustanova", required = true)
    protected String ustanova;

    /**
     * Gets the value of the ustanova property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUstanova() {
        return ustanova;
    }

    /**
     * Sets the value of the ustanova property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUstanova(String value) {
        this.ustanova = value;
    }

}
