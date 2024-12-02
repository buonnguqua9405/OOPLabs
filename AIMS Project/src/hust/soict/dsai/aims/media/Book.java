package hust.soict.dsai.aims.media;
import java.util.List;
import java.util.ArrayList;
public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }
    public void addAuthor(String authorName) {
        boolean found = false;
        for (String name : authors) {
            if (name.equals(authorName)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Author already in list");
        } else {
            authors.add(authorName);
            System.out.println("Add successfully");
        }
    }
    public void removeAuthor(String authorName) {
        boolean found = false;
        for (String name : authors) {
            if (name.equals(authorName)) {
                found = true;
                break;
            }
        }
        if (found) {
            authors.remove(authorName);
            System.out.println("Remove successfully");
        } else {
            System.out.println("Author not in list");
        }
    }
    public List<String> getAuthors() {
        return authors;
    }
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    
}
