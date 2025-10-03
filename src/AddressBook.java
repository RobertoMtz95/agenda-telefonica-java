import java.util.HashMap;
import java.io.*; //Manejo de Archivos

public class AddressBook {

    //El HashMap almacenara los datos
    private HashMap<String, String> contacts = new HashMap<>();

    //Nombre del archivo donde guardaremos los datos.
    private static final String FILE_NAME = "contactos.csv";

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                //el formato es: Número,Nombre
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    // parts[0] es el número (la clave)
                    // parts[1] es el nombre (el valor)
                    contacts.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            //Si el archivo no existe la primera vez simplemente no se cargarán contactos.
            System.out.println("No se encontró el archivo de contactos, se creará uno nuevo al guardar.");
        }
    }

    public void save() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            //Separamos el numero y el nombre con una ,
            for (HashMap.Entry<String, String> entry : contacts.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los contactos: " + e.getMessage());
        }
    }

    //Metodo para mostrar la lista de contactos
    public void list(){
        System.out.println("Contactos");
        if (contacts.isEmpty()){
            System.out.println("La agenda esta vacia.");
        }
        else{
            for (HashMap.Entry<String, String> entry : contacts.entrySet()){
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    //Metodo para crear un nuevo contacto
    public void create(String number, String name){
        contacts.put(number, name);
        System.out.println("Contacto añadido.");
    }

    //Metodo para borrar contacto
    public void delete(String number) {
        if (contacts.containsKey(number)) {
            contacts.remove(number);
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }
}
