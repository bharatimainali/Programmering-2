public class Planet {
    // instance variable
    private String name;
    private double radius;
    private double mass;

    // Class constructor
    public Planet(String name, double radius, double mass){
        this.name = name;
        this.radius = radius;
        this.mass = mass;
    }

    public void printBeskrivelse(){
        System.out.println("Planet " + this.name +
                " har en radius på " + this.radius +
                " Rjup og en mass på " + this.mass + " Mjup.");
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

    public double getRadiusKm() {
        return this.radius * 71492;
    }

    public double getMassKg() {
        return this.mass * 1.898E27;
    }

    //Oppgave 2.5
    public double getSurfaceGravity() {
        // Setting the gravity constant to correct value
        double gravityConstant = 6.67408E-11;

        // Getting mass in kg
        double massInKg = this.getMassKg();

        // Getting the radius in meters
        double radiusInMeter = this.getRadiusKm() * 1000;

        // Calculating the surface gravity with the formula, and returning the value
        return (gravityConstant * massInKg) / (radiusInMeter * radiusInMeter);
    }

    //Oppgave 3.1
    public double getRadiusRearth() {
        return this.getRadiusKm() / 6371;
    }

    public double getMassMearth() {
        return this.getMassKg() / 5.972E24;
    }

}


