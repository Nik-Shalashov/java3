package lesson4;

public class Task1 {

    private final Object mon = new Object();
    private volatile char letter = 'C';

    public static void main(String[] args) {
        printLetters();
    }

    private static void printLetters() {
        Task1 task1 = new Task1();
        new Thread(task1::LetterA).start();
        new Thread(task1::LetterB).start();
        new Thread(task1::LetterC).start();
    }

    private void setLetter(char lttr) {
        this.letter = lttr;
    }

    private void print() {
        System.out.print(letter);
    }

    private void LetterA() {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (letter != 'C') {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                setLetter('A');
                print();
                mon.notifyAll();
            }
        }

    }

    private void LetterB() {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (letter != 'A') {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                setLetter('B');
                print();
                mon.notifyAll();
            }
        }

    }

    private void LetterC() {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (letter != 'B') {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                setLetter('C');
                print();
                mon.notifyAll();
            }
        }
    }

}
