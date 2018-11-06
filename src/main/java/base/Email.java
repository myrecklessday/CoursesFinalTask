package base;

import java.util.Random;

public class Email {
    public String getRandEmail() {
        String RANDCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder rand = new StringBuilder();
        Random rnd = new Random();
        while (rand.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * RANDCHARS.length());
            rand.append(RANDCHARS.charAt(index));
        }
        String randStr = rand.toString();
        return randStr +"@test.com";
    }
}
