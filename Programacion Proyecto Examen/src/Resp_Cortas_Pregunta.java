/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hector
 */
import java.util.Scanner;

public class Resp_Cortas extends pregunta{
    private final String respuestacorrecta;
    private static final Scanner scanner = new Scanner(System.in);

    public Resp_Cortas(String text, String respuestaCorrecta, int puntaje) {
    super (puntaje, text);
    this.respuestacorrecta=respuestaCorrecta;
    }
    @Override
    public boolean buscar () {
    System.out.println (getText ());
    String respuestaUsuario = leerRespuesta ();

    if (respuestacorrecta.equalsIgnoreCase (respuestaUsuario)) {
    //System. out.println("¡bien hecho lacayo!");
    return true;
    }else{
    //System.out.println ("equivocado. La respuesta correcta era: " + respuestacorrecta);
    return false;

    }

    }

    String leerRespuesta () {

    System.out.println("ingresa tu respuesta: ");
    String respuesta = scanner.nextLine();


    return respuesta;
    }
    }
