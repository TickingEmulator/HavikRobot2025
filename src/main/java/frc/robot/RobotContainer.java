// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Mechanisms.HavikCommands;
import frc.robot.Mechanisms.IntakeSubystem;
import frc.robot.Mechanisms.ShootSubsystem;

public class RobotContainer {
  private final Joystick operatorJoystick = new Joystick(0);
  private final ShootSubsystem m_ShootSubsystem = new ShootSubsystem();
  private final IntakeSubystem m_IntakeSubystem = new IntakeSubystem();
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(operatorJoystick, 0).onTrue(new HavikCommands(m_ShootSubsystem, m_IntakeSubystem).onShoot());
    new JoystickButton(operatorJoystick, 1).onTrue(new HavikCommands(m_ShootSubsystem, m_IntakeSubystem).onIntake());
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
