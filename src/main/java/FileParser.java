import model.Sentence;
import model.Word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    public List<Sentence> parseText(String filePath) {

        return parseSentencesAndWords(getTextFromFile(filePath));
    }


    private List<Sentence> parseSentencesAndWords(String text) {
        String[] sentences = text.split("\\.");

        List<Sentence> sentenceList = new ArrayList<>();

        for (String sentence : sentences) {

            String[] words = sentence.toLowerCase().trim().split("\\W+");

            List<Word> wordsList = new ArrayList<>();
            for (String w : words) {
                Word word = new Word(w);
                wordsList.add(word);
            }


            sentenceList.add(new Sentence(wordsList));

        }
        return sentenceList;
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
