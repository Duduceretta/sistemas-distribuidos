/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Eduardo
 */
public class Ex7 {
    public static void main(String[] args) throws InterruptedException {
        Random gerador = new Random();
        List<Integer> listaParaSomar = new ArrayList();
        final int tamanhoLista = 10;
        
        for (int i = 0; i < tamanhoLista; i++) {
            int numeroAleatorio = gerador.nextInt(0, 10);
            listaParaSomar.add(numeroAleatorio);
        }
        
        System.out.println(listaParaSomar);
        
        SomaNumeros threadSoma = new SomaNumeros(listaParaSomar);
        threadSoma.start();
        
        threadSoma.join();
        
        int resultado = threadSoma.getSoma();
        
        System.out.println("Soma total: " + resultado);
    }
}
