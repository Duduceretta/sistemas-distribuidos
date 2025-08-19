package codigosAula.Java;

class MinhaTarefa implements Runnable { //permite o uso de memória compartilhada
    @Override
    public void run() {
        //aqui está o código a ser concomitado
        Thread t = Thread.currentThread();
        System.out.println("Executando na Thread: " + t.getName() + " | ID: " + t.getId());
    }
}

public class TesteThreads {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MinhaTarefa(), "Tarefa-1");
        Thread t2 = new Thread(new MinhaTarefa(), "Tarefa-2");

        t1.start();
        t2.start();
    }
}