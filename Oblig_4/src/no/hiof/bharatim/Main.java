package no.hiof.bharatim;

import no.hiof.bharatim.models.Planet;
import no.hiof.bharatim.models.PlanetSystem;
import no.hiof.bharatim.models.Star;
import no.hiof.bharatim.tools.StarCSVFileHandler;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        // Oppretter Star-objektet som representerer solsystemets sol
        Star sun = new Star("Sun", 1.0, 1.0, 5777);

        // Oppretter en rekke med planet-objekter
        Planet mercury = new Planet("Mercury", 0.03412549655905556, 1.7297154899894627E-4, 0.387, 0.206, 88, sun);
        Planet venus = new Planet("Venus", 0.08465003077267387, 0.002564278187565859, 0.723, 0.007, 225, sun);
        Planet earth = new Planet("Earth", 0.08911486599899289, 0.003146469968387777, 1, 0.017, 365, sun);
        Planet mars = new Planet("Mars", 0.04741089912158004, 3.3667017913593256E-4, 1.524, 0.093, 687, sun);
        Planet jupiter = new Planet("Jupiter", 1.0, 1.0, 5.20440, 0.049, 4380, sun);
        Planet saturn = new Planet("Saturn", 0.8145247020645666, 0.2994204425711275, 9.5826, 0.057, 10585, sun);
        Planet uranus = new Planet("Uranus", 0.35475297935433336, 0.04573761854583773, 19.2184, 0.046, 30660, sun);
        Planet neptune = new Planet("Neptune", 0.34440217087226543, 0.05395152792413066, 30.11, 0.010, 60225, sun);

        //) Legger til planet-objektene i en arrayliste
        ArrayList<Planet> planets = new ArrayList<>();
        planets.add(mercury);
        planets.add(venus);
        planets.add(earth);
        planets.add(mars);
        planets.add(jupiter);
        planets.add(saturn);
        planets.add(uranus);
        planets.add(neptune);

        Collections.sort(planets);


        for(Planet planet : planets){
            System.out.println(planet);
        }

        // Oppretter planetsystemet "Solar system"
        PlanetSystem planetSystem = new PlanetSystem("Solar system", sun, planets);

        System.out.println();

        String randomText = "Plannet system ser veldig interesant ut";

        StarCSVFileHandler filetest = new StarCSVFileHandler();

        ArrayList<Star> stars = new ArrayList<>();
        stars.add(sun);
        stars.add(new Star("MU Cas",4.192, 4.657, 14750));
        stars.add(new Star("V69-47",1.316, 0.876, 5945));
        stars.add(new Star("YZ Cas",2.547, 2.308, 9200));
        stars.add(new Star("NGC188",1.425, 1.102, 5900));
        stars.add(new Star("zet Phe",2.853, 3.922, 14550));

        filetest.writeObjectsToFile(stars, new File("test.txt"));

        ArrayList<Star> starsFromFile = filetest.readObjectsFromFile(new File("test.txt"));

        for (Star currentStar : starsFromFile) {
            System.out.println(currentStar);
        }


    }
}
