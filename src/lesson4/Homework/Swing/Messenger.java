package lesson4.Homework.Swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Messenger extends JFrame {

    private JTextArea textArea;
    private JTextField textMessage;

    Messenger() {
        setTitle("Messenger");
        setBounds(1000, 500, 500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setBackground(Color.gray);
        centerPanel.setLayout(new BorderLayout());

        JPanel bottonPanel = new JPanel();
        add(bottonPanel, BorderLayout.SOUTH);
        bottonPanel.setBackground(Color.darkGray);
        bottonPanel.setPreferredSize(new Dimension(1, 40));
        bottonPanel.setLayout(new BorderLayout());

        JButton startButton = new JButton("Отправить");
        bottonPanel.add(startButton, BorderLayout.EAST);

        textArea = new JTextArea();
        JScrollPane textAreaScroll = new JScrollPane(textArea);
        centerPanel.add(textAreaScroll, BorderLayout.CENTER);
        textArea.setEditable(false);

        textMessage = new JTextField();
        bottonPanel.add(textMessage, BorderLayout.CENTER);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addText();
            }
        });

        textMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addText();
            }
        });

        setVisible(true);
    }
    private void addText() {
        textArea.append(textMessage.getText()+"\n");
        textMessage.setText("");
    }
}