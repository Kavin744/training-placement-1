import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static PerformOperation isOdd() {
        return (a) -> a % 2 != 0;
    }

    public static PerformOperation isPrime() {
        return (a) -> {
            if (a <= 1) return false;
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) return false;
            }
            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return (a) -> {
            String s = Integer.toString(a);
            return s.equals(new StringBuilder(s).reverse().toString());
        };
    }

    public boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            PerformOperation op;
            boolean result;
            switch (ch) {
                case 1:
                    op = MyMath.isOdd();
                    result = ob.checker(op, num);
                    System.out.println(result ? "ODD" : "EVEN");
                    break;
                case 2:
                    op = MyMath.isPrime();
                    result = ob.checker(op, num);
                    System.out.println(result ? "PRIME" : "COMPOSITE");
                    break;
                case 3:
                    op = MyMath.isPalindrome();
                    result = ob.checker(op, num);
                    System.out.println(result ? "PALINDROME" : "NOT PALINDROME");
                    break;
            }
        }
    }
}
