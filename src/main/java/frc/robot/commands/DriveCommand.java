/*----------------------------------------------------------------------------*/
/* Copyright (c) 2020 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import javax.xml.namespace.QName;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Drivetrain;

public class DriveCommand extends BaseCommand {
  double fast = -.8;
  double slow = -.5;
  double speedMult = fast;
    
  double fastRot = .6;
  double slowRot = .6;
  double rotMult = slowRot;

  public static final Timer m_timer = new Timer();
  public static double step = 0;

  public static void resetEncoders(){
    drive.resetEncoders();
  }

  /**
   * Creates a new TeleopArcadeDrive.
   */
  public DriveCommand(Drivetrain drive) {
    System.out.println("Teleop Arcade Drive Initialized");
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // System.out.println("executing teleop");
    if (BaseCommand.isTeleOp){
    
      if (!oi.getButton(1)) {
        speedMult = -((-oi.getAxis(3)+1)/2);
        rotMult = fastRot;
      } else {
        speedMult = slow;
        rotMult = slowRot;
      }

      if(oi.getButtonPressed(3)) {
        drive.rotDeg(-12);
      } else if(oi.getButtonPressed(4)) {
        drive.rotDeg(12); 
      }
        
      drive.arcadeDrive(oi.getAxis(1) * speedMult, oi.getAxis(2) * rotMult, oi.getButton(5), oi.getButton(2));
    } else {
      //drive.resetEncoders();
      System.out.println(drive.leftDist()+ ", " +drive.rightDist() + ", " + drive.avgDist());
      
      //--------Rover Arc steps------
      if (step == 0 && drive.avgDist() < 1.8) {
        drive.arcadeDrive(.65, -.125, false, false);
      } else if (step == 0){
        step = 0.5;
        resetEncoders();
      }
      
      if (step == 0.5 && drive.avgDist() < 19){
        drive.arcadeDrive(.7125, -.36275, false, false);
      } else if (step == 0.5){
        step = 1;
        resetEncoders();
      }

      if (step == 1 && drive.avgDist() < 2.5) {
        drive.arcadeDrive(.75, -.4, false, false);
      } else if (step == 1){
        step = 2;
        resetEncoders();
      }

      if (step == 2 && drive.avgDist() < 8.125) {
        drive.arcadeDrive(.7, -.628, false, false);
      } else if (step == 2){
        step = 3;
        resetEncoders();
      }

      if (step == 3 && drive.avgDist() < 23){
        drive.arcadeDrive(.75, -.115, false, false);
      } else if (step == 3){
        step = 4;
        resetEncoders();
      }

      if (step == 4 && drive.leftDist() < 6.825){
        drive.arcadeDrive(0, .5, false, false);
      } else if (step == 4){
        step = 5;
        resetEncoders();
      }

      if (step == 5 && drive.avgDist() < 20){
        drive.arcadeDrive(.7125, .375, false, false);
      } else if (step == 5){
        step = 6;
        resetEncoders();
      }

      if (step == 6 && drive.avgDist() < 2.5){
        drive.arcadeDrive(.7125, .65, false, false);
      } else if (step == 6){
        step = 7;
        resetEncoders();
      }

      if (step == 7 && drive.avgDist() < 2.25) {
        drive.arcadeDrive(.75, -.125, false, false);
      } else if (step == 7){
        step = 8;
        resetEncoders();
      }

      /*
      //-------River steps-------
      if (step == 0 && drive.avgDist() < 5){
        drive.arcadeDrive(.5, -.125, false, false);
      } else if (step == 0){
        step = 0.5;
        resetEncoders();
      }

      if (step == 0.5 && drive.avgDist() < 6){
        drive.arcadeDrive(.75, -.125, false, false);
      } else if (step == 0.5){
        step = 0.75;
        resetEncoders();
      }
      
      if (step == 0.75 && drive.avgDist() < 5){
        drive.arcadeDrive(.5, -.125, false, false);
      } else if (step == 0.75){
        step = 1;
        resetEncoders();
      }


      if (step == 1 && drive.rightDist() < 3.745){
        drive.arcadeDrive(0, -.5, false, false);
      } else if (step == 1){
        step = 1.5;
        resetEncoders();
      }
     
      if (step == 1.5 && drive.avgDist() < 5){
        drive.arcadeDrive(.5, -.1375, false, false);
      } else if (step == 1.5){
        step = 1.75;
        resetEncoders();
      }

      if (step == 1.75 && drive.avgDist() < 6){
        drive.arcadeDrive(.75, -.1375, false, false);
      } else if (step == 1.75){
        step = 2;
        resetEncoders();
      }

      if (step == 2 && drive.avgDist() < 5){
        drive.arcadeDrive(.5, -.1375, false, false);
      } else if (step == 2){
        step = 3;
        resetEncoders();
      }

          if (step == 3 && drive.rightDist() < 5){
        drive.arcadeDrive(0, -.5, false, false);
      } else if (step == 3){
        step = 3.5;
        resetEncoders();
      }

      if (step == 3.5 && drive.avgDist() < 5){
        drive.arcadeDrive(.5, -.125, false, false);
      } else if (step == 3.5){
        step = 3.75;
        resetEncoders();
      }

      if (step == 3.75 && drive.avgDist() < 13){
        drive.arcadeDrive(.75, -.125, false, false);
      } else if (step == 3.75){
        step = 4;
        resetEncoders();
      }

      if (step == 4 && drive.avgDist() < 5){
        drive.arcadeDrive(0.75, -.125, false, false);
      } else if (step == 4){
        step = 5;
        resetEncoders();
      }
      
      if (step == 5 && drive.leftDist() < 7.3){
        drive.arcadeDrive(0, .5, false, false);
      } else if (step == 5){
        step = 5.5;
        resetEncoders();
      }

      if (step == 5.5 && drive.avgDist() < 4){
        drive.arcadeDrive(.5, -.11, false, false);
      } else if (step == 5.5){
        step = 5.75;
        resetEncoders();
      }

      if (step == 5.75 && drive.avgDist() < 6){
        drive.arcadeDrive(.75, -.11, false, false);
      } else if (step == 5.75){
        step = 6;
        resetEncoders();
      }

      if (step == 6 && drive.avgDist() < 4){
        drive.arcadeDrive(0.75, -.11, false, false);
      } else if (step == 6){
        step = 7;
        resetEncoders();
      }

      if (step == 7 && drive.leftDist() < 6.15){
        drive.arcadeDrive(0, .5, false, false);
      } else if (step == 7){
        step = 7.5;
        resetEncoders();
      }

      if (step == 7.5 && drive.avgDist() < 3){
        drive.arcadeDrive(.5, -.11, false, false);
      } else if (step == 7.5){
        step = 7.75;
        resetEncoders();
      }

      if (step == 7.75 && drive.avgDist() < 4.5){
        drive.arcadeDrive(.75, -.11, false, false);
      } else if (step == 7.75){
        step = 8;
        resetEncoders();
      }

      if (step == 8 && drive.avgDist() < 3){
        drive.arcadeDrive(0.75, -.11, false, false);
      } else if (step == 8){
        step = 9;
        resetEncoders();
      }
      */
      /*
      if (m_timer.get() < .4) {
        System.out.println("Autoing");
         drive.arcadeDrive(.8,0,false, false); // drive forwards half speed
      } else if (m_timer.get() < 1) { 
          drive.arcadeDrive(.2,-.5,false, false); 
      }
      */
    }

    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
