package no.hiof.bharatim.models;

import java.io.File;

public class Star extends CelestialBody {

    private int effectiveTemp;
    private static final double rsun = 695_700;
    private static final double msun = 1.98892E30;

    public Star(String name, double radius, double mass, int effectiveTemp) {
        super(name, radius, mass);
        this.effectiveTemp = effectiveTemp;
    }

    @Override
    public double getRadiusInKm() {
        return 695_700;
    }

    public double getradiusInKm() {
        return super.getRadius() * rsun;
    }

    @Override
    public double getMassInKg() {
        return 1.98892E30;
    }

    public double getmassInKg() {
        return super.getMass() * msun;
    }

    public double getSurfaceGravity() {
        return (super.getGravityConst() * getmassInKg()) / Math.pow(getradiusInKm()*1000, 2);
    }

    @Override
    public String toString() {
        return "The star " + super.getName() + " has a radius of " + super.getRadius() +
                " Rsun, and a mass of " + super.getMass() + " Msun. It's effective temperature is " +
                effectiveTemp + " kelvin.";
    }


    public int getEffectiveTemp() {
        return effectiveTemp;
    }

    public void setEffectiveTemp(int effectiveTemp) {
        this.effectiveTemp = effectiveTemp;
    }


    @Override
    public void writeObjectsToFile(Object o, File file) {

    }

    @Override
    public Object readObjectsFromFile(File file) {
        return null;
    }
}
