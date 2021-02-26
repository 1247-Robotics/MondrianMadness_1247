package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
//import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;
//import frc.robot.subsystems.Led;
//import frc.robot.subsystems.Button;

public class BaseCommand extends CommandBase {
    public static Drivetrain drive;
    // public static Led led;
    // public static Button button;
    public static OI oi;

    public static boolean isTeleOp = true;

    public BaseCommand() {
        super();
        System.out.println("BaseCommand initialized");
    }

    public static void init() {
        drive = new Drivetrain();
        drive.setDefaultCommand(new DriveCommand(drive));
        // button = new Button(RobotMap.LED_CHANNEL_1);
        // button.setDefaultCommand(new ButtonCommand(button));
        oi = new OI();
    }
}
