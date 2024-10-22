public class main {
    public static void main(String[] args) {
        Exam exam = new Exam();

        exam.agregaPregunta(new TFpregunta("La tierra es plana.", false, 2));
        exam.agregaPregunta(new TFpregunta("El agua hierve a 100 grados Celsius.", true, 2));
        exam.agregaPregunta(new TFpregunta("Los seres humanos pueden volar sin ayuda.", false, 2));

        String[] opciones1 = { "Java", "Python", "C++", "Ruby" };
        int[] respuestasCorrectas1 = { 0, 1 };
        exam.agregaPregunta(new Selec_Mul_Pregunta("¿Cuáles de los siguientes son lenguajes de programación?",
                opciones1, respuestasCorrectas1, 3));

        String[] opciones2 = { "HTML", "CSS", "JavaScript", "SQL" };
        int[] respuestasCorrectas2 = { 1, 2 };
        exam.agregaPregunta(
                new Selec_Mul_Pregunta("¿Cuáles son lenguajes de diseño web?", opciones2, respuestasCorrectas2, 3));

        String[] opciones3 = { "Windows", "Linux", "Android", "iOS" };
        int[] respuestasCorrectas3 = { 0, 1 };
        exam.agregaPregunta(new Selec_Mul_Pregunta("¿Cuáles de los siguientes son sistemas operativos?", opciones3,
                respuestasCorrectas3, 3));

        exam.agregaPregunta(new Resp_Cortas("¿Cuál es la capital de Francia?", "parís", 5));
        exam.agregaPregunta(new Resp_Cortas("¿Quién escribió 'Cien años de soledad'?", "gabriel garcía márquez", 5));
        exam.agregaPregunta(new Resp_Cortas("¿Cuál es el símbolo químico del oro?", "au", 5));
        exam.agregaPregunta(new Resp_Cortas("¿En qué año llegó el hombre a la luna?", "1969", 5));

        exam.darExam();
    }
}
