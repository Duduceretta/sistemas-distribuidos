package ex1;

import java.io.*; 
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class EnviadorUDP {
    DatagramSocket socket;

    public EnviadorUDP() {
        criaClientSocket();
        DatagramPacket pacote;

        ArrayList<String> listaFrutas = new ArrayList<>(Arrays.asList("maca", "banana", "goiaba"));
        Random gerador = new Random();
        String frutaEscolhida;
        
        while (true) {            
                frutaEscolhida = listaFrutas.get(gerador.nextInt(3));
                pacote = ComunicadorUDP.montaMensagem(frutaEscolhida, "localhost", 1234);
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {

                }
                ComunicadorUDP.enviaMensagem(socket, pacote);
        }
    }

    private void criaClientSocket() {
        try {
            //Cria um socket datagrama para enviar dados
            socket = new DatagramSocket();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EnviadorUDP enviador = new EnviadorUDP();
    }
}
