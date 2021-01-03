package lesson4.Task3;

public class Task3 {

    private final Object printer = new Object();
    private final Object scanner = new Object();


    public static void main(String[] args) {
        Documents doc1 = new Documents("Homework", 5);
        Documents doc2 = new Documents("Report", 4);
        Documents doc3 = new Documents("Analyse", 2);
        Documents doc4 = new Documents("Label", 1);

        Task3 task3 = new Task3();
        new Thread(() -> task3.printing(doc1)).start();
        new Thread(() -> task3.printing(doc2)).start();
        new Thread(() -> task3.printing(doc3)).start();
        new Thread(() -> task3.printing(doc4)).start();

        new Thread(() -> task3.scanning(doc1)).start();
        new Thread(() -> task3.scanning(doc2)).start();
        new Thread(() -> task3.scanning(doc3)).start();
        new Thread(() -> task3.scanning(doc4)).start();
    }

    public void printing(Documents doc) {
        synchronized (printer) {
            System.out.println("Документ " + doc.getName() + " отправлен на печать");
            try {
                Thread.sleep(50);
                for (int i = 0; i < doc.getNumberOfPages(); i++) {
                    System.out.println("Печать страницы " + (i+1));
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Печать документа " + doc.getName() + " завершена!");
        }
    }

    public void scanning(Documents doc) {
        synchronized (scanner) {
            System.out.println("Документ " + doc.getName() + " отправлен на сканирование");
            try {
                Thread.sleep(50);
                for (int i = 0; i < doc.getNumberOfPages(); i++) {
                    System.out.println("Сканирование страницы " + (i+1));
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Сканирование документа " + doc.getName() + " завершено!");
        }
    }
}
