import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num1 = Integer.parseInt(br.readLine().trim());
            int num2 = Integer.parseInt(br.readLine().trim());
            int num3 = Integer.parseInt(br.readLine().trim());
            int num4 = Integer.parseInt(br.readLine().trim());
            int num5 = Integer.parseInt(br.readLine().trim());

            Prime prime = new Prime();
            prime.checkPrime(num1);
            prime.checkPrime(num1, num2);
            prime.checkPrime(num1, num2, num3);
            prime.checkPrime(num1, num2, num3, num4, num5);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Prime {
    public void checkPrime(int... numbers) {
        boolean printed = false;
        for (int num : numbers) {
            if (isPrime(num)) {
                System.out.print(num + " ");
                printed = true;
            }
        }
        if (printed) {
            System.out.println();
        } else {
            System.out.println();
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
