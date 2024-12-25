import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine().trim();

            Singleton singleton = Singleton.getSingleInstance();
            singleton.str = input;

            System.out.println("Hello I am a singleton! Let me say " + singleton.str + " to you");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Singleton {
    public String str;

    private static Singleton singleInstance = null;

    private Singleton() {
    }

    public static Singleton getSingleInstance() {
        if (singleInstance == null) {
            singleInstance = new Singleton();
        }
        return singleInstance;
    }
}
