import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class VideoStoreTest {

    private final Movie newReleaseMovie1 = new Movie("The Cell", Movie.NEW_RELEASE);
    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("Fred");
    }

    @Test
    public void testSingleNewReleaseStatement() {
        customer.addRental(new Rental(newReleaseMovie1, 3));
        customer.statement();
        assertEquals(9.0, customer.getAmountOwed());
        assertEquals(2, customer.getFrequentRenterPoints());
    }

    @Test
    public void testDualNewReleaseStatement() {
        customer.addRental(new Rental(newReleaseMovie1, 3));
        customer.addRental(new Rental(new Movie("The Tigger Movie", Movie.NEW_RELEASE), 3));
        customer.statement();
        assertEquals(18.0, customer.getAmountOwed());
        assertEquals(4, customer.getFrequentRenterPoints());
    }

    @Test
    public void testSingleChildrensStatement() {
        customer.addRental(new Rental(new Movie("The Tigger Movie", Movie.CHILDRENS), 3));
        customer.statement();
        assertEquals(1.5, customer.getAmountOwed());
        assertEquals(1, customer.getFrequentRenterPoints());
    }

    @Test
    public void testMultipleRegularStatement() {
        customer.addRental(new Rental(new Movie("Plan 9 from Outer Space", Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie("8 1/2", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Eraserhead", Movie.REGULAR), 3));
        customer.statement();
        assertEquals(7.5, customer.getAmountOwed());
        assertEquals(3, customer.getFrequentRenterPoints());
    }
}