package frc.command;

import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj2.command.Command;
import frc.subsystems.IntakeSubsystem;

public class RunIntakeCmd extends Command {
    private IntakeSubsystem intakeSub;
    private Timer time = new Timer();
    private double timeout = 0.4;

    public RunIntakeCmd(IntakeSubsystem innieSubbie) {
        this.intakeSub = innieSubbie;
    }

    @Override
    public void initialize() {
        time.reset();
        time.start();
    }

    @Override
    public void execute() {
        intakeSub.runIntake();
    }

    @Override
    public void end(boolean interrupted) {
        intakeSub.stop();
    }

    @Override
    public boolean isFinished() {
        return time.hasElapsed(timeout);
    }
}
