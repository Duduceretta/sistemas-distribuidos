/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex8;


import java.util.concurrent.CyclicBarrier;

/**
 *  
 * @author Eduardo
 */
public class Ex8 {
    public static void main(String[] args) {
        System.out.println("Iniciando o programa principal.");
        
        Runnable acaoDaBarreira = () -> System.out.println("\n--- TODAS AS THREADS CHEGARAM NA BARREIRA! Liberando para a Etapa 2. ---\n");

        CyclicBarrier barrier = new CyclicBarrier(4, acaoDaBarreira);


        Thread t1 = new Thread(new Tarefa("Thread 1", barrier));
        Thread t2 = new Thread(new Tarefa("Thread 2", barrier));
        Thread t3 = new Thread(new Tarefa("Thread 3", barrier));
        Thread t4 = new Thread(new Tarefa("Thread 4", barrier));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println("Programa principal iniciou todas as threads.");
    }
}
