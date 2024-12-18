package hust.soict.dsai.aims.media;

public abstract class Media {
    private static int nbMedia = 0;
    private int id;
    private String title;
    private String category;
    private float cost;
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(String media_title, String media_category, float media_cost) {
		if(media_title.isBlank()) {
			title = "Unknown";
			System.out.println("Warning: Media created without title.");
		} else {
			title = media_title;
		}
		category = media_category;
		cost = media_cost;
		id = nbMedia++;
	}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public String toString() {
        return "Id: " + id + "\n"
        + "Title: " + title + "\n"
        + "Category: " + category + "\n"
        + "Cost: " + cost + ".";
    }
    public boolean equals(Object obj) {
        try {
            Media otherMedia = (Media) obj;

            return this.title != null && this.title.equals(otherMedia.getTitle());
        } catch (NullPointerException | ClassCastException e) {
            return false; 
        }
    }
}
