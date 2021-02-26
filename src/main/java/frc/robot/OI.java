package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
    Joystick extreme;

    public OI() {
        System.out.println("OI initialized...");
        extreme = new Joystick(RobotMap.EXTREME);
    }

    public double getAxis(int axis) {
        double axisValue = 0;
        axisValue = extreme.getRawAxis(axis);

        return axisValue;
    }

    public boolean getButton(int buttonNumber) {
        boolean buttonValue = false;
        buttonValue = extreme.getRawButton(buttonNumber);

        return buttonValue;
    }

    
    public boolean getButtonPressed(int buttonNumber) {
        boolean buttonValue = false;
        buttonValue = extreme.getRawButtonPressed(buttonNumber);

        return buttonValue;
    }



}
