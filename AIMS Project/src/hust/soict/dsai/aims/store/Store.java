package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore;
    public Store() {
        itemsInStore = new ArrayList<>();
    }
    public void addMedia(Media media) {
        boolean found = false;
        for (Media m : itemsInStore) {
            if (m.equals(media)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("The dvd is already added");
        } else {
            itemsInStore.add(media);
            System.out.println("The dvd has been added");
        }
    }
    public void removeMedia(Media media) {
        boolean found = false;
        for (Media m : itemsInStore) {
            if (m.equals(media)) {
                found = true;
                break;
            }
        }
        if (found) {
            itemsInStore.remove(media);
            System.out.println("The dvd has been removed");
        } else {
            System.out.println("DVD not found");
        }
    }
    public void displayStore() {
        if (itemsInStore.size() == 0) {
            System.out.println("No item in store.");
        } else {
            for (Media m: itemsInStore) {
                System.out.println(m.toString());
            }
        }
    }
    public void searchMedia(String title) {
        boolean found = false;
        for (Media m: itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                found = true;
                System.out.println("Disc in cart. Disc information: ");
                System.out.println(m.toString());
                break;
            }
        }
        if (!found) {
            System.out.println("Disc not found");
        } 
    }
    public Media findMedia(String title) {
        for (Media m: itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }
    public void addMedia(Scanner sc) {
        System.out.println("Choose type of media.");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. CD");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            System.out.println("Enter id");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter title");
            String title = sc.nextLine();
            System.out.println("Enter category");
            String category = sc.nextLine();
            System.out.println("Enter cost");
            float cost = sc.nextFloat();
            sc.nextLine();
            Book book = new Book(id, title, category, cost, null);
            this.addMedia(book);
        }
        else if (choice == 2) {
            System.out.println("Enter title");
            String title = sc.nextLine();
            System.out.println("Enter category");
            String category = sc.nextLine();
            System.out.println("Enter cost");
            float cost = sc.nextFloat();
            System.out.println("Enter length");
            int length = sc.nextInt();
            System.out.println("Enter director");
            String director = sc.nextLine();
            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            this.addMedia(dvd);
        } else if (choice == 3) {
            System.out.println("Enter title");
            String title = sc.nextLine();
            System.out.println("Enter category");
            String category = sc.nextLine();
            System.out.println("Enter cost");
            float cost = sc.nextFloat();
            System.out.println("Enter length");
            int length = sc.nextInt();
            System.out.println("Enter director");
            String director = sc.nextLine();
            System.out.println("Enter artist");
            String artist = sc.nextLine();
            CompactDisc cd = new CompactDisc(title, category, cost, length, director, artist);
            this.addMedia(cd);
        } else {
            System.out.println("Invalid");
        }
    }
    public void removeMedia(Scanner sc) {
        System.out.println("Enter the title to be removed");
        String title = sc.nextLine();
        boolean found = false;
        for (Media m: itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                found = true;
                this.removeMedia(m);
            }
        }
        if (found) {
            System.out.println("Removed succesfully");
        } else {
            System.out.println("Not in store");
        }
    }
}