import model.Sentence;
import model.Word;
import model.WrapperClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileParser {
    public WrapperClass parseAndSortText(String filePath) {
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

    private String getTextFromFile(String filePath) {
        String contents = null;
        try {
            contents = new String(Files.readAllBytes(Path.of(filePath).toAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents;
    }

}
