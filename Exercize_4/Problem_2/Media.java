package Exercize_4.Problem_2;

/**
 * Media - Parent class representing a generic media item in the library
 */
public class Media {
    protected String title;
    protected int year;

    public Media(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Media{" +
                "title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
