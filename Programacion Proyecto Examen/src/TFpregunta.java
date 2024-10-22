import java.util.Scanner;

public class TFpregunta extends Pregunta {
    private final boolean respCorrecta;

    public TFpregunta(String text, boolean respCorrecta, int puntaje) {
        super(text, puntaje);
        this.respCorrecta = respCorrecta;
    }

    @Override
    public boolean buscar() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("\n>>>>>>" + getText() + "<<<<<<\n");
            System.out.print("Ingrese una opción (T | F): ");
            String respuesta = scan.nextLine().toLowerCase();

            while (!respuesta.equals("t") && !respuesta.equals("f")) {
                System.out.print("Lo que ha ingresado es inválido, pruebe otra vez (T | F): ");
                respuesta = scan.nextLine().toLowerCase();
            }

            boolean respUsuario = respuesta.equals("t");

            return respUsuario == respCorrecta;
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al procesar la pregunta: " + e.getMessage());
            return false;
        }
    }
}
