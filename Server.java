import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.net.*;
public class Server {
    public static void main(String[] args) {
        try {
            //server connection and acceptance
            ServerSocket server = new ServerSocket(8000);
            System.out.println("connection established");
            Socket communication = server.accept();
            System.out.println("Client Accepted");

            //sending messages
            BufferedReader in = new BufferedReader(new InputStreamReader(communication.getInputStream()));
            PrintWriter out  = new PrintWriter(communication.getOutputStream());
            BufferedReader any = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;

                        while ((msg = any.readLine()) != null){
                            out.println(any.readLine()); 
                            if("/exit" .equals(msg)){
                                break;
                            }
                            out.close();
                        
                        }
            


            //receiving messages
            Runnable obj = ()->{
              try {
                 

                  String message = null;

                  while((message = in.readLine()) != null){
                      System.out.println("Client: "+message);
                  }

                  communication.close();
              } catch (IOException e) {
                  System.err.println("Error while receiving messages: " + e.getMessage());
              }

            };
            Thread t1 = new Thread(obj);
            t1.start();



        } catch (Exception e) {
            // TODO: handle exception
        }



















    //     try {
    //         ServerSocket server = new ServerSocket(8000);
    //         Socket communication = server.accept();
    //         // socketServer.setSoTimeout(10000);
    //         System.out.println("Server is running and waiting for a connection...");
    //         Socket clientSocket = socketServer.accept();
    //         System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

    //     } 
    //     catch (SocketException e) {
    //         System.out.println("Socket exception occurred: " + e.getMessage());
    //     }
    //     catch (SocketTimeoutException e) {
    //         e.printStackTrace();
    //     } catch (IOException e) {
    //         e.printStackTrace();
        
    //     // System.out.println("Hello, World!");
    // }
    }
}