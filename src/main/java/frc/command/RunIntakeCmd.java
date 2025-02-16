package frc.command;

import edu.wpi.first.wpilibj2.command.Command;
import frc.subsystems.IntakeSubsystem;

public class RunIntakeCmd extends Command {
    private IntakeSubsystem intakeSub;

    public RunIntakeCmd(IntakeSubsystem innieSubbie) {
        this.intakeSub = innieSubbie;
    }

    @Override
    public void execute() {
        intakeSub.runIntake();
    }

    @Override
    public void end(boolean interrupted) {
        intakeSub.stop();
    }
}
