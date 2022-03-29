import javax.swing.*;
import java.awt.*;
import java.beans.Transient;

public class GUI2 extends JPanel {

    public Cell[][] tab;
    Calculations calculations = new Calculations();


    public GUI2(int width, int height){
        this.tab = Start.initialize2(width,height);
    }

    public void updateTab(){
        calculations.setConcetrations(tab);
        calculations.calculateOutput(tab);
        calculations.setInputFunctions(tab);
    }


    @Override
    @Transient
    public Dimension getPreferredSize() {
        return new Dimension(tab.length * 4, tab[0].length * 4);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color gColor = g.getColor();

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {

                if (tab[i][j].isAlive()==false){
                    g.setColor(Color.black);
                }

                else {
                    int value = (int)tab[i][j].getConcetration();
                    if(value>250)
                        value=250;

                    value=250-value;
                    Color concetrationColor=new Color(240,value,value);
                    g.setColor(concetrationColor);
                }

                g.fillRect(j * 4, i * 4, 4, 4);

            }
        }

        g.setColor(gColor);

    }

}