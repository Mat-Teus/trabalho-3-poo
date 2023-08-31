package minecraft2d;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements Runnable{
    //Atributos
    private ImageIcon icon;
    
    //Construtor
    public MyPanel(ImageIcon icon) {
        this.icon = icon;
    }
    
    public MyPanel(){
        icon = new ImageIcon("./src/imgs/avatar_idle.png");
    }
    
    //Métodos
    public void setIcon(ImageIcon icon){
        this.icon = icon;
        repaint();
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
    }

    @Override
    public void run() {
        
    }
}
