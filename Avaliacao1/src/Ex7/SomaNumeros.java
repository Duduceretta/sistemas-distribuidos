/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex7;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Eduardo
 */
public class SomaNumeros extends Thread{
    private final List<Integer> listaParaSomar;
    private int soma;

    public SomaNumeros(List<Integer> listaParaSomar) {
        this.listaParaSomar = listaParaSomar;
        this.soma = 0;
    }

    @Override
    public void run() {
        // Rotina a ser concomitada
        int somaLocal = 0;
        
        for (int numero : listaParaSomar) {
            somaLocal = somaLocal + numero;
        }
        
        this.soma = somaLocal;
    }

    public int getSoma() {
        return soma;
    }    
}
