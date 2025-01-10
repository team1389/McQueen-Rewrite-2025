package frc.subsystems;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase{
    private double shootSpeed = 1; // percent of max motor speed -1 to 1
    private final double wristSpeed = .15; // percent of max motor speed
    private CANSparkFlex bottomShoot;
    private CANSparkFlex topShoot;
    private CANSparkFlex wristControl;

    public ShooterSubsystem() {
        topShoot = new CANSparkFlex(RobotMap.MotorPorts.INTAKE_MOTOR, MotorType.kBrushless);
        topShoot.setSmartCurrentLimit(40);
        topShoot.setInverted(true);
        topShoot.setIdleMode(IdleMode.kCoast);
        topShoot.burnFlash();

        bottomShoot = new CANSparkFlex(RobotMap.MotorPorts.INTAKE_MOTOR, MotorType.kBrushless);
        bottomShoot.setSmartCurrentLimit(40);
        bottomShoot.setInverted(true);
        bottomShoot.setIdleMode(IdleMode.kCoast);
        bottomShoot.burnFlash();
        
        wristControl = new CANSparkFlex(RobotMap.MotorPorts.INTAKE_MOTOR, MotorType.kBrushless);
        wristControl.setSmartCurrentLimit(40);
        wristControl.setIdleMode(IdleMode.kBrake);
        wristControl.burnFlash();
    }

    public void shootTuah() {
        topShoot.set(shootSpeed);
        bottomShoot.set(shootSpeed);
    }

    public void stop() {
        topShoot.set(0);
        bottomShoot.set(0);
    }
}
