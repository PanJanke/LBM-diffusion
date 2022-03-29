import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start {






    public static Cell[][] initialize(int width, int height){
        Cell[][] tab = new Cell[width][height];

        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++) {
                tab[i][j] = new Cell(true, 0, new IFunction(0.0,0.0,0.0,0.0),new IFunction(0.0,0.0,0.0,0.0));

                if (i == 0 || j == 0 || i == width - 1 || j == height - 1) {
                    tab[i][j].setAlive(false);
                    continue;
                }

                //czesc przestrzeni wypelniona
                if (j < 25) {
                    tab[i][j].getInputFunction().setAll(600);
                    continue;
                }
                if (j == 30) { //sczelina
                    tab[i][j].setAlive(false);

                    if (i > 65 && i < 100)
                        tab[i][j].setAlive(true);

                    if(i>10 && i<20)
                        tab[i][j].setAlive(true);

                }
            }
        return tab;
    }

    public static Cell[][] initialize2(int width, int height){
        Cell[][] tab = new Cell[width][height];


        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++) {
                tab[i][j] = new Cell(true, 0, new IFunction(0.0,0.0,0.0,0.0),new IFunction(0.0,0.0,0.0,0.0));

                if (i == 0 || j == 0 || i == width - 1 || j == height - 1) {
                    tab[i][j].setAlive(false);
                    continue;
                }



                if(j>50 && j<70 && i>50 && i<70) {
                    tab[i][j].getInputFunction().setAll(4000);
                    continue;
                }

                if (j == 40) {

                    if (i > 65 && i < 86)
                        tab[i][j].setAlive(false);

                }

                if(i==65){
                    if (j > 20 && j < 41)
                        tab[i][j].setAlive(false);


                }
            }
        return tab;
    }



    public static void main(String[] args) {

        final GUI2 window = new GUI2(120, 120);
        JFrame frame = new JFrame();
        frame.getContentPane().add(window);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        new Timer(1, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                window.updateTab();
                window.repaint();
            }
        }
        ).start();

    }

}
