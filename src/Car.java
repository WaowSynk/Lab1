import java.awt.*;

public abstract class Car implements Movable {

    private final String modelName;         // The car model name
    private final double enginePower;       // Engine power of the car
    private final int nrDoors;              // Number of doors on the car
    private Color color;                    // Color of the car
    private double currentSpeed;            // The current speed of the car

    // Must be implemented by subclasses
    public abstract double speedFactor();   // Speed adjustment of the car

    // ------------ CONSTRUCTOR ------------
    public Car (String modelName, double enginePower, int nrDoors, Color color){
        this.modelName = modelName;
        this.enginePower = enginePower;
        this.nrDoors = nrDoors;
        this.color = color;
        this.stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public Color getColor(){
        return color;
    }
    public void setColor(Color clr){
        color = clr;
    }

    // Might be needed in future labs?
    public String getModelName(){
        return modelName;
    }

    // ------------ BASICS ------------
    public void startEngine(){
        currentSpeed = 0.1;

    }
    public void stopEngine(){
        currentSpeed = 0;
    }

    // Has to be between 0 and 1
    public void gas(double amount){
        if (amount <= 1 && amount >= 0) {
            incrementSpeed(amount);
        } else System.out.println("Amount has to be between 0 and 1");
    }

    // Has to be between 0 and 1
    public void brake(double amount){
        if (amount <= 1 && amount >= 0) {
            decrementSpeed(amount);
        } else System.out.println("Amount has to be between 0 and 1");
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }
    private void incrementSpeed(double amount){
        // If the speed-factor is negative nothing will happen
        if (speedFactor() > 0) {
            // If the formula exceeds the engine-power, the speed will automatically be put to the max
            if (getCurrentSpeed() + speedFactor() * amount < getEnginePower()) {
                currentSpeed = getCurrentSpeed() + speedFactor() * amount;
            } else currentSpeed = getEnginePower();
        }
    }

    private void decrementSpeed(double amount) {
        // If the speed-factor is negative nothing will happen
        if (speedFactor() > 0) {
            // If the calculation gets below zero, the speed will automatically be put to zero
            if (getCurrentSpeed() - speedFactor() * amount > 0) {
                currentSpeed = getCurrentSpeed() - speedFactor() * amount;
            } else currentSpeed = 0;
        }
    }


    // ------------ NAVIGATION ------------
    private final char[] directions = {'N', 'E', 'S', 'W'};
    private int x = 0, y = 0;
    private char heading = 'N';

    public int getXPosition(){
        return x;
    }

    public int getYPosition(){
        return y;
    }

    public char getHeading() {
        return heading;
    }

    // ------------ MOVEMENT ------------
    private void turn(int direction) {
        // direction should be -1 for left and 1 for right.

        int headingIndex = 0;
        while (directions[headingIndex] != heading) {
            headingIndex++;
        }

        heading = directions[(headingIndex + direction + directions.length) % directions.length];
    }

    public void turnLeft() {
        turn(-1);
    }

    public void turnRight() {
        turn(1);
    }

    public void move(){
        if (heading == directions[0]) {             // North
            y += currentSpeed;
        } else if (heading == directions[1]) {      // East
            x += currentSpeed;
        } else if (heading == directions[2]) {      // South
            y -= currentSpeed;
        } else if (heading == directions[3]) {      // West
            x -= currentSpeed;
        }
    }
}
