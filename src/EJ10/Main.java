package EJ10;

import java.io.*;
public class Main {
    public static void main(String[] args) {
        File file = new File("D:\\Stuff\\Desktop\\Segundo Curso\\ADA\\UD1\\BookFile.dat");
        Book libro = new Book("Edith Hamilton", "Mythology", "Steele Savage", "01/1942");

        escribirDatos(libro, file);
        leerDatos(file);
    }

    public static void escribirDatos(Book libro, File file) {
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream outObject = new ObjectOutputStream(fileOut);

            outObject.writeObject(libro);
            outObject.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leerDatos(File file) {
        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream inObject = new ObjectInputStream(fileIn);

            Book libro = (Book) inObject.readObject();
            inObject.close();
            System.out.println(libro.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}