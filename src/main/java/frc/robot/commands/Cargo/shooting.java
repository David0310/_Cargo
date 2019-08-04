/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Cargo;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
//import frc.robot.Useful;

public class shooting extends Command {
  public shooting() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_Cargo);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  //  double CRspd = 0.0;
  //  double CLspd = 0.0;
  //  double CLiftspd = 0.0;
    boolean PressUP = true;
    boolean Shooting = Robot.m_oi.Controller.getRawButton(RobotMap.Right_Button);
    boolean Hold = Robot.m_oi.Controller.getRawButton(RobotMap.Down_Button);
    boolean CAngleU = Robot.m_oi.Controller.getRawButton(RobotMap.Up_Button);
    boolean CAngleD = Robot.m_oi.Controller.getRawButton(RobotMap.Left_Button);
    Encoder CLE = Robot.m_Cargo.CLE;
    if (Shooting){
      Robot.m_Cargo.SetSpeed(1, 1);
    }
    else if (Hold){
      Robot.m_Cargo.SetSpeed(-1,-1);
    }
    if (CAngleU){
      if(PressUP==true){
        while(CLE.get()<512){
          Robot.m_Cargo.SetLiftSpeed(1);
        }
        Robot.m_Cargo.SetLiftSpeed(0);
        CLE.reset();
        PressUP = false;
      }
    }
    else if(CAngleD){
      if(PressUP==false){
        while(CLE.get()<-512){
          Robot.m_Cargo.SetLiftSpeed(-1);
        }
        Robot.m_Cargo.SetLiftSpeed(0);
        CLE.reset();
        PressUP = true;
      }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }
2313131
  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_Cargo.SetSpeed(0,0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();
  }
}
