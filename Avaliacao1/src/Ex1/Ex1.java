/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ex1;

/**
 *
 * @author Eduardo
 */
public class Ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        ImprimePares threadPares = new ImprimePares();
        ImprimeImpares threadImpares = new ImprimeImpares();
          
        threadPares.start();
        threadImpares.start();
    }
    
}
