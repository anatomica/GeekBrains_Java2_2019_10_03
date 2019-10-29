package lesson7.Client;
import lesson7.Client.Controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Messenger extends Application {

    private static Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Сетевой чат");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("scene.fxml"));
        Parent root = loader.load();

        scene = new Scene(root);

        Controller controller = loader.getController();
        stage.setOnHidden(e -> controller.shutdown());
        stage.setScene(scene);
        stage.setTitle("lesson7");
        stage.setX(900);
        stage.setY(400);
        stage.show();
    }
}