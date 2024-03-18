package Less2.HW;

import Less2.HW.client.ClientController;
import Less2.HW.client.ClientGUI;
import Less2.HW.server.MainServerWindow;
import Less2.HW.server.ServerWindowController;
import Less2.HW.server.ServerWindowGUI;
import Less2.HW.server.ServerWindowRepository;

/**
 * Этот класс надо полностью переписывать...
 * TODO Нужно организовать работу вызовов и клиентской и серверной части в этом классе.
 * Возможно для этого можно использовать интерфейсы...
 */

public class Main {
    public static void main(String[] args) {

        //создание объектов сервера и создание связи между ними
        MainServerWindow mainServerWindow = new MainServerWindow();
        ServerController serverController = new ServerController();
        serverController.setServerView(mainServerWindow);
        mainServerWindow.setServerController(serverController);

        //создание объектов клиента1 и создание связи между ними
        ClientGUI clientGUI1 = new ClientGUI();
        ClientController clientController1 = new ClientController();
        clientController1.setClientView(clientGUI1);
        clientGUI1.setClient(clientController1);
        clientController1.setServer(serverController);

        //создание объектов клиента2 и создание связи между ними
        ClientGUI clientGUI2 = new ClientGUI();
        ClientController clientController2 = new ClientController();
        clientController2.setClientView(clientGUI2);
        clientGUI2.setClient(clientController2);
        clientController2.setServer(serverController);

        // вызов основных методов для работы с классами сервера
//        ServerWindowGUI gui = new ServerWindowGUI();
//        ServerWindowRepository repository = new ServerWindowRepository();
//        ServerWindowController controller = new ServerWindowController(gui, repository);
    }
}