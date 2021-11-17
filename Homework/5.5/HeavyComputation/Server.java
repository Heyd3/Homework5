package HeavyComputation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {


        ServerSocket servSocket = new ServerSocket(23444);

        while (true) {
            try (Socket socket = servSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                String str;
                int n;
                int n0 = 1;
                int n1 = 1;
                int n2 = 0;
                while ((str = in.readLine()) != null) {
                    n = Integer.parseInt (str);
                    if (n==1 || n==2){
                        n = 1;
                        out.println(String.valueOf(n));
                    } else {
                    for (int i = 3; i < (n + 1); i++){
                       n2 = n0 + n1;
                       n0 = n1;
                       n1 = n2;
                    }
                    out.println(String.valueOf(n2));
                    }
                    n0 = 1;
                    n1 = 1;
                    n2 = 0;
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}
