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
        return Commands.startEnd(() -> m_ShootSubsystem.setShooterState(ShootState.kShooting), () -> m_ShootSubsystem.setShooterState(ShootState.kBrake), m_ShootSubsystem);
    }
    public Command onIntake(){
        return Commands.startEnd(() -> m_IntakeSubystem.setIntakeState(IntakeState.kIntaking), () -> m_IntakeSubystem.setIntakeState(IntakeState.kBrake), m_IntakeSubystem);
    }
    
}
