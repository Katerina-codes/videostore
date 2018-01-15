public class ChildrensMovie extends Movie {

    public ChildrensMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    public double getAmount(int days) {
        double points = 1.5;
        if (days > 3)
            points += (days - 3) * 1.5;
        return points;
    }
}
