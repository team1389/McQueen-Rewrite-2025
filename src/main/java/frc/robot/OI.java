package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.subsystems.*;

public class OI {


    public XboxController driveController, manipController;

    /**
     * Initialize JoystickButtons and Controllers
     */
    private void initControllers() {
        driveController = new XboxController(0);
        manipController = new XboxController(1);

        manipAButton = new JoystickButton(manipController,1);
    }

    public OI() {
        initControllers();
        
        public final ShooterSubsystem shooterSub = new ShooterSubsystem();
        public final ElevatorSubsystem elevator = new ElevatorSubsystem();
        manipAButton.whileTrue(new runShoot(shooterSub));
        elevatorSubsystem.setDefaultCommand(new ElevatorUpDown(elevatorSubsystem, () -> -getManipRightY()));
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
    //Minip Control axis valu grabbers

    public double getManipLeftY() {
        return driveController.getRawAxis(1);
        
    }
    private double getManipLeftX() {
        return driveController.getRawAxis(0);
        
    }
    private double getManipRightY(){
        return driveController.getRawAxis(4);
    }
    private double getManipRightX(){
        return driveController.getRawAxis(3);
    }


}