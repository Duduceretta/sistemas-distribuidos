/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex3;

/**
 *
 * @author Eduardo
 */
public class Ex3 {
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();

        Thread thread1 = new Thread(new Incrementador(contador));
        Thread thread2 = new Thread(new Incrementador(contador));
        
        thread1.setName("Thread 1");
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        
        System.out.println("threads terminadas.");
        System.out.println("Valor final do contador: " + contador.getValor());
        System.out.println("O resultado e menor que 200.000 por causa da condicao de corrida!");
 
    }
}
