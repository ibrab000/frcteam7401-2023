/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Claw extends SubsystemBase {
  private final PWMSparkMax m_clawMotor = new PWMSparkMax(Constants.kFrontClaw);
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void setClawSpeed(double speed) {
    if(speed < -1 || speed > -1) {
      speed = 0;
    } 
    m_clawMotor.set(speed);

  }
}