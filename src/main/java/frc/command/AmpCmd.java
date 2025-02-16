package frc.command;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.subsystems.IndexerSubsystem;
import frc.subsystems.IntakeSubsystem;

public class AmpCmd extends SequentialCommandGroup {

    public AmpCmd(IntakeSubsystem intakeSub, IndexerSubsystem indexSub) {
        addCommands(
            new MoveToAmpCmd(indexSub, intakeSub),
            new ShootAmpCmd(indexSub, intakeSub)
        );
    }
}
