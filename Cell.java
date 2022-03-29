public class Cell  {


    private boolean alive;
    private double concetration;
    private IFunction iFunction;
    private IFunction outputFunction;

    public Cell(boolean alive, double concetration, IFunction iFunction, IFunction outputFunction) {
        this.concetration = concetration;
        this.alive = alive;
        this.iFunction = iFunction;
        this.outputFunction=outputFunction;
    }



    public void calculateConcetration(){
        this.concetration= this.iFunction.getDown()+ this.iFunction.getUp()+ this.iFunction.getLeft()+ this.iFunction.getRight();
    }

    public void calculateOutputFunctions(double wage,double relaxationTime,double timeStep){
        double result=0;

        result=this.iFunction.getLeft() + (timeStep/relaxationTime) * (concetration*wage-this.iFunction.getLeft());
        this.outputFunction.setLeft(result);

        result=this.iFunction.getRight() + (timeStep/relaxationTime) * (concetration*wage-this.iFunction.getRight());
        this.outputFunction.setRight(result);

        result=this.iFunction.getDown() + (timeStep/relaxationTime) * (concetration*wage-this.iFunction.getDown());
        this.outputFunction.setDown(result);

        result=this.iFunction.getUp() + (timeStep/relaxationTime) * (concetration*wage-this.iFunction.getUp());
        this.outputFunction.setUp(result);

    }


 //setterty i gettery
    public IFunction getOutputFunction() {
        return outputFunction;
    }

    public IFunction getInputFunction() {
        return iFunction;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public double getConcetration() {
        return concetration;
    }

}
