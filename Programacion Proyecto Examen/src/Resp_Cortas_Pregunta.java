/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hector
 */
import java.util.Scanner;

public class Resp_Cortas extends pregunta {
    private final String respuestacorrecta;
    private static final Scanner scanner = new Scanner(System.in);

    public Resp_Cortas(String text, String respuestaCorrecta, int puntaje) {
        super(puntaje, text);
        this.respuestacorrecta = respuestaCorrecta;
    }

    @Override
    public boolean buscar() {
        System.out.println("\n*************** PREGUNTA ***************");
        System.out.println(getText());
        System.out.println("****************************************");
        
        String respuestaUsuario = leerRespuesta();

        if (respuestacorrecta.equalsIgnoreCase(respuestaUsuario)) {
            return true;
        } else {
            return false;
        }
    }

    String leerRespuesta() {
        System.out.println("\nIngresa tu respuesta a continuación:");
        System.out.print(">> "); 
        String respuesta = scanner.nextLine();

        return respuesta;
    }
}

