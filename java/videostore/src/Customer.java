import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();
    private double amountOwed = 0;
    private int frequentRenterPoints = 0;
    double currentAmount = 0;

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";

        result = updateAmountOwedAndRenterPoints(result);

        result += "You owed " + String.valueOf(amountOwed) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";

        return result;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    private String updateAmountOwedAndRenterPoints(String result) {
        for (Rental eachMovie : rentals) {
            amountOwed += eachMovie.getAmountForRental();
            frequentRenterPoints += eachMovie.getFrequentRenterPoints();

            result += "\t" + eachMovie.getMovie().getTitle() + "\t" + String.valueOf(currentAmount) + "\n";
        }
        return result;
    }

}
