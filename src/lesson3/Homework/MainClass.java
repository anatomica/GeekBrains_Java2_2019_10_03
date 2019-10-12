package lesson3.Homework;
import java.util.HashMap;

public class MainClass {
    public static void main(String[] args) {
        String[] words =
                {"A", "A", "B", "C", "C", "C", "D", "D", "E", "F", "G", "G", "G"};
        HashMap <String, Integer> arrayWords = new HashMap<>();
        for (String i : words) {
            arrayWords.put(i, arrayWords.getOrDefault(i, 0) + 1);
        }
        System.out.println(arrayWords);
    }
}
