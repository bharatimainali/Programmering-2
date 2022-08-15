package no.hiof.bharatim.interfaces;
import java.io.File;
public interface ObjectFileHandler<T> {

    void writeObjectsToFile(T t, File file);

    T readObjectsFromFile(File file);
}
