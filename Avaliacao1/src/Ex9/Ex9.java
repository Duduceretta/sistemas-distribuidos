/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex9;

/**
 *
 * @author Eduardo
 */
public class Ex9 {
     public static void main(String[] args) {
        final Object recursoA = new Object();
        final Object recursoB = new Object();

        // --- Thread 1 ---
        // Tenta travar o recurso A e depois o recurso B
        Thread thread1 = new Thread(() -> {
            // Usa 'synchronized' para travar o recurso A
            synchronized (recursoA) {
                System.out.println("Thread 1: bloqueou o Recurso A");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 1: tentando bloquear o Recurso B...");
                synchronized (recursoB) {
                    System.out.println("Thread 1: bloqueou o Recurso B");
                }
            }
            System.out.println("Thread 1: finalizou.");
        });

        // --- Thread 2 ---
        // Tenta travar o recurso B e depois o recurso A (ORDEM INVERSA)
        Thread thread2 = new Thread(() -> {
            // Usa 'synchronized' para travar o recurso B
            synchronized (recursoB) {
                System.out.println("Thread 2: bloqueou o Recurso B");

                try {
                    // Pausa para dar tempo para a Thread 1 travar o Recurso A
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 2: tentando bloquear o Recurso A...");
                synchronized (recursoA) {
                    System.out.println("Thread 2: bloqueou o Recurso A");
                }
            }
            System.out.println("Thread 2: finalizou.");
        });

        // Inicia as duas threads
        thread1.setName("Thread 1");
        thread2.setName("Thread 2");
        thread1.start();
        thread2.start();
        
        System.out.println("Threads iniciadas. O programa entrará em deadlock. Pois um estará esperando pelo outro");
    
        // A causa do deadlock foi a ordem inconsistente na qual as threads tentaram adquirir os locks. A Thread 1 pediu A -> B, enquanto a Thread 2 pediu B -> A, criando uma espera circular.
        // A solução mais simples e comum para evitar deadlocks é garantir que todas as threads adquiram os locks sempre na mesma ordem.
     }
}

