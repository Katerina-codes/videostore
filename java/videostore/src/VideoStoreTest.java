import junit.framework.*;

public class VideoStoreTest extends TestCase {

    private Customer customer;

    public VideoStoreTest(String name) {
        super(name);
    }

    protected void setUp() {
        customer = new Customer("Fred");
    }

    public void testSingleNewReleaseStatement() {
        customer.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));
        customer.statement();
        assertEquals(9.0, customer.getAmountOwed());
        assertEquals(2, customer.getFrequentRenterPoints());
    }

    public void testDualNewReleaseStatement() {
        customer.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("The Tigger Movie", Movie.NEW_RELEASE), 3));
        customer.statement();
        assertEquals(18.0, customer.getAmountOwed());
        assertEquals(4, customer.getFrequentRenterPoints());
    }

    public void testSingleChildrensStatement() {
        customer.addRental(new Rental(new Movie("The Tigger Movie", Movie.CHILDRENS), 3));
        customer.statement();
        assertEquals(1.5, customer.getAmountOwed());
        assertEquals(1, customer.getFrequentRenterPoints());
    }

    public void testMultipleRegularStatement() {
        customer.addRental(new Rental(new Movie("Plan 9 from Outer Space", Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie("8 1/2", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Eraserhead", Movie.REGULAR), 3));
        customer.statement();
        assertEquals(7.5, customer.getAmountOwed());
        assertEquals(3, customer.getFrequentRenterPoints());
    }
}