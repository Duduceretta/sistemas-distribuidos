/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex1;

/**
 *
 * @author Eduardo
 */
public class ImprimePares extends Thread{
    @Override
    public void run() {
        // Rotina a ser concomitada
        
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
