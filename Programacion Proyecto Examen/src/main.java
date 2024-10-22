public class main {
    public static void main(String[] args) {
        Exam exam = new Exam();

        exam.agregaPregunta(new TFpregunta("La tierra es plana.", false, 2));
        exam.agregaPregunta(new TFpregunta("El agua hierve a 100 grados Celsius.", true, 2));
        exam.agregaPregunta(new TFpregunta("Los seres humanos pueden volar sin ayuda.", false, 2));

        String[] opciones1 = { "Java", "Python", "C++", "Ruby" };
        int[] respuestasCorrectas1 = { 0, 1 };
        exam.agregaPregunta(new Selec_Mul_Pregunta("Cuales de los siguientes son lenguajes de programacion?",
                opciones1, respuestasCorrectas1, 3));

        String[] opciones2 = { "HTML", "CSS", "JavaScript", "SQL" };
        int[] respuestasCorrectas2 = { 1, 2 };
        exam.agregaPregunta(
                new Selec_Mul_Pregunta("Cuales son lenguajes de diseño web?", opciones2, respuestasCorrectas2, 3));

        String[] opciones3 = { "Windows", "Linux", "Android", "iOS" };
        int[] respuestasCorrectas3 = { 0, 1 };
        exam.agregaPregunta(new Selec_Mul_Pregunta("Cuales de los siguientes son sistemas operativos?", opciones3,
                respuestasCorrectas3, 3));

        exam.agregaPregunta(new Resp_Cortas(Cual es la capital de Francia?", "paris", 5));
        exam.agregaPregunta(new Resp_Cortas("Quién escribió 'Cien años de soledad'?", "gabriel garcia marquez", 5));
        exam.agregaPregunta(new Resp_Cortas("Cual es el simbolo quimico del oro?", "au", 5));
        exam.agregaPregunta(new Resp_Cortas("En que año llegó el hombre a la luna?", "1969", 5));

        exam.darExam();
    }
}
