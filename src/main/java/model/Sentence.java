package model;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlRootElement
@XmlSeeAlso(WrapperClass.class)
public class Sentence {


    private List<Word> words;


    public Sentence(List<Word> words) {
        this.words = words;
    }

    public Sentence(){

    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
    @XmlElement(name = "word")
    public List<Word> getWords() {
        return words;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "sentence=" + words +
                '}';
    }
}
