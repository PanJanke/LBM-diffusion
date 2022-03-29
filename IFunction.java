public class IFunction {

    private double Up;
    private double Down;
    private double Left;
    private double Right;

    public IFunction(double up, double down, double left, double right) {
        Up = up;
        Down = down;
        Left = left;
        Right = right;
    }

    public void setAll(double value){
        Up = value;
        Down = value;
        Left = value;
        Right = value;
    }



    public double getUp() {
        return Up;
    }

    public void setUp(double up) {
        Up = up;
    }

    public double getDown() {
        return Down;
    }

    public void setDown(double down) {
        Down = down;
    }

    public double getLeft() {
        return Left;
    }

    public void setLeft(double left) {
        Left = left;
    }

    public double getRight() {
        return Right;
    }

    public void setRight(double right) {
        Right = right;
    }
}
