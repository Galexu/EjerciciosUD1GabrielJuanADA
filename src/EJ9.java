import java.io.*;

public class EJ9 {
    public static void main(String[] args) {
        String[] títulos = {"Las tinieblas y el alba", "Don Quijote de la Mancha", "El Señor de los Anillos", "El principito"};
        int[] anyoPublicacion = {2020, 1605, 1954, 1943};

        File file = new File("D:\\Stuff\\Desktop\\Segundo Curso\\ADA\\UD1\\Teoria\\BinaryFile.dat");

        try {
            FileOutputStream archivoOut = new FileOutputStream(file);
            DataOutputStream archivoOutStream = new DataOutputStream(archivoOut);

            for (int i = 0; i < títulos.length; i++) {
                archivoOutStream.writeUTF(títulos[i]);
                archivoOutStream.writeInt(anyoPublicacion[i]);
            }

            archivoOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

        leerDatos(file);
    }

    public static void leerDatos(File file) {
        try {
            FileInputStream fileInput = new FileInputStream(file);
            DataInputStream entrada = new DataInputStream(fileInput);

            while (entrada.available() > 0) {
                String titulo = entrada.readUTF();
                int anyo = entrada.readInt();
                System.out.println("Título: " + titulo + ", Año: " + anyo);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
