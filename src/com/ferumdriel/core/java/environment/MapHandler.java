package com.ferumdriel.core.java.environment;

/**
 * Created by Mati on 4/18/2017.
 */
public class MapHandler {
    Zone currZone;

    public MapHandler(){
        currZone = null;
    }

    public void changeZone(Zone zone){
        if (properZoneFound(zone)) {
            System.out.println("Zone changed from: " + currZone + " to: " + zone);
            currZone = zone;
        }else{
            System.out.println("Zone: " + zone + "does not adjoin to: " + currZone);
        }
    }

    private boolean properZoneFound(Zone zone){
        boolean zoneFound = false;
        for(Zone m: currZone.getNeighbourZones()){
            if(zone.getZoneName().equals(m.getZoneName())){
                zoneFound = true;
            }
        }
        return zoneFound;
    }

    public void setCurrZone(Zone currZone) {
        this.currZone = currZone;
    }
}
