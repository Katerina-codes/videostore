import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        String statement = "Rental Record for " + name + "\n";

        for (Rental rental : rentals) {
            statement += "\t" + rental.getMovie().getTitle() + "\t" + Rental.getAmountForRental(rental) + "\n";
        }

        statement += "You owed " + totalAmountOwed() + "\n";
        statement += "You earned " + frequentRenterPoints() + " frequent renter points\n";

        return statement;
    }

    public double totalAmountOwed() {
        double totalAmountOwed = 0;
        for (Rental rental : rentals) {
            totalAmountOwed += Rental.getAmountForRental(rental);
        }
        return totalAmountOwed;
    }

    public int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += frequentRenterPoints(rental);
        }
        return frequentRenterPoints;
    }

    private int frequentRenterPoints(Rental rental) {
        if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
