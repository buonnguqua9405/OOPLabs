package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private int length;
    private String director;
    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }
    public Disc(int Id, String title, String category, float cost, int length, String director) {
        super(Id, title, category, cost);
        this.length = length;
        this.director = director;
    }
    public void play() {
        System.out.println("Playing Disc: " + this.getTitle());
        System.out.println("Disc length: " + this.getLength());
    }
    public String toString() {
        return "Id: " + this.getId() + "\n"
        + "Title: " + this.getTitle() + "\n"
        + "Category: " + this.getCategory() + "\n"
        + "Cost: " + this.getCost() + "\n"
        + "Length" + this.getLength() + "\n"
        + "Director" + this.getDirector() + ".";
    } 
}
