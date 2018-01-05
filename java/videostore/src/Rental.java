public class Rental {
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

	private Movie movie;
	private int daysRented;

    double getAmountForRental() {
        return movie.getAmount(daysRented);
    }

    int getFrequentRenterPoints() {
        if (movie instanceof NewReleaseMovie) {
            return ((NewReleaseMovie) movie).getFrequentRenterPoints(daysRented);
        } else {
            return 1;
        }
    }

}
