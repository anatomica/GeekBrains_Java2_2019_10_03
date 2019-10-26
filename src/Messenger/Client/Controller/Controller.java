package Messenger.Client.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML public Button sendMessageButton;
    @FXML public TextField textMessage;
    @FXML public TextArea textArea;
    @FXML public MenuItem closeButton;
    @FXML public TextField loginField;
    @FXML public PasswordField passField;
    @FXML public HBox authPanel;
    @FXML public VBox chatPanel;

    private MessageService messageService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.messageService = new MessageService(this, true);
        } catch (Exception e) {
            showError(e);
        }
    }

    private void showError (Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Упс! ЧТо-то пошло не так!");
        alert.setHeaderText(e.getMessage());
        VBox dialogPaneContent = new VBox();
        Label label = new Label("Stack Trace:");
//        String stackTrace = ExceptionUtils.getStackTrace(e);
        TextArea textArea = new TextArea();
//        textArea.setText(stackTrace);
        dialogPaneContent.getChildren().addAll(label, textArea);
        // Set content for Dialog Pane
        alert.getDialogPane().setContent(dialogPaneContent);
        alert.setResizable(true);
        alert.showAndWait();
        e.printStackTrace();
    }

    @FXML
    private void closeButtonAction(){
        System.exit(0);
    }

    @FXML
    private void sendMessage (ActionEvent event) {
        sendMessageAction();
    }

    @FXML
    private void sendText (ActionEvent event) {
        sendMessageAction();
    }

    private void sendMessageAction() {
        String message = textMessage.getText();
        if (message.startsWith("/w")) {
            String[] privateMessage = message.split("\\s+", 3);
            String name = privateMessage[1];
            String lastMessage = privateMessage[2];
            textArea.appendText("Я [private] " + name + ": " + lastMessage + System.lineSeparator());
        } else {
            textArea.appendText("Я: " + message + System.lineSeparator());
        }
        messageService.sendMessage(message);
        textMessage.clear();
    }

    public void shutdown() {
        try {
            messageService.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void sendAuth (ActionEvent actionEvent) {
        String login = loginField.getText();
        String password = passField.getText();
        messageService.sendMessage(String.format("/auth %s %s", login, password));
    }
}