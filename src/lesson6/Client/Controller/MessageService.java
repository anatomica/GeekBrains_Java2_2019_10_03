package lesson6.Client.Controller;
import javafx.scene.control.TextArea;

class MessageService {
    private static TextArea textArea;
    private Network network;

    MessageService(TextArea chatTextArea) {
        textArea = chatTextArea;
    }

    void setNetwork(Network network) {
        this.network = network;
    }

    void sendMessage(String message) {
        textArea.appendText("Я: " + message + System.lineSeparator());
        network.send(message);
    }

    static void receiveMessage(String message) {
        textArea.appendText("Сервер: " + message + System.lineSeparator());
    }
}