package frc.command;

import edu.wpi.first.wpilibj2.command.Command;
import frc.subsystems.ShooterSubsystem;

public class RunShootSpeedCmd extends Command {
    ShooterSubsystem shooterSub;

    public RunShootSpeedCmd(ShooterSubsystem shootSub) {
        this.shooterSub = shootSub;
    }
    @Override
    public void execute() {
        shooterSub.runShootSpeed();
    }
    @Override
    public void end(boolean interrupted) {
        shooterSub.stop();
    }
}
