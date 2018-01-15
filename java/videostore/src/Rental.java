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

    public static double getAmountForRental(Rental rental) {
        int days = rental.daysRented;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                return RegularMovie.getAmount(days);
            case Movie.NEW_RELEASE:
                return NewReleaseMovie.getAmount(days);
            case Movie.CHILDRENS:
                return ChildrensMovie.getAmount(days);
        }
        return 0;
    }

    public double getAmountForRental() {
        return getAmountForRental(this);
    }
}
