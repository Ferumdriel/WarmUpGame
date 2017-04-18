package java.environment;

import com.ferumdriel.core.java.entities.Entity;
import com.ferumdriel.core.java.environment.Zone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Mati on 4/18/2017.
 */
class ZoneTest {
    Zone zone1;
    Zone zone2;
    @BeforeAll
    public void generateTestZone(){
        zone1 = Zone.getReadyZone("Las");
        zone2 = Zone.getReadyZone("Jezioro");
    }

    @Test
    void testIfZoneAdded(){
        zone1.addZone(zone2);
        String actualZoneName = zone1.getNeighbourZones().get(0).getZoneName();
        String expectedZoneName = "Jezioro";
        assertEquals(expectedZoneName, actualZoneName);
    }



}