import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;

public class EJ7 {
    public static void main(String[] args) {
        File archivo = new File("D:\\Stuff\\Desktop\\Segundo Curso\\asd.txt");
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el String a introducir en el archivo de texto: ");
        String texto = sc.nextLine();

         try {
             FileWriter escribir = new FileWriter(archivo);
//             FileWriter escribir = new FileWriter(archivo, true);

             escribir.write(texto);
             escribir.close();
             System.out.println("Guardado realizado correctamente.");
         } catch (IOException e) {
             System.out.println(e);
         }
    }
}
