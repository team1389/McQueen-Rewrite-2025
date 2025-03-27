package frc.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.RobotMap.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase{
    private final double intakeSpeed = 1; //should be 1
    private SparkFlex intakeMotor;
    private AnalogPotentiometer intakeDistanceSensor;
    private boolean isNoteIn = true;

    public IntakeSubsystem() {
        // SmartDashboard.putBoolean("Note in Intake", false);
        intakeMotor = new SparkFlex(RobotMap.MotorPorts.INTAKE_MOTOR, MotorType.kBrushless);
        // intakeMotor.setSmartCurrentLimit(40);

        //The type of distance sensor we have in the intake, a 2m rev IR Distance Sensor, must be declared as an analog potentiometer
        intakeDistanceSensor = new AnalogPotentiometer(0, 100, 30); 
        // SmartDashboard.putNumber("Intake Distance Sensor", intakeDistanceSensor.get());
        // SmartDashboard.putBoolean("isNoteIn", isNoteIn);
    }

    public void runIntake(){
        intakeMotor.set(-intakeSpeed);
    }

    public void runOuttake(){
        intakeMotor.set(1);
    }

    public boolean hitSensor(){ 
        // SmartDashboard.putBoolean("Note in Intake", isNoteIn);
        return isNoteIn;
    }

    public void stop(){
        intakeMotor.set(0);
    }

    @Override
    public void periodic(){
        isNoteIn = intakeDistanceSensor.get() > (IntakeConstants.kDistanceWithoutNode + 5);
        // SmartDashboard.putNumber("Intake Distance Sensor", intakeDistanceSensor.get());
        // SmartDashboard.putBoolean("isNoteIn", hitSensor());
    }
}
