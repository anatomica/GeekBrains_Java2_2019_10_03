package NetworkChatClient.controller;

import javafx.application.Platform;
import NetworkChatClient.controller.message.IMessageService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Network {

    private final Socket socket;
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public Network(String serverAddress, int port, IMessageService messageService) throws IOException {
        this.socket = new Socket(serverAddress, port);
        this.inputStream  = new DataInputStream(socket.getInputStream());
        this.outputStream = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            while (true) {
                try {
                    String message = inputStream.readUTF();
                    Platform.runLater(() -> messageService.processRetrievedMessage(message));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void send(String message) {
        try {
            outputStream.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
