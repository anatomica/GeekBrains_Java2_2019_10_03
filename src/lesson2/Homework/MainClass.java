package lesson2.Homework;

public class MainClass {

    public static void main(String[] args) {

        String[][] arrayStrings = new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        try {
            arrayMassive(arrayStrings);
        } catch (MyArraySizeException e) {
            System.out.println ("Неверный размер массива!!! ");
        }
    }


    private static void arrayMassive(String[][] args) throws MyArraySizeException {
        if (args.length != 4) {
            for (int i = 0; i < args.length; i++) {
                for (int j = 0; j < args.length; j++) {
                    System.out.print(args[i][j] + " ");
                }
            }
            System.out.println(" ");
            throw new MyArraySizeException ("Неверный размер массива! ");
        }
    }
}