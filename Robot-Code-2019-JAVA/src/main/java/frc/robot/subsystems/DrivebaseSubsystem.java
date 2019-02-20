/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.StickdriveCommand;

/**
 * Add your docs here.
 */
public class DrivebaseSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public WPI_TalonSRX MasterL;
  public WPI_TalonSRX MasterR;
  

  public DrivebaseSubsystem(){
    MasterL = new WPI_TalonSRX(RobotMap.MasterLPort);
    WPI_VictorSPX SlaveL = new WPI_VictorSPX(RobotMap.SlaveLPort);
    MasterR = new WPI_TalonSRX(RobotMap.MasterRPort);
    WPI_VictorSPX SlaveR = new WPI_VictorSPX(RobotMap.SlaveRPort);
    MasterL.setInverted(true);
    SlaveL.setInverted(true);
    SlaveL.follow(MasterL);
    SlaveR.follow(MasterR);
    DifferentialDrive m_drive = new DifferentialDrive(MasterL, MasterR);
    
  

  }

  
  public void setspeed(double leftspeed, double rightspeed){
    MasterL.set(ControlMode.PercentOutput, leftspeed);
    MasterR.set(ControlMode.PercentOutput, rightspeed);
  }

    
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new StickdriveCommand());
  }
}
