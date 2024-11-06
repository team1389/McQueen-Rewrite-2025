package frc.robot;
import frc.subsystems.ElevatorSubsystem.ElevatorSubsystem.;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.RunCommand;

public class OI {


    public XboxController driveController, manipController;

    public OI() {
        initControllers();
        Elevator.setDefaultCommand(
            new RunCommand(
                () ->
                    //(UNCOMMENT FOR TANKDRIVE) m_drivetrain.tankDrive(
                    m_drivetrain.arcadeDrive( //(COMMENT FOR TANKDRIVE)
                        getDriveLeftY(), getDriveLeftX()),
                m_drivetrain));
    }

    /**
     * Initialize JoystickButtons and Controllers
     */
    private void initControllers() {
        driveController = new XboxController(0);
        manipController = new XboxController(1);

    }

    //gets the stick values
    //----------
    //—Left stick--
    //X-axis: 0
    //Y-axis: 1 and 2
    //—Right stick--
    //X-axis: 3
    //Y-axis: 4 and 5
    //----------
    //Drive controler axis value grabers
    public double getDriveLeftY() {
        return driveController.getRawAxis(1);
        
    }
    private double getDriveLeftX() {
        return driveController.getRawAxis(0);
        
    }
    private double getDriveRightY(){
        return driveController.getRawAxis(4);
    }
    private double getDriveRightX(){
        return driveController.getRawAxis(3);
    }
    


}