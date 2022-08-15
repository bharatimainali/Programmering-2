package no.hiof.bharatim.models;

import no.hiof.bharatim.interfaces.ObjectFileHandler;

import java.io.File;
import java.util.ArrayList;


public class PlanetSystem implements ObjectFileHandler, Comparable<PlanetSystem> {
    private String name;
    private Star centerStar;
    private ArrayList<Planet> planets;

    public PlanetSystem(String name, Star centerStar, ArrayList<Planet> planets) {
        this.name = name;
        this.centerStar = centerStar;
        this.planets = planets;
    }

    @Override
    public int compareTo(PlanetSystem planetSystem) {
        if(planets.size() == planetSystem.getPlanets().size()) {
            return 0;
        }
        else if (planets.size() > planetSystem.getPlanets().size()) {
            return 1;
        }
        else {
            return -1;
        }
    }

    public Planet getBiggestPlanet() {
        Planet biggestPlanet = planets.get(0);
        for (Planet planet : planets) {
            if (planet.getRadius() > biggestPlanet.getRadius()) {
                biggestPlanet = planet;
            }
            else if (planet.getRadius() == biggestPlanet.getRadius() &&
                    planet.getMass() > biggestPlanet.getMass()) {
                biggestPlanet = planet;
            }
        }
        return biggestPlanet;
    }

    public Planet getSmallestPlanet() {
        Planet smallestPlanet = planets.get(0);
        for (Planet planet : planets) {
            if (planet.getRadius() < smallestPlanet.getRadius()) {
                smallestPlanet = planet;
            }
            else if (planet.getRadius() == smallestPlanet.getRadius() &&
                    planet.getMass() < smallestPlanet.getMass()) {
                smallestPlanet = planet;
            }
        }
        return smallestPlanet;
    }
    //2.2
    public Planet getPlanetByName(String planetName){
        Planet getPlanet = null;
        for (Planet planet : planets){
            if(planet.getName().equalsIgnoreCase(planetName)){
                getPlanet = planet;
            }
        }
        return getPlanet;
        //til here
    }

    @Override
    public String toString() {
        return "The planet system " + name + " has the center star " + centerStar.getName() +
                " and a total of " + planets.size() + " planets.";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(ArrayList<Planet> planets) {
        this.planets = planets;
    }


    @Override
    public void writeObjectsToFile(Object o, File file) {

    }

    @Override
    public Object readObjectsFromFile(File file) {
        return null;
    }
}
