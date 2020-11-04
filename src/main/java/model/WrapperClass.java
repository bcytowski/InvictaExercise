package model;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlRootElement(name = "text")
@XmlAccessorType(XmlAccessType.FIELD)
public class WrapperClass {
    @XmlElement(name = "sentence")
    List<Sentence> sentenceList;

    public WrapperClass(List<Sentence> sentenceList) {
        this.sentenceList = sentenceList;
    }

    public WrapperClass(){

    }
}
