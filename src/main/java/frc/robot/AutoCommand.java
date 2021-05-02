package frc.robot;

public class AutoCommand {
    public double leftSpeed;
    public double rightSpeed;
    public double leftDistance;
    public double rightDistance;

    public AutoCommand() {
        leftSpeed = 0.0;
        rightSpeed = 0.0;
        leftDistance = 0.0;
        rightDistance = 0.0;
    }

    public AutoCommand(double _speed, double _distance) {
        leftSpeed = _speed;
        rightSpeed = _speed;
        leftDistance = _distance;
        rightDistance = _distance;
    }

    public AutoCommand(double _leftSpeed, double _rightSpeed, double _distance) {
        leftSpeed = _leftSpeed;
        rightSpeed = _rightSpeed;
        leftDistance = _distance;
        rightDistance = _distance;
    }

    public AutoCommand(double _leftSpeed, double _rightSpeed, double _leftDistance, double _rightDistance) {
        leftSpeed = _leftSpeed;
        rightSpeed = _rightSpeed;
        leftDistance = _leftDistance;
        rightDistance = _rightDistance;
    }
}
