package frc.command;
import frc.subsystems.ElevatorSubsystem;
import frc.robot.OI;
import edu.wpi.first.wpilibj2.command.Command;

public class ElevatorUpDown  extends Command {
    ElevatorSubsystem elevator;
    public moveElevator(ElevatorSubsystem elevator){
        this.elevator = elevator;
   }
   @Override
   public void execute(){
    elevator.elevatorupdown(getManipLeftY()); 
   }
   @Override
   public void end(){

   }
}
