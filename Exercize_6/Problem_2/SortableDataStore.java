package Exercize_6.Problem_2;
public class SortableDataStore implements Comparable<SortableDataStore> {
    private String first;
    private String second;
    private String third;

    public SortableDataStore(String first, String second, String third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public int compareTo(SortableDataStore other) {
        int firstComparison = this.first.compareTo(other.first);
        if (firstComparison != 0) {
            return firstComparison;
        }

        int secondComparison = this.second.compareTo(other.second);
        if (secondComparison != 0) {
            return secondComparison;
        }

        return this.third.compareTo(other.third);
    }

    public String toString(String str1, String str2) {
        return str1 + ", " + str2;
    }

    @Override
    public String toString() {
        return first + ", " + second + ", " + third;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public String getThird() {
        return third;
    }
}
