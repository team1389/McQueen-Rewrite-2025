package frc.subsystems;
import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class ElevatorSubsystem extends SubsystemBase {
    //Inititalizing CAN Sparks and giving them names
    private CANSparkMax motion;
    public void elevator(){
        //-------
        //motor
        this.motion = new CANSparkMax(RobotMap.MotorPorts.ELEVATOR_MOTOR, MotorType.kBrushed);
        //--------
        //Setting Current limits to not damage motors
        motion.setSmartCurrentLimit(40);
    }

    public void elevatorupdown(double speed){
        this.motion.set(speed);
    }

    public void elevatorStop(){
        this.motion.set(0);
    }
    // Perodic func
    @Override
    public void periodic(){

    }
}
