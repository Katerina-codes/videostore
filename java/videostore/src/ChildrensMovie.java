public class ChildrensMovie extends Movie {

    public ChildrensMovie(String title) {
        super(title);
    }

    public double getAmount(int days) {
        double points = 1.5;
        if (days > 3)
            points += (days - 3) * 1.5;
        return points;
    }

    public int frequentRenterPoints(int daysRented) {
        return 1;
    }
}
