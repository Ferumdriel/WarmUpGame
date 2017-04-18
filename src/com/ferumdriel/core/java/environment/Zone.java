package com.ferumdriel.core.java.environment;

import com.ferumdriel.core.java.entities.Entity;

import java.util.ArrayList;

/**
 * Created by Mati on 4/18/2017.
 */
public class Zone {
    ArrayList<Zone> neighbourZones;
    private String zoneName;
    private ArrayList<Entity> currEnt; //list of all entities currently present in zone

    public Zone(String name, Zone ...zones){
        zoneName = name;
        currEnt = new ArrayList<>();
        neighbourZones = new ArrayList<>();
        for(int i = 0; i < zones.length; i++){
            neighbourZones.add(zones[i]);
        }
    }

    private void randomlyGenerateZone(){
        for(int i = 0; i < 10; i++){
        currEnt.add(new Entity("Ada" + i));
        }
    }

    public static Zone getReadyZone(String name, Zone ...zones){
        Zone zone = new Zone(name);
        zone.randomlyGenerateZone();
        return zone;
    }

    public ArrayList<Entity> getCurrEnt() {
        return currEnt;
    }

    public String toString(){
        String s = "Current zone: " + zoneName + "\n";
        s += "Current entities list: \n";
        for(Entity m: currEnt){
            s+= m + "\n";
        }
        return s;
    }

    public ArrayList<Zone> getNeighbourZones() {
        return neighbourZones;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void addZone(Zone zone){
        neighbourZones.add(zone);
    }
}
