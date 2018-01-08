public abstract class Movie {
	private String title;

	public Movie(String title) {
		this.title = title;
	}

	public abstract double getAmount(int days);

	public String getTitle() {
		return title;
	}

	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}
}
