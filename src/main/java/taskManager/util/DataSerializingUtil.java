package taskManager.util;

import taskManager.model.AbstractTask;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public final class DataSerializingUtil {
    private static final String FILENAME = "src/main/resources/db";

    public static void save(Object object) {
        try (OutputStream fileOutputStream = new FileOutputStream(FILENAME);
             ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream)) {
            outputStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object load() {
        Object object = null;
        try (InputStream fileInputStream = new FileInputStream(FILENAME);
             ObjectInputStream inputStream = new ObjectInputStream(fileInputStream)) {
            object = inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
