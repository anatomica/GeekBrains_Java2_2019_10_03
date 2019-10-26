package lesson6.Server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static Scanner scanner = new Scanner(System.in);
    private static DataInputStream in;
    private static DataOutputStream out;

    public static void main(String[] args) {
        Socket socket;
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread receiveMessage = new Thread(() -> {
                while (true) {
                    String str = null;
                    try {
                        str = in.readUTF();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (str.equals("/end")) {
                        break;
                    }
                    System.out.println("Клиент: " + str);
                }
            });
            receiveMessage.start();

            Thread sendMessage = new Thread(() -> {
                while (true) {
                    String serverMessage = scanner.nextLine();
                    try {
                        out.writeUTF(serverMessage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            sendMessage.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
