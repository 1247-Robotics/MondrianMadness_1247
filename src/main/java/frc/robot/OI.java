package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class OI {
    Joystick extreme;
    XboxController ps4;

    public OI() {
        System.out.println("OI initialized...");
        extreme = new Joystick(RobotMap.EXTREME);
        ps4 = new XboxController(RobotMap.PS4);
    }

    public double getAxis(int controller, int axis) {
        double axisValue = 0;
        if (controller == RobotMap.EXTREME)
            axisValue = extreme.getRawAxis(axis);
        if (controller == RobotMap.PS4)
            axisValue = ps4.getRawAxis(axis);

        return axisValue;
    }

    public boolean getButton(int controller, int buttonNumber) {
        boolean buttonValue = false;
        if (controller == RobotMap.EXTREME)
            buttonValue = extreme.getRawButton(buttonNumber);
        if (controller == RobotMap.PS4)
            buttonValue = ps4.getRawButton(buttonNumber);

        return buttonValue;
    }

    
    public boolean getButtonPressed(int controller, int buttonNumber) {
        boolean buttonValue = false;
        if (controller == RobotMap.EXTREME)
            buttonValue = extreme.getRawButtonPressed(buttonNumber);
        if (controller == RobotMap.PS4)
            buttonValue = ps4.getRawButtonPressed(buttonNumber);

        return buttonValue;
    }



}
