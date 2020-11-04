import model.Sentence;

import java.util.List;

public interface Converter {
    void generate(List<Sentence> sentenceList);
}
