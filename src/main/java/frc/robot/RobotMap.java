package frc.robot;

import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;

/**
 * define Hardware Ports in here
 */
public class RobotMap {


}
//Motor Ports
public static final class MotorPorts{
    //MOTORS
    public static final int SHOOT_BOTTOM = 11;
    public static final int SHOOT_TOP = 10;
    public static final int WRIST_MOTOR = 12;
    public static final int INDEXER_MOTOR = 14;
    public static final int INTAKE_MOTOR = 13;
    public static final int ELEVATOR_MOTOR = 16;

    //ENCODERS

    public static final int WRIST_ENCODER = 8;
    public static final int ELEVATOR_ENCODER = 7;


    //PIDGEON?
    public static final int PIGEON = 18;
}