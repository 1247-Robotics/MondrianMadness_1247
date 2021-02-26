package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LightSensor {

    public class Button extends SubsystemBase {
        private final AnalogInput mothLight;

        public Button(int channel) {
            mothLight = new AnalogInput(channel);

        }

        public double get() {
            double val = mothLight.getAverageValue();

            System.out.println(val);

            return val;
        }
    }
}
