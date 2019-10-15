package lesson4.Homework.Swing;
import javax.swing.*;

public class MainClass {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Messenger();
            }
        });
    }
}