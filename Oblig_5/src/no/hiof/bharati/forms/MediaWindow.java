package no.hiof.bharati.forms;

import no.hiof.bharati.Media;
import no.hiof.bharati.Movie;
import no.hiof.bharati.Music;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MediaWindow extends javax.swing.JFrame {

    private JPanel panelLeft;
    private JPanel panelRight;
    private JList<String> mediaJList;
    private JButton saveButton;
    private JButton exitButton;
    private JTextField textDirectorName;
    private JTextField textActor;
    private JTextField textMediaName;
    private JTextField textMediaGenre;
    private JTextField textMediaReleaseYear;
    private JPanel PanelMain;
    private JTextField textMediaRating;
    private JLabel ratingLabel;
    private JLabel releaseYearLabel;
    private JLabel genreLabel;
    private JLabel movieNameLabel;
    private JLabel actorNameLabel;
    private JLabel directorNameLabel;
    private JTextField textLengthInMinutes;
    private JTextField textAudioSampleRate;
    private JLabel lengthInMinutesLabel;
    private JLabel audioSampleRateLabel;
    private final ArrayList<Media> listOfMedia;
    private final DefaultListModel<String> movieListModel;

    MediaWindow(){
        
        super("Media browser program");
        this.setContentPane(this.PanelMain);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        listOfMedia = new ArrayList<Media>();
        movieListModel = new DefaultListModel<>();
        mediaJList.setModel(movieListModel);
        saveButton.setEnabled(false);

        directorNameLabel.setVisible(false);
        textDirectorName.setVisible(false);
        actorNameLabel.setVisible(false);
        textActor.setVisible(false);
        textLengthInMinutes.setVisible(false);
        textAudioSampleRate.setVisible(false);
        lengthInMinutesLabel.setVisible(false);
        audioSampleRateLabel.setVisible(false);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Media selectedMedia = listOfMedia.get(mediaJList.getSelectedIndex());

                if (selectedMedia instanceof Movie) {
                    ((Movie) selectedMedia).setDirectorName(textDirectorName.getText());
                    ((Movie) selectedMedia).setActor(textActor.getText());
                }
                else if (selectedMedia instanceof Music) {
                    ((Music) selectedMedia).setAudioSampleRate(textAudioSampleRate.getText());
                    ((Music) selectedMedia).setLengthInMinutes(Double.parseDouble(textLengthInMinutes.getText()));
                }

                selectedMedia.setName(textMediaName.getText());
                selectedMedia.setGenre(textMediaGenre.getText());
                selectedMedia.setReleaseYear(Integer.parseInt(textMediaReleaseYear.getText()));
                selectedMedia.setRating(Double.parseDouble(textMediaRating.getText()));

                refreshMediaJList();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitButton.addActionListener((event) -> System.exit(0));
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });

        mediaJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int mediaIndex = mediaJList.getSelectedIndex();
                if (mediaIndex >= 0){

                    Media currentMedia = listOfMedia.get(mediaIndex);

                    if (currentMedia instanceof Movie) {
                        textDirectorName.setText(((Movie) currentMedia).getDirectorName());
                        textActor.setText(((Movie) currentMedia).getActor());
                        directorNameLabel.setVisible(true);
                        textDirectorName.setVisible(true);
                        actorNameLabel.setVisible(true);
                        textActor.setVisible(true);
                        textLengthInMinutes.setVisible(false);
                        textAudioSampleRate.setVisible(false);
                        lengthInMinutesLabel.setVisible(false);
                        audioSampleRateLabel.setVisible(false);
                    }
                    else if (currentMedia instanceof Music) {
                        textLengthInMinutes.setText(String.valueOf(((Music) currentMedia).getLengthInMinutes()));
                        textAudioSampleRate.setText(String.valueOf(((Music) currentMedia).getAudioSampleRate()));
                        textLengthInMinutes.setVisible(true);
                        textAudioSampleRate.setVisible(true);
                        lengthInMinutesLabel.setVisible(true);
                        audioSampleRateLabel.setVisible(true);
                        directorNameLabel.setVisible(false);
                        textDirectorName.setVisible(false);
                        actorNameLabel.setVisible(false);
                        textActor.setVisible(false);
                    }

                    textMediaName.setText(currentMedia.getName());
                    textMediaGenre.setText(currentMedia.getGenre());
                    textMediaRating.setText(String.valueOf(currentMedia.getRating()));
                    textMediaReleaseYear.setText(String.valueOf(currentMedia.getReleaseYear()));
                    saveButton.setEnabled(true);

                }else {

                    saveButton.setEnabled(false);
                }
            }
        });

    }

    public void refreshMediaJList(){
        movieListModel.removeAllElements();
        // System.out.println("Removing all movies from list");
        for (Media media : listOfMedia){
            if (media instanceof Movie) {
                movieListModel.addElement("Movie: " + media.getName());
            }
            else if (media instanceof Music) {
                movieListModel.addElement("Music: " + media.getName());
            }
        }
    }

    public void addMedia(Media media){
        listOfMedia.add(media);
        refreshMediaJList();
    }

    public static void main(String[] args) {
        MediaWindow mediaBrowser = new MediaWindow();
        mediaBrowser.setVisible(true);

        Movie fran = new Movie("The 400 Blows",
                1959, 8.1, "Crime, Drama", "François Truffaut", "Jean-Pierre Léaud, Albert Rémy, Claire Maurier, Guy Decomble");

        Movie math = new Movie("La Haine",
                1995, 8.1, "Crime, Drama", "Mathieu Kassovitz", "Vincent Cassel, Hubert Koundé, Saïd Taghmaoui, Abdel Ahmed Ghili");

        Movie frann = new Movie("The Godfather",
                1972, 9.2, "Crime, Drama", "Francis Ford Coppola", "Marlon Brando, Al Pacino, James Caan, Diane Keaton");

        Movie ford = new Movie("The Godfather: Part II",
                1974, 9, "Crime, Drama", "Francis Ford Coppola", "Al Pacino, Robert De Niro, Robert Duvall, Diane Keaton");

        Movie mar = new Movie("Man Bites Dog",
                1992, 7.4, "Comedy, Crime, Drama", "Martin Scorsese", "Benoît Poelvoorde, Jacqueline Poelvoorde-Pappaert, Nelly Pappaert, Hector Pappaert");

        Music week = new Music("Blinding Lights", 2020, 7.8, "R&B, Soul, Synthwave", 3.35, "48kHz");

        Music sik = new Music("See You Again", 2015, 9, "Pop rap, Pop, Hiphop/Rap", 5, "49kHz");

        Music giu = new Music("Sorry", 2015, 8.1, "Dance/Elektronisk, R&B/Sou", 4.1, "48kHz");

        Music olt = new Music("Blank space", 1998, 7.5, "Pop", 2.55, "49kHz");

        Music sut = new Music("Roar", 2013, 7.8, "pop", 4, "48kHz");

        mediaBrowser.addMedia(fran);
        mediaBrowser.addMedia(math);
        mediaBrowser.addMedia(frann);
        mediaBrowser.addMedia(ford);
        mediaBrowser.addMedia(mar);
        mediaBrowser.addMedia(week);
        mediaBrowser.addMedia(sik);
        mediaBrowser.addMedia(giu);
        mediaBrowser.addMedia(olt);
        mediaBrowser.addMedia(sut);


    }
}
