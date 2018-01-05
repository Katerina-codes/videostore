public class ChildrenMovie extends Movie {

    public ChildrenMovie(String title) {
        super(title, Movie.CHILDRENS);
    }

    public double getAmount(int days) {
        double points = 1.5;
        if (days > 3)
            points += (days - 3) * 1.5;
        return points;
    }
}
