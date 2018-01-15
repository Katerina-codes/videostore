import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class VideoStoreTest {

    private Customer customer;
    private Movie newReleaseMovie1;
    private Movie regularMovie3;
    private Movie newReleaseMovie2;
    private Movie regularMovie1;
    private Movie newChildrensMovie;
    private Movie regularMove2;

    @Before
    public void setUp() {
        customer = new Customer("Fred");
        newReleaseMovie1 = new NewReleaseMovie("The Cell");
        newReleaseMovie2 = new NewReleaseMovie("The Tigger Movie");
        newChildrensMovie = new ChildrensMovie("The Tigger Movie");
        regularMovie1 = new RegularMovie("Plan 9 from Outer Space");
        regularMove2 = new RegularMovie("8 1/2");
        regularMovie3 = new RegularMovie("Eraserhead");
    }

    @Test
    public void singleNewReleaseStatement () {
        customer.addRental(new Rental (newReleaseMovie1, 3));
        assertEquals ("Rental Record for Fred\n" +
                "\tThe Cell\t9.0\n" +
                "You owed 9.0\n" +
                "You earned 2 frequent renter points\n", customer.statement ());
    }

    @Test
    public void singleNewRelease() {
        customer.addRental(new Rental(newReleaseMovie1, 3));
        customer.statement();
        assertEquals(9.0, customer.totalAmountOwed());
        assertEquals(2, customer.frequentRenterPoints());
    }

    @Test
    public void multipleNewReleases() {
        customer.addRental(new Rental(newReleaseMovie1, 3));
        customer.addRental(new Rental(newReleaseMovie2, 3));
        customer.statement();
        assertEquals(18.0, customer.totalAmountOwed());
        assertEquals(4, customer.frequentRenterPoints());
    }

    @Test
    public void childrensMovie() {
        customer.addRental(new Rental(newChildrensMovie, 3));
        customer.statement();
        assertEquals(1.5, customer.totalAmountOwed());
        assertEquals(1, customer.frequentRenterPoints());
    }

    @Test
    public void multipleRegular() {
        customer.addRental(new Rental(regularMovie1, 1));
        customer.addRental(new Rental(regularMove2, 2));
        customer.addRental(new Rental(regularMovie3, 3));
        customer.statement();
        assertEquals(7.5, customer.totalAmountOwed());
        assertEquals(3, customer.frequentRenterPoints());
    }
}