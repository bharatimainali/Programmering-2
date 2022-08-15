package no.hiof.bharatim.models;

import no.hiof.bharatim.interfaces.ObjectFileHandler;

import java.util.Collections;

public abstract class CelestialBody implements ObjectFileHandler, Comparable<CelestialBody> {
    private String name;
    private double radius;
    private double mass;
    private static final double gravityConst = 6.67408E-11;
    private static final double au = 149_597_871;

    public CelestialBody(String name, double radius, double mass){
        this.name = name;
        this.radius = radius;
        this.mass = mass;
    }



    @Override
    public int compareTo(CelestialBody celestialBody) {
        if(mass == celestialBody.getMass()) {
            return 0;
        }
        else if (mass > celestialBody.getMass()) {
            return -1;
        }
        else {
            return 1;
        }
    }


    public double getGravityConst(){
        return gravityConst;
    }

    public double getAu(){
        return au;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
    public abstract String toString();
    public abstract double getRadiusInKm();
    public abstract double getMassInKg();



}


