package frc.command;

import edu.wpi.first.wpilibj2.command.Command;
import frc.subsystems.IndexerSubsystem;

public class MoveToShootCmd extends Command{
    private IndexerSubsystem indexerSub;

    public MoveToShootCmd(IndexerSubsystem indexSub) {
        this.indexerSub = indexSub;
    }

    @Override
    public void execute() {
        indexerSub.moveToShoot();
    }

    @Override
    public void end(boolean interrupted) {
        indexerSub.stop();
    }
}
