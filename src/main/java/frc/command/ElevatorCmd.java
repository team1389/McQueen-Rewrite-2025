package frc.command;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.subsystems.ElevatorSubsystem;

public class ElevatorCmd extends Command {
    private ElevatorSubsystem elevatorSubsystem;
    private double speed;

    public ElevatorCmd(ElevatorSubsystem igottaelevate, Supplier<Double> direction) {
        this.elevatorSubsystem = igottaelevate;
        this.speed = direction.get();
    }

    @Override
    public void execute() {
        elevatorSubsystem.moveElevator(speed);
    }

    @Override
    public void end(boolean interrupted) {
        elevatorSubsystem.stop();
    }
}
