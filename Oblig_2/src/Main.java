import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Creating the sun object from Star class.
        Star sun = new Star("Sun", 1, 1, 5777);

        // Creating the ArrayList to hold a list of planets with Planet class.
        ArrayList<Planet> planetsArray = new ArrayList<>();
        // Adding all the planets to the ArrayList
        planetsArray.add(new Planet("Mercury", 0.03412549655905556, 1.7297154899894627E-4));
        planetsArray.add(new Planet("Venus", 0.08465003077267387, 0.002564278187565859));
        planetsArray.add(new Planet("Earth", 0.08911486599899289, 0.003146469968387777));
        planetsArray.add(new Planet("Mars", 0.04741089912158004, 3.3667017913593256E-4));
        planetsArray.add(new Planet("Jupiter", 1.0, 1.0));
        planetsArray.add(new Planet("Saturn", 0.8145247020645666, 0.2994204425711275));
        planetsArray.add(new Planet("Uranus", 0.35475297935433336, 0.04573761854583773));
        planetsArray.add(new Planet("Neptune", 0.34440217087226543, 0.05395152792413066));

        // Creating the solar system object with the class PlanetSystem, containing the sun and the list of planets.
        PlanetSystem solarSystem = new PlanetSystem("Solar system", sun, planetsArray);

        // Printing out description of our solar system, it's center star and it's planets
        System.out.println("Oppgave 2.3");
        solarSystem.printBeskrivelse();

        Planet saturn = planetsArray.get(5);
        System.out.println("\nOppgave 2.4");
        System.out.println("Saturn has a radius of " + saturn.getRadiusKm() + " km and a mass of " + saturn.getMassKg() + " kg.");
        System.out.println("The Sun has a radius of " + sun.getRadiusKm() + " km and a mass of " + sun.getMassKg() + "kg.");


        Planet neptune = planetsArray.get(7);
        System.out.println("\nOppgave 2.5");
        System.out.println("Neptune has a surface gravity of " + neptune.getSurfaceGravity() + " m/s^2");

        System.out.println("\nOppgave 2.6");
        System.out.println("Information about largest and smallest planet respectively:");
        solarSystem.getLargestPlanet().printBeskrivelse();
        solarSystem.getSmallestPlanet().printBeskrivelse();

        Planet mars = planetsArray.get(3);
        System.out.println("\nOppgave 3.1");
        System.out.println("Mars has a radius of " + mars.getRadiusRearth() + " Rearth and a mass of " + mars.getMassMearth() + " Mearth.");

    }
}
