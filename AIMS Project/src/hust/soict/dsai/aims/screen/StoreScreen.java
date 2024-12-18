package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.Aims.Aims;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;


public class StoreScreen extends JFrame{
    private Store store;
    
    public JPanel create_North() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    public JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        
        JMenu smUpdateStore = new JMenu("Update store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddBookToStoreScreen();
            }
        });
        smUpdateStore.add(addBook);
        JMenuItem AddCD = new JMenuItem("Add CD");
        AddCD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddCompactDiscToStoreScreen();
            }
        });
        smUpdateStore.add(AddCD);
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddDigitalVideoDiscToStoreScreen();
            }
        });
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);

        JMenuItem viewStoreItem = new JMenuItem("View Store");
        viewStoreItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new StoreScreen(store);
            }
        });
        menu.add(viewStoreItem);
        JMenuItem viewCartItem = new JMenuItem("View Cart");
        viewCartItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CartScreen(Aims.cart);
            }
        });
        menu.add(viewCartItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    public JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title .setForeground(Color.cyan);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));
        cart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CartScreen(Aims.cart);
            }
        });

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        
        return header;
    }

    public JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore1();
        for (int i = 0; i < mediaInStore.size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }

    public StoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(create_North(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }
    public static void main(String[] args) {
        Aims.init();
        new StoreScreen(Aims.store);
    }
    
}
