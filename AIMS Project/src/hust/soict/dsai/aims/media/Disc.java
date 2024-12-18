package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

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

    public Disc(String disc_title, String disc_category, String disc_director, int disc_length, float disc_cost) {
		super(disc_title, disc_category, disc_cost);
		director = disc_director;
		length = disc_length;
	}
    public String toString() {
        return "Id: " + this.getId() + "\n"
        + "Title: " + this.getTitle() + "\n"
        + "Category: " + this.getCategory() + "\n"
        + "Cost: " + this.getCost() + "\n"
        + "Length" + this.getLength() + "\n"
        + "Director" + this.getDirector() + ".";
    } 

    public void play() throws PlayerException {
		if(getLength() > 0) {
			System.out.println("Playing: " + getTitle());			
			System.out.println("Length: " + String.valueOf(getLength()));
		} else {
			throw new PlayerException("ERROR: Disc length is non-positive .");
		}
	}
}
