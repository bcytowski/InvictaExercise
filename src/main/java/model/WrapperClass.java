package model;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlRootElement(name = "text")
@XmlAccessorType(XmlAccessType.FIELD)
public class WrapperClass {
    @XmlElement(name = "sentence")
    List<Sentence> sentenceList;
    @XmlTransient
    private int longestSentenceLength;

    public List<Sentence> getSentenceList() {
        return sentenceList;
    }

    public void setSentenceList(List<Sentence> sentenceList) {
        this.sentenceList = sentenceList;
    }


    public int getLongestSentenceLength() {
        return longestSentenceLength;
    }

    public void setLongestSentenceLength(int longestSentenceLength) {
        this.longestSentenceLength = longestSentenceLength;
    }

    public WrapperClass(List<Sentence> sentenceList, int longestSentenceLength) {
        this.sentenceList = sentenceList;
        this.longestSentenceLength = longestSentenceLength;
    }

    public WrapperClass(){

    }
}
