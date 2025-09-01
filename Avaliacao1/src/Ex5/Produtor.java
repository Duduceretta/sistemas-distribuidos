/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex5;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Eduardo
 */
public class Produtor implements Runnable{
     private final BlockingQueue<Integer> buffer;

    public Produtor(BlockingQueue<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Produzindo item " + i);
                buffer.put(i); // Coloca o item na fila. Bloqueia se a fila estiver cheia.

                Thread.sleep(100); 
            }
            
            System.out.println("Produtor finalizou. Adicionando 'poison pill' para o consumidor parar.");
            buffer.put(-1); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
