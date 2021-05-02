package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class LightSensor extends SubsystemBase {
    private AnalogInput left, right, middle;
    private float max;
    int leftVal, rightVal, middleVal, oldLeftVal, oldRightVal, oldMiddleVal, leftDiff, rightDiff, middleDiff,
            leftOffset, rightOffset, middleOffset;
    private float k_DifferenceEquation = 5000f;

    public LightSensor() {
        left = new AnalogInput(RobotMap.LINE_L);
        middle = new AnalogInput(RobotMap.LINE_M);
        right = new AnalogInput(RobotMap.LINE_R);
        max = 0f;

        left.setAverageBits(4);
        right.setAverageBits(4);
        middle.setAverageBits(4);

        leftVal = left.getValue();
        rightVal = right.getValue();
        middleVal = middle.getValue();

        leftOffset = 1450;

        middleOffset = 968;

        rightOffset = 1321;

    }

    public void update() {
        oldLeftVal = leftVal;
        leftVal = left.getAverageValue() - leftOffset;
        leftDiff = leftVal - oldLeftVal;

        oldRightVal = rightVal;
        rightVal = right.getAverageValue() - rightOffset;
        rightDiff = rightVal - oldRightVal;

        oldMiddleVal = middleVal;
        middleVal = middle.getAverageValue() - middleOffset;
        middleDiff = middleVal - oldMiddleVal;

    }

    public String goDir() {
        int threshold = 50;
        if (middleVal > leftVal + threshold && middleVal > rightVal + threshold) {
            return "s";
        } else if (leftVal > middleVal + threshold && leftVal > rightVal + threshold) {
            return "l";
        } else if (rightVal > middleVal + threshold && rightVal > leftVal + threshold) {
            return "r";
        } else {
            return "stop";
        }
    }

    public float dist() {
        if (left.getValue() > max)
            max = left.getValue();
        if (middle.getValue() > max)
            max = middle.getValue();
        if (right.getValue() > max)
            max = right.getValue();
        System.out.println(max);
        return max;
    }

    public int getValue(String v) {
        switch (v) {
            case "l":
                return leftVal;
            case "ol":
                return oldLeftVal;
            case "ld":
                return leftDiff;
            case "r":
                return rightVal;
            case "or":
                return oldRightVal;
            case "rd":
                return rightDiff;
            case "m":
                return middleVal;
            case "om":
                return oldMiddleVal;
            case "md":
                return middleDiff;
            default:
                return 0;
        }
    }

    public float diff() {
        float ld = Math.abs(left.getValue() - middle.getValue());
        float rd = Math.abs(right.getValue() - middle.getValue());

        // System.out.println("Ldiff: " + ld + ", RDiff: " + rd);

        float dif = (float) (left.getValue() - right.getValue());

        dif /= middle.getValue();

        dif /= 4096f;

        dif *= k_DifferenceEquation;

        dif = Math.max(-1f, Math.min(1f, dif));

        System.out.println(dif);
        return dif;
    }
}
