/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex5;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Eduardo
 */
public class Ex5 {
    public static void main(String[] args) {
        // Cria o buffer compartilhado com capacidade para 5 itens.
        BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(5);

        Produtor produtor = new Produtor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        Thread threadProdutor = new Thread(produtor);
        Thread threadConsumidor = new Thread(consumidor);

        System.out.println("Iniciando a simulacao Produtor-Consumidor...");
        threadProdutor.start();
        threadConsumidor.start();
    }
}
