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
            amountOwed += getAmountAccruedForRentals(eachMovie);
            frequentRenterPoints += getFrequentRenterPoints(eachMovie);

            result += "\t" + eachMovie.getMovie().getTitle() + "\t" + String.valueOf(currentAmount) + "\n";
        }
        return result;
    }

    private int getFrequentRenterPoints(Rental eachMovie) {
        if (eachMovie.getMovie().getPriceCode() == Movie.NEW_RELEASE && eachMovie.getDaysRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }

    private double getAmountAccruedForRentals(Rental rental) {
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                return getPointsForRegular(rental);
            case Movie.NEW_RELEASE:
                return getPointsForNewRelease(rental);
            case Movie.CHILDRENS:
                return getPointsForChildrens(rental);
        }
        return 0;
    }

    private double getPointsForChildrens(Rental rental) {
        double points = 1.5;
        if (rental.getDaysRented() > 3)
            points += (rental.getDaysRented() - 3) * 1.5;
        return points;
    }

    private double getPointsForNewRelease(Rental rental) {
        return rental.getDaysRented() * 3;
    }

    private double getPointsForRegular(Rental each) {
        double points = 2;
        if (each.getDaysRented() > 2)
            points += (each.getDaysRented() - 2) * 1.5;
        return points;
    }
}
