import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();
    private double amountOwed;
    private int frequentRenterPoints;

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
        amountOwed = 0;
        frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental eachMovie : rentals) {
            double currentAmount = 0;

            amountOwed += getAmountAccrued(eachMovie, currentAmount);

            getFrequentRenterPoints(eachMovie);

            result += "\t" + eachMovie.getMovie().getTitle() + "\t" + String.valueOf(currentAmount) + "\n";
        }

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

    private double getAmountAccrued(Rental eachMovie, double currentAmount) {
        return amountAccruedForRentals(currentAmount, eachMovie);
    }
    private void getFrequentRenterPoints(Rental eachMovie) {
        frequentRenterPoints++;

        if (eachMovie.getMovie().getPriceCode() == Movie.NEW_RELEASE
                && eachMovie.getDaysRented() > 1)
            frequentRenterPoints++;
    }

    private double amountAccruedForRentals(double currentAmount, Rental each) {
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                currentAmount += 2;
                if (each.getDaysRented() > 2)
                    currentAmount += (each.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                currentAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                currentAmount += 1.5;
                if (each.getDaysRented() > 3)
                    currentAmount += (each.getDaysRented() - 3) * 1.5;
                break;
        }
        return currentAmount;
    }
}
