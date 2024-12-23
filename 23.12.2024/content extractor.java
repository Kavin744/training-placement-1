import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String line = scanner.nextLine();
            boolean found = false;
            
            Pattern pattern = Pattern.compile("<([a-zA-Z][^>]*)>([^<]+)</\\1>");
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                System.out.println(matcher.group(2));
                found = true;
            }
            if (!found) {
                System.out.println("None");
            }
        }
        scanner.close();
    }
}
