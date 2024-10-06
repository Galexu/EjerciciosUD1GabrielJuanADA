import java.io.File;

public class EJ3 {
    public static void main(String[] args) {
        //Comprobamos que se pase un argumento
        if (args.length == 0) {
            System.out.println("Debes pasar al menos un argumento");
            return;
        }

        //Comprobamos que no pase mas de un argumento
        if (args.length > 1) {
            System.out.println("El programa solo admite un argumento");
            System.out.println("Si tu ruta de directorio contiene espacios introducela entre comillas");
            return;
        }

        //Con un try-catch y su NullPointerException que es requerido comprobamos que el directorio exista y como en el ejercicio anterior
        //con un foreach los mostramos facilmente
        //En este caso el listFiles a diferencia del list nos devuelve un array de File en vez de String
        try {
            File file = new File(args[0]);
            for (File i : file.listFiles()) {
                System.out.println(i);
            }
        } catch (NullPointerException e) {
            System.out.println("Por favor introduce un directorio valido");
        }
    }
}
