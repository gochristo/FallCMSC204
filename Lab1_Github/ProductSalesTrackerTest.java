import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTrackerTest {
    private ProductSalesTracker tracker1;
    private ProductSalesTracker tracker2;
    private ProductSalesTracker tracker3;

    @BeforeEach
    public void setUp() {
        tracker1 = new ProductSalesTracker(5);
        tracker2 = new ProductSalesTracker(2);
        tracker3 = new ProductSalesTracker(3);

        tracker1.addSale(1.0);
        tracker1.addSale(2.0);
        tracker1.addSale(3.0);

        tracker2.addSale(50.0);
    }
    @AfterEach
    public void tearDown() {
        tracker1 = null;
        tracker2 = null;
    }
    @Test
    public void testAddSale() {
        assertTrue(tracker1.addSale(4.0));

        assertTrue(tracker2.addSale(1.0));
        assertFalse(tracker2.addSale(500.0));
    }
    @Test
    public void testTotalSales() {
        assertEquals(6.0,tracker1.totalSales());
        assertEquals(50.0,tracker2.totalSales());
    }
    @Test
    public void testLowestSale() {
        assertEquals(1.0,tracker1.lowestSale());
        assertEquals(50.0,tracker2.lowestSale());
        assertEquals(0.0,tracker3.lowestSale());
    }
    @Test
    public void testFinalSalesTotal() {
        assertEquals(5.0,tracker1.finalSalesTotal());
        assertEquals(0.0,tracker2.finalSalesTotal());
        assertEquals(0.0,tracker3.lowestSale());
    }
    @Test
    public void testToString() {
        assertEquals("1.0 2.0 3.0", tracker1.toString());
        assertEquals("50.0", tracker2.toString());
        assertEquals("", tracker3.toString());
    }
}