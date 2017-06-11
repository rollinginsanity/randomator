/**
 * Created by rollinginsanity on 11/6/17.
 */
package net.rollinginsanity.randomator;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class that handles creating random names in the NSA style of adjective_noun.
 */
public class Randomator {
    private String adjectiveFile = "/adjectives.txt";
    private String nounFile = "/nouns.txt";
    private ArrayList<String> adjectives;
    private ArrayList<String> nouns;
    private Random randomGenerator;

    public Randomator() {

        randomGenerator = new Random();

        adjectives = getListFromResourceFile(adjectiveFile);
        nouns = getListFromResourceFile(nounFile);

    }

    public String getRandomName() {
        return getRandomNameElement(adjectives)+"_"+getRandomNameElement(nouns);
    }

    private String getRandomNameElement(ArrayList<String> nameElement) {
        int randomIndex = randomGenerator.nextInt(nameElement.size());
        return nameElement.get(randomIndex);
    }

    private ArrayList<String> getListFromResourceFile(String fileName) {
        ArrayList<String> outputList = new ArrayList<>();
        InputStream fileIs = getClass().getResourceAsStream(fileName);
        InputStreamReader fileSr = new InputStreamReader(fileIs);
        BufferedReader fileBr = new BufferedReader(fileSr);
        String line;
        try {
            while ((line = fileBr.readLine()) != null) {
                outputList.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return outputList;
    }
}
