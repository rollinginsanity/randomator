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
    //These are the files in the resources/ folder.
    private String adjectiveFile = "/adjectives.txt";
    private String nounFile = "/nouns.txt";

    //Where we store our goodies.
    private ArrayList<String> adjectives;
    private ArrayList<String> nouns;

    //Random numbers are important.
    private Random randomGenerator;

    /**
     * Default constructor.
     */
    public Randomator() {
        randomGenerator = new Random();
        adjectives = getListFromResourceFile(adjectiveFile);
        nouns = getListFromResourceFile(nounFile);

    }

    /**
     * Gets a random name. It calls the getRandomNameElement() function on our adjectives and nouns arrays.
     * @return This returns the random name.
     */
    public String getRandomName() {
        return getRandomNameElement(adjectives)+"_"+getRandomNameElement(nouns);
    }

    /**
     * This function gets an element from either the noun or adjective array. To be glued together elsewhere.
     * @param nameElement An ArrayList containing the values we want to pick from randomly.
     * @return This returns a random element from the ArrayList that was passed in.
     */
    private String getRandomNameElement(ArrayList<String> nameElement) {
        int randomIndex = randomGenerator.nextInt(nameElement.size());
        return nameElement.get(randomIndex);
    }

    /**
     * Generates an arraylist from a list of lines in a resource file (in this case adjectives.txt and nouns.txt.)
     * @param fileName The name of the resource file to load in to an ArrayList.
     * @return An Arraylist containing the values from the resource file.
     */
    private ArrayList<String> getListFromResourceFile(String fileName) {
        //Does the needful.
        //Just joining the dots Stream->StreamReader->BufferedReader.
        ArrayList<String> outputList = new ArrayList<>();
        InputStream fileIs = getClass().getResourceAsStream(fileName);
        InputStreamReader fileSr = new InputStreamReader(fileIs);
        BufferedReader fileBr = new BufferedReader(fileSr);
        String line;
        //Loop through and add values to a list.
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
