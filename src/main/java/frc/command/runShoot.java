package frc.command;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.subsystems.ShooterSubsystem;

public class runShoot extends Command {
    ShooterSubsystem shooter;

    public RunShoot(ShooterSubsystem shooter) {
        this.shooter = shooter;
    }

    public void execute() {
        shooter.shootTuah();
    }

    public void end() {
        shooter.stop();
    }
}
