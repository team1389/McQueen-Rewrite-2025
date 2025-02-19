package frc.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkFlex;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.RobotMap;

public class IndexerSubsystem extends SubsystemBase{
    double indexerMotorSpeed = 1; //.2
    private SparkFlex indexerMotor;

    public IndexerSubsystem(){
        indexerMotor = new SparkFlex(RobotMap.MotorPorts.INDEXER_MOTOR, MotorType.kBrushless);
        // indexerMotor.setSmartCurrentLimit(40);
        // indexerMotor.burnFlash();
    }

    public void moveToShoot() {
        indexerMotor.set(indexerMotorSpeed);
    }

    public void moveToAmp(){
        indexerMotor.set(-indexerMotorSpeed);
    }

    public void stop(){
        indexerMotor.set(0);
    }

}
