package lesson4.Homework.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;

public class FXMLDocumentController {

    @FXML
    public Button button;
    @FXML
    public TextField textMessage;
    @FXML
    public TextArea textArea;
    @FXML
    public MenuItem closeButton;

    @FXML
    private void closeButtonAction(){
        System.exit(0);
    }

    @FXML
    private void sendButtonAction(ActionEvent event) {
        addText();
    }

    @FXML
    private void textAction (ActionEvent event) {
        addText();
    }

    private void addText() {
        textArea.appendText(textMessage.getText()+"\n");
        textMessage.setText("");
    }
}