public abstract class Movie {

	private String title;

	public Movie(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public abstract double getAmount(int days);

	public abstract int frequentRenterPoints(int daysRented);
}
