package frc.command;

import edu.wpi.first.wpilibj2.command.Command;
import frc.subsystems.ShooterSubsystem;

public class MoveShooterDownCmd extends Command{
    private ShooterSubsystem shootSub;
    public MoveShooterDownCmd(ShooterSubsystem shootieSubbie) {
        this.shootSub = shootieSubbie;
    }

    @Override
    public void execute() {
        shootSub.runWristDown();
    }

    @Override
    public void end(boolean interrupted) {
        shootSub.stop();
    }
}
