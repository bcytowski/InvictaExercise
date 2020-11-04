package model;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlRootElement
@XmlSeeAlso(WrapperClass.class)
public class Sentence {

    @XmlElement(name = "word")
    private List<Word> words;


    public Sentence(List<Word> words) {
        this.words = words;
    }

    public Sentence(){

    }

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
