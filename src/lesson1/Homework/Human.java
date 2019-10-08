package lesson1.Homework;

public class Human implements Ability {

    @Override
    public double jump() {
        return 1.30;
    }

    @Override
    public int run() {
        return 6000;
    }

    public double getJump() {
        return jump();
    }

    public int getRun() {
        return run();
    }
}
