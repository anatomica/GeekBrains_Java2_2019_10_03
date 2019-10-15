package lesson4.Homework.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FXMLDocumentController {
    
    @FXML
    private Label label1;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label1.setText("Hello World!");
    }
    
}