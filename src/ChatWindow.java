import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame {

    String name;
    Client client;
    JTextField inputField;

    public ChatWindow(String name)
    {
        this.name = name;
        this.client = new Client("127.0.0.1", 800);
        initFrame();

        JPanel messagePanel = new JPanel();

        //input panel

        add(generateInputPanel(),BorderLayout.SOUTH);
        add(messagePanel);

        this.setVisible(true);
    }

    private JPanel generateInputPanel()
    {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setPreferredSize(new Dimension(getWidth(),50));

        JButton sendButton = new JButton("Send");
        sendButton.setPreferredSize(new Dimension(200,inputPanel.getHeight()));
        inputField = new JTextField();

        sendButton.addActionListener(e -> {
            client.sendMessage(new Message(name, inputField.getText()));
            inputField.setText("");
        });

        inputPanel.add(sendButton,BorderLayout.EAST);
        inputPanel.add(inputField);

        return inputPanel;
    }

    private void initFrame()
    {
        this.setTitle(name + "'s Messenger");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1200, 800);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(new Color(20, 54, 79));
        setContentPane(contentPane);

        this.setLocationRelativeTo(null);
        this.setFocusable(true);
    }
}
