import model.Word;
import model.WrapperClass;

import java.io.*;
import java.util.stream.Collectors;

public class CsvConverter implements Converter {
    public void generate(WrapperClass sentenceListWrapper, String filePath) throws IOException {


        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filePath), "utf-8"))) {

            String sb = buildFirstLine(sentenceListWrapper);

            writer.write(sb);

            writer.write("\n");


            String s = buildRestOfTheLines(sentenceListWrapper);

            writer.write(s);

        }

    }


    private String buildFirstLine(WrapperClass sentenceListWrapper) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < sentenceListWrapper.getLongestSentenceLength() + 1; i++) {
            sb.append(", ");
            sb.append("Word ");
            sb.append(i);
        }
        return sb.toString();
    }

    private String buildRestOfTheLines(WrapperClass sentenceListWrapper) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentenceListWrapper.getSentenceList().size(); i++) {
            sb.append("Sentence ");
            sb.append(i + 1).append(", ").append(sentenceListWrapper.getSentenceList().get(i).getWords().stream()
                    .map(Word::toString).collect(Collectors.joining(", "))).append("\n");
        }
        return sb.toString();
    }
}
