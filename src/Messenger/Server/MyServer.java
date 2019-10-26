package Messenger.Server;
import Messenger.Server.auth.AuthService;
import Messenger.Server.auth.BaseAuthService;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class MyServer {

    private static final int PORT = 8189;
    private final AuthService authService = new BaseAuthService();
    private List<ClientHandler> clients = new ArrayList<>();

    MyServer() {
        System.out.println("Сервер запущен!");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            authService.start();
            while (true) {
                System.out.println("Ожидание подключения клиентов ...");
                Socket socket = serverSocket.accept();
                System.out.println("Клиент подключен!");
                new ClientHandler(socket, this);
            }
        } catch (IOException e) {
            System.err.println("Ошибка в работе сервера. Причина: " + e.getMessage());
            e.printStackTrace();
        } finally {
            authService.stop();
        }
    }

    synchronized void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }
    synchronized void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    AuthService getAuthService() {
        return authService;
    }

    synchronized boolean isNickBusy(String nick) {
        for (ClientHandler client : clients) {
            if (client.getClientName().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    synchronized void broadcastMessage(String nameSender, String message) {
        for (ClientHandler client : clients) {
            if (!client.getClientName().equals(nameSender)) {
                client.sendMessage(message);
            }
        }
    }

    synchronized void privateMessage(String nick, String sender, String message) {
        for (ClientHandler client : clients) {
            if (client.getClientName().equals(nick)) {
                client.sendMessage(message);
                break;
            }
            if (!client.getClientName().equals(nick) && client.getClientName().equals(sender)) {
                client.sendMessage("Сервер: Этот клиент не подключен!");
                break;
            }
        }
    }
}
