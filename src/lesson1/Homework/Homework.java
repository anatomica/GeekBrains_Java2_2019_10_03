package lesson1.Homework;

public class Homework {

    public static void main(String[] args) {

        System.out.println("Задание 1.1");
        Human human = new Human();
        System.out.println("Человек может прыгнуть на: " + human.jump() + " м.");
        System.out.println("А пробежать может: " + human.run() + " м.\n");

        Cat cat = new Cat();
        System.out.println("Кошка может прыгнуть на: " + cat.jump() + " м.");
        System.out.println("А пробежать может: " + cat.run() + " м.\n");

        Robot robot = new Robot();
        System.out.println("Робот может прыгнуть на: " + robot.jump() + " м.");
        System.out.println("А пробежать может: " + robot.run() + " м.\n");

        System.out.println("Задание 1.2");
        Wall wall = new Wall();
        Treadmill treadmill = new Treadmill();

        // Человек
        if (human.run() >= treadmill.getDistance())
            System.out.println("Человек успешно пробежал на беговой дорожке " + treadmill.getDistance() + " м.");
        else
            System.out.println("Человек не смог пробежать на беговой дорожке " + treadmill.getDistance() + " м.");
        if (human.jump() >= wall.getHeight())
            System.out.println("Человек успешно перепрыгнул стену высотой " + wall.getHeight() + " м.\n");
        else
            System.out.println("Человек не смог перепрыгнуть стену высотой " + wall.getHeight() + " м.\n");

        // Кошка
        if (cat.run() >= treadmill.getDistance())
            System.out.println("Кошка успешно пробежала на беговой дорожке " + treadmill.getDistance() + " м.");
        else
            System.out.println("Кошка не смогла пробежать на беговой дорожке " + treadmill.getDistance() + " м.");
        if (cat.jump() >= wall.getHeight())
            System.out.println("Кошка успешно перепрыгнула стену высотой " + wall.getHeight() + " м.\n");
        else
            System.out.println("Кошка не смога перепрыгнуть стену высотой " + wall.getHeight() + " м.\n");

        // Робот
        if (robot.run() >= treadmill.getDistance())
            System.out.println("Робот успешно пробежал на беговой дорожке " + treadmill.getDistance() + " м.");
        else
            System.out.println("Робот не смог пробежать на беговой дорожке " + treadmill.getDistance() + " м.");
        if (robot.jump() >= wall.getHeight())
            System.out.println("Робот успешно перепрыгнул стену высотой " + wall.getHeight() + " м.\n");
        else
            System.out.println("Робот не смог перепрыгнуть стену высотой " + wall.getHeight() + " м.\n");

        System.out.println("Задание 1.3");
        // Забег участников
        Ability[] arrayParticipants= new Ability[3];
        arrayParticipants[0] = new Human();
        arrayParticipants[1] = new Cat();
        arrayParticipants[2] = new Robot();

        // Забег атлетов
        Participants[] participantsArray = new Participants[5];
        participantsArray[0] = new Participants("Макс", 8000, 1.5);
        participantsArray[1] = new Participants("Олег", 7000, 1.4);
        participantsArray[2] = new Participants("Витя", 6000, 1.3);
        participantsArray[3] = new Participants("Иван", 5000, 1.2);
        participantsArray[4] = new Participants("Шура", 4000, 1.1);

        // Препядствия
        Obstacles[] obstaclesArray = new Obstacles[3];
        obstaclesArray[0] = new Obstacles(1000, 1);
        obstaclesArray[1] = new Obstacles(5500, 1.25);
        obstaclesArray[2] = new Obstacles(7500, 1.35);

        System.out.println("Забег участников:");
        for (int i = 0; i < arrayParticipants.length; i++) {
            for (int j = 0; j < obstaclesArray.length; j++) {
                if ((arrayParticipants[i].jump() < obstaclesArray[j].getHeight()) ||
                        (arrayParticipants[i].run() < obstaclesArray[j].getDistance())) {
                    System.out.println("К сожалению участнику " + (i + 1) + " не удалось преодолеть " + (j + 1) + " барьер испытаний!");
                    break;
                }
            }
        }

        System.out.println(" ");
        System.out.println("Забег атлетов:");
        for (int i = 0; i < participantsArray.length; i++) {
            for (int j = 0; j < obstaclesArray.length; j++) {
                if ((participantsArray[i].getDistanceJump() < obstaclesArray[j].getHeight()) ||
                        (participantsArray[i].getDistanceRun() < obstaclesArray[j].getDistance())) {
                    System.out.println("К сожалению атлету " + participantsArray[i].getName() +
                            " не удалось преодолеть " + (j + 1) + " барьер испытаний!");
                    break;
                }
                else if ((participantsArray[i].getDistanceJump() >= obstaclesArray[j].getHeight()) &&
                        (participantsArray[i].getDistanceRun() >= obstaclesArray[j].getDistance()) && j == 2) {
                    System.out.println("Поздравляем атлета " + participantsArray[i].getName() +
                            ", которому удалось всё одолеть!");
                }
            }
        }
    }
}
