package at.technikum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void testMarkerXIsStored() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
    }

    @Test
    void testMarkerOIsStored() {
        Player player = new Player('O');
        assertEquals('O', player.getMarker());
    }
}