package lesson4.Homework.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLDocumentController {

    @FXML
    public Button button;
    @FXML
    public TextField textMessage;
    @FXML
    public TextArea textArea;

    @FXML
    private void buttonAction(ActionEvent event) {
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