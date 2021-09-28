import java.io.Serializable;

public class Message implements Serializable {

    String senderName;
    String messageContent;

//Constructor:
    public Message(String sender, String content)
    {
        this.senderName = sender;
        this.messageContent = content;
    }
}
