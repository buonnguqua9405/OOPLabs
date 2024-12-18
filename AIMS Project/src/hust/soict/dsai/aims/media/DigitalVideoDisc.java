package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDisc;
    public DigitalVideoDisc(String title) {
        nbDigitalVideoDisc ++;
        super(nbDigitalVideoDisc, title, null, 0, 0, null);
        
    }
    public DigitalVideoDisc(String category, String title, float cost) {
        nbDigitalVideoDisc ++;
        super(nbDigitalVideoDisc, title, category, cost, 0, null);
    }
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        nbDigitalVideoDisc ++;
        super(nbDigitalVideoDisc, title, category, cost, 0, director);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        nbDigitalVideoDisc ++;
        super(nbDigitalVideoDisc, title, category, cost, length, director);
        
    }
    public String toString() {
        return "Id: " + this.getId() + "\n"
        + "Title: " + this.getTitle() + "\n"
        + "Category: " + this.getCategory() + "\n"
        + "Cost: " + this.getCost() + "\n"
        + "Length" + this.getLength() + "\n"
        + "Director" + this.getDirector() + ".";
    }
    public boolean isMatch(String title) {
        if (title.equals(this.getTitle())) {
            return true;
        } else {
            return false;
        }
    }
    public void play() throws PlayerException {
		if(getLength() > 0) {
			System.out.println("Playing DVD: " + getTitle());
			System.out.println("DVD length: " + String.valueOf(getLength()));
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive .");
		}
	}
    

}
