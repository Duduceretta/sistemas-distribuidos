package Trabalhos.Trabalho1;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Eduardo
 */
public class PopulaLista extends Thread{
    private final List<Integer> lista;
    private final int tamanho;

    // Construtor
    public PopulaLista(List<Integer> lista, Integer tamanho) {
        this.lista = lista;
        this.tamanho = tamanho;
    }

    @Override
    public void run() {
        // Aqui que está a tarefa ou rotina a ser concomitada
        // Popula a lista com numeros aleatorios entre 1000 e 100000
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            int numeroAleatorio = random.nextInt(1000, 100001);
            lista.add(numeroAleatorio);
        }
    }
}
