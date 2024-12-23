import java.io.*;
import java.util.*;

class MyRegex {
    String pattern = "((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\.){3}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])";
}
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String ip = scanner.nextLine();
            System.out.println(ip.matches(new MyRegex().pattern));
        }
        scanner.close();
    }
}
