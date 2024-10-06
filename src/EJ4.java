import java.io.File;
import java.util.Scanner;

public class EJ4 {
    public static void main(String[] args) {
        int eleccion = 0;

        //Creamos un switch que llamara a nuestro menu y dependiendo de la opcion elegida iremos al metodo correspondiente
        while (eleccion != 4) {
            eleccion = mostrarMenu();
            switch (eleccion) {
                case 1:
                    crearDirectorio();
                    break;
                case 2:
                    crearArchivo();
                    break;
                case 3:
                    borrar();
                    break;
                case 4:
                    System.out.println("Ha salido del programa");
                    break;
            }
        }
    }

    public static int mostrarMenu(){
        //Crearemos un sencillo menu para que el usuario pueda hacer su seleccion
        Scanner sc = new Scanner(System.in);
        int entrada = 1;

        do {
            if (entrada < 1 || entrada > 4) {
                System.out.println("Por favor introduzca un numero valido");
            }

            System.out.println("Elige la accion a realizar.");
            System.out.println("1 - Crear directorio.");
            System.out.println("2 - Crear archivo en el directorio indicado.");
            System.out.println("3 - Borrar directorio o archivo en el directorio indicado.");
            System.out.println("4 - Salir del programa.");
            System.out.print("Eleccion: ");
            entrada = sc.nextInt();
            System.out.println();
        } while(entrada < 1 || entrada > 4);

        return entrada;
    }

    public static void crearDirectorio() {
        //Pedimos al usuario la carpeta padre y el nombre de la carpeta a crear
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca la ruta padre del directorio a crear: ");
        String ruta = sc.nextLine();

        System.out.print("Introduzca el nombre del directorio a crear: ");
        String directorio = sc.nextLine();

        File directorioCreacion = new File(ruta, directorio);

        //Creamos el directorio y mostramos un mensaje de exito o fallo
        boolean exito = directorioCreacion.mkdir();
        if (exito) {
            System.out.println("Directorio creado correctamente");
        } else {
            System.out.println("Fallo la creacion del directorio, vuelva a comprobar la ruta y tenga cuidado con los caracteres especiales");
        }
        System.out.println();
    }

    public static void crearArchivo() {
        //Pedimos al usuario la carpeta padre y el nombre del archivo a crear
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca la ruta padre del archivo a crear: ");
        String ruta = sc.nextLine();

        System.out.print("Introduzca el nombre del archivo a crear con extension incluida: ");
        String archivo = sc.nextLine();

        File archivoCreacion = new File(ruta, archivo);

        try {
            archivoCreacion.createNewFile();
            System.out.println("Creacion del archivo exitosa");
        } catch (java.io.IOException e) {
            System.out.println("La creacion del archivo fallo, compruebe que la ruta sea correcta, que no exista un archivo ya con ese nombre y cuidado con los caracteres especiales");
        }
    }

    public static void borrar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("⚠\uFE0F⚠\uFE0F⚠\uFE0F Cuidado ⚠\uFE0F⚠\uFE0F⚠\uFE0F");
        System.out.println("Con esta eleccion asegurese muy bien y revise los nombres introducidos, con esta accion podra borrar carpetas (siempre que esten vacias) y sus archivos personales");
        System.out.println("No nos haremos responsable de un mal uso del programa por parte del usuario.");

        System.out.print("Desea continuar? s/n: ");
        String eleccion = sc.nextLine();

        if (eleccion.equalsIgnoreCase("n")) {
            System.out.println();
            return;
        }

        //Pedimos al usuario si quiere borrar un archivo o una carpeta
        do {
            System.out.print("Desea borrar una carpeta o un archivo? carpeta/archivo: ");
            eleccion = sc.nextLine();
        } while (!eleccion.equalsIgnoreCase("archivo") && !eleccion.equalsIgnoreCase("carpeta"));

        //Dependiendo de la eleccion del usuario pediremos la ruta y el nombre del archivo o carpeta a borrar
        if (eleccion.equalsIgnoreCase("archivo")) {
            System.out.print("Introduzca la ruta de la carpeta padre del archivo: ");
            String ruta = sc.nextLine();

            System.out.print("Introduzca el nombre del archivo con la extension incluida: ");
            String archivo = sc.nextLine();
            File archivoBorrar = new File(ruta, archivo);

            //Pedimos confirmacion al usuario antes de borrar el archivo
            System.out.print("Desea borrar '" + archivoBorrar + "'? s/n: ");
            String confirmacion = sc.nextLine();

            //Si el usuario confirma procedemos a borrar el archivo
            if (confirmacion.equalsIgnoreCase("s")) {
                boolean exito = archivoBorrar.delete();

                //Mostramos un mensaje de exito o fallo
                if (exito) {
                    System.out.println("Archivo borrado exitosamente");
                } else {
                    System.out.println("Fallo la eliminacion del archivo, revise los nombres");
                }
            }
        } else if (eleccion.equalsIgnoreCase("carpeta")) {
            System.out.print("Introduzca la ruta de la carpeta a borrar, para que funcione la carpeta debe estar vacia: ");
            String ruta = sc.nextLine();
            File directorioBorrar = new File(ruta);

            System.out.print("Desea borrar '" + directorioBorrar + "'? s/n: ");
            String confirmacion = sc.nextLine();

            if (confirmacion.equalsIgnoreCase("s")) {
                boolean exito = directorioBorrar.delete();

                if (exito) {
                    System.out.println("Directorio borrado exitosamente");
                } else {
                    System.out.println("Fallo la eliminacion del directorio, revise que la carpeta este vacia y los nombres introducidos");
                }
            }
        }
        System.out.println();
    }
}
