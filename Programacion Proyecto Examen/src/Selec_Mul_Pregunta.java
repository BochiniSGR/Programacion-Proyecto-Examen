import java.util.Scanner;
import java.util.Arrays;

class Selec_Mul_Pregunta extends Pregunta {
    private String[] opciones;
    private int[] respuestasCorrectas;

    public Selec_Mul_Pregunta(String texto, String[] opciones, int[] respuestasCorrectas, int puntaje) {
        super(texto, puntaje);
        
        if (opciones.length < 2) {
            throw new IllegalArgumentException("Debe haber al menos 2 opciones en una pregunta de selección múltiple.");
        }

        if (respuestasCorrectas.length < 1) {
            throw new IllegalArgumentException("Debe haber al menos 1 respuesta correcta.");
        }

        this.opciones = opciones;
        this.respuestasCorrectas = respuestasCorrectas;
    }

    @Override
    public boolean buscar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("****************************************");
        System.out.println("Por favor, seleccione 1 o más alternativas:");
        System.out.println(getText());
        System.out.println("****************************************");

        char letra = 'a';
        for (int i = 0; i < opciones.length; i++) {
            System.out.println(letra + ") " + opciones[i]);
            letra++;
        }

        System.out.print("\nIngrese su respuesta (ej. 'a' o 'a b'): ");
        String respuesta = sc.nextLine().toLowerCase();

        String[] respuestasUsuario = respuesta.split(" ");

        boolean esCorrecta = true;
        for (String r : respuestasUsuario) {
            int indiceRespuestaUsuario = r.charAt(0) - 'a';

            if (!Arrays.stream(respuestasCorrectas).anyMatch(i -> i == indiceRespuestaUsuario)) {
                esCorrecta = false;
            }
        }

        if (esCorrecta) {
            //System.out.println("\n¡Correcto!\n");
        } else {
            //System.out.println("\nIncorrecto.\n");
        }

        return esCorrecta;
    }
}
