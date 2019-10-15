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
        setBounds(1000, 450, 500, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Файл");
        JMenuItem exitMenuItem = new JMenuItem("Выход");
        menuBar.setLayout(new BorderLayout());
        add(menuBar, BorderLayout.NORTH);
        menuBar.add(menu);
        menu.add(exitMenuItem);

        JPanel textAreaPanel = new JPanel();
        textAreaPanel.setLayout(new BorderLayout());
        textAreaPanel.setBackground(Color.gray);
        add(textAreaPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setBackground(Color.darkGray);
        buttonPanel.setPreferredSize(new Dimension(1, 40));
        add(buttonPanel, BorderLayout.SOUTH);

        JButton sendButton = new JButton("Отправить");
        buttonPanel.add(sendButton, BorderLayout.EAST);

        textArea = new JTextArea();
        JScrollPane textAreaScroll = new JScrollPane(textArea);
        textAreaPanel.add(textAreaScroll, BorderLayout.CENTER);
        textArea.setEditable(false);

        textMessage = new JTextField();
        buttonPanel.add(textMessage, BorderLayout.CENTER);

        sendButton.addActionListener(new ActionListener() {
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

        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
    private void addText() {
        textArea.append(textMessage.getText() + "\n");
        textMessage.setText("");
    }
}