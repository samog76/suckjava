import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try(Socket Client = new Socket("localhost", 8000);
        PrintWriter out = new PrintWriter(Client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(Client.getInputStream());
        Scanner pen = new Scanner(System.in))) {
            Thread recievThread = new Thread() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("server:" + message);
                    }
                } catch (Exception e) {
                    System.err.println("error receiving message:" + e.getMessage());
                }
            }};
            receiveThread.start();

            String useInput;
            



            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
         