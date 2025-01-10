package frc.command;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.subsystems.ShooterSubsystem;

public class runShoot extends Command {
    ShooterSubsystem shooter;

    public runShoot(ShooterSubsystem shooter) {
        this.shooter = shooter;
    }

    @Override
    public void execute() {
        shooter.shootTuah();
    }

    @Override
    public void end(boolean interupted) {
        shooter.stop();
    }
}
