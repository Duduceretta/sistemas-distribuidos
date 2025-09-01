/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex6;

/**
 *
 * @author Eduardo
 */
public class Processo {
    private final int id;
    private int L = 0; //Relógio lógico inicial

    public Processo(int id) {
        this.id = id;
    }

    public int eventoLocal() {
        L++; // L = L + 1
        System.out.println("Processo " + id + " evento local. L = " + L); 
        return L;
    }

    public int enviarMensagem() {
        L++; // L = L + 1
        System.out.println("Processo " + id + " envia mensagem. L = " + L); 
        return L; // valor enviado na mensagem
    }

    public void receberMensagem(int L_msg) {
        L = Math.max(L, L_msg) + 1;
        System.out.println("Processo " + id + " recebe mensagem. L atualizado = " + L);
    }
}
