package frc.robot.Mechanisms;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Mechanisms.IntakeSubystem.IntakeState;
import frc.robot.Mechanisms.ShootSubsystem.ShootState;

public class HavikCommands {
    private ShootSubsystem m_ShootSubsystem;
    private IntakeSubystem m_IntakeSubystem;
    public HavikCommands(ShootSubsystem m_ShootSubsystem, IntakeSubystem m_IntakeSubystem){
        this.m_ShootSubsystem = m_ShootSubsystem;
        this.m_IntakeSubystem = m_IntakeSubystem;
    }
    public Command onShoot(){
        return Commands.runOnce(() -> m_ShootSubsystem.setShooterState(ShootState.kShooting));
    }
    public Command onIntake(){
        return Commands.runOnce(() -> m_IntakeSubystem.setIntakeState(IntakeState.kIntaking));
    }
    public Command onBrakeShooter(){
        return Commands.runOnce(() -> m_ShootSubsystem.setShooterState(ShootState.kBrake));
    }
    public Command onBrakeIntake(){
        return Commands.runOnce(() -> m_IntakeSubystem.setIntakeState(IntakeState.kBrake));
    }
}
