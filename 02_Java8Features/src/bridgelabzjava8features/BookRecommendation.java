package bridgelabzjava8features;

public class BookRecommendation {

    private String title;
    private double rating;

    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "BookRecommendation{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }
}
