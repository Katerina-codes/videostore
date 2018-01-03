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
            getFrequentRenterPoints(eachMovie);

            result += "\t" + eachMovie.getMovie().getTitle() + "\t" + String.valueOf(currentAmount) + "\n";
        }
        return result;
    }

    private int getFrequentRenterPoints(Rental eachMovie) {
        if (eachMovie.getMovie().getPriceCode() == Movie.NEW_RELEASE && eachMovie.getDaysRented() > 1) {
            frequentRenterPoints += 2;
        } else {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    private double getAmountAccruedForRentals(Rental each) {
        double points = 0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                points += 2;
                if (each.getDaysRented() > 2)
                    points += (each.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                points += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                points += 1.5;
                if (each.getDaysRented() > 3)
                    points += (each.getDaysRented() - 3) * 1.5;
                break;
        }
        return points;
    }
}
