package frc.command;

import java.util.function.Supplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.subsystems.ElevatorSubsystem;

public class ElevatorCmd extends Command {
    public ElevatorSubsystem elevatorSubsystem;
    public Supplier<Double> speed;

    public ElevatorCmd(ElevatorSubsystem igottaelevate, Supplier<Double> direction) {
        this.elevatorSubsystem = igottaelevate;
        this.speed = direction;
        addRequirements(elevatorSubsystem);
    }
    // public ElevatorCmd(ElevatorSubsystem igottaElevate, double direction){
    //     this.elevatorSubsystem = igottaElevate;
    //     this.speed = direction;
    // }

    @Override
    public void execute() {
        elevatorSubsystem.moveElevator(MathUtil.clamp(speed.get(), -1, 1));
    }

    @Override
    public void end(boolean interrupted) {
        elevatorSubsystem.stop();
    }
}
