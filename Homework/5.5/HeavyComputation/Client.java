package HeavyComputation;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 23444);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        {
            Scanner scanner = new Scanner(System.in);
            String msg;
            while (true) {

                System.out.println("Введите номер числа Фибоначчи или введите 0 для завершения");
                try {
                    msg = scanner.nextLine();
                    out.println(msg);
                    if ("0".equals(msg)) break;
                    System.out.println("Запрашиваемое число " + in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
