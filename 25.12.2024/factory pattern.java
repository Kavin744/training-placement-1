import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine().trim();

            FoodFactory foodFactory = new FoodFactory();
            Food food = foodFactory.getFood(input);

            System.out.println("The factory returned class " + food.getClass().getSimpleName());
            System.out.println(food.getType());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

interface Food {
    String getType();
}

class Pizza implements Food {
    @Override
    public String getType() {
        return "Someone ordered Fast Food!";
    }
}

class Cake implements Food {
    @Override
    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

class FoodFactory {
    public Food getFood(String order) {
        if (order.equalsIgnoreCase("pizza")) {
            return new Pizza();
        } else if (order.equalsIgnoreCase("cake")) {
            return new Cake();
        } else {
            return null;
        }
    }
}
