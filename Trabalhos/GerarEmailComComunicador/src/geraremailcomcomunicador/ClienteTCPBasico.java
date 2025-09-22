/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geraremailcomcomunicador;

import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ClienteTCPBasico {
    Socket socket;

    public ClienteTCPBasico() {
        criaClientSocket();
        
        String nomeCompleto = JOptionPane.showInputDialog(null,"Nome completo");
        Pessoa novaPessoa = new Pessoa(nomeCompleto);
        ComunicadorObjetos.enviaObjeto(socket, novaPessoa);
        Pessoa pessoaCadastrada = ComunicadorObjetos.recebeObjeto(socket);
        
        if (pessoaCadastrada == null) {
          JOptionPane.showMessageDialog(null, "Seu nome já está na lista com um email gerado");
        } else {
          JOptionPane.showMessageDialog(null,"Pessoa criada e recebida: " + pessoaCadastrada.toString());
        }
    }

    private void criaClientSocket() {
        try {
            //cria um socket TCP para se conectar ao servidor de ip "localhost" porta 1234
            socket = new Socket("localhost", 1234);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
    
    
    public static void main(String[] args) {  
        ClienteTCPBasico cliente = new ClienteTCPBasico();
  }
}
