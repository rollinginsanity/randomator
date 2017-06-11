Randomator
==========

If you want random NSA styled names, this is the thing for you.

I can't promise it's efficient, I'm not a good java dev.
I can't promise the code is readable, I'm not a good java dev.
I can't promise it will work in all situations. I'm not a good java dev.

Otherwise have fun.

To run:

`java -jar randomator-jar-file.jar`

Or to include in your own work as a dependency:

```java
import net.rollinginsanity.randomator.Randomator;

public class RandomTest {
    public static void main(String[] args) {
        Randomator randomName = new Randomator();
        System.out.println(randomName.getRandomName());
    }
}
```