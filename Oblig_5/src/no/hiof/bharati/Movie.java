package no.hiof.bharati;

public class Movie extends Media {
    private String directorName;
    private String actor;

    public Movie(String name, int releaseYear, double rating, String genre, String directorName, String actor) {
        super(name, releaseYear, rating, genre);
        this.directorName = directorName;
        this.actor = actor;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

}



