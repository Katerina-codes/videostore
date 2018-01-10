public class RegularMovie  extends Movie {

    public RegularMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    public static double getAmount(int days) {
        double points = 2;
        if (days > 2)
            points += (days - 2) * 1.5;
        return points;
    }
}
