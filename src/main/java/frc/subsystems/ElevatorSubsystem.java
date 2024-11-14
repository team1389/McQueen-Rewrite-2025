package frc.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class ElevatorSubsystem extends SubsystemBase {
    //Inititalizing CAN Sparks and giving them names
    private CANSparkMax motion;
    public void elevator(){
    
        //intitalizing CAN sparks to motors
        //-------
        //Left Side Drive
        this.motion = new CANSparkMax(frc.robot.MotorPorts.ELEVATOR_MOTOR, MotorType.kBrushed);
        //--------
        //Setting Current limits to not damage motors
        motion.setSmartCurrentLimit(60);
    }

    public void elevatorupdown(double speed){
        this.motion.set(speed);
    }
    // Perodic func
    @Override
    public void periodic(){

    }
}
