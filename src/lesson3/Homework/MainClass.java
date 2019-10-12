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
        System.out.println(" ");

        // Задание 3.2
        PhoneBook phonebook = new PhoneBook();
        phonebook.add("Макс", "111222");
        phonebook.add("Олег", "111333");
        phonebook.add("Витя", "111444");
        phonebook.add("Рома", "111555");
        phonebook.add("Ника", "111666");
        phonebook.add("Ника", "111777");

        phonebook.get("Макс");
        phonebook.get("Олег");
        phonebook.get("Ника");

    }
}