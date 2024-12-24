import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

 public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
import java.util.*;

public class UniquePairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); 

        Set<String> uniquePairs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String first = scanner.next();
            String second = scanner.next();
            scanner.nextLine(); 

            uniquePairs.add(first + "," + second);

            System.out.println(uniquePairs.size());
        }
        scanner.close();
    }
}
   }
}
