public class Rental {
    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getAmountForRental() {
        return getMovie().getAmount(daysRented);
    }

    public int frequentRenterPoints() {
        return getMovie().frequentRenterPoints(getDaysRented());
    }
}
