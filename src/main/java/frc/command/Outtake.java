package frc.command;

import edu.wpi.first.wpilibj2.command.Command;
import frc.subsystems.IntakeSubsystem;

public class Outtake extends Command {
    private IntakeSubsystem intakeSub;

    public Outtake(IntakeSubsystem innieSubbie) {
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
