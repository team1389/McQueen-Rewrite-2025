package frc.command;

import edu.wpi.first.wpilibj2.command.Command;
import frc.subsystems.IndexerSubsystem;
import frc.subsystems.IntakeSubsystem;

public class MoveToAmpCmd extends Command {
    private IndexerSubsystem indexerSub;
    private IntakeSubsystem intakeSub;

    public MoveToAmpCmd(IndexerSubsystem indexSub, IntakeSubsystem intSub) {
        this.indexerSub = indexSub;
        this.intakeSub = intSub;
    }

    @Override
    public void execute() {
        indexerSub.moveToAmp();
        intakeSub.runIntake();
    }

    @Override
    public void end(boolean interrupted) {
        indexerSub.stop();
        intakeSub.stop();
    }
    
}
