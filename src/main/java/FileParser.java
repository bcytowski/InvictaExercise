import model.Sentence;
import model.Word;
import model.WrapperClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileParser {
    public WrapperClass parseAndSortText(String filePath) throws IOException {
        return parseAndSort(getTextFromFile(filePath));
    }

    private WrapperClass parseAndSort(String text) {
        String[] sentences = text.split("\\.");

        List<Sentence> sentenceList = new ArrayList<>();
        int longestSentenceLength = 0;

        for (String sentence : sentences) {

            String[] words = sentence.split("\\W+");

            List<Word> wordsList = new ArrayList<>();
            for (String w : words) {
                if (!w.isBlank()) {
                    Word word = new Word(w);
                    wordsList.add(word);
                }
            }
            if (!wordsList.isEmpty()) {
                List<Word> wordList = sortWords(wordsList);
                sentenceList.add(new Sentence(wordList));
                if (wordList.size() > longestSentenceLength) {
                    longestSentenceLength = wordList.size();
                }
            }
        }
        return new WrapperClass(sentenceList, longestSentenceLength);
    }

    private List<Word> sortWords(List<Word> wordsList) {
        return wordsList.stream()
                .sorted(Comparator.comparing(o -> o.getWord().toLowerCase()))
                .collect(Collectors.toList());
    }

    private String getTextFromFile(String filePath) throws IOException {
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            StringBuilder sb = new StringBuilder();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }

            return sb.toString();

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }

        }
    }

}
