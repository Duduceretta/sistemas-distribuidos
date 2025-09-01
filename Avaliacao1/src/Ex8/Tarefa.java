/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author Eduardo
 */
public class Tarefa implements Runnable{
    private final String nome;
    private final CyclicBarrier barrier;

    public Tarefa(String nome, CyclicBarrier barrier) {
        this.nome = nome;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            // ---- ETAPA 1 ----
            System.out.println(nome + ": Iniciando Etapa 1...");
            
            Thread.sleep((long) (Math.random() * 3000 + 1000));
            System.out.println(nome + ": Finalizou a Etapa 1 e esta esperando na barreira.");

            // PONTO DE SINCRONIZAÇÃO: A thread vai pausar aqui até que todas as 4 cheguem.
            barrier.await();

            // ---- ETAPA 2 ----
            // Este código só será executado depois que todas as threads passarem da barreira.
            System.out.println(nome + ": Cruzou a barreira! Iniciando Etapa 2...");
            Thread.sleep((long) (Math.random() * 2000 + 500));
            System.out.println(nome + ": Finalizou a Etapa 2.");

        } catch (InterruptedException | BrokenBarrierException e) {
            // BrokenBarrierException ocorre se a barreira for quebrada de forma inesperada.
            e.printStackTrace();
        }
    }
}
