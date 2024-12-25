import java.io.*;
import java.lang.reflect.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine().trim());

        Solution.Inner inner = new Solution.Inner();
        Solution.Inner.Private innerPrivate = inner.new Private();

        System.out.println(num + " is " + (innerPrivate.powerof2(num) ? "power of 2" : "not a power of 2"));
        System.out.println("An instance of class: Solution.Inner.Private has been created");
    }

    static class Inner {
        private class Private {
            public boolean powerof2(int num) {
                return (num > 0) && ((num & (num - 1)) == 0);
            }
        }
    }
}
