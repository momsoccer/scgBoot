package com.scg.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by KIMU on 2016. 7. 12..
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class JusoResult {
    @XmlElement(name = "common")
    private JusoCommon common;
    @XmlElement(name = "juso")
    private List<Juso> juso;

    //naver
    private int total;
    private String userquery;
    private List<Juso> item;


    public JusoCommon getCommon() {
        return common;
    }

    public void setCommon(JusoCommon common) {
        this.common = common;
    }

    public List<Juso> getJuso() {
        return juso;
    }

    public void setJuso(List<Juso> juso) {
        this.juso = juso;
    }
}
