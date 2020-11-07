import model.Sentence;
import model.WrapperClass;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String filePath = args[0];
        FileParser fileParser = new FileParser();
        WrapperClass sentenceListWrapper = fileParser.parseAndSortText(filePath);

        for (Sentence sentence : sentenceListWrapper.getSentenceList()) {
            System.out.println(sentence);
        }
        Converter xmlConverter = new XmlConverter();
        xmlConverter.generate(sentenceListWrapper, args[1]);

        Converter csvConverter = new CsvConverter();
        csvConverter.generate(sentenceListWrapper, args[2]);
    }
}
