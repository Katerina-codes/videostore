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

    public static double getAmountForRental(Rental rental) {
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                return getAmountForRegular(rental);
            case Movie.NEW_RELEASE:
                return getAmountForNewRelease(rental);
            case Movie.CHILDRENS:
                return getAmountForChildrens(rental);
        }
        return 0;
    }

    private static double getAmountForChildrens(Rental rental) {
        int days = rental.getDaysRented();
        double points = 1.5;
        if (days > 3)
            points += (days - 3) * 1.5;
        return points;
    }

    private static double getAmountForNewRelease(Rental rental) {
        int days = rental.getDaysRented();
        return days * 3;
    }

    private static double getAmountForRegular(Rental rental) {
        int days = rental.getDaysRented();
        double points = 2;
        if (days > 2)
            points += (days - 2) * 1.5;
        return points;
    }
}
