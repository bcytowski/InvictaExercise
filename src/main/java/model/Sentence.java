package model;

import java.util.List;

public class Sentence {
    private List<Word> sentence;

    public Sentence(List<Word> sentence) {
        this.sentence = sentence;
    }

    public List<Word> getSentence() {
        return sentence;
    }
}
