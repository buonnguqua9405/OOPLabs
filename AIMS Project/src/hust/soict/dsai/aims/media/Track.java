package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public Track(String string) {
       this.title = string;
       this.length = 0;
    }
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    public void play() throws PlayerException {
		if(getLength() > 0) {
			System.out.println("Playing Track: " + getTitle());
			System.out.println("Track length: " + String.valueOf(getLength()));
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive .");
		}
	}
    public String toString() {
        return "Title: " + title + "\n"
        + "Length: " + length;
    }
    public boolean equals(Object o) {
        if (this == o) {
         return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
         return false;
        }
        Track track = (Track) o;
        return title.equals(track.getTitle());
     }
}
