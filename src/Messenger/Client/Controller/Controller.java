package Messenger.Client.Controller;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML public Button button;
    @FXML public TextField textMessage;
    @FXML public TextArea textArea;
    @FXML public MenuItem closeButton;
    private MessageService messageService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        messageService = new MessageService(textArea);
        try {
            Network network = new Network("localhost", 8189, messageService);
            messageService.setNetwork(network);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Server connection error");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    @FXML
    private void closeButtonAction(){
        Platform.exit();
    }

    @FXML
    private void sendButtonAction(ActionEvent event) {
        sendMessage();
    }

    @FXML
    private void textAction (ActionEvent event) {
        sendMessage();
    }

    private void sendMessage() {
        String message = textMessage.getText();
        messageService.sendMessage(message);
        textMessage.clear();
    }
}