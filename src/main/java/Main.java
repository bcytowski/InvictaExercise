import model.CsvConverter;
import model.Sentence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // todo pass argument with file path
        FileParser fileParser = new FileParser();
        List<Sentence> sentenceList = fileParser.parseText();

        XmlConverter xmlConverter = new XmlConverter();
        xmlConverter.generateXML(sentenceList);

        CsvConverter csvConverter = new CsvConverter();
        csvConverter.generateCSV(sentenceList);
    }
}
