package frc.command;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.subsystems.IndexerSubsystem;
import frc.subsystems.IntakeSubsystem;

public class AmpShootCmd extends ParallelCommandGroup {
    public AmpShootCmd(IntakeSubsystem intakeSub, IndexerSubsystem indexSub) {
        new MoveToAmpCmd(indexSub, intakeSub);
    }
}