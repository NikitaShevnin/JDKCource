package Less1.HW;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static final int PORT = 1234;
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected");

            ClientHandler clientHandler = new ClientHandler(clientSocket);
            clients.add(clientHandler);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }

    public static synchronized void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader reader;
    private PrintWriter writer;

    public ClientHandler(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        writer = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = reader.readLine()) != null) {
                Server.broadcastMessage(message);
                System.out.println(message); // Дублирование лога в консоль
                appendToFile("chatlog.txt", message); // Дублирование лога в файл
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        writer.println(message);
    }

    private synchronized void appendToFile(String filename, String text) throws IOException {
        FileWriter writer = new FileWriter(filename, true);
        writer.append(text);
        writer.append("\n");
        writer.close();
    }
}