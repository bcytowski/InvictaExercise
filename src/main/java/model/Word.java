package model;

import javax.xml.bind.annotation.XmlValue;


public class Word {


    private String word;

    public Word(String word) {
        this.word = word;
    }

    public Word(){

    }
    @XmlValue
    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return word;
    }
}
