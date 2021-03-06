package com.sluzbenik.SluzbenikApp.model.dto.termini_dto;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "value"
})
@XmlRootElement(name = "Termin")
public class TerminDTO {

    @XmlAttribute(name = "datum", required = true)
    protected String datum;

    @XmlValue
    @XmlSchemaType(name = "nonNegativeInteger")
    protected int value;

    public TerminDTO() {}

    @Override
    public String toString() {
        return "TerminDTO{" +
                "datum='" + datum + '\'' +
                ", value=" + value +
                '}';
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
