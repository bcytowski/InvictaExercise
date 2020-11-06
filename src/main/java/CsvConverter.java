import model.WrapperClass;

import java.io.*;

public class CsvConverter implements Converter {
    public void generate(WrapperClass sentenceListWrapper) throws IOException {


        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(".\\src\\main\\resources\\file.csv"), "utf-8"))) {

            String sb = buildFirstLine(sentenceListWrapper);

            writer.write(sb);

            writer.write("\n");

            for (int i = 0; i < sentenceListWrapper.getSentenceList().size(); i++) {

            }

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
}
