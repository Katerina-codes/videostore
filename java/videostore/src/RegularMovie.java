public class RegularMovie extends Movie {

    public RegularMovie(String title) {
        super(title, Movie.REGULAR);
    }

    public double getAmount(int days) {
        double points = 2;
        if (days > 2)
            points += (days - 2) * 1.5;
        return points;
    }
}
