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
        int days = daysRented;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                return RegularMovie.getAmount(days);
            case Movie.NEW_RELEASE:
                return NewReleaseMovie.getAmount(days);
            case Movie.CHILDRENS:
                return ChildrensMovie.getAmount(days);
        }
        return 0;
    }
}
