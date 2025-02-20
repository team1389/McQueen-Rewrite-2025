package frc.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkFlex;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.RobotMap;

public class ElevatorSubsystem extends SubsystemBase{
    // double elevatorSpeed = 1; //.2
    private SparkFlex elevatorMotor;

    public ElevatorSubsystem(){
        elevatorMotor = new SparkFlex(16, MotorType.kBrushless);
        // indexerMotor.setSmartCurrentLimit(40);
        // indexerMotor.burnFlash();
    }

    public void moveElevator(double elevatorSpeed) {
        elevatorMotor.set(elevatorSpeed);
    }

    // public void elevatorDown(){
    //     elevatorMotor.set(-elevatorSpeed);
    // }

    public void stop(){
        elevatorMotor.set(0);
    }

}
