package hust.soict.dsai.aims.Aims;

import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    public static Store store = new Store();
    public static Cart cart = new Cart();

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3.");
    }
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4.");
    }
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2.");
    }
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5.");
    }

    public static void init() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("a");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("b","c",10);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("e", "f", "g", 5);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("h", "i", "j", 99, 7.5f);
        
        Track track1 = new Track("abcdefg", 6);
        Track track2 = new Track("hijklmnop", 5);
        
        CompactDisc cd1 = new CompactDisc("aa", "b", "cc", 60, 9);
        cd1.addTrack(track1, track2);
        CompactDisc cd2 = new CompactDisc("ab", "bb", "dd", 6);
        CompactDisc cd3 = new CompactDisc("zz", "yz", 10);
        CompactDisc cd4 = new CompactDisc("a-z");
        
        
        Book book1 = new Book("JJ");
        Book book2 = new Book("AA", "ZZ", 8);
        
        store.addMedia(dvd1,dvd2,dvd3,dvd4,cd1,cd2,cd3,cd4,book1,book2);
    }
    public static void main(String[] args) throws PlayerException, LimitExceededException {
        Store store = new Store();
        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);
        int a;
        do {
            showMenu();
            a = sc.nextInt();
            sc.nextLine();
            switch (a) {
                case 0:
                    System.out.println("Exiting");
                    break;
                case 1:
                    store.displayStore();
                    int storechoice;
                    do {
                        storeMenu();
                        storechoice = sc.nextInt();
                        sc.nextLine();
                        switch (storechoice) {
                            case 0:
                                break;
                            case 1:
                                System.out.print("Enter the title of the media: ");
                                String title = sc.nextLine();
                                Media media = store.findMedia(title);
                                if (media != null) {
                                    System.out.println(media.toString());
                                    int mediachoice;
                                    do {
                                        mediaDetailsMenu();
                                        mediachoice = sc.nextInt();
                                        sc.nextLine();
                                        switch (mediachoice) {
                                            case 1:
                                                cart.addMedia(media);
                                                break;
                                            case 2:
                                                if (media instanceof Playable) {
                                                    ((Playable) media).play();
                                                }else {
                                                    System.out.println("This media cannot be played");
                                                }
                                                break;
                                            case 0:
                                                break;
                                            default:
                                                System.out.println("Invalid choice.");
                                                break;
                                        }
                                    } while (mediachoice != 0);
                                }else {
                                    System.out.println("Media not found");
                                }
                                break;
                                case 2:
                                    System.out.println("Enter the title of the media: ");
                                    String title1 = sc.nextLine();
                                    Media media1 = store.findMedia(title1);
                                    if (media1 != null) {
                                        System.out.println(media1.toString());
                                        cart.addMedia(media1);
                                    } else {
                                        System.out.println("Media not found");
                                    }
                                    break;
                                case 3:
                                    System.out.println("Enter the title of the media");
                                    String title2 = sc.nextLine();
                                    Media media2 = store.findMedia(title2);
                                    if (media2 != null) {
                                        if (media2 instanceof Playable) {
                                            ((Playable) media2).play();
                                        }else {
                                            System.out.println("This media cannot be played");
                                        }
                                    } else {
                                        System.out.println("Media not found");
                                    }
                                    break;
                                case 4:
                                    cart.displayCart();
                                    int cartchoice;
                                    do {
                                        cartMenu();
                                        cartchoice = sc.nextInt();
                                        sc.nextLine();
                                        switch (cartchoice) {
                                            case 0:
                                                break;
                                            case 1:
                                                cart.filterCart(sc);
                                                break;
                                            case 2:
                                                cart.sortCart(sc);
                                                break;
                                            case 3:
                                                cart.removeCart(sc);
                                                break;
                                            case 4:
                                                cart.addMedia(sc);
                                                break;
                                            case 5:
                                                if (cart.isEmpty()) {
                                                    System.out.println("No item in cart");
                                                } else {
                                                    System.out.println("An order is created");
                                                    cart.emptyCart();
                                                }
                                                break;
                                            default:
                                            System.out.println("Invalid choice");
                                                break;
                                        }
                                    } while (cartchoice != 0);
                                    break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                    } while (storechoice != 0);
                    break;
                case 2:
                    System.out.println("1. Add media");
                    System.out.println("2. Remove media");
                    System.out.println("3. Back");
                    int updatechoice = sc.nextInt();
                    sc.nextLine();
                    switch (updatechoice) {
                        case 1:
                            store.addMedia(sc);
                            break;
                        case 2:
                            store.removeMedia(sc);
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                    break;
                case 3:
                    cart.displayCart();
                    cartMenu();
                    int cartchoice = sc.nextInt();
                    sc.nextLine();
                    switch (cartchoice) {
                        case 1:
                            cart.filterCart(sc);
                            break;
                        case 2:
                            cart.sortCart(sc);
                            break;
                        case 3:
                            cart.removeCart(sc);
                            break;
                        case 4:
                            cart.addMedia(sc);
                            break;
                        case 5:
                            if (cart.isEmpty()) {
                                System.out.println("No item in cart");
                            } else {
                                System.out.println("An order is created");
                                cart.emptyCart();
                            }
                            break;
                        default:
                            break;
                    }
                    
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (a != 0);
        sc.close();
    }
}
