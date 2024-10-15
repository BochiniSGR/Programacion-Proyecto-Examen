
class Selec_Mul_Pregunta extends Pregunta {
    private String[] opciones;
    private int[] respuestasCorrectas;

    public Selec_Mul_Pregunta(String texto, String[] opciones, int[] respuestasCorrectas, int puntaje) {
        super(texto, puntaje);
        
        if (opciones.length < 2) {
            throw new IllegalArgumentException("Debe haber al menos 2 opciones en una pregunta de selección múltiple.");
        }

        if (respuestasCorrectas.length < 2) {
            throw new IllegalArgumentException("Debe haber al menos 2 respuestas correctas.");
        }

        this.opciones = opciones;
        this.respuestasCorrectas = respuestasCorrectas;
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

        if (Arrays.stream(respuestasCorrectas).anyMatch(i -> i == indiceRespuestaUsuario)) {
            System.out.println("¡Correcto!");
            return true;
        } else {
            System.out.println("Incorrecto.");
            return false;
        }
    }
}
