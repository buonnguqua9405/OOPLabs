package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import hust.soict.dsai.aims.Aims.Aims;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel{
    private Media media;
    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart  = new JButton("Add to cart");
        btnAddToCart.addActionListener(new ButtonListener());
        container.add(btnAddToCart);
        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(new ButtonListener());
            container.add(btnPlay);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            JButton btn = (JButton) evt.getSource();
            if (btn.getText().equals("Play")) {
                JDialog dialog = new JDialog();
                Disc disc = (Disc) media;
                String info = "Title: " + disc.getTitle()
								+ "\nCategory: " + disc.getCategory()
								+ "\nDirector: " + disc.getDirector()
								+ "\nLength: " + disc.getLength()
								+ "\nCost: " + disc.getCost() ;
				JTextArea mediaInfo = new JTextArea(info);
					
				mediaInfo.setEditable(false);
				dialog.add(mediaInfo);

				dialog.setTitle("Playing " + media.getTitle() + " (demo)");
				dialog.setLocationRelativeTo(null);
				dialog.setSize(new Dimension(400, 400));
				dialog.setVisible(true);
            } else if (btn.getText().equals("Add to cart")) {
                try {
                    Aims.cart.addMedia(media);
                } catch (LimitExceededException e1) {
                    e1.printStackTrace();
                }
                JDialog dialog = new JDialog();
				String info = "Media added to cart succesfully";
				JTextArea statusDialog = new JTextArea(info);
				
				statusDialog.setEditable(false);
				dialog.add(statusDialog);

				dialog.setTitle("Info");
				dialog.setLocationRelativeTo(null);
				dialog.setSize(new Dimension(200, 75));
				dialog.setVisible(true);
            }
        }
    }
}
