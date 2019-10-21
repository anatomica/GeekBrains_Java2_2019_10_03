package lesson5.Homework;

public class MainClass {

    private static final int size = 10000000;
    private static final int h = size / 2;

    public static void main(String[] args) {

        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.currentTimeMillis();
        System.out.println("Время на проход всего массива в одном потоке:");
        System.out.println((System.currentTimeMillis() - a) + " мс.");

        myThread(arr);
    }

    private static void myThread(float[] arr) {
        long b = System.currentTimeMillis();

        float[] arr1 = new float[h];
        System.arraycopy(arr, 0, arr1, 0, h);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();

        float[] arr2 = new float[h];
        System.arraycopy(arr, h, arr2, 0, h);
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float) ((arr2[i] + h) * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
            }
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.currentTimeMillis();
        System.out.println("Время на общий проход по обоим массивам и склейки:");
        System.out.println((System.currentTimeMillis() - b) + " мс.");
    }
}
