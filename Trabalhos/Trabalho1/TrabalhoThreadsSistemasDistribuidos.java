package Trabalhos.Trabalho1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class TrabalhoThreadsSistemasDistribuidos {
   /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        final int totalDeListas = 1000;
        final int numerosPorLista = 100000;
        final int totalDeNumeros = totalDeListas * numerosPorLista;
        
        List<List<Integer>> listaDeListas = criarEstruturaDeListas(totalDeListas);
        List<Thread> threadsAtivas = popularListasEmParalelo(listaDeListas, numerosPorLista);
        aguardarFinalizacaoDasThreads(threadsAtivas);
        
        // Opcional, pode causar lentidao se tiver muitas listas
        // exibirConteudoDasListas(listaDeListas);
        
        double somaTotal = calcularSomaTotal(listaDeListas);
        double mediaFinal = somaTotal / totalDeNumeros;
        
        System.out.println("Soma Total: " + somaTotal);
        System.out.println("Media Final: " + mediaFinal);
    }
    
    private static List<List<Integer>> criarEstruturaDeListas (int quantidadeDeListas){
        List<List<Integer>> listaDeListas = new ArrayList<>();
        
        for (int i = 0; i < quantidadeDeListas; i++) {
            listaDeListas.add(new ArrayList<>());
        }
        
        return listaDeListas;
    }
    
    private static List<Thread> popularListasEmParalelo (List<List<Integer>> listaDeListas, int numerosPorLista){
        List<Thread> threadsAtivas = new ArrayList<>();
        
        for (List listaIndividual : listaDeListas) {
            Thread novaThread = new PopulaLista(listaIndividual, numerosPorLista);
            threadsAtivas.add(novaThread);
            novaThread.start();
        }
        
        return threadsAtivas;
    }
    
    private static void aguardarFinalizacaoDasThreads (List<Thread> listaDeThreads) throws InterruptedException{
        for (Thread threadAtiva : listaDeThreads) {
            // Espera todas as threads terminarem
            threadAtiva.join();
        }
    }
    
    private static double calcularSomaTotal (List<List<Integer>> listaDeListas) {
        double somaTotal = 0;
        
        for (List<Integer> listaIndividual : listaDeListas) {
            for (double numero : listaIndividual){
                somaTotal = somaTotal + numero;
            }
        }
        
        return somaTotal;
    }
    
    private static void exibirConteudoDasListas (List<List<Integer>> listaDeListas) {
        for (List<Integer> listaIndividual : listaDeListas) {
            System.out.println(listaIndividual);
        }
    }
}
