package no.hiof.bharatim.oblig3.models;

 public abstract class CelestialBody {
    private String name;
    private double radius;
    private double mass;
    private static final double gravityConst = 6.67408E-11;
     private static final double au = 149_597_871;

    public CelestialBody(String name, double radius, double mass){
        System.out.println("constructing an CelestialBody");
        this.name = name;
        this.radius = radius;
        this.mass = mass;
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


