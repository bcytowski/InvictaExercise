import model.Sentence;
import model.WrapperClass;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface Converter {
    void generate(WrapperClass sentenceListWrapper) throws IOException;
}
