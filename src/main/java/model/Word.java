package model;

import javax.xml.bind.annotation.XmlElement;


public class Word {

    @XmlElement
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public Word(){

    }

    @Override
    public String toString() {
        return word;
    }
}
