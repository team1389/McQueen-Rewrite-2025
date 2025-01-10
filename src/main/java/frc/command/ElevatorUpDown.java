package frc.command;
import frc.subsystems.ElevatorSubsystem;
import frc.robot.OI;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;

public class ElevatorUpDown  extends Command {
    ElevatorSubsystem elevator;
    Supplier <Double> speed;
    public ElevatorUpDown(ElevatorSubsystem elevator, Supplier <Double> speed){
        this.elevator = elevator;
        this.speed = speed;
   }
   @Override
   public void execute(){
    elevator.elevatorupdown(speed.get()); 
   }
   @Override
   public void end( boolean interupted) {
    elevator.elevatorStop();
    
   }
}
