package frc.command;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.subsystems.IndexerSubsystem;
import frc.subsystems.IntakeSubsystem;
import frc.subsystems.ShooterSubsystem;


public class ShootCmd extends SequentialCommandGroup{

    public ShootCmd(IntakeSubsystem intakeSubsystem, IndexerSubsystem indexerSubsystem, ShooterSubsystem shooterSubsystem){
        addCommands(
            Commands.sequence(
            //   new SetWristCmd(shooterSubsystem, limelightVisionSubsystem.calculateShooterAngle(), limelightVisionSubsystem),
                    // Commands.parallel(
                        new MoveToShootCmd(indexerSubsystem, intakeSubsystem),
                            // new IsRpmTarget(shooterSubsystem, limelightVisionSubsystem),
                            new RunShootSpeedCmd(shooterSubsystem)
            // )    
            )
        );
    }
}
