
import java.util.Arrays;
import java.util.Scanner;
public class pr2UD5juanviLlorca {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        menuOpciones();
    }

    public static void menuOpciones() {
        int opcion;
        do {
            menu();
            opcion = validaInt();
            sc.nextLine();
            switch (opcion) {
                case 1 -> ejercicio1();
                case 2 -> ejercicio2();
                case 3 -> ejercicio3();
                case 4 -> ejercicio4();
                case 0 -> // Salir
                        System.out.println("Adios!");
                default -> // En otro caso
                        System.out.println("Error: opcion incorrecta.");
            }
        } while (opcion != 0);
    }

    public static void menu() {
        System.out.println("Que quieres hacer? ");
        System.out.println("1. Ejercicio 1");
        System.out.println("2. Ejercicio 2");
        System.out.println("3. Ejercicio 3");
        System.out.println("4. Ejercicio 4");
        System.out.println("5. Ejercicio 5");
        System.out.println("0. Salir");
        System.out.print("Introduce opcion: ");
    }

    public static int validaInt() {
        while (!sc.hasNextInt()) {
            System.out.println("Valor no valido!");
            sc.nextLine(); // IMPORTANTE!
        }
        return sc.nextInt();
    }

    public static double validaDouble() {
        while (!sc.hasNextDouble()) {
            System.out.println("Valor no valido!");
            sc.nextLine(); // IMPORTANTE!
        }
        return sc.nextDouble();
    }

    public static boolean validaString(String cadena) {
        boolean soloLetras = true;
        for (int i = 0; i < cadena.length() && soloLetras; i++) {
            if ((cadena.charAt(i) < 58 || cadena.charAt(i) > 126) && cadena.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }
    /**
     1. Crea un programa que pida una cadena de texto por teclado y luego muestre cada
        palabra de la cadena en una línea distinta.
     */
    public static void ejercicio1() {
        String frase = "";
        boolean validaFrase = true; //Validar que solo sean letras lo que pones.
        do {
            System.out.println("Escriba una frase");
            frase = sc.nextLine();
            validaFrase = validaString(frase); //validar que son frases
            if (!validaFrase) {
                System.out.println("Por favor, introduzca una cadena con letras y no numeros");
            }
        } while (!validaFrase);
        String[] palabra = frase.split(" ");
        for (int i = 0; i < palabra.length; i++) {
            System.out.println(palabra[i]);
        }
    }
    /**
     2. Crea un programa que pida dos cadenas de texto por teclado y luego indique si son
        iguales, además de si son iguales sin diferenciar entre mayúsculas y minúsculas.
     */
    public static void ejercicio2() {
        String frase1 = "", frase2 = "";
        boolean  validaFrase = true; //Por cada frase que quiero validar un bucle do while.
        do {
            System.out.println("Escriba la primera frase");
            frase1 = sc.nextLine();
            validaFrase = validaString(frase1); //validar que son frases
            if (!validaFrase) {
                System.out.println("Acaba de producirse un error en el sistema");
            }
        } while (!validaFrase);
        do {
            System.out.println("Escriba la segunda frase");
            frase2 = sc.nextLine();
            validaFrase = validaString(frase2); //validar que son frases
            if (!validaFrase) {
                System.out.println("Por favor, introduzca una cadena con letras y no numeros");
            }
        } while (!validaFrase);
        if (frase1.equalsIgnoreCase(frase2)) {
            System.out.println("Las frases son iguales");
        } else {
            System.out.println("Las frases no son iguales");
        }
    }
    /**
     3. Crea un programa que pida por teclado tres cadenas de texto: nombre y dos
        apellidos. Luego mostrará un código de usuario (en mayúsculas) formado por la
        concatenación de las tres primeras letras de cada uno de ellos. Por ejemplo, si se
        introduce “Alberto”, “Alemany” y “Navarro” mostrará “ALBALENAV”.
     */
    public static void ejercicio3() {
        String nombre = "", nom = "", apellido1 = "", ap1 = "", apellido2 = "", ap2 = "";
        boolean  validaFrase = true; //Por cada frase que quiero validar un bucle do while.
        do {
            System.out.println("Escriba su nombre");
            nombre = sc.nextLine();
            validaFrase = validaString(nombre); //validar que son frases
            if (!validaFrase) {
                System.out.println("Por favor, introduzca una cadena con letras y no numeros");
            }
        } while (!validaFrase);
        do {
            System.out.println("Escriba su primer apellido");
            apellido1 = sc.nextLine();
            validaFrase = validaString(apellido1); //validar que son frases
            if (!validaFrase) {
                System.out.println("Por favor, introduzca una cadena con letras y no numeros");
            }
        } while (!validaFrase);
        do {
            System.out.println("Escriba su segundo apellido");
            apellido2 = sc.nextLine();
            validaFrase = validaString(apellido2); //validar que son frases
            if (!validaFrase) {
                System.out.println("Por favor, introduzca una cadena con letras y no numeros");
            }
        } while (!validaFrase);
        nom = nombre.substring(0, 3);//Sacamos las tres primeras letras de cada palabra introducida
        ap1 = apellido1.substring(0, 3);
        ap2 = apellido2.substring(0, 3);
        System.out.println("Su codigo de usuario es: " + nom.toUpperCase() + ap1.toUpperCase() + ap2.toUpperCase()); //Las imprimimos en mayuscula.
    }
    /**
     4. Crea un programa que muestre por pantalla cuantas vocales de cada tipo hay
        (cuantas ‘a’, cuantas ‘e’, etc.) en una frase introducida por teclado. No se debe
        diferenciar entre mayúsculas y minúsculas. Por ejemplo, dada la frase “Mi mama me
        mima” dirá que hay:
            Nº de A's: 3
            Nº de E's: 1
            Nº de I's: 2
            Nº de O's: 0
            Nº de U's: 0
     */
    public static void ejercicio4() {
        String frase = "";
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        boolean validaFrase = true;
        do {
            System.out.println("Escriba una frase");
            frase = sc.nextLine();
            validaFrase = validaString(frase); //validar que son frases
            if (!validaFrase) {
                System.out.println("Por favor, introduzca una cadena con letras y no numeros");
            }
        } while (!validaFrase);
        String[] letra = frase.split(""); //Gasto split para crear un array de strings. pongo "" para que me separe las letras.
        for (int j = 0; j < letra.length; j++) { //Bucle para recorrer el array y que sume las vocales comparando letra por letra.
            if (letra[j].equalsIgnoreCase("a")) { //If para ir sumando cade vez que comparando encuentra que son iguales sin contar mayusculas.
                a++;
            } if (letra[j].equalsIgnoreCase("e")) {
                e++;
            } if (letra[j].equalsIgnoreCase("i")) {
                i++;
            } if (letra[j].equalsIgnoreCase("o")) {
                o++;
            } if (letra[j].equalsIgnoreCase("u")) {
                u++;
            }
        }
        System.out.println("Nº de A's: " + a);
        System.out.println("Nº de E's: " + e);
        System.out.println("Nº de I's: " + i);
        System.out.println("Nº de O's: " + o);
        System.out.println("Nº de U's: " + u);
    }
}