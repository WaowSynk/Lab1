import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95() {
        super("Saab95", 100, 2, Color.red);
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}