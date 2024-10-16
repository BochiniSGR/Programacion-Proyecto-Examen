/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author Joshu
 */
public class TFpregunta extends Pregunta{
    private boolean respCorrecta;

    public TFpregunta(String text , boolean respCorrecta, int puntaje ){
        super(text, puntaje);
        this.respCorrecta = respCorrecta;
    }

@Override
public boolean buscar(){
    Scanner scan = new Scanner(System.in);
    System.out.println("\n>>>>>>"+getText()+"<<<<<<"");
    System.out.print("Ingrese una opcion verdadero o falso ( T | F ): ");
    String respuesta = scan.nextLine().toLowerCase();

    while(!respuesta.equals("t") && !respuesta.equals("f")){
        System.out.print("Su respuesta no es valida, intentelo otra vez ( T | F ): ");
        respuesta = scan.nextLine().toLowerCase();
    }

    boolean respUsuario = respuesta.equals("t");
    if(respUsuario == respCorrecta){
        return true;
    }else{
        return false;
    }
}      
}
