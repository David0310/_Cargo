package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
//import frc.robot.commands.Chassis.JoystickDrive;
import frc.robot.commands.Chassis.PIDJoystickDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

//import edu.wpi.first.wpilibj.ADXRS450_Gyro;
//import edu.wpi.first.wpilibj.SPI;
//import edu.wpi.first.wpilibj.Timer;



public class Cargo extends Subsystem {
    public VictorSP CRM = new VictorSP(RobotMap.Motor_cargor);
    public VictorSP CLM = new VictorSP(RobotMap.Motor_cargol);
    public VictorSP CLift = new VictorSP(RobotMap.Motor_cargolift);
    public Encoder  CLE = new Encoder(RobotMap.CargoLiftEncoderSA, RobotMap.CargoLiftEncoderSB);
    public SpeedControllerGroup CSH = new SpeedControllerGroup(CRM, CLM);
    //public Timer Timer = new Timer();


    public Cargo() {
    CRM.setInverted(RobotMap.Motor_RB_Invert);
    CLM.setInverted(RobotMap.Motor_LB_Invert);
    //Timer.reset();
    //Timer.start();
  }

  public void SetSpeed(double CRspd,double CLspd){
    CLM.set(CLspd*RobotMap.cargoShootingPP);
    CRM.set(CRspd*RobotMap.cargoShootingPP);
    }

  public void SetLiftSpeed(double CLiftspd){
    CLift.set(CLiftspd*RobotMap.cargoLiftPP);
  }

  public void InitEncoder(){
    CLE.reset();
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new PIDJoystickDrive());
  }
}









































