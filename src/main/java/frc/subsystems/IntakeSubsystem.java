package frc.subsystems;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.RobotMap.IntakeConstants;


public class IntakeSubsystem extends SubsystemBase{
    private CANSparkFlex intakeMotor;
    private double intakeSpeed = 1;
    private AnalogPotentiometer intakeDistanceSensor;
    private boolean isNoteIn = true;

    public IntakeSubsystem() {
        intakeMotor = new CANSparkFlex(RobotMap.MotorPorts.INTAKE_MOTOR, MotorType.kBrushless);
        intakeMotor.setSmartCurrentLimit(40);
        intakeMotor.burnFlash();
        intakeDistanceSensor = new AnalogPotentiometer(0, 100, 30);
    }

    public void runIntake() {
        intakeMotor.set(-intakeSpeed);
    }

    public void runOuttake() {
        intakeMotor.set(0.2);
    }

    public boolean hitSensor() {
        return isNoteIn;
    }

    public void stop() {
        intakeMotor.set(0);
    }

    @Override
    public void periodic() {
        isNoteIn = intakeDistanceSensor.get() > (IntakeConstants.kDistanceWithoutNode + 5);
    }
}
