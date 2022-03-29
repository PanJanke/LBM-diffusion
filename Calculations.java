public class Calculations {

   public double wage=0.25;
   public double relaxationTime=1.0;
   public double timeStep=1.0;

    public void setConcetrations(Cell tab[][]){
        int width=tab.length;
        int height=tab[0].length;
        for(int i=1;i<width-1;i++)
            for(int j=1;j<height-1;j++)
                if(tab[i][j].isAlive()) {
                    tab[i][j].calculateConcetration();
                }
    }

    public void calculateOutput(Cell tab[][]){

        int width=tab.length;
        int height=tab[0].length;
        for(int i=1;i<width-1;i++)
            for(int j=1;j<height-1;j++)
                if(tab[i][j].isAlive()){
                    tab[i][j].calculateOutputFunctions(wage,relaxationTime,timeStep);
                }
    }


    public void setInputFunctions(Cell tab[][]){
        int width=tab.length;
        int height=tab[0].length;
        double value;
        for(int i=1;i<width-1;i++)
            for(int j=1;j<height-1;j++)
                if(tab[i][j].isAlive()){

                    //gora
                    if(tab[i+1][j].isAlive()){
                        value=tab[i+1][j].getOutputFunction().getDown();
                    }
                    else{ //sciana
                        value=tab[i][j].getOutputFunction().getUp();
                    }
                    tab[i][j].getInputFunction().setUp(value);

                    //dolna
                    if(tab[i-1][j].isAlive()){
                        value=tab[i-1][j].getOutputFunction().getUp();
                    }
                    else{ //sciana
                        value=tab[i][j].getOutputFunction().getDown();
                    }
                    tab[i][j].getInputFunction().setDown(value);


                    //lewa
                    if(tab[i][j-1].isAlive()){
                        value=tab[i][j-1].getOutputFunction().getRight();
                    }
                    else{ //sciana
                        value=tab[i][j].getOutputFunction().getLeft();
                    }
                    tab[i][j].getInputFunction().setLeft(value);

                    //prawa
                    if(tab[i][j+1].isAlive()){
                        value=tab[i][j+1].getOutputFunction().getLeft();

                    }
                    else{ //sciana
                        value=tab[i][j].getOutputFunction().getRight();
                    }
                    tab[i][j].getInputFunction().setRight(value);

                }
    }



}
