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
    public void displayCart() {
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc dvd = itemsOrdered[i];
            System.out.println("Title: " + dvd.getTitle());
            System.out.println("Category: " + dvd.getCategory());
            System.out.println("Director: " + dvd.getDirector());
            System.out.println("Length: " + dvd.getLength());
            System.out.println("Cost: $" + dvd.getCost());
        }
        System.out.println("Total Cost is: "+totalCost());
    }
}


