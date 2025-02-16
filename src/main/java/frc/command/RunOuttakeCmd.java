package frc.command;

import edu.wpi.first.wpilibj2.command.Command;
import frc.subsystems.IntakeSubsystem;

public class RunOuttakeCmd extends Command{
    private IntakeSubsystem intakeSub;

    public RunOuttakeCmd(IntakeSubsystem innieSubbie) {
        this.intakeSub = innieSubbie;
    }

    @Override
    public void execute() {
        intakeSub.runOuttake();
    }

    @Override
    public void end(boolean interrupted) {
        intakeSub.stop();
    }
}
