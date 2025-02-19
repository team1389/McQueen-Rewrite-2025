package frc.command;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.subsystems.IndexerSubsystem;
import frc.subsystems.IntakeSubsystem;

public class IntakeCmd extends ParallelCommandGroup {
    public IntakeCmd(IntakeSubsystem intakeSub, IndexerSubsystem indexSub) {
        addCommands(
            new RunIntakeCmd(intakeSub),
            new MoveToShootCmd(indexSub)
        );
    }
}
