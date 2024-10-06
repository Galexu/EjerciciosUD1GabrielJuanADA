import java.io.File;

public class EJ2 {
    public static void main(String[] args) {
        //Declaramos un nuevo objeto file como ruta el fichero actual
        File file = new File(".");

        //El metodo list() nos devuelve un array de Strings asi que con un simple foreach por ejemplo los recorremos y mostramos facilmente
        int contador = 0;
        for (String i : file.list()) {
            contador++;
            System.out.println("Archivo numero " + contador + ": " + i);
        }
    }
}
