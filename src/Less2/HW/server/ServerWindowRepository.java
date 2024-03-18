package Less2.HW.server;

import Less2.HW.client.ClientGUI;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerWindowRepository implements ServerWindowInterface {
    public static final String LOG_PATH = "src\\Less2\\HW\\log.txt";
    private List<ClientGUI> clientGUIList;
    private boolean work;

    public ServerWindowRepository() {
        clientGUIList = new ArrayList<>();
        work = false;
    }

    public boolean isWork() {
        return work;
    }

    @Override
    public boolean connectUser(ClientGUI clientGUI) {
        if (!work) {
            return false;
        }
        clientGUIList.add(clientGUI);
        return true;
    }

    @Override
    public String getLog() {
        return readLog();
    }

    @Override
    public void disconnectUser(ClientGUI clientGUI) {
        clientGUIList.remove(clientGUI);
        if (clientGUI != null) {
            clientGUI.disconnectedFromServer();
        }
    }

    @Override
    public void message(String text) {
        if (!work) {
            return;
        }
        appendLog(text);
        answerAll(text);
        saveInLog(text);
    }

    private void appendLog(String text) {
        try {
            // Открыть файл или ресурс, где хранится лог
            FileWriter writer = new FileWriter("log.txt", true); // "true" указывает на дописывание в файл, а не создание нового

            // Записать переданный текст в лог
            writer.write(text + "\n");

            // Закрыть файл или ресурс
            writer.close();
        } catch (IOException e) {
            // Обработка ошибок записи в лог
            e.printStackTrace();
        }
    }

    private void answerAll(String text) {
        for (ClientGUI clientGUI : clientGUIList) {
            clientGUI.answer(text);
        }
    }

    private void saveInLog(String text) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)) {
            writer.write(text);
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readLog() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH)) {
            int c;
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void startServer() {
        work = true;
    }

    public void stopServer() {
        work = false;
        while (!clientGUIList.isEmpty()) {
            disconnectUser(clientGUIList.get(clientGUIList.size() - 1));
        }
    }
}
