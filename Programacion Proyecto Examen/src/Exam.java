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
            puntajeTotal += pregunta.getPuntaje();
        } else {
            System.out.println("No se pueden agregar más preguntas al examen.");
        }
    }

    public int darExam() {
        for (int i = 0; i < contadorPreguntas; i++) {
            if (preguntas[i].buscar()) {
                puntajeObtenido += preguntas[i].getPuntaje();
            }
        }
        return (puntajeObtenido * 100) / puntajeTotal; 
    }
}
