import com.codersbaya.MeasurePoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MeasurePointTest {

    @Test
    public void testConstruction() {
        MeasurePoint start = new MeasurePoint(0, 0., 0.);
        assertEquals(0, start.getTime());
        assertEquals(0., start.getSpeed(), 0.);
        assertEquals(0., start.getDistance(), 0.);

        MeasurePoint end = new MeasurePoint(60, 50., 1000.);
        assertEquals(60, end.getTime());
        assertEquals(50., end.getSpeed(), 0.);
        assertEquals(1000., end.getDistance(), 0.);
    }

    @Test
    @DisplayName("the toString method properly prints the given MeasurePoints data")
    public void testToString() {
        MeasurePoint instance = new MeasurePoint(5, 30., 100.);
        String expResult = "Time:    5 s, Speed:   30.00 m/s, Distance:  100.00 m";
        String result = instance.toString();
        assertEquals(expResult, result);

        instance = new MeasurePoint(5000, 3000., 1000.);
        expResult = "Time: 5000 s, Speed: 3000.00 m/s, Distance: 1000.00 m";
        result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    @DisplayName("The compares to method ignores the speed")
    public void testCompareToIgnoresSpeed() {
        MeasurePoint instance = new MeasurePoint(10, 50., 100.);
        MeasurePoint other = new MeasurePoint(10, 15., 100.);

        assertEquals(0, instance.compareTo(other));
        assertEquals(0, other.compareTo(instance));
    }

    @Test
    @DisplayName("a point is smaller than another point if its time is smaller")
    public void testCompareToEarlierInTime() {
        MeasurePoint instance = new MeasurePoint(3, 25., 80.);
        MeasurePoint other = new MeasurePoint(4, 25., 80.);
        assertTrue(instance.compareTo(other) < 0);
    }

    @Test
    @DisplayName("a point is smaller than another point if its time is greater")
    public void testCompareToLaterInTime() {
        MeasurePoint instance = new MeasurePoint(3, 25., 80.);
        MeasurePoint other = new MeasurePoint(4, 25., 80.);
        assertTrue(other.compareTo(instance) > 0);
    }

    @Test
    @DisplayName("two MeasurePoints with the exact same properties are equal")
    public void testEqualsTwoTotallyEqualPoints() {
        MeasurePoint other = new MeasurePoint(3, 20, 50);
        MeasurePoint instance = new MeasurePoint(3, 20, 50);
        assertTrue(instance.equals(other));
    }
}
