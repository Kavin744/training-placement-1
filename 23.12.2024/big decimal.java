import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] s = new String[n];
        
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextLine();
        }
        scanner.close();
        Arrays.sort(s, (a, b) -> {
            BigDecimal numA = new BigDecimal(a);
            BigDecimal numB = new BigDecimal(b);
            return numB.compareTo(numA);
        });
        for (String value : s) {
            System.out.println(value);
        }
    }
}
