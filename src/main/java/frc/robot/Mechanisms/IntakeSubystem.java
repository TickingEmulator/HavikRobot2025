// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Mechanisms;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.LimitSwitchConfig.Type;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubystem extends SubsystemBase {
  private IntakeSubystem m_IntakeSubystem;
  private SparkMax spoolMotor;
  private SparkMaxConfig spoolMotorConfiguration;
  enum IntakeState {
    kIntaking,
    kBrake
  }
  public IntakeSubystem(){
    spoolMotor = new SparkMax(1, MotorType.kBrushless);
    spoolMotorConfiguration = new SparkMaxConfig();
    spoolMotorConfiguration.smartCurrentLimit(40);
    spoolMotorConfiguration.idleMode(IdleMode.kBrake);
    spoolMotorConfiguration.limitSwitch.forwardLimitSwitchEnabled(true).forwardLimitSwitchType(Type.kNormallyOpen);
    spoolMotor.configure(spoolMotorConfiguration, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }
  public void setIntakeState(IntakeState defaultIntakeState){
    spoolMotor.set(switch(defaultIntakeState){
      case kIntaking -> 1.0;
      case kBrake -> 0.0;
    });
  }
}
