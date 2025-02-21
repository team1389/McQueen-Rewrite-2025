package frc.command;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.subsystems.ShooterSubsystem;
import java.util.function.Supplier;

public class WristCmd extends Command {
    public ShooterSubsystem shooterSubbie;
    public Supplier<Double> speed;

    public WristCmd(ShooterSubsystem igottashoot, Supplier<Double> direction) {
        this.shooterSubbie = igottashoot;
        this.speed = direction;
        addRequirements(shooterSubbie);
    }
    // public WristCmd(ShooterSubsystem igottashoot, double direction) {
    //     this.shooterSubbie = igottashoot;
    //     this.speed = direction;
    // }

    @Override
    public void execute() {
        shooterSubbie.runWrist(MathUtil.clamp(-speed.get(),-.1,.1));
    }

    @Override
    public void end(boolean interrupted) {
        shooterSubbie.holdPosition();
    }
}