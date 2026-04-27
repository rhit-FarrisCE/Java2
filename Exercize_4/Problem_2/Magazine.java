package Exercize_4.Problem_2;

/**
 * Magazine - Child class representing a magazine in the library
 */
public class Magazine extends Media {
    private int issueNumber;

    public Magazine(String title, int year, int issueNumber) {
        super(title, year);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", issueNumber=" + issueNumber +
                '}';
    }
}
