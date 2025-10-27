
import java.rmi.RemoteException;
import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComunicacaoServidor extends UnicastRemoteObject implements IComunicacaoServidor {

    IComunicacaoCliente c;
    ServidorFrame s;

    public ComunicacaoServidor(ServidorFrame s) throws RemoteException {
        this.s = s;
    }

    @Override
    public void receberCliente(IComunicacaoCliente c) throws RemoteException {
        this.c = c;
        s.adicionaMsg("Recebi um cliente");
    }

    @Override
    public void receberMensagemDoCliente(String msg) throws RemoteException {
        try {
            // Pega o IP do cliente que fez a chamada
            String ipCliente = RemoteServer.getClientHost();

            // Pega data e hora atual
            String dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());

            s.adicionaMsg(dataHora + " " + ipCliente + " " + msg);
        } catch (ServerNotActiveException ex) {
            ex.printStackTrace();
        }
            
        
    }

    public void enviaMsgProCliente(String msg) {
        try {
            c.receberMensagemDoServidor(msg);
        } catch (RemoteException ex) {
        }
    }
}
