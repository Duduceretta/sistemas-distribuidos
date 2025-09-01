/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex3;

/**
 *
 * @author Eduardo
 */
public class Incrementador implements Runnable{
    private Contador contadorCompartilhado;

    public Incrementador(Contador contador) {
        this.contadorCompartilhado = contador;
    }

    @Override
    public void run() {
        // Cada thread vai incrementar o contador 100.000 vezes.
        for (int i = 0; i < 100000; i++) {
            contadorCompartilhado.incrementar();
        }
    }
}
