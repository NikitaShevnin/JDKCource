package Less2.HW.server;

import Less2.HW.client.ClientGUI;

public interface ServerWindowInterface {
    boolean connectUser(ClientGUI clientGUI);
    String getLog();
    void disconnectUser(ClientGUI clientGUI);
    void message(String text);
}
