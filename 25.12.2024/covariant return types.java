import java.io.*;
import java.util.*;

class Flower {
    String whatsYourName() {
        return "I have many names and types.";
    }
}

class Jasmine extends Flower {
    @Override
    String whatsYourName() {
        return "Jasmine";
    }
}

class Lily extends Flower {
    @Override
    String whatsYourName() {
        return "Lily";
    }
}

class Lotus extends Flower {
    @Override
    String whatsYourName() {
        return "Lotus";
    }
}

class State {
    Flower yourNationalFlower() {
        return new Flower();
    }
}

class WestBengal extends State {
    @Override
    Lotus yourNationalFlower() {
        return new Lotus();
    }
}

class Karnataka extends State {
    @Override
    Jasmine yourNationalFlower() {
        return new Jasmine();
    }
}

class AndhraPradesh extends State {
    @Override
    Lily yourNationalFlower() {
        return new Lily();
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stateName = scanner.nextLine();
        State state;
        switch (stateName) {
            case "WestBengal":
                state = new WestBengal();
                break;
            case "Karnataka":
                state = new Karnataka();
                break;
            case "AndhraPradesh":
                state = new AndhraPradesh();
                break;
            default:
                state = new State();
                break;
        }
        System.out.println(state.yourNationalFlower().whatsYourName());
    }
}
