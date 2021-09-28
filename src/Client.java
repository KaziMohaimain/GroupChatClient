import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    private Socket clientSocket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

//Constructor:
    public Client(String serverIP, int port)
    {
        try {

            clientSocket = new Socket(serverIP,port);
            System.out.println("Connected to Server");

            inputStream = new ObjectInputStream(clientSocket.getInputStream());
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(Message msg)
    {
        try {
            outputStream.writeObject(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
