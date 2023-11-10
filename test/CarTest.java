import org.junit.Test;
import java.awt.*;

import static org.junit.Assert.*;

public class CarTest {

    private void testInitialHeading(Car testCar) {
        char expected = 'N';
        char received = testCar.getHeading();
        assertEquals(expected, received);
    }

    @Test
    public void testInitialHeadingSaab95() {
        testInitialHeading(new Saab95());
    }

    @Test
    public void testInitialHeadingVolvo240() {
        testInitialHeading(new Volvo240());
    }

    private void testGetModelName(Car car, String expected) {
        String received = car.getModelName();
        assertEquals(expected, received);
    }

    @Test
    public void testGetModelNameSaab95() {
        testGetModelName(new Saab95(), "Saab95");
    }

    @Test
    public void testGetModelNameVolvo240() {
        testGetModelName(new Volvo240(), "Volvo240");
    }

    private void testNrDoors(Car car, int expected) {
        int received = car.getNrDoors();
        assertEquals( expected, received);
    }

    @Test
    public void testNrDoorsSaab95() {
        testNrDoors(new Saab95(), 2);
    }

    @Test
    public void testNrDoorsVolvo240() {
        testNrDoors(new Volvo240(), 4);
    }

    private void testInitialXPosition(Car testCar) {
        int expected = 0;
        int received = testCar.getXPosition();
        assertEquals(expected, received);
    }

    private void testInitialYPosition(Car testCar) {
        int expected = 0;
        int received = testCar.getYPosition();
        assertEquals(expected, received);
    }

    @Test
    public void testInitialXPositionSaab95() {
        testInitialXPosition(new Saab95());
    }

    @Test
    public void testInitialYPositionSaab95() {
        testInitialYPosition(new Saab95());
    }

    @Test
    public void testInitialXPositionVolvo240() {
        testInitialXPosition(new Volvo240());
    }

    @Test
    public void testInitialYPositionVolvo240() {
        testInitialYPosition(new Volvo240());
    }

    @Test
    public void testSpeedFactorVolvo240(){
        Car testCar = new Volvo240();
        double expected = 1.25;
        double received = testCar.speedFactor();
        assertEquals(expected, received, 0.0);
    }

    @Test
    public void testSpeedFactorSaab95(){
        Car testCar = new Saab95();
        double expected = 1;
        double received = testCar.speedFactor();
        assertEquals(expected, received, 0.0);
    }

    @Test
    public void testTurboOnSaab95() {
        Saab95 testCar = new Saab95();
        double factorBefore = testCar.speedFactor();
        testCar.setTurboOn();
        double factorAfter = testCar.speedFactor();
        assertTrue(factorBefore < factorAfter );
    }

    @Test
    public void testTurboOffSaab95() {
        Saab95 testCar = new Saab95();
        testCar.setTurboOn();
        double factorBefore = testCar.speedFactor();
        testCar.setTurboOff();
        double factorAfter = testCar.speedFactor();
        assertTrue(factorBefore > factorAfter );
    }

    @Test
    public void testGetColorSaab95(){
        Car testCar = new Saab95();
        Color expected = Color.red;
        Color received = testCar.getColor();
        assertEquals(expected, received);
    }

    @Test
    public void testGetColorVolvo240() {
        Car testCar = new Volvo240();
        Color expected = Color.black;
        Color received = testCar.getColor();
        assertEquals(expected, received);
    }

    private void testSetColor(Car testCar) {
        Color initialColor = testCar.getColor();
        testCar.setColor(Color.blue);
        Color changedColor = testCar.getColor();
        assertNotSame(initialColor, changedColor);
    }

    @Test
    public void testSetColorSaab95() {
        testSetColor(new Saab95());
    }

    @Test
    public void testSetColorVolvo240() {
        testSetColor(new Volvo240());
    }

    @Test
    public void testGetEnginePowerSaab95() {
        Car testCar = new Saab95();
        double expected = 100;
        double received = testCar.getEnginePower();
        assertEquals(expected, received, 0.0);
    }

    @Test
    public void testGetEnginePowerVolvo240() {
        Car testCar = new Volvo240();
        double expected = 100;
        double received = testCar.getEnginePower();
        assertEquals(expected, received, 0.0);
    }

    public void testMove(Car testCar) {
        // Assumes cars heading is N (north)
        int yPositionBefore = testCar.getYPosition();
        testCar.startEngine();
        testCar.gas(1);
        testCar.move();
        int yPositionAfter= testCar.getYPosition();
        assertTrue(yPositionBefore < yPositionAfter);
    }

    @Test
    public void testMoveVolvo240() {
        testMove(new Volvo240());
    }

    @Test
    public void testMoveSaab95() {
        testMove(new Saab95());
    }

    // continue
    // Marcus:
    private void testEngineStart(Car testCar) {
        double speedBefore = testCar.getCurrentSpeed();
        if (speedBefore == 0) {
            testCar.startEngine();
            double speedAfter = testCar.getCurrentSpeed();
            assertTrue(speedAfter > speedBefore);
        }
    }

    @Test
    public void testEngineStartSaab95() {
        testEngineStart(new Saab95());
    }

    @Test
    public void testEngineStartVolvo240() {
        testEngineStart(new Volvo240());
    }

    private void testEngineStop(Car testCar){
        testCar.stopEngine();
        double expected = 0.0;
        double received = testCar.getCurrentSpeed();
        assertEquals(received, expected, 0.0);
    }
    @Test
    public void testEngineStopSaab95(){
        testEngineStop(new Saab95());
    }

    @Test
    public void testEngineStopVolvo240(){
        testEngineStop(new Volvo240());
    }

    private void testGetCurrentSpeed(Car testCar){
        double expected = 0;
        double received = testCar.getCurrentSpeed();
        assertEquals(expected, received, 0.0);
    }

    @Test
    public void testGetCurrentSpeedSaab95() {
        testGetCurrentSpeed(new Saab95());
    }
    @Test
    public void testGetCurrentSpeedVolvo240() {
        testGetCurrentSpeed(new Volvo240());
    }

    private void testGas(Car testCar) {
        double initialSpeed = testCar.getCurrentSpeed();
        testCar.gas(1);
        double speed = testCar.getCurrentSpeed();
        assertTrue(speed > initialSpeed);
    }

    @Test
    public void testGasSaab95() {
        testGas(new Saab95());
    }

    @Test
    public void testGasVolvo240() {
        testGas(new Volvo240());
    }

    private void testBrake(Car testCar) {
        testCar.gas(1);
        double initialSpeed = testCar.getCurrentSpeed();
        testCar.brake(1);
        double speed = testCar.getCurrentSpeed();
        assertTrue(speed < initialSpeed);
    }

    @Test
    public void testBrakeSaab95() {
        testBrake(new Saab95());
    }

    @Test
    public void testBrakeVolvo240() {
        testBrake(new Volvo240());
    }

    private void testTurnRight(Car testCar){
        char initialHeading = testCar.getHeading();
        testCar.turnRight();
        char newHeading = testCar.getHeading();
        if (initialHeading == '0') {
            assertEquals('1', newHeading);
        } else if (initialHeading == '1') {
            assertEquals('2', newHeading);
        } else if (initialHeading == '2') {
            assertEquals('3', newHeading);
        } else if (initialHeading == '3') {
            assertEquals('0', newHeading);
        }
    }

    @Test
    public void testTurnRightSaab95(){
        testTurnRight(new Saab95());
    }

    @Test
    public void testTurnRightVolvo240(){
        testTurnRight(new Volvo240());
    }

    private void testTurnLeft(Car testCar){
        char initialHeading = testCar.getHeading();
        testCar.turnLeft();
        char newHeading = testCar.getHeading();

        if (initialHeading == '0') {
            assertEquals('3', newHeading);
        } else if (initialHeading == '3') {
            assertEquals('2', newHeading);
        } else if (initialHeading == '2') {
            assertEquals('1', newHeading);
        } else if (initialHeading == '1') {
            assertEquals('0', newHeading);
        }
    }

    @Test
    public void testTurnLeftSaab95(){
        testTurnLeft(new Saab95());
    }

    @Test
    public void testTurnLeftVolvo240(){
        testTurnLeft(new Volvo240());
    }

    private void testCurrentSpeedMin(Car testCar) {
        double initialSpeed = testCar.getCurrentSpeed();
        testCar.brake(1);
        double speed = testCar.getCurrentSpeed();
        assertEquals(initialSpeed, speed, 0.0);
    }

    @Test
    public void testCurrentSpeedMinSaab95(){
        testCurrentSpeedMin(new Saab95());
    }

    @Test
    public void testCurrentSpeedMinVolvo240(){
        testCurrentSpeedMin(new Volvo240());
    }

    private void testCurrentSpeedMax(Car testCar) {
        // The maximum allowed speed
        double maxSpeed = testCar.getEnginePower();
        // Check if car can accelerate
        if (testCar.speedFactor() > 0) {
            // Accelerate to maximum speed
            while (testCar.getCurrentSpeed() != maxSpeed) {
                testCar.gas(1);
            }
            // Try to accelerate above allowed speed
            testCar.gas(1);
            double speed = testCar.getCurrentSpeed();
            assertEquals(maxSpeed, speed, 0.0);
        } else System.out.println("Seems to be something wrong with the speed factor!");
    }
    @Test
    public void testCurrentSpeedMaxSaab95() {
        testCurrentSpeedMax(new Saab95());
    }
    @Test
    public void testCurrentSpeedMaxVolvo240() {
        testCurrentSpeedMax(new Volvo240());
    }


}