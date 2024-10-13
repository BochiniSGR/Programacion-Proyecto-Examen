import java.util.Scanner;


abstract class Pregunta {
    protected int peso;
    protected String texto;

    public Pregunta(String texto, int peso) {
        this.texto = texto;
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    public String getTexto() {
        return texto;
    }

    public abstract boolean buscar();
}


class Selec_Mul_Pregunta extends Pregunta {
    private String[] opciones;
    private int respuestaCorrecta; 

    public Selec_Mul_Pregunta(String texto, String[] opciones, int respuestaCorrecta, int peso) {
        super(texto, peso);
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public boolean buscar() {
        Scanner sc = new Scanner(System.in);
        System.out.println(getTexto());


        char letra = 'a';
        for (int i = 0; i < opciones.length; i++) {
            System.out.println(letra + ") " + opciones[i]);
            letra++;
        }


        System.out.print("Elija la opción correcta (a, b, c, etc.): ");
        String respuesta = sc.nextLine().toLowerCase();


        int indiceRespuestaUsuario = respuesta.charAt(0) - 'a';


        if (indiceRespuestaUsuario == respuestaCorrecta) {
            System.out.println("¡Correcto!");
            return true;
        } else {
            System.out.println("Incorrecto.");
            return false;
        }
    }
}


public class ExamDemo {
    public static void main(String[] args) {

        String[] opciones1 = {"Santiago", "Valparaíso", "Concepción", "Arica"};
        Selec_Mul_Pregunta pregunta1 = new Selec_Mul_Pregunta("¿Cuál es la capital de Chile?", opciones1, 0, 1);

        String[] opciones2 = {"Victoria", "Vancouver", "Toronto"};
        Selec_Mul_Pregunta pregunta2 = new Selec_Mul_Pregunta("¿Cuál es la capital de British Columbia?", opciones2, 0, 1);

        System.out.println("Pregunta 1:");
        pregunta1.buscar();

        System.out.println("Pregunta 2:");
        pregunta2.buscar();
    }
}
