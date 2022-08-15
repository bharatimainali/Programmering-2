package no.hiof.bharatim.oblig3.models;

public class Planet extends NaturalSatellite {

    private static final double rjup = 71_492;
    private static final double mjup = 1.898E27;
    private static final double rearth = 6371;
    private static final double mearth = 5.972E24;


    public Planet(String name, double radius, double mass, double semiMajorAxis, double eccentricity, double orbitalPeriod, CelestialBody centralCelestialBody) {
        super(name, radius, mass, semiMajorAxis, eccentricity, orbitalPeriod, centralCelestialBody);
    }


    public double getradiusInKm() {
        return super.getRadius() * rjup;
    }

    public double getmassInKg() {
        return super.getMass() * mjup;
    }

    public double radiusInRearth() {
        return getradiusInKm()/rearth;
    }

    public double massInMearth() {
        return getmassInKg()/mearth;
    }

    public double getSurfaceGravity() {
        //g = GM/R^2
        return (getGravityConst() * getmassInKg()) / Math.pow(getRadiusInKm()*1000, 2);
    }

    @Override
    public String toString() {
        return "The planet " + super.getName() + " has a radius of " + super.getRadius() +
                " Rjup, and a mass of " + super.getMass() + " Mjup.";
    }

    @Override
    public double getRadiusInKm() {
        return 71_492;
    }

    @Override
    public double getMassInKg() {
        return 1.898E27;
    }



}
