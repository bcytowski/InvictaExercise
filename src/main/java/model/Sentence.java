package model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Sentence {

    private List<Word> sentence;


    public Sentence(List<Word> sentence) {
        this.sentence = sentence;
    }

    public Sentence(){

    }

    public List<Word> getSentence() {
        return sentence;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "sentence=" + sentence +
                '}';
    }
}
