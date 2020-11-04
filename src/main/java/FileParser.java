import model.Sentence;
import model.Word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    public List<Sentence> parseText() {
        String filePath = ".\\src\\main\\resources\\text.txt";

        return parseSentencesAndWords(getTextFromFile(filePath));
    }


    private List<Sentence> parseSentencesAndWords(String text) {
        String[] sentences = text.split("\\.");

        List<Sentence> sentenceList = new ArrayList<>();

        for (String sentence : sentences) {
            String[] words = sentence.split("([^a-zA-Z']+)'*\\1*");

            List<Word> wordsList = new ArrayList<>();
            for (String w : words) {
                Word word = new Word(w);
                wordsList.add(word);
            }

            System.out.println(wordsList.toString());
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
