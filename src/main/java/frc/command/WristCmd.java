package frc.command;

import edu.wpi.first.wpilibj2.command.Command;
import frc.subsystems.ShooterSubsystem;
import java.util.function.Supplier;

public class WristCmd extends Command {
    private ShooterSubsystem shooterSubbie;
    private double speed;

    public WristCmd(ShooterSubsystem igottashoot, Supplier<Double> direction) {
        this.shooterSubbie = igottashoot;
        this.speed = direction.get();
    }

    @Override
    public void execute() {
        shooterSubbie.runWrist(speed);
    }

    @Override
    public void end(boolean interrupted) {
        shooterSubbie.stopWrist();
    }
}