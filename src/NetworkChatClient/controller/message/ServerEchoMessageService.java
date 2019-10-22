package NetworkChatClient.controller.message;
import javafx.scene.control.TextArea;
import NetworkChatClient.controller.Network;

public class ServerEchoMessageService implements IMessageService {

    private final TextArea chatTextArea;
    private Network network;

    public ServerEchoMessageService(TextArea chatTextArea) {
        this.chatTextArea = chatTextArea;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    @Override
    public void sendMessage(String message) {
        network.send(message);
    }

    @Override
    public void processRetrievedMessage(String message) {
        chatTextArea.appendText(message + System.lineSeparator());
    }
}
