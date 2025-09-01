/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex2;

/**
 *
 * @author Eduardo
 */
public class Ex2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MinhaTarefa(1000));
        Thread t2 = new Thread(new MinhaTarefa(2000));
        Thread t3 = new Thread(new MinhaTarefa(3000));
        
        t1.start();
        t2.start();
        t3.start();
    }
}
