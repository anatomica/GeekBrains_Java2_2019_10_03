package lesson2.Homework;

public class MainClass {
    private static int number;
    private static int result;
    private static String[][] arrayStrings = new String[][] {{"1", "2", "3", "4"},
            {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};

    public static void main(String[] args) {

        try {
            try {
                arrayMassive(arrayStrings);
            } catch (MyArraySizeException e) {
                System.out.println(" ");
                System.out.println("Неверный размер массива !!! ");
            }
        } catch (MyArrayDataException e) {
            System.out.println(" ");
            System.out.println ("Ошибка в ячейке " + number + " (значение не цифра) !!! ");
        }
    }

    private static void arrayMassive(String[][] args) throws MyArraySizeException, NumberFormatException {

        // arrayStrings.length - строки
        // arrayStrings[0].length - 1 колонка
        // arrayStrings[1].length - 2 колонка и т.д.
        if (arrayStrings.length != 4 || arrayStrings[0].length != 4 || arrayStrings[1].length != 4 ||
                arrayStrings[2].length != 4 || arrayStrings[3].length != 4) {
            for (String[] arg : arrayStrings) {
                for (int j = 0; j < arrayStrings.length; j++) {
                    System.out.print(arg[j] + " ");
                }
            }
            throw new MyArraySizeException("");
        }

        try {
            int count = 0;
            for (String[] arg : args) {
                for (int j = 0; j < args.length; j++) {
                    System.out.print(arg[j] + " ");
                    result = result + Integer.parseInt(arg[j]);
                    count++;
                    number = count + 1;
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("");
        }

        System.out.println(" ");
        System.out.println("Сумма чисел равна: " + result);
    }
}