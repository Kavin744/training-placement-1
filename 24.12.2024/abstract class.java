import java.io.*;
import java.util.*;

abstract class Book {
    String title;
    abstract void setTitle(String s);
    String getTitle() {
        return title;
    }
}
class MyBook extends Book {
    @Override
    void setTitle(String s) {
        this.title = s;
    }
}
public class Solution {
    public static void main(String[] args) {
        MyBook new_novel = new MyBook();
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        new_novel.setTitle(title);
        System.out.println("The title is: " + new_novel.getTitle());
    }
}
