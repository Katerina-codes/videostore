public class NewReleaseMovie extends Movie {

    public NewReleaseMovie(String title) {
        super(title);
    }

    public double getAmount(int days) {
        return days * 3;
    }

    public int frequentRenterPoints(int daysRented) {
        if (daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
