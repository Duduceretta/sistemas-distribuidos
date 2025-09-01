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
public class Consumidor implements Runnable{
    private final BlockingQueue<Integer> buffer;

    public Consumidor(BlockingQueue<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Pega um item da fila. Bloqueia se a fila estiver vazia.
                Integer item = buffer.take();

                // Verifica se é o "poison pill" (sinal de parada)
                if (item == -1) {
                    System.out.println("Consumidor encontrou o 'poison pill'. Parando.");
                    break;
                }

                System.out.println("Consumindo item " + item + ". Itens restantes no buffer: " + buffer.size());
                
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
