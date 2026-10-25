package labs.pm.data;

/**
 * @author marwane
 **/
public record Review(
        Rating rating,
        String comments) implements Comparable<Review> {
    @Override
    public int compareTo(Review other) {
//        return (this.rating.ordinal() < other.rating().ordinal()) ? -1 :
//                (this.rating.ordinal() > other.rating().ordinal()) ? 1 : 0;
        return Integer.compare(this.rating.ordinal(), other.rating().ordinal());
    }
}
