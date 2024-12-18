package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.media.MediaComparatorByTitleCost;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.naming.LimitExceededException;
public class Cart {
    private static final int max_numbers_ordered = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    public static final Comparator<Media> Compare_by_title_cost = new MediaComparatorByTitleCost();
    public static final Comparator<Media> Compare_by_cost_title = new MediaComparatorByCostTitle();
    public Cart() {
    }
    public float totalCost() {
        float res = 0;
        for (Media m: itemsOrdered) {
            res += m.getCost();
        }
        return res;
    }
    public void searchMedia(int id) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
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
    public void searchMedia(String title) {
        boolean found = false;
        for (Media m: itemsOrdered) {
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
    public void addMedia(Media media) throws LimitExceededException {
		if (itemsOrdered.size() == max_numbers_ordered) {
			throw new LimitExceededException("ERROR: The number of media has reached its limit");
		}
		
		if (itemsOrdered.add(media)) {
			System.out.println("The media has been successfully added.");
		} else {
			System.out.println("Something wrong happened. Please try again.");
		}
		
		if(itemsOrdered.size() == max_numbers_ordered) {
			System.out.println("Info: The cart is full.");
		}
	}
    public void removeMedia(Media media) {
        boolean found = false;
        for (Media m: itemsOrdered) {
            if (m.equals(media)) {
                found = true;
                break;
            }
        }
        if (found) {
            itemsOrdered.remove(media);
            System.out.println("Removed successfully");
        } else {
            System.out.println("Not in cart");
        }
    }

    public void addMedia(Media ...media) throws LimitExceededException {
		int numDisc = media.length;
		if (itemsOrdered.size() + numDisc > max_numbers_ordered) {
			System.out.println("Cannot add all select media, the cart does not have enough space.");
			return;
		} else {
			for (Media m: media) {
				addMedia(m);
			}
		}
		
	}

    public boolean Contains(Object o) {
        boolean found = false;
        for (Media m: itemsOrdered) {
            if (m.equals(o)) {
                found = true;
                break;
            }
        }
        return found;
    }
    public void displayCart() {
        if (itemsOrdered.size() == 0) {
            System.out.println("No item in cart.");
        } else {
            for (Media m: itemsOrdered) {
                System.out.println(m.toString());
            }
        }
    }
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Compare_by_title_cost);
    }
    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Compare_by_cost_title);
    }
    public Media findMedia(String title) {
        for (Media m: itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }
    public boolean isEmpty() {
        if (itemsOrdered.size() == 0) {
            return true;
        }
        return false;
    }
    public void emptyCart() {
		itemsOrdered = FXCollections.observableArrayList();
	}
    public void filterCart(Scanner sc) throws LimitExceededException {
        System.out.println("1. Filter by id");
        System.out.println("2. Filter by title");
        System.out.println("3. Back");
        int filterchoice = sc.nextInt();
        switch (filterchoice) {
            case 1:
                int id = sc.nextInt();
                Cart cart = new Cart();
                for (Media m: itemsOrdered) {
                    if (m.getId() == id) {
                        cart.addMedia(m);
                    }
                }
                if (cart.isEmpty()) {
                    System.out.println("No media same title");
                } else {
                    cart.displayCart();
                }
                break;
            case 2:
                String title = sc.nextLine();
                Cart cart1 = new Cart();
                for (Media m: itemsOrdered) {
                    if (m.getTitle().equalsIgnoreCase(title)) {
                        cart1.addMedia(m);
                    }
                }
                if (cart1.isEmpty()) {
                    System.out.println("No media same title");
                } else {
                    cart1.displayCart();
                }
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    public void sortCart(Scanner sc) {
        System.out.println("1. Sort by title-cost.");
        System.out.println("2. Sort by cost-title.");
        System.out.println("3. Back.");
        int sortchoice = sc.nextInt();
        switch (sortchoice) {
            case 1:
                this.sortByTitleCost();
                this.displayCart();
                break;
            case 2:
                this.sortByCostTitle();
                this.displayCart();
                break;
            case 3:
                break;
            default:
            System.out.println("Invalid choice");
                break;
            }
                                                
    }
    public void removeCart(Scanner sc) {
        this.displayCart();
        System.out.println("Enter cart title to be removed.");
        String title3 = sc.nextLine();
        Media media3 = this.findMedia(title3);
        if (media3 != null) {
            this.removeMedia(media3);
        } else {
            System.out.println("Not in cart.");
        }
    }
    public void placeOrder(Scanner sc) {
        if (this.isEmpty()) {
            System.out.println("No item in cart.");
        } else {
            System.out.println("Successfully created");
            this.emptyCart();
        }
    }
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    public List<Media> searchById(String keyword) {
        try {
            int id = Integer.parseInt(keyword);
            return itemsOrdered.stream().filter(media -> media.getId() == id).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            return Collections.emptyList();
        }
    }
    public List<Media> searchByTitle(String keyword) {
        return itemsOrdered.stream().filter(media -> media.getTitle().toLowerCase().contains(keyword.toLowerCase())).collect(Collectors.toList());
    }
    public void addMedia(Scanner sc) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addMedia'");
    }
}


