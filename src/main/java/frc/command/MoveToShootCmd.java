package frc.command;

import edu.wpi.first.wpilibj2.command.Command;
import frc.subsystems.IndexerSubsystem;
import frc.subsystems.IntakeSubsystem;

public class MoveToShootCmd extends Command{
    private IndexerSubsystem indexerSub;
    private IntakeSubsystem intakeSub;

    public MoveToShootCmd(IndexerSubsystem indexSub, IntakeSubsystem intSub) {
        this.indexerSub = indexSub;
        this.intakeSub = intSub;
    }

    @Override
    public void execute() {
        indexerSub.moveToShoot();
        intakeSub.runIntake();
    }

    @Override
    public void end(boolean interrupted) {
        indexerSub.stop();
        intakeSub.stop();
    }
}
