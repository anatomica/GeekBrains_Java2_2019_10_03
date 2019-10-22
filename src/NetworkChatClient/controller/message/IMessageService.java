package NetworkChatClient.controller.message;

public interface IMessageService {

    void sendMessage(String message);

    void processRetrievedMessage(String message);
}
