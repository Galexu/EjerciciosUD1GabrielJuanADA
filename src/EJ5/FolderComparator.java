package EJ5;

import java.io.File;
import java.util.*;

public class FolderComparator {
    private File folderA;
    private File folderB;

    public static void main(String[] args) {
        try {
            FolderComparator comparator = new FolderComparator();

            //Pedimos al usuario las rutas
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce la ruta absoluta de la primera carpeta a comparar: ");
            File carpeta1 = new File(sc.nextLine());
            System.out.print("Introduce la ruta absoluta de la segunda carpeta a comparar: ");
            File carpeta2 = new File(sc.nextLine());
            sc.close();

            //Establecemos las carpetas
            comparator.setFolders(carpeta1, carpeta2);

            //Llamamos a compare() para comprobar si son identicas
            if (comparator.compare()) {
                System.out.println("Las dos carpetas son identicas");
            } else {
                System.out.println("Los carpetas son distintas");
            }

        } catch (UtilityFileException e) {
            e.printStackTrace();
        }
    }

    public File getFolderA() {
        return folderA;
    }

    public File getFolderB() {
        return folderB;
    }


    public void setFolders(File folderA, File folderB) throws UtilityFileException{
        if (!folderA.exists() || !folderB.exists()) {
            throw new UtilityFileException("Una de las carpetas no existe.");
        }
        if (!folderA.isDirectory() || !folderB.isDirectory()) {
            throw new UtilityFileException("Ambas carpetas deben ser directorios.");
        }

        this.folderA = folderA;
        this.folderB = folderB;
    }

    public boolean compare() {
        //Creamos un map por carpeta con sus archivos como objeto File dentro
        Map<String, File> archivosCarpeta1 = new HashMap<>();
        Map<String, File> archivosCarpeta2 = new HashMap<>();

        //los rellenamos con el nombre del archivo y el objeto File en si que nos devuelve listFiles()
        for (File i : getFolderA().listFiles()) {
            archivosCarpeta1.put(i.getName(), i);
        }

        for (File i : getFolderB().listFiles()) {
            archivosCarpeta2.put(i.getName(), i);
        }

        //Si el tamaño de los maps es distinto una carpeta tendria mas archivos que otra, por lo tanto son distintas
        if (archivosCarpeta1.size() != archivosCarpeta2.size()) {
            return false;
        }

        //comparamos si el archivoA tiene propiedades distintas al archivoB de los map
        for (String nombreArchivo : archivosCarpeta1.keySet()) {
            if (!archivosCarpeta2.containsKey(nombreArchivo)) {
                return false;
            }

            File archivoA = archivosCarpeta1.get(nombreArchivo);
            File archivoB = archivosCarpeta2.get(nombreArchivo);

            if (archivoA.length() != archivoB.length() || archivoA.lastModified() != archivoB.lastModified()) {
                return false;
            }
        }

        return true;
    }
}
