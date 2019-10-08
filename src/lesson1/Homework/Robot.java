package lesson1.Homework;

public class Robot implements Ability {

    @Override
    public double jump() {
        return 0.5;
    }

    @Override
    public int run() {
        return 20000;
    }
}
