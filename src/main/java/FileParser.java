import model.Sentence;
import model.Word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    public List<Sentence> parseText() {
        String filePath = "C:\\Users\\zajaw\\IdeaProjects\\InvictaExercise\\src\\main\\resources\\text.txt";


        String contents = null;
        try {
            contents = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }


        String[] sentences = contents.split("\\.");

        List<Sentence> sentenceList = new ArrayList<>();

        for (String sentence : sentences) {
            String[] words = sentence.split("([^a-zA-Z']+)'*\\1*");

            List<Word> wordsList = new ArrayList<>();
            for (String word : words) {
                Word ble = new Word(word);
                wordsList.add(ble);
            }

            System.out.println(wordsList.toString());
            sentenceList.add(new Sentence(wordsList));


            //  String replace = sentence.replaceAll("\\s+", " ");
            //  String replace1 = replace.replaceAll("”|“","");
            //  String finalSentence = replace1.trim();
            //  clearedSentences.add(finalSentence);
        }


//        for (String clearedSentence : clearedSentences) {
//            System.out.println(clearedSentence);
//        }


        return sentenceList;
    }
}
