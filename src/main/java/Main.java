import model.Sentence;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // todo pass argument with file path
        FileParser fileParser = new FileParser();
        List<Sentence> sentenceList = fileParser.parseText();

        Converter xmlConverter = new XmlConverter();
        xmlConverter.generate(sentenceList);

        Converter csvConverter = new CsvConverter();
        csvConverter.generate(sentenceList);
    }
}
