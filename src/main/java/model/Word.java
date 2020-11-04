package model;

import javax.xml.bind.annotation.XmlValue;


public class Word {

    @XmlValue
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
