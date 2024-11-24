package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class Cart {
    private static final int max_numbers_ordered = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[max_numbers_ordered];
    private int qtyOrdered;
    public Cart() {
        qtyOrdered = 0;
    }
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < max_numbers_ordered) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered ++;
            System.out.println("The disc has been added.");
            if (qtyOrdered == max_numbers_ordered) {
                System.out.println("The cart is almost full.");
            }
        } else {
            System.out.println("The cart is full. Cannot add more discs.");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdlist) {
        for (DigitalVideoDisc disc : dvdlist) {
            if (qtyOrdered < max_numbers_ordered) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered ++;
                System.out.println("The disc has been added.");
            }
            else {
                System.out.println("The cart is full. Cannot add more discs.");
                break;
            }
        }
    }
    public void addDigitalVideoDisc( DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        if ((qtyOrdered+2) <= max_numbers_ordered) {
            itemsOrdered[qtyOrdered] = disc1;
            qtyOrdered ++;
            itemsOrdered[qtyOrdered] = disc2;
            qtyOrdered ++;
            System.out.println("The discs have been added.");
        } else if ((qtyOrdered+1) <= max_numbers_ordered) {
            itemsOrdered[qtyOrdered] = disc1;
            qtyOrdered ++;
            System.out.println("The first disc has been added. Cannot add the second disc. The cart is full.");
        } else {
            System.out.println("The cart is full. Cannot add more discs.");
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                itemsOrdered[i] = itemsOrdered[qtyOrdered - 1];
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                found = true;
                System.out.println("The disc has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc was not found in the cart.");
        }
    }
    public float totalCost() {
        float res = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            res += itemsOrdered[i].getCost();
        }
        return res;
    }
    public void searchDVD(int id) {
        boolean found = false;
        for (int i = 0; i< qtyOrdered; i++) {
            if (itemsOrdered[i].getid() == id) {
                found = true;
                System.out.println("Disc in cart. Disc information: ");
                System.out.println(itemsOrdered[i].toString());
                break;
            }
        }
        if (!found) {
            System.out.println("Disc not found");
        }
    }
    public void searchDVD(String title) {
        boolean found = false;
        for (int i = 0; i< qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                found = true;
                System.out.println("Disc in cart. Disc information: ");
                System.out.println(itemsOrdered[i].toString());
                break;
            }
        }
        if (!found) {
            System.out.println("Disc not found");
        } 
    }
    public void displayCart() {
        for (int i = 0; i < qtyOrdered; i ++) {
            System.out.println("DVD - " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost());
    }

}


