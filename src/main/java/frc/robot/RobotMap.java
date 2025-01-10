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
public static final class IntakeConstants {
    public static final double kDistanceWithoutNode = 46.7;
}

public static final class ShooterConstants {
        //Shooter Parameters

        public static final double kTopRPM = 3000; //top
        public static final double kBottomRPM = 3000; //bottom
        
        public static final double kTop_P = .1;
        public static final double kTop_I = 0;//change
        public static final double kTop_D = 0;
        public static final double kTop_FF = 1.75;
        public static final double kTop_MIN_OUTPUT = 0.3;
        public static final double kTop_MAX_OUTPUT = 1;

        public static final double kBottom_P = .1;
        public static final double kBottom_I = 0;//change
        public static final double kBottom_D = 0;
        public static final double kBottom_FF = 1.75;
        public static final double kBottom_MIN_OUTPUT = 0.3;
        public static final double kBottom_MAX_OUTPUT = 1;

        public static final double kWrist_P = 0.055;
        public static final double kWrist_I = 0.01;
        public static final double kWrist_D = 0.0;

        public static final double kMinWristAngle = 0.8;
        public static final double kMaxWristAngle = 0.98;

        public static final double AprilTagHeight = 4.697916667; // height of the center of the speaker apriltag to ground (ft) //h2
        public static final double LimelightHeight = 26/12; // distance from the center of the limelight lens to ground //h1
        public static final double TagToSpeakerHeight = 1.896192542; // height from center of apriltag to center of speaker //s
        public static final double LimelightAngle = 22.5; // how many degrees back is the limelight rotated from perfectly vertical (deg) //a1

        public static final double SpeakerXDistfromCenter = 8.270621; 
        public static final double SpeakerYDistfromCenter = 1.442212;
        public static final double XOffset = 0.0254;
        public static final double YOffset = 0.0889;
        public static final double dis_LL_to_bumpers = 1.333;// ft

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

}


