import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Classe com metodos uteis para o JFrame_Principal
 * @author Eduardo
 */
public class Util {
    /***
     * Sorteia a posicao da frutinha apos um jogador colidir com ela
     * @param frutinha posicao da frutinha
     * @param frame Jframe_principal
     * @param ghost1 botao do jogador1
     * @param ghost2 botao do jogador2
     * @return 
     */
    public static JButton sorteiaPosicao(JButton frutinha, JFrame frame, JButton ghost1, JButton ghost2){
        Random gerador = new Random();
        int limiteInferior = frame.getContentPane().getHeight() - frutinha.getHeight();
        int limiteDireita = frame.getContentPane().getWidth() - frutinha.getWidth();
        int x, y; 
        
        // Faz com que a frutinha nao nasca onde estao os jogadores
        do {            
            x = gerador.nextInt(10, limiteDireita);
            y = gerador.nextInt(10, limiteInferior);
            frutinha.setBounds(x, y, frutinha.getWidth(), frutinha.getHeight());
        } while ((frutinha.getBounds().intersects(ghost1.getBounds())) || 
                frutinha.getBounds().intersects(ghost2.getBounds()));
        
        return frutinha;
    }
    
    /***
     * Verifica qual jogador pegou a frutinha
     * @param origem frutinha
     * @param destino jogador1 ou jogador2
     * @return retorna true para o jogador que colidiu com a fruta
     */
    public static boolean pegou(JButton origem, JButton destino) {
        return origem.getBounds().intersects(destino.getBounds());
    }
    
}
