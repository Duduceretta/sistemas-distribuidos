package Trabalhos.Trabalho1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class Trabalho1 {
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        List<List<Integer>> listaDeListas = new ArrayList<>();
        List<Thread> listaPopulaThreads = new ArrayList<>();
        
        int totalListas = 1000;
        int tamanhoListas = 100000;
        
        double soma = 0;
        double media;
        
        // adiciona as listas dentro da listaDeListas
        for (int i = 0; i < totalListas; i++){
            listaDeListas.add(new ArrayList<>());
        }
        
        // popular as listas
        for (int i = 0; i < totalListas; i++) {
            Thread thread1 = new PopulaLista(listaDeListas.get(i), tamanhoListas);
            listaPopulaThreads.add(thread1);
            thread1.start();
        }
        
        // espera todas as threads acabarem
        for (Thread thread : listaPopulaThreads) {
            thread.join();
        }
        
        //for (List<Integer> lista : listaDeListas) {
            //System.out.println(lista);
        //}
        
        //Calcula a soma de todas as listas
        for (List<Integer> lista : listaDeListas) {
            for (Integer numero : lista) {
                soma = soma + numero;
            }
        }
        
        //Calcula e mostra a media
        media = soma / (totalListas * tamanhoListas);
        System.out.println(media);
    }
}
