import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroUsuarios {

    private static final Scanner LECTOR_ENTRADA = new Scanner(System.in);

    public static void main(String[] args) {
        int opcionMenu = 0;

        do {
            mostrarMenu();
            try {
                opcionMenu = LECTOR_ENTRADA.nextInt();
                LECTOR_ENTRADA.nextLine(); // Consumir el salto de línea

                switch (opcionMenu) {
                    case 1:
                        registrarUsuarioRegular();
                        break;
                    case 2:
                        registrarUsuarioAdministrador();
                        break;
                    case 3:
                        System.out.println("¡Gracias por usar el sistema de registro de usuarios!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Se esperaba un número.");
                LECTOR_ENTRADA.nextLine(); // Limpiar la entrada del usuario
            }

        } while (opcionMenu != 3);
    }

    private static void mostrarMenu() {
        System.out.println("\n**Menú principal**");
        System.out.println("1. Registrar usuario regular");
        System.out.println("2. Registrar usuario administrador");
        System.out.println("3. Salir");
        System.out.print("Ingrese la opción deseada: ");
    }

    private static void registrarUsuarioRegular() {
        String nombre, apellido, correoElectronicoPrincipal;
        int edad;
        List<String> correosElectronicosAdicionales = new ArrayList<>();
        String numeroTelefono;

        System.out.println("\n**Registro de usuario regular**");

        do {
            System.out.print("Ingrese su nombre: ");
            nombre = LECTOR_ENTRADA.nextLine();
        } while (nombre.trim().isEmpty());

        do {
            System.out.print("Ingrese su apellido: ");
            apellido = LECTOR_ENTRADA.nextLine();
        } while (apellido.trim().isEmpty());

        do {
            System.out.print("Ingrese su edad: ");
            while (!LECTOR_ENTRADA.hasNextInt()) {
                System.out.print("Ingrese un valor numérico para la edad: ");
                LECTOR_ENTRADA.next(); // Consumir el valor no válido
            }
            edad = LECTOR_ENTRADA.nextInt();
            LECTOR_ENTRADA.nextLine(); // Consumir el salto de línea
        } while (edad <= 0);

        do {
            System.out.print("Ingrese su correo electrónico principal: ");
            correoElectronicoPrincipal = LECTOR_ENTRADA.nextLine();
        } while (!validarCorreoElectronico(correoElectronicoPrincipal));

        do {
            System.out.print("Ingrese su número de teléfono: ");
            numeroTelefono = LECTOR_ENTRADA.nextLine();
        } while (!validarNumeroTelefono(numeroTelefono));

        // Lógica para capturar correos electrónicos adicionales

        // Crear instancia de UsuarioRegular con los datos ingresados
        UsuarioRegular usuario = new UsuarioRegular(nombre, apellido, edad, correoElectronicoPrincipal, numeroTelefono);

        System.out.println("Usuario registrado exitosamente.");
    }

    private static boolean validarCorreoElectronico(String correoElectronico) {
        // Implementar lógica de validación de correo electrónico
        return correoElectronico.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    private static boolean validarNumeroTelefono(String numeroTelefono) {
        // Implementar lógica de validación de número de teléfono
        return true; // Temporal, reemplazar con la validación real
    }

    private static void registrarUsuarioAdministrador() {
        // Aquí debes implementar la lógica para registrar usuarios administradores
        // Por ejemplo, podrías solicitar un nombre de usuario y una contraseña y almacenarlos en alguna estructura de datos
        // O podrías simplemente imprimir un mensaje indicando que la funcionalidad aún no está implementada
        System.out.println("Funcionalidad de registro de usuario administrador aún no implementada.");
    }
}

class UsuarioRegular {
    private String nombre;
    private String apellido;
    private int edad;
    private String correoElectronico;
    private String numeroTelefono;

    public UsuarioRegular(String nombre, String apellido, int edad, String correoElectronico, String numeroTelefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
    }
}


