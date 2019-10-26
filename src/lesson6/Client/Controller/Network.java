package lesson6.Client.Controller;
import javafx.application.Platform;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class Network {

    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    Network (String serverAddress, int port) throws IOException {
        Socket socket = new Socket(serverAddress, port);
        this.inputStream  = new DataInputStream(socket.getInputStream());
        this.outputStream = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            while (true) {
                try {
                    String message = inputStream.readUTF();
                    Platform.runLater(() -> MessageService.receiveMessage(message));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    void send (String message) {
        try {
            outputStream.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
