package lab5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyFrame extends JFrame {

    private int i = 0;

    public MyFrame() {
        super.setTitle("Frame title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 0));
        //frame.setResizable(false);
        //setSize(500, 500);
        setVisible(true);

        final DefaultListModel listModel = new DefaultListModel();
        final DefaultListModel listModelLeft = new DefaultListModel();
        final DefaultListModel listModelRight = new DefaultListModel();


        for (i = 0; i < 10; i++) {
            listModel.addElement("Элемент списка " + i);
        }

        for (i = 0; i < 10; i++) {
            listModelLeft.addElement("Элемент списка " + i);
        }

        //JPanel firstPanel = new JPanel();

        //JPanel panelLeft = new JPanel();
        final JList listLeft = new JList(listModelLeft);
        listLeft.setSelectedIndex(0);
        listLeft.setFocusable(false);
        add(listLeft);
        //add(new JScrollPane(listLeft));
//        panelLeft.add(listLeft);
//        add(panelLeft);
        //firstPanel.add(listLeft);

        //JPanel panel = new JPanel();
        final JList list = new JList(listModel);
        list.setSelectedIndex(0);
        list.setFocusable(false);
        add(list);
        add(new JScrollPane(list));
//        panel.add(list);
//        add(panel);
        //firstPanel.add(list);

        JPanel panelRight = new JPanel();
        final JList listRight = new JList(listModelRight);
        listRight.setSelectedIndex(0);
        listRight.setFocusable(false);
        add(listRight);
//        panelRight.add(listRight);
//        add(panelRight);

        //add(firstPanel);

        JButton move1 = new JButton("Переместить");
        move1.setFocusable(false);
        move1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                var element = listLeft.getSelectedValue();
                listModel.addElement(element);
                int index = listModel.size() - 1;
                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
                listModelLeft.remove(listLeft.getSelectedIndex());
            }
        });
        add(move1);

        JButton move2 = new JButton("Переместить");
        move2.setFocusable(false);
        move2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                var element = list.getSelectedValue();
                listModelRight.addElement(element);
                int index = listModelRight.size() - 1;
                listRight.setSelectedIndex(index);
                listRight.ensureIndexIsVisible(index);
                listModel.remove(list.getSelectedIndex());
            }
        });
        add(move2);

        JButton move3 = new JButton("Переместить");
        move3.setFocusable(false);
        move3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                var element = listRight.getSelectedValue();
                listModelLeft.addElement(element);
                int index = listModelLeft.size() - 1;
                listLeft.setSelectedIndex(index);
                listLeft.ensureIndexIsVisible(index);
                listModelRight.remove(listRight.getSelectedIndex());
            }
        });
        add(move3);

        JButton addButton = new JButton("Добавить");
        addButton.setFocusable(false);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String element = "Элемент списка " + i++;
                listModel.addElement(element);
                int index = listModel.size() - 1;
                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
            }
        });
        add(addButton);

        JButton removeButton = new JButton("Удалить");
        removeButton.setFocusable(false);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listModel.remove(list.getSelectedIndex());
            }
        });
        add(removeButton);

        pack();
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}