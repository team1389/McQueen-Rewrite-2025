package frc.command;

import edu.wpi.first.wpilibj2.command.Command;
import frc.subsystems.ShooterSubsystem;

public class MoveShooterCmd extends Command {
    private ShooterSubsystem shootSub;

    public MoveShooterCmd(ShooterSubsystem shootieSubbie) {
        this.shootSub = shootieSubbie;
    }

    @Override
    public void execute() {
        shootSub.runWristUp();
    }

    @Override
    public void end(boolean interrupted) {
        shootSub.stopWrist();
    }
}
