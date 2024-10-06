import java.io.File;

public class EJ1 {
    public static void main(String[] args) {
        //Mirando la documentacion en Oracle podemos ver algunos metodos sencillos para comprobar estados del archivo, usaremos esos para este ejercicio

        File file = new File("D:\\Stuff\\Desktop\\Segundo Curso\\ADA\\UD1\\Teoria\\UD1.1- Conceptos básicos.pdf");
        System.out.println("Existe el archivo?: " + file.exists());
        System.out.println("Pueder ser leido?: " + file.canRead());
        System.out.println("Puede ser ejecutado?: " + file.canExecute());
        System.out.println("Puede ser escrito?: " + file.canExecute());
    }
}
