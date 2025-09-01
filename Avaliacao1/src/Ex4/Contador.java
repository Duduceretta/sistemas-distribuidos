/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex4;

/**
 *
 * @author Eduardo
 */
public class Contador {
     private int valor = 0;

    // Método para incrementar o contador. Esta operação não é atômica!
    public synchronized void incrementar() {
        valor++; // Perigo! Leitura -> Modificação -> Escrita
    }

    public int getValor() {
        return valor;
    }
}
