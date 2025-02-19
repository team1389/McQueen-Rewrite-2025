package frc.command;

import edu.wpi.first.wpilibj2.command.Command;
import frc.subsystems.ShooterSubsystem;


public class newShootCmd extends Command {

    ShooterSubsystem shootSub;
    public newShootCmd(ShooterSubsystem shootieSubbie){
        shootSub = shootieSubbie;
    }

    @Override
    public void execute() {
        shootSub.runShootSpeed();
    }

    @Override
    public void end(boolean interrupted) {
        shootSub.stop();
    }
}
