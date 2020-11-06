import model.Sentence;
import model.WrapperClass;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // todo pass argument with file path
        String filePath = ".\\src\\main\\resources\\text.txt";
        FileParser fileParser = new FileParser();
        WrapperClass sentenceListWrapper = fileParser.parseAndSortText(filePath);

        for (Sentence sentence : sentenceListWrapper.getSentenceList()) {
            System.out.println(sentence);
        }
        Converter xmlConverter = new XmlConverter();
        xmlConverter.generate(sentenceListWrapper);

        Converter csvConverter = new CsvConverter();
        csvConverter.generate(sentenceListWrapper);
    }
}
