package raf;

import java.io.IOException;

/**
 * Created by Eugene on 20.09.2016.
 */
public class Main {
    // создаем экземпляр класса что мы создали
    private static WorkWithFile worker;

    public static void main(String[] args) throws IOException {
        // инициализируем класс передавая в него путь к файлу
        // так как мой файл лежит в корне проекта, то я просто указываю его имя
        worker = new WorkWithFile("testfile.txt");

        // пишем передаваемый текст в файл
        worker.write("Give me a break from your take and your take. \n" +
                "Come on and give me a break,\n" +
                "what do you want from me?\n" +
                "Feeding the rich with that son of a bitch.\n" +
                "Well that son of a bitch,\n" +
                "he looks just like me!\n" +
                "Yeah, yeah");

        System.out.println("*******");

        // читаем весь файл
        System.out.println(worker.read());
        System.out.println("*******");

        // читаем файл с указанного символа
        System.out.println(worker.readFrom(105));
    }
}
