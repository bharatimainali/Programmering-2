package no.hiof.bharatim.tools;

import no.hiof.bharatim.interfaces.ObjectFileHandler;
import no.hiof.bharatim.models.Star;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class StarCSVFileHandler implements ObjectFileHandler<ArrayList<Star>> {

    @Override
    public void writeObjectsToFile(ArrayList<Star> stars, File file) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {

            String writeString = "name,radius,mass,effectiveTemp\n";
            for (Star star : stars) {
                writeString += star.getName() + "," + star.getRadius() + "," + star.getMass() + "," + star.getEffectiveTemp() + "\n";
            }
            bufferedWriter.write(String.valueOf(writeString));

        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
    }

    @Override
    public ArrayList<Star> readObjectsFromFile(File file) {
        ArrayList<Star> stars = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            while ( (line = bufferedReader.readLine()) != null) {
                if (!line.equalsIgnoreCase("name,radius,mass,effectiveTemp")) {
                    String[] values = line.split(",");
                    stars.add(new Star(values[0], Double.parseDouble(values[1]), Double.parseDouble(values[2]), Integer.parseInt(values[3])));
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stars;
    }
}
