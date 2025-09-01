/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex2;

/**
 *
 * @author Eduardo
 */
public class MinhaTarefa implements Runnable{
    private final long tempoDeEspera;
    
    public MinhaTarefa(long tempoDeEspera) {
        this.tempoDeEspera = tempoDeEspera;
    }

    @Override
    public void run(){
        Thread t = Thread.currentThread();
        try {
            t.sleep(tempoDeEspera);
        } catch (InterruptedException ex) {
            
        }
        System.out.println("Executando na Thread: " + t.getName());
    }
}
