package hust.soict.dsai.aims.screen;

import javax.swing.*;

import hust.soict.dsai.aims.Aims.Aims;
import hust.soict.dsai.aims.media.Book;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends JFrame {

    public AddBookToStoreScreen() {
        setTitle("Add Book to Store");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
      
        setJMenuBar(createMenuBar());

        setLayout(new GridLayout(5, 2, 10, 10));

        
        add(new JLabel("Title:"));
        JTextField tfTitle = new JTextField();
        add(tfTitle);

        add(new JLabel("Category:"));
        JTextField tfCategory = new JTextField();
        add(tfCategory);

        add(new JLabel("Cost:"));
        JTextField tfCost = new JTextField();
        add(tfCost);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    float cost = Float.parseFloat(tfCost.getText());
                } catch (NumberFormatException ex) {
                    JDialog dialog = new JDialog();
                    String info = "Cost must be float type";
                    JTextArea statusDialog = new JTextArea(info);
				
				statusDialog.setEditable(false);
				dialog.add(statusDialog);

				dialog.setTitle("Info");
				dialog.setLocationRelativeTo(null);
				dialog.setSize(new Dimension(300, 200));
				dialog.setVisible(true);

                }
                Book b = new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText()));
                Aims.store.addMedia(b);
                JDialog dialog = new JDialog();
				String info = "Media added to store succesfully";
				JTextArea statusDialog = new JTextArea(info);
				
				statusDialog.setEditable(false);
				dialog.add(statusDialog);

				dialog.setTitle("Info");
				dialog.setLocationRelativeTo(null);
				dialog.setSize(new Dimension(300, 200));
				dialog.setVisible(true);
            }
        });
           

        add(addButton);
        add(new JLabel()); 

        setVisible(true);
    }

    public JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        
        JMenu smUpdateStore = new JMenu("Update store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add dvd"));

        menu.add(smUpdateStore);

        JMenuItem viewStoreItem = new JMenuItem("View Store");
        viewStoreItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action to navigate to StoreScreen
                new StoreScreen(Aims.store);
            }
        });
        menu.add(viewStoreItem);

        JMenuItem viewCartItem = new JMenuItem("View Cart");
        viewCartItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action to navigate to CartScreen
                new CartScreen(Aims.cart);
            }
        });
        menu.add(viewCartItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }
    public static void main(String[] args) {
        new AddBookToStoreScreen();
    }
}
