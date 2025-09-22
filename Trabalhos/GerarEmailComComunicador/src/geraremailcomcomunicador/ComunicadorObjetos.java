package geraremailcomcomunicador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ComunicadorObjetos {

    public static Pessoa recebeObjeto(Socket s) {
        try {
            //Cria um objeto de fluxo de dados de entrada, para poder receber um objeto do tipo Pessoa de um socket s
            ObjectInputStream leitor = new ObjectInputStream(s.getInputStream());
            Pessoa p = (Pessoa) leitor.readObject();
            return p;
        } catch (Exception e) {
            return null;
        }
    }

    public static void enviaObjeto(Socket s, Pessoa p) {
        try {
            //Cria um objeto de fluxo de dados de de saída, para poder enviar dados pelo socket s
            ObjectOutputStream escritor = new ObjectOutputStream(s.getOutputStream());
            System.out.println("Enviarei " + p.getNome() + "," + p.getEmail());
            escritor.writeObject(p);
        } catch (Exception e) {
        }
    }
}