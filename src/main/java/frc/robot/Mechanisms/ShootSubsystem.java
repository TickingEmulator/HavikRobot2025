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

public class ShootSubsystem extends SubsystemBase {
  private ShootSubsystem m_ShootSubsystem;
  private SparkMax shootMotor;
  private SparkMaxConfig shootMotorConfiguration;
  enum ShootState {
    kShootingMax,
    kShootingHalf,
    kShootingLow,
    kBrake
  }
  public ShootSubsystem(){
    shootMotor = new SparkMax(2, MotorType.kBrushless);
    shootMotorConfiguration = new SparkMaxConfig();
    shootMotorConfiguration.smartCurrentLimit(40);
    shootMotorConfiguration.idleMode(IdleMode.kBrake);
    shootMotorConfiguration.inverted(false);
    shootMotorConfiguration.limitSwitch.forwardLimitSwitchEnabled(true).forwardLimitSwitchType(Type.kNormallyOpen);
    shootMotorConfiguration.openLoopRampRate(3);
    shootMotor.configure(shootMotorConfiguration, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }
  private ShootState defaultShootState = ShootState.kBrake;
  public void setShooterState(ShootState defaultShootState){
    this.defaultShootState = defaultShootState;
    shootMotor.set(switch(this.defaultShootState){
      case kShootingMax -> 1;
      case kShootingHalf -> .5;
      case kShootingLow -> .25;
      case kBrake -> 0.0;
    });
  }
}
