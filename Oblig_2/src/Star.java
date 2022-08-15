public class Star {
// instance variable
    private String name;
    private int radius;
    private int mass;
    private int effectiveTemp;

    // class constructor
    public Star(String name, int radius, int mass, int effectiveTemp){
        this.name = name;
        this.radius = radius;
        this.mass = mass;
        this.effectiveTemp = effectiveTemp;

    }

    public void printBeskrivelse(){
        System.out.println("Stjernen " + this.name +
                " har en radius på " + this.radius +
                " Rsun og en masse på " + this.mass + " Msun.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public int getEffectiveTemp() {
        return effectiveTemp;
    }

    public void setEffectiveTemp(int effectiveTemp) {
        this.effectiveTemp = effectiveTemp;
    }

    public double getRadiusKm() {
        return this.radius * 695700;
    }

    public double getMassKg() {
        return this.mass * 1.98892E30;
    }


}
