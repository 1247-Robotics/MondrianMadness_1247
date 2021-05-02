/*----------------------------------------------------------------------------*/
/* Copyright (c) 2020 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import javax.xml.namespace.QName;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.AutoCommand;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LightSensor;

public class DriveCommand extends BaseCommand {
  double fast = -.8;
  double slow = -.5;
  double speedMult = fast;

  double fastRot = .6;
  double slowRot = .9;
  double rotMult = slowRot;

  double vel = 0;
  double demVel = 0;
  boolean go = true;

  public static final Timer m_timer = new Timer();
  public static double step = 0;

  public static void resetEncoders() {
    drive.resetEncoders();
  }

  /**
   * Creates a new TeleopArcadeDrive.
   */
  public DriveCommand(Drivetrain drive, LightSensor lightSensor) {
    System.out.println("Teleop Arcade Drive Initialized");
    addRequirements(drive);
    addRequirements(lightSensor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    GenerateCommands();
  }

  private void GenerateCommands() {
    go = true;
    drive.Commands.clear();
    drive.Commands.add(new AutoCommand(.7, 8));
    drive.Commands.add(new AutoCommand(.3, .8, 2, 4));
    drive.Commands.add(new AutoCommand(.7, 9));
    drive.Commands.add(new AutoCommand(.7, .2, 5.75, 2));
    drive.Commands.add(new AutoCommand(.8, .78, 30, 28)); // FIRST STRAIGHT-AWAY
    drive.Commands.add(new AutoCommand(.8, .6, 17, 7));
    drive.Commands.add(new AutoCommand(.55, .8, 23));// Loop
    drive.Commands.add(new AutoCommand(.8, .2, 7, 2));
    drive.Commands.add(new AutoCommand(.8, .78, 43, 41));
    drive.Commands.add(new AutoCommand(.7, .3, 6, 4));
    drive.Commands.add(new AutoCommand(.8, .78, 6, 4));
    drive.Commands.add(new AutoCommand(.2, .7, 4, 6));
    drive.Commands.add(new AutoCommand(.8, .78, 5, 4));
  }

  private void Amber() {
    // drive.resetEncoders();

    // -------Roger Color w/o Arc--------
    if (step == 0 && drive.avgDist() < 8) {
      demVel = 1;
      if (vel < demVel) {
        vel += .05;
      }
      drive.arcadeDrive(vel, -.125, false, false);
    } else if (step == 0) {
      step = 1;
      resetEncoders();
    } /*
       * if (step == 0.25 && drive.avgDist() < 1) { drive.arcadeDrive(0.6, -.125,
       * false, false); } else if (step == 0.25){ step = 0.5; resetEncoders(); } if
       * (step == 0.5 && drive.avgDist() < 6) { drive.arcadeDrive(0.75, -.125, false,
       * false); } else if (step == 0.5){ step = 1; resetEncoders(); }
       */

    if (step == 1 && drive.rightDist() < 4) {
      vel = 0;
      drive.arcadeDrive(vel, -.5, false, false);
    } else if (step == 1) {
      step = 2;
      resetEncoders();
    }
    if (step == 2 && drive.avgDist() < 11) {
      demVel = 1;
      if (vel < demVel) {
        vel += .05;
      }
      drive.arcadeDrive(vel, -.125, false, false);
    } else if (step == 2) {
      step = 3;
      resetEncoders();
    }
    if (step == 3 && drive.leftDist() < 6) {
      vel = 0;
      drive.arcadeDrive(vel, .5, false, false);
    } else if (step == 3) {
      step = 4;
      resetEncoders();
    }
    if (step == 4 && drive.avgDist() < 30) {
      demVel = 1;
      if (vel < demVel) {
        vel += .05;
      }
      drive.arcadeDrive(vel, .06, false, false);
    } else if (step == 4) {
      step = 5;
      resetEncoders();
    }
    if (step == 5 && drive.leftDist() < 5) {
      vel = 0;
      drive.arcadeDrive(vel, .5, false, false);
    } else if (step == 5) {
      step = 6;
      resetEncoders();
    }
    if (step == 6 && drive.avgDist() < 10) {
      demVel = 1;
      if (vel < demVel) {
        vel += .05;
      }
      drive.arcadeDrive(vel, -.125, false, false);
    } else if (step == 6) {
      step = 7;
      resetEncoders();
    }
    if (step == 7 && drive.avgDist() < 25) {
      demVel = 1;
      if (vel < demVel) {
        vel += .05;
      }
      drive.arcadeDrive(vel, -.9, false, false);
    } else if (step == 7) {
      step = 8;
      resetEncoders();
    }
    if (step == 8 && drive.avgDist() < 5) {
      demVel = 1;
      if (vel < demVel) {
        vel += .05;
      }
      drive.arcadeDrive(vel, -.125, false, false);
    } else if (step == 8) {
      step = 9;
      resetEncoders();
    }
    if (step == 9 && drive.leftDist() < 4.375) {
      vel = 0;
      drive.arcadeDrive(vel, .5, false, false);
    } else if (step == 9) {
      step = 10;
      resetEncoders();
    }
    if (step == 10 && drive.avgDist() < 30) {
      demVel = 1;
      if (vel < demVel) {
        vel += .05;
      }
      drive.arcadeDrive(vel, .06, false, false);
    } else if (step == 10) {
      step = 11;
      resetEncoders();
    }
    if (step == 11 && drive.leftDist() < 3.5) {
      vel = 0;
      drive.arcadeDrive(vel, .5, false, false);
    } else if (step == 11) {
      step = 12;
      resetEncoders();
    }
    if (step == 12 && drive.avgDist() < 15) {
      demVel = 1;
      if (vel < demVel) {
        vel += .05;
      }
      drive.arcadeDrive(vel, -.125, false, false);
    } else if (step == 12) {
      step = 13;
      resetEncoders();
    }
    if (step == 13 && drive.avgDist() < 10) {
      demVel = 1;
      if (vel < demVel) {
        vel += .05;
      }
      drive.arcadeDrive(vel, -.75, false, false);
    } else if (step == 13) {
      step = 14;
      resetEncoders();
    }

    /*
     * //--------Roger Color w/Arc----- if (step == 0 && drive.avgDist() < 19){
     * drive.arcadeDrive(.75, -.75, false, false); } else if (step == 0){ step = 1;
     * resetEncoders(); }
     */
    /*
     * //--------Rover Arc steps------ if (step == 0 && drive.avgDist() < 1.8) {
     * drive.arcadeDrive(.65, -.125, false, false); } else if (step == 0){ step =
     * 0.5; resetEncoders(); }
     * 
     * if (step == 0.5 && drive.avgDist() < 19){ drive.arcadeDrive(.7125, -.36275,
     * false, false); } else if (step == 0.5){ step = 1; resetEncoders(); }
     * 
     * if (step == 1 && drive.avgDist() < 2.5) { drive.arcadeDrive(.75, -.4, false,
     * false); } else if (step == 1){ step = 2; resetEncoders(); }
     * 
     * if (step == 2 && drive.avgDist() < 8.125) { drive.arcadeDrive(.7, -.628,
     * false, false); } else if (step == 2){ step = 3; resetEncoders(); }
     * 
     * if (step == 3 && drive.avgDist() < 23){ drive.arcadeDrive(.75, -.115, false,
     * false); } else if (step == 3){ step = 4; resetEncoders(); }
     * 
     * if (step == 4 && drive.leftDist() < 6.825){ drive.arcadeDrive(0, .5, false,
     * false); } else if (step == 4){ step = 5; resetEncoders(); }
     * 
     * if (step == 5 && drive.avgDist() < 20){ drive.arcadeDrive(.7125, .375, false,
     * false); } else if (step == 5){ step = 6; resetEncoders(); }
     * 
     * if (step == 6 && drive.avgDist() < 2.5){ drive.arcadeDrive(.7125, .65, false,
     * false); } else if (step == 6){ step = 7; resetEncoders(); }
     * 
     * if (step == 7 && drive.avgDist() < 2.25) { drive.arcadeDrive(.75, -.125,
     * false, false); } else if (step == 7){ step = 8; resetEncoders(); }
     */

    /*
     * //-------River steps------- if (step == 0 && drive.avgDist() < 5){
     * drive.arcadeDrive(.5, -.125, false, false); } else if (step == 0){ step =
     * 0.5; resetEncoders(); }
     * 
     * if (step == 0.5 && drive.avgDist() < 6){ drive.arcadeDrive(.75, -.125, false,
     * false); } else if (step == 0.5){ step = 0.75; resetEncoders(); }
     * 
     * if (step == 0.75 && drive.avgDist() < 5){ drive.arcadeDrive(.5, -.125, false,
     * false); } else if (step == 0.75){ step = 1; resetEncoders(); }
     * 
     * 
     * if (step == 1 && drive.rightDist() < 3.745){ drive.arcadeDrive(0, -.5, false,
     * false); } else if (step == 1){ step = 1.5; resetEncoders(); }
     * 
     * if (step == 1.5 && drive.avgDist() < 5){ drive.arcadeDrive(.5, -.1375, false,
     * false); } else if (step == 1.5){ step = 1.75; resetEncoders(); }
     * 
     * if (step == 1.75 && drive.avgDist() < 6){ drive.arcadeDrive(.75, -.1375,
     * false, false); } else if (step == 1.75){ step = 2; resetEncoders(); }
     * 
     * if (step == 2 && drive.avgDist() < 5){ drive.arcadeDrive(.5, -.1375, false,
     * false); } else if (step == 2){ step = 3; resetEncoders(); }
     * 
     * if (step == 3 && drive.rightDist() < 5){ drive.arcadeDrive(0, -.5, false,
     * false); } else if (step == 3){ step = 3.5; resetEncoders(); }
     * 
     * if (step == 3.5 && drive.avgDist() < 5){ drive.arcadeDrive(.5, -.125, false,
     * false); } else if (step == 3.5){ step = 3.75; resetEncoders(); }
     * 
     * if (step == 3.75 && drive.avgDist() < 13){ drive.arcadeDrive(.75, -.125,
     * false, false); } else if (step == 3.75){ step = 4; resetEncoders(); }
     * 
     * if (step == 4 && drive.avgDist() < 5){ drive.arcadeDrive(0.75, -.125, false,
     * false); } else if (step == 4){ step = 5; resetEncoders(); }
     * 
     * if (step == 5 && drive.leftDist() < 7.3){ drive.arcadeDrive(0, .5, false,
     * false); } else if (step == 5){ step = 5.5; resetEncoders(); }
     * 
     * if (step == 5.5 && drive.avgDist() < 4){ drive.arcadeDrive(.5, -.11, false,
     * false); } else if (step == 5.5){ step = 5.75; resetEncoders(); }
     * 
     * if (step == 5.75 && drive.avgDist() < 6){ drive.arcadeDrive(.75, -.11, false,
     * false); } else if (step == 5.75){ step = 6; resetEncoders(); }
     * 
     * if (step == 6 && drive.avgDist() < 4){ drive.arcadeDrive(0.75, -.11, false,
     * false); } else if (step == 6){ step = 7; resetEncoders(); }
     * 
     * if (step == 7 && drive.leftDist() < 6.15){ drive.arcadeDrive(0, .5, false,
     * false); } else if (step == 7){ step = 7.5; resetEncoders(); }
     * 
     * if (step == 7.5 && drive.avgDist() < 3){ drive.arcadeDrive(.5, -.11, false,
     * false); } else if (step == 7.5){ step = 7.75; resetEncoders(); }
     * 
     * if (step == 7.75 && drive.avgDist() < 4.5){ drive.arcadeDrive(.75, -.11,
     * false, false); } else if (step == 7.75){ step = 8; resetEncoders(); }
     * 
     * if (step == 8 && drive.avgDist() < 3){ drive.arcadeDrive(0.75, -.11, false,
     * false); } else if (step == 8){ step = 9; resetEncoders(); }
     */
    /*
     * if (m_timer.get() < .4) { System.out.println("Autoing");
     * drive.arcadeDrive(.8,0,false, false); // drive forwards half speed } else if
     * (m_timer.get() < 1) { drive.arcadeDrive(.2,-.5,false, false); }
     */
  }

  private void Will() {
    if (go && drive.AutoHandler())
      go = false;
  }

  private void LineFollow() {
    float dif = lightSensor.diff();
    dif = Math.max(-.5f, Math.min(.5f, dif));
    drive.arcadeDrive(.4f, -dif, false, false);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    lightSensor.update();

    int l = lightSensor.getValue("l");
    int r = lightSensor.getValue("r");
    int m = lightSensor.getValue("m");
    if (Math.abs(l) > 12 || Math.abs(r) > 12 || Math.abs(m) > 12) {
      System.out.println(l + ", " + m + ", " + r);
    }
    if (!BaseCommand.isTeleOp) {
      String dir = lightSensor.goDir();
      System.out.println(dir);
      switch (dir) {
        case "s":
          System.out.println("going straight");
          drive.arcadeDrive(.5, 0, false, false);
          break;
        case "l":
          drive.arcadeDrive(0, -.3, false, false);
          break;
        case "r":
          drive.arcadeDrive(0, .3, false, false);
          break;
        case "stop":
          System.out.println("STOP!!!");
          drive.arcadeDrive(0, -.425, false, false);
          break;
        default:
          System.out.println("OMG HOW DID I GET HERE!!!!!! got: " + dir);
          break;
      }
    }

    // lightSensor.diff(); // System.out.println("executing teleop"); if
    if (BaseCommand.isTeleOp) {
      drive.arcadeDrive(-1 * oi.getAxis(RobotMap.PS4, 1), oi.getAxis(RobotMap.PS4, 2) * .9,
          oi.getButton(RobotMap.PS4, 5), oi.getButton(RobotMap.PS4, 6));
    }

    // LineFollow();

    // Will();
    // Amber();
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
