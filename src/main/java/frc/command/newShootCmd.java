package frc.command;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.subsystems.IndexerSubsystem;
import frc.subsystems.IntakeSubsystem;
import frc.subsystems.ShooterSubsystem;


public class newShootCmd extends SequentialCommandGroup{

    public newShootCmd(IntakeSubsystem intakeSubsystem, IndexerSubsystem indexerSubsystem, ShooterSubsystem shooterSubsystem){
        addCommands(
            Commands.sequence(
            //   new SetWristCmd(shooterSubsystem, limelightVisionSubsystem.calculateShooterAngle(), limelightVisionSubsystem),
                    // Commands.parallel(
                        new RunShootSpeedCmd(shooterSubsystem),
                        // new IsRpmTarget(shooterSubsystem, limelightVisionSubsystem),
                        new MoveToShootCmd(indexerSubsystem, intakeSubsystem)
            // )    
            )
        );
    }
}
