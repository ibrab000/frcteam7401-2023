// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.TurnOffClaw;
import frc.robot.commands.TurnOnClaw;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Constants;

/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private XboxController m_xboxController;


  private final MotorController m_leftMotor1 = new VictorSP(Constants.klDT1);
  private final MotorController m_leftMotor2 = new VictorSP(Constants.klDT2);
  private final MotorController m_rightMotor1 = new VictorSP(Constants.krDT3);
  private final MotorController m_rightMotor2 = new VictorSP(Constants.krDT4);
  
  private final MotorControllerGroup m_motorControllerGroupLeft = new MotorControllerGroup(m_leftMotor1, m_leftMotor2);
  private final MotorControllerGroup m_motorControllerGroupRight = new MotorControllerGroup(m_rightMotor1, m_rightMotor2);

  private final Claw m_claw = new Claw();
  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    m_motorControllerGroupRight.setInverted(true);

    m_myRobot = new DifferentialDrive(m_motorControllerGroupLeft, m_motorControllerGroupRight);
    m_xboxController = new XboxController(0);
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(m_xboxController.getLeftY(), m_xboxController.getRightY());
  
    Trigger yTrigger = new JoystickButton(m_xboxController, XboxController.Button.kY.value);
    yTrigger.onTrue(new TurnOnClaw(m_claw));
    yTrigger.onFalse(new TurnOffClaw(m_claw));
  }
}
