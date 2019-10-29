package lesson7.Client.Controller;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class MessageService {

    private static final String HOST_ADDRESS_PROP = "server.address";
    private static final String HOST_PORT_PROP = "server.port";
    private static final String STOP_SERVER_COMMAND = "/end";

    private String hostAddress;
    private int hostPort;

    private TextArea textArea;
    private Controller controller;
    private boolean needStopServerOnClosed;
    private Network network;

    MessageService (Controller controller, boolean needStopServerOnClosed) throws IOException {
        this.textArea = controller.textArea;
        this.controller = controller;
        this.needStopServerOnClosed = needStopServerOnClosed;
        initialize();
    }

    private void initialize () {
        readProperties();
        startConnectionToServer();
    }

    private void startConnectionToServer() {
        try {
            this.network = new Network(hostAddress, hostPort, this);
        } catch (IOException e) {
            throw new ServerConnectionException("Failed to connect to server", e);
        }
    }

    private void readProperties() {
        Properties serverProperties = new Properties();
        try (InputStream inputStream = getClass().getResourceAsStream("application.properties")) {
            serverProperties.load(inputStream);
            hostAddress = serverProperties.getProperty(HOST_ADDRESS_PROP);
            hostPort = Integer.parseInt(serverProperties.getProperty(HOST_PORT_PROP));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read application.properties file", e);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid port value", e);
        }
    }

    public void sendMessage(String message) {
        network.send(message);
    }

    void processRetrievedMessage(String message) {
        if (message.startsWith("/authok")) {
            controller.authPanel.setVisible(false);
            controller.chatPanel.setVisible(true);
        } else if (controller.authPanel.isVisible()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Authentication is failed");
            alert.setContentText(message);
            alert.showAndWait();
        } else {
            textArea.appendText(message + System.lineSeparator());
        }
    }

    public void close() throws IOException {
        if (needStopServerOnClosed) {
            sendMessage(STOP_SERVER_COMMAND);
        }
        network.close();
    }
}
