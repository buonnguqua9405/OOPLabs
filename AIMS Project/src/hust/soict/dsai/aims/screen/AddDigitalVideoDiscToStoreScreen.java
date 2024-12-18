package hust.soict.dsai.aims.screen;

import javax.swing.*;

import hust.soict.dsai.aims.Aims.Aims;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends JFrame {
    public AddDigitalVideoDiscToStoreScreen() {
        setTitle("Add DVD to Store");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

       
        setJMenuBar(createMenuBar());

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  
        gbc.fill = GridBagConstraints.HORIZONTAL; 

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Title:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JTextField tfTitle = new JTextField(20);
        add(tfTitle, gbc);

       
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Category:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JTextField tfCategory = new JTextField(20);
        add(tfCategory, gbc);

   
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Director:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JTextField tfDirector = new JTextField(20);
        add(tfDirector, gbc);

       
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Length:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JTextField tfLength = new JTextField(20);
        add(tfLength, gbc);

    
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Cost:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JTextField tfCost = new JTextField(20);
        add(tfCost, gbc);

       
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;  
        gbc.anchor = GridBagConstraints.CENTER;
        JButton addButton = new JButton("Add DVD");
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
                try {
                    int length = Integer.parseInt(tfLength.getText());
                } catch (NumberFormatException ex) {
                    JDialog dialog = new JDialog();
                    String info = "Length must be int type";
                    JTextArea statusDialog = new JTextArea(info);
				
				statusDialog.setEditable(false);
				dialog.add(statusDialog);

				dialog.setTitle("Info");
				dialog.setLocationRelativeTo(null);
				dialog.setSize(new Dimension(300, 200));
				dialog.setVisible(true);

                }
                DigitalVideoDisc dvd = new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), tfDirector.getText(), Integer.parseInt(tfLength.getText()), Float.parseFloat(tfCost.getText()));
                Aims.store.addMedia(dvd);
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
        new AddDigitalVideoDiscToStoreScreen();
    }
}