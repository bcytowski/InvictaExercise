import model.Sentence;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface Converter {
    void generate(List<Sentence> sentenceList) throws JAXBException;
}
