import java.util.Objects;

public class FilmRecord {
    protected String title;
    protected float Movie_Rating;
    protected int No_of_Ratings;
    protected String Format;
    protected int ReleaseYear;
    protected String Directed_By;
    public FilmRecord(String[] items) {
        this.title = items[1];
        this.Movie_Rating = Float.parseFloat(items[2]);
        this.No_of_Ratings = Integer.parseInt(items[3]);
        this.Format = items[4];
        this.ReleaseYear = Integer.parseInt(items[5]);
        this.Directed_By = items[7];
    }

    public String get_title() {
        return this.title;
    }
    public float get_rating() {
        return this.Movie_Rating;
    }
    public int get_releseYear() {
        return this.ReleaseYear;
    }

    @Override
    public String toString() {
        return title + ", " +
                Movie_Rating + ", " +
                No_of_Ratings + ", " +
                Format + ", " +
                ReleaseYear + ", " +
                Directed_By;
    }

    public boolean equals(FilmRecord other) {
        if (other == null) return false;
        else if (this == other) {
            return true;
        }
        else return (Objects.equals(title, other.title)) && (Objects.equals(Movie_Rating, other.Movie_Rating)) &&
                    (Objects.equals(ReleaseYear, other.ReleaseYear)) && (Objects.equals(Directed_By, other.Directed_By)) &&
                    (Objects.equals(No_of_Ratings, other.No_of_Ratings)) && (Objects.equals(Format, other.Format));

    }
}
