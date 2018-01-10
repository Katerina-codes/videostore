public class RegularMovie {

    private double getAmountForRegular(Rental rental) {
        int days = rental.getDaysRented();
        double points = 2;
        if (days > 2)
            points += (days - 2) * 1.5;
        return points;
    }
}
