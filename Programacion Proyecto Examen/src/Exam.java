import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDate;

public class Exam {
    private Pregunta[] preguntas;
    private int contador;

    public Exam() {
        preguntas = new Pregunta[10];
        contador = 0;
    }

    public void agregaPregunta(Pregunta pregunta) {
        if (contador < 10) {
            preguntas[contador++] = pregunta;
        }
    }

    public void darExam() {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Ingrese su Nombre: ");
        String nombreUsuario = scan.nextLine();
        LocalDate fechaHoy = LocalDate.now();
        
        int puntajeTotal = 0;
        int puntajeObtenido = 0;

        for (int i = 0; i < contador; i++) {
            Pregunta pregunta = preguntas[i];
            puntajeTotal += pregunta.getPuntaje();
            if (pregunta.buscar()) {
                puntajeObtenido += pregunta.getPuntaje();
            }
        }

        double porcentaje = ((double) puntajeObtenido / puntajeTotal) * 100;
        System.out.printf("Puntaje obtenido: %d/%d\n", puntajeObtenido, puntajeTotal);
        System.out.printf("Porcentaje: %.2f%%\n", porcentaje);

        // Guardar los resultados en un archivo
        guardarResultados(nombreUsuario,fechaHoy, puntajeObtenido, puntajeTotal, porcentaje);
    }

    private void guardarResultados(String nombreUsuario,LocalDate fechaHoy, int puntajeObtenido, int puntajeTotal, double porcentaje) {
       
        String fileName = "Resultados Examen.txt";
        
        try (BufferedWriter escribe = new BufferedWriter(new FileWriter(fileName, true))) {
            escribe.write("Nombre de estudiante: " + nombreUsuario);
            escribe.write("\n\nFecha de hoy: " + fechaHoy );
            escribe.write("\nPuntaje del examen: " + puntajeObtenido + "/" + puntajeTotal );
            escribe.write("\nPorcentaje logrado: " + String.format("%.2f", porcentaje)  );
            escribe.write("\n\n<<<<<<<<<<<<<<<<<---->>>>>>>>>>>>>>>>>\n\n");
        } catch (IOException e) {
            System.out.println("Error al guardar los resultados: " + e.getMessage());
        }
    }
}
