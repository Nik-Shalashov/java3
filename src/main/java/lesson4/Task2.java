package lesson4;

import java.io.*;

public class Task2 {

    private final Object mon = new Object();
    private final File file = new File("src/main/resources/forLesson3Task2.txt");

    public static void main(String[] args) {
        printers();
    }

    private static void printers() {
        Task2 task2 = new Task2();
        new Thread(task2::printer1).start();
        new Thread(task2::printer2).start();
        new Thread(task2::printer3).start();
    }

    private void printer1() {
        synchronized (mon) {
                try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
                    String text = "Method 1 write this\n";
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(20);
                        out.write(text);
                    }

                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    private void printer2() {
        synchronized (mon) {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
                String text = "Method 2 write this\n";
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(20);
                    out.write(text);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printer3() {
        synchronized (mon) {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
                String text = "Method 3 write this\n";
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(20);
                    out.write(text);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
