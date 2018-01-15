public abstract class Movie {

	private String title;

	public Movie(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public abstract double getAmount(int days);

	public int frequentRenterPoints(int daysRented) {
        return 1;
    }
}
