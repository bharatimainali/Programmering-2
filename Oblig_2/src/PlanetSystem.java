import java.util.ArrayList;
import java.util.Collections;

public class PlanetSystem {

    private String name;
    private Star centerStar;
    private ArrayList<Planet> planets;

    public PlanetSystem(String name, Star centerStar, ArrayList planets){
        this.name = name;
        this.centerStar = centerStar;
        this.planets = planets;
    }

    public void printBeskrivelse() {
        System.out.println("Information about '" + this.name + "':\n\nThe center star:");
        centerStar.printBeskrivelse(); // Printing out description for center star from Star class
        System.out.println("\nAnd the planets are:");
        for (Planet planet : planets) { // Printing out description for each planet in the list from Planet class
            planet.printBeskrivelse();
        }
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

    public ArrayList getPlanets() {
        return planets;
    }

    public void setPlanets(ArrayList planets) {
        this.planets = planets;
    }

    // Oppgave 2.6, returning the planet with the max radius.
    public Planet getLargestPlanet() {
        ArrayList<Double> planetRadiusList = new ArrayList<>();
        for (Planet planet : planets) {
            planetRadiusList.add(planet.getRadius());
        }

        int indexOfBiggest = planetRadiusList.indexOf(Collections.max(planetRadiusList));

        return planets.get(indexOfBiggest);
    }
    // returning the planet with the min radius. Oppgave 2.6
    public Planet getSmallestPlanet() {
        ArrayList<Double> planetRadiusList = new ArrayList<>();
        for (Planet planet : planets) {
            planetRadiusList.add(planet.getRadius());
        }

        int indexOfSmallest = planetRadiusList.indexOf(Collections.min(planetRadiusList));

        return planets.get(indexOfSmallest);
    }

}


