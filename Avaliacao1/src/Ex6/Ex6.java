/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex6;

/**
 *
 * @author Eduardo
 */
public class Ex6 {
    public static void main(String[] args) {
        Processo A = new Processo(1);
        Processo B = new Processo(2);

        //Passo 1: evento local em A
        A.eventoLocal(); 
        // A: L = 1

        //Passo 2: A envia mensagem para B
        int L_msg = A.enviarMensagem(); 
        // A: L = 2 (valor enviado)

        // Passo 3: B recebe mensagem
        B.receberMensagem(L_msg); 
        // B: L = Math.max(0,2)+1 = 3

        // Passo 4: evento local em B
        B.eventoLocal(); 
        // B: L = 4

        // Passo 5: B envia mensagem para A
        int L_msg2 = B.enviarMensagem();
        // B: L = 5 (valor enviado)

        //Passo 6: A recebe mensagem de B
        A.receberMensagem(L_msg2);
        // A: L = Math.max(2,5)+1 = 6

        // Passo 7: evento local em A
        A.eventoLocal(); 
        // A: L = 7
    }
}
