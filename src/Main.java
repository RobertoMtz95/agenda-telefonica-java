import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();
        //Cargamos los contactos existentes del archivo al iniciar
        addressBook.load();

        //Creamos un Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        //Bucle infinito para el menú
        while (true) {
            System.out.println("\n--- Agenda Telefónica ---");
            System.out.println("1. Listar contactos");
            System.out.println("2. Crear contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Guardar y Salir");
            System.out.print("Elige una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); //Limpiar el buffer del scanner

            switch (choice) {
                case 1:
                    addressBook.list();
                    break;
                case 2:
                    System.out.print("Introduce el número de teléfono: ");
                    String number = scanner.nextLine();
                    System.out.print("Introduce el nombre: ");
                    String name = scanner.nextLine();
                    addressBook.create(number, name);
                    break;
                case 3:
                    System.out.print("Introduce el número del contacto a eliminar: ");
                    String numberToDelete = scanner.nextLine();
                    addressBook.delete(numberToDelete);
                    break;
                case 4:
                    addressBook.save();
                    System.out.println("Cambios guardados. ¡Adiós!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}