import java.io.File;

public class EJ0 {
    public static void main(String[] args) {
        //Con la documentacion en Oracle de la clase File de java.io podemos deducir que hay 4 formas de declarar un objeto File usando su constructor

        //Primera, con un objeto File como primer argumento para la ruta del directorio y una String como segundo argumento para el archivo en si.
        File directorio = new File("D:\\Stuff\\Desktop\\Segundo Curso\\ADA\\UD1\\Teoria");
        File archivo1 = new File(directorio, "UD1.1- Conceptos básicos.pdf");
        System.out.println("Primera forma, Objeto File como ruta y String para el archivo: " + archivo1);

        //Segunda, con una sola String como argumento pasandole la ruta absoluta
        File archivo2 = new File("D:\\Stuff\\Desktop\\Segundo Curso\\ADA\\UD1\\Teoria\\UD1.1- Conceptos básicos.pdf");
        System.out.println("Segunda forma, solamente una String para la ruta entera: " + archivo2);

        //Tercera, Con una String como primer argumento indicando la ruta del directorio y una String como segundo argumento indicando el archivo"
        File archivo3 = new File("D:\\Stuff\\Desktop\\Segundo Curso\\ADA\\UD1\\Teoria", "UD1.1- Conceptos básicos.pdf");
        System.out.println("Tercera Forma, una String para la ruta y otra String para el archivo: " + archivo3);

        System.out.println("La cuarta seria con un Objeto URI pero es algo que no he visto anteriormente.");
    }
}
