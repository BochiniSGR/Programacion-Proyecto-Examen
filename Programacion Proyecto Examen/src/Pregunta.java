/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Joshu
 */
public abstract class Pregunta {
   protected String text;
   protected int puntaje;
   

   public Pregunta(String text,int puntaje){
       this.puntaje = puntaje;
       this.text = text;
   }      

public int getPuntaje(){
    return puntaje; 
}

public String getText(){
    return text;
}    

public abstract boolean buscar();
    
    
}
