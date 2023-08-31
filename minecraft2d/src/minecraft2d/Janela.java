package minecraft2d;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//autor sprites blocos: bo tie, sprites resources
//autor Steve: tarkan 809, sprites resources

public class Janela extends JFrame implements KeyListener{
    private final int size=400,rows=20, cols=20;
    private final String avatar_idle = "./src/imgs/steve_idle.jpg";
    private final String avatar_1 = "./src/imgs/steve_andando_1.png";
    private final String avatar_2 = "./src/imgs/steve_andando_2.png";
    private final String avatar_3 = "./src/imgs/steve_andando_3.png";
    private final String avatar_4 = "./src/imgs/steve_andando_4.png";
    private final String avatar_idle_esquerda = "./src/imgs/steve_esquerda_idle.jpg";
    private final String avatar_1_esquerda = "./src/imgs/steve_andando_esquerda_1.png";
    private final String avatar_2_esquerda = "./src/imgs/steve_andando_esquerda_2.png";
    private final String avatar_3_esquerda = "./src/imgs/steve_andando_esquerda_3.png";
    private final String avatar_4_esquerda = "./src/imgs/steve_andando_esquerda_4.png";
    private final String bloco_grama = "./src/imgs/bloco_grama.png";
    private final String bloco_terra = "./src/imgs/bloco_terra.png";
    private final String fundo_azul = "./src/imgs/fundo_azul.png";
    private final String bloco_stone = "./src/imgs/stone_bloco.png";
    private final String bloco_stone2 = "./src/imgs/stone_3_bloco.png";
    private final String bloco_stone3 = "./src/imgs/stone_2_bloco.png";
    private final String cobblestone_bloco = "./src/imgs/cobblestone_bloco.png";
    private final String bloco_madeira = "./src/imgs/bloco_madeira.png";
    private MyPanel myPanel[];
    private ImageIcon av_idle;
    private ImageIcon av_andando_1;
    private ImageIcon av_andando_2;
    private ImageIcon av_andando_3;
    private ImageIcon av_andando_4;
    private ImageIcon av_idle_esquerda;
    private ImageIcon av_andando_1_esquerda;
    private ImageIcon av_andando_2_esquerda;
    private ImageIcon av_andando_3_esquerda;
    private ImageIcon av_andando_4_esquerda;
    private ImageIcon fundo;
    private ImageIcon blc;
    private ImageIcon blc2;
    private ImageIcon blc3;
    private ImageIcon blc4;
    private ImageIcon blc5;
    private ImageIcon blc6;
    private ImageIcon blc7;
    private ImageIcon blc8;
    private int pose_avatar = 0;
    private int posAv;
    private int tipoBloco;
    private int[] blocos;
    private boolean bloco_direita=true;

    public Janela() {
        this.addKeyListener(this);
        this.setTitle("Mine 2d");
        this.setExtendedState(6);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(cols, rows));
        
        av_idle = new ImageIcon(avatar_idle);
        av_andando_1 = new ImageIcon(avatar_1);
        av_andando_2 = new ImageIcon(avatar_2);
        av_andando_3 = new ImageIcon(avatar_3);
        av_andando_4 = new ImageIcon(avatar_4);
        av_idle_esquerda = new ImageIcon(avatar_idle_esquerda);
        av_andando_1_esquerda = new ImageIcon(avatar_1_esquerda);
        av_andando_2_esquerda = new ImageIcon(avatar_2_esquerda);
        av_andando_3_esquerda = new ImageIcon(avatar_3_esquerda);
        av_andando_4_esquerda = new ImageIcon(avatar_4_esquerda);
        fundo = new ImageIcon(fundo_azul);
        blc = new ImageIcon(bloco_stone);
        blc2 = new ImageIcon(bloco_grama);
        blc3 = new ImageIcon(bloco_terra);
        blc4 = new ImageIcon(bloco_grama);
        blc5 = new ImageIcon(bloco_madeira);
        blc6 = new ImageIcon(bloco_stone2);
        blc7 = new ImageIcon(bloco_stone3);
        blc8 = new ImageIcon(cobblestone_bloco);
        
        myPanel = new MyPanel[size];
        blocos = new int[size];
        
        for(int i=0;i<size;i++){
          if(i<=259){
            myPanel[i] = new MyPanel(fundo);
            this.add(myPanel[i]);
            blocos[i]=0;
          }
          if(i>259 && i<280){
            myPanel[i] = new MyPanel(blc4);
            this.add(myPanel[i]);
            blocos[i]=2;
          }
          if(i>=280){
            myPanel[i] = new MyPanel(blc3);
            this.add(myPanel[i]);
            blocos[i]=3;
          }
        }
        
        posAv = 249;
        myPanel[posAv].setIcon(av_idle);
    }
    

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent key) {        
    // movimentações   
    if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
        if(getIcon(posAv+1)==fundo){
            myPanel[posAv].setIcon(getIcon(posAv));
            posAv++;
            if (posAv > 400) posAv = posAv - 20;
            myPanel[posAv].setIcon(avatar_andando(pose_avatar,false));
            pose_avatar=(pose_avatar+1)%4;
            bloco_direita=true;
        }
    }
    
    if (key.getKeyCode() == KeyEvent.VK_LEFT) {
        if(getIcon(posAv-1)==fundo){
            myPanel[posAv].setIcon(getIcon(posAv));
            posAv--;
            myPanel[posAv].setIcon(avatar_andando(pose_avatar,true));
            pose_avatar=(pose_avatar+1)%4;
            bloco_direita=false;
        }
    }
     
     if (key.getKeyCode() == KeyEvent.VK_DOWN) {
        if(getIcon(posAv+20)==fundo){
            myPanel[posAv].setIcon(getIcon(posAv));
            posAv+=20;
            if (posAv > 399) posAv = posAv - 400;
            myPanel[posAv].setIcon(av_idle);
        }
    }
    
     if (key.getKeyCode() == KeyEvent.VK_UP) {
        if(getIcon(posAv-20)==fundo){
            myPanel[posAv].setIcon(getIcon(posAv));
            posAv-=20;
            if (posAv < 0) posAv = 400 - (Math.abs(posAv));
            myPanel[posAv].setIcon(av_idle);
        }
    }
    
    // seleção de blocos
    if (key.getKeyCode() == KeyEvent.VK_1) {
        tipoBloco = 1;
        JOptionPane.showMessageDialog(null, "bloco de stone selecionado");
    }
    
    if (key.getKeyCode() == KeyEvent.VK_2) {
        tipoBloco = 2;                   
        JOptionPane.showMessageDialog(null, "bloco de grama selecionado");
    }
    
    if (key.getKeyCode() == KeyEvent.VK_3) {
        tipoBloco = 3;
        JOptionPane.showMessageDialog(null, "bloco de terra selecionado");
    }
    
    if (key.getKeyCode() == KeyEvent.VK_4) {
        tipoBloco = 4;
        JOptionPane.showMessageDialog(null, "bloco de madeira selecionado");
    }
    
    if (key.getKeyCode() == KeyEvent.VK_5) {
        tipoBloco = 5;
        JOptionPane.showMessageDialog(null, "bloco de pedra selecionado");
    }
    
    if (key.getKeyCode() == KeyEvent.VK_6) {
        tipoBloco = 6;
        JOptionPane.showMessageDialog(null, "bloco de concreto selecionado");
    }
    
    if (key.getKeyCode() == KeyEvent.VK_7) {
        tipoBloco = 7;
        JOptionPane.showMessageDialog(null, "bloco de cobblestone selecionado");
    }
    
    if(key.getKeyCode() == KeyEvent.VK_Z){
       if(bloco_direita==true){
        myPanel[posAv + 1].setIcon(fundo);
        blocos[posAv + 1] = 0;
       }
       
       if(bloco_direita==false){
         myPanel[posAv - 1].setIcon(fundo);
         blocos[posAv - 1] = 0;
       }
    }
    
    if (key.getKeyCode() == KeyEvent.VK_SPACE) {
         if (bloco_direita == true) {
            switch (tipoBloco) {
                case 1:
                    myPanel[posAv+1].setIcon(blc);
                    blocos[posAv + 1] = 1;
                    break;
                case 2:
                    myPanel[posAv+1].setIcon(blc2);
                    blocos[posAv + 1] = 2;
                    break;
                case 3:
                    myPanel[posAv+1].setIcon(blc3);
                    blocos[posAv + 1] = 3;
                    break;
                case 4:
                    myPanel[posAv+1].setIcon(blc5);
                    blocos[posAv + 1] = 5;
                    break;
                case 5:
                    myPanel[posAv+1].setIcon(blc6);
                    blocos[posAv + 1] = 6;
                    break;
                case 6:
                    myPanel[posAv+1].setIcon(blc7);
                    blocos[posAv + 1] = 7;
                    break;
                case 7:
                    myPanel[posAv+1].setIcon(blc8);
                    blocos[posAv + 1] = 8;
                    break;
            }
        } 
         
         if (bloco_direita==false) {
            switch (tipoBloco) {
                case 1:
                    myPanel[posAv-1].setIcon(blc);
                    blocos[posAv - 1] = 1;
                    break;
                case 2:
                    myPanel[posAv-1].setIcon(blc2);
                    blocos[posAv - 1] = 2;
                    break;
                case 3:
                    myPanel[posAv-1].setIcon(blc3);
                    blocos[posAv - 1] = 3;
                    break;
                case 4:
                    myPanel[posAv-1].setIcon(blc5);
                    blocos[posAv - 1] = 5;
                    break;
                case 5:
                    myPanel[posAv-1].setIcon(blc6);
                    blocos[posAv - 1] = 6;
                    break;
                case 6:
                    myPanel[posAv-1].setIcon(blc7);
                    blocos[posAv - 1] = 7;
                    break;
                case 7:
                    myPanel[posAv-1].setIcon(blc8);
                    blocos[posAv - 1] = 8;
                    break;
            }
        }
    }
}

private ImageIcon getIcon(int tipo){
    switch(blocos[tipo]){
        case 0:
            return fundo;
        case 1:
            return blc;
        case 2:
            return blc2;
        case 3:
            return blc3;
        case 4:
            return blc4;
        case 5:
            return blc5;
        case 6:
            return blc6;
        case 7:
            return blc7;
        case 8:
            return blc8;
        default:
            return fundo;
    }
}

private ImageIcon avatar_andando(int pose, boolean olhando_esquerda) {
    int pose_avatar = pose % 4;
    
    if (olhando_esquerda==true) {
        switch (pose_avatar) {
            case 0:
                return av_idle_esquerda;
            case 1:
                return av_andando_1_esquerda;
            case 2:
                return av_andando_2_esquerda;
            case 3:
                return av_andando_3_esquerda;
            default:
                return av_andando_4_esquerda;
        }
    } 
    
    if(olhando_esquerda==false){
        switch(pose_avatar){
            case 0:
                return av_idle;
            case 1:
                return av_andando_1;
            case 2:
                return av_andando_2;
            case 3:
                return av_andando_3;
            default:
                return av_andando_4;
        }
    }
        return null;
}

    
    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}
