package gs_project.hotel;

import java.io.*;

public class FileHandler {
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T readFile(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fin = new FileInputStream(filename)) {
            try (ObjectInputStream oin = new ObjectInputStream(fin)) {
                return (T) oin.readObject();
            }
        }
    }

    public static <T extends Serializable> void writeFile(String filename, T object) throws IOException {
        try (FileOutputStream fout = new FileOutputStream(filename)) {
            try (ObjectOutputStream oout = new ObjectOutputStream(fout)) {
                oout.writeObject(object);
            }
        }
    }
}
