import model.Sentence;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException {
        // todo pass argument with file path
        FileParser fileParser = new FileParser();
        List<Sentence> sentenceList = fileParser.parseText();
        for (Sentence sentence : sentenceList) {
            System.out.println(sentence);
        }
        Converter xmlConverter = new XmlConverter();
        xmlConverter.generate(sentenceList);

//        Converter csvConverter = new CsvConverter();
//        csvConverter.generate(sentenceList);
    }
}
