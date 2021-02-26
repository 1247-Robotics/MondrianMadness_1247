package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Drivetrain extends SubsystemBase {
  private static final double kCountsPerRevolution = 1440.0;
  private static final double kWheelDiameterInch = 2.75;
  private static final double kRobotDiameterInch = 5.75;
  private boolean isRotating;
  private double targetDist = 0;
  private boolean startedRotating;
  private double encoderFrame;

  // The Romi has the left and right motors set to
  // PWM channels 0 and 1 respectively
  private final Spark m_leftMotor = new Spark(RobotMap.DRIVE_LEFT);
  private final Spark m_rightMotor = new Spark(RobotMap.DRIVE_RIGHT);

  // The Romi has onboard encoders that are hardcoded
  // to use DIO pins 4/5 and 6/7 for the left and right
  private final Encoder m_leftEncoder = new Encoder(RobotMap.LEFT_ENC_A, RobotMap.LEFT_ENC_B);
  private final Encoder m_rightEncoder = new Encoder(RobotMap.RIGHT_ENC_A, RobotMap.RIGHT_ENC_B);
  private final DifferentialDrive m_diffDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);


  public Drivetrain() {
    // DifferentialDrive defaults to having the right side flipped
    // We don't need to do this because the Romi has accounted for this
    // in firmware/hardware
    m_leftMotor.setSafetyEnabled(false);
    m_rightMotor.setSafetyEnabled(false);
    m_diffDrive.setRightSideInverted(false);
    resetEncoders();
    isRotating = false;
    
  }

  public void arcadeDrive(double xaxisSpeed, double zaxisRotate, boolean leftLock, boolean rightLock) {

    if(leftLock || rightLock){
      m_diffDrive.tankDrive(leftLock ? 0 : xaxisSpeed, rightLock ? 0 : -xaxisSpeed);
    }else {
      isRotating = isRotating && (Math.abs(avgDist() / 4) < Math.abs(targetDist));
      
      System.out.println(xaxisSpeed + ", " + zaxisRotate);
      
      double rot = 0;
      if(isRotating) rot = targetDist > 0 ? .6 : -.6;
    
      m_diffDrive.arcadeDrive(Math.max(Math.min(zaxisRotate + rot, 1), -1), xaxisSpeed);
    }
    }

    
  public void rotDeg(double angle){
    resetEncoders();
    targetDist = angle * Math.PI / 180 * kRobotDiameterInch / 2;
    isRotating = true;
    startedRotating = false;
  }

 
  public void driveBasic(double x, double y) {
    m_diffDrive.arcadeDrive(x, y);
  }

  
  public void resetEncoders() {
    m_leftEncoder.reset();
    m_rightEncoder.reset();
  }

  
  public double leftDist() {
    return Math.PI * kWheelDiameterInch * (m_leftEncoder.get() / kCountsPerRevolution);
  }

  
  public double rightDist() {
    return Math.PI * kWheelDiameterInch * (m_rightEncoder.get() / kCountsPerRevolution);
  }

    
  public double avgDist() {
   return (Math.abs(rightDist()) + Math.abs(leftDist())) / 2;
}
  

  public boolean stopped() {
    return Math.abs(m_rightEncoder.getRate()) < .00001 && Math.abs(m_leftEncoder.getRate()) < .00001; 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
