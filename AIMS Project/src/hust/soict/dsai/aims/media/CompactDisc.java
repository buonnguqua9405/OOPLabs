package hust.soict.dsai.aims.media;
import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;
public class CompactDisc extends Disc implements Playable {
    private static int nbDisc;
    private String artist;
    private ArrayList<Track> tracks;
    public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
        nbDisc ++;
        this.artist = artist;
        super(nbDisc, title, category, cost, length, director);
        this.tracks = new ArrayList<>();
    }

    public CompactDisc(String cd_title, String cd_category, String cd_director, int cd_length, float cd_cost) {
		super(cd_title, cd_category, cd_director, cd_length, cd_cost);
        this.tracks = new ArrayList<>();
	}

    public CompactDisc(String cd_title) {
		super(cd_title, "Unknown", "Unknown", 0, 0);
        this.tracks = new ArrayList<>();
	}
	public CompactDisc(String cd_title, String cd_category, float cd_cost) {
		this(cd_title, cd_category, "Unknown", 0, cd_cost);
        this.tracks = new ArrayList<>();
	}
	public CompactDisc(String cd_title, String cd_category, String cd_director, float cd_cost) {
		this(cd_title, cd_category, cd_director, 0, cd_cost);
        this.tracks = new ArrayList<>();
	}


    public String getArtist() {
        return artist;
    }
    public void addTrack(Track track) {
        boolean found = false;
        for (Track t: tracks) {
            if (t.equals(track)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Already in track");
        } else {
            tracks.add(track);
            System.out.println("Added successfully");
        }
    }

    public void addTrack(Track ...tracks) {
		for (Track t: tracks) {
			addTrack(t);
		}
	}

    public void removeTrack(Track track) {
        boolean found = false;
        for (Track t: tracks) {
            if (t.equals(track)) {
                found = true;
                break;
            }
        }
        if (found) {
            tracks.remove(track);
            System.out.println("Removed succesfully");
        } else {
            System.out.println("Not in track");
        }
    }
    public int getLength() {
        int length = 0;
        for (Track t: tracks) {
            length += t.getLength();
        }
        return length;
    } 
    public void play() throws PlayerException {
		System.out.println("\nPlaying CD: " +getTitle());
		if(getLength() > 0) {
			for (int i = 0; i < tracks.size(); i++) {
				Track t = tracks.get(i);
				System.out.println("Track no." + String.valueOf(i+1) + "...");
				t.play();
			}
		} else {
			throw new PlayerException("ERROR: CD length is non-positive .");
	    }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(nbDisc).append("\n")
        .append("Title: ").append(this.getTitle()).append("\n")
        .append("Category: ").append(this.getCategory()).append("\n")
        .append("Cost: ").append(this.getCost()).append("\n")
        .append("Length: ").append(this.getLength()).append("\n")
        .append("Director: ").append(this.getDirector()).append("\n")
        .append("Artist: ").append(this.artist).append("\n");
        for (Track t: tracks) {
            sb.append(t.toString());
        }
        return sb.toString();
    }
    public boolean Cointains(Object o) {
        boolean found = false;
        for (Track t: tracks) {
            if (t.equals(o)) {
                found = true;
                break;
            }
        }
        return found;
    }
   
}
