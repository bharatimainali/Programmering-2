package no.hiof.bharati;

public class Music extends Media {
    private double lengthInMinutes;
    private String audioSampleRate;

    public Music(String name, int releaseYear, double rating, String genre, double lengthInMinutes, String audioSampleRate) {
        super(name, releaseYear, rating, genre);
        this.lengthInMinutes = lengthInMinutes;
        this.audioSampleRate = audioSampleRate;
    }

    public double getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(double lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public String getAudioSampleRate() {
        return audioSampleRate;
    }

    public void setAudioSampleRate(String audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }
}
