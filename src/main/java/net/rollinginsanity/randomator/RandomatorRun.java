/**
 * Created by rollinginsanity on 11/6/17.
 */
package net.rollinginsanity.randomator;

/**
 * This class just instanciates the Randomator class, and outputs a random name value.
 * This class is only here to facilitate some output if the class is called.
 */
public class RandomatorRun {
    /**
     * Just runs the Randomator class and prints a random name.
     * @param args
     */
    public static void main(String[] args) {
        Randomator randomator = new Randomator();
        System.out.println(randomator.getRandomName());
    }
}
