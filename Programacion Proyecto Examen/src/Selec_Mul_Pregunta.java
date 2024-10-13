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

class Exam {
    private Pregunta[] preguntas;
    private int contadorPreguntas;
    private int puntajeTotal;
    private int puntajeObtenido;

    public Exam() {
        preguntas = new Pregunta[10]; 
        contadorPreguntas = 0;
        puntajeTotal = 0;
        puntajeObtenido = 0;
    }

    public void agregaPregunta(Pregunta pregunta) {
        if (contadorPreguntas < 10) {
            preguntas[contadorPreguntas] = pregunta;
            contadorPreguntas++;
            puntajeTotal += pregunta.getPeso();
        } else {
            System.out.println("No se pueden agregar más preguntas al examen.");
        }
    }

    public int darExam() {
        for (int i = 0; i < contadorPreguntas; i++) {
            if (preguntas[i].buscar()) {
                puntajeObtenido += preguntas[i].getPeso();
            }
        }
        return (puntajeObtenido * 100) / puntajeTotal;  
    }
}

public class ExamDemo {
    public static void main(String[] args) {

        Exam miExam = new Exam();

        miExam.agregaPregunta(new Selec_Mul_Pregunta("¿Cuál es la capital de Chile?", 
            new String[]{"Santiago", "Valparaíso", "Concepción", "Arica"}, 0, 1));

        miExam.agregaPregunta(new Selec_Mul_Pregunta("¿Cuál es la capital de British Columbia?", 
            new String[]{"Victoria", "Vancouver", "Toronto"}, 0, 1));

        miExam.agregaPregunta(new Selec_Mul_Pregunta("¿Cuál es la capital de Brasil?", 
            new String[]{"Brasilia", "Rio de Janeiro", "Sao Paulo", "Blumenau"}, 0, 1));

        int puntaje = miExam.darExam();
        System.out.println("Su resultado es: " + puntaje + "%");
    }
}
