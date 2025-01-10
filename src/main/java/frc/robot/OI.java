package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.command.ElevatorUpDown;
import frc.command.runShoot;
import frc.subsystems.*;


public class OI {


    public XboxController driveController, manipController;

    /**
     * Initialize JoystickButtons and Controllers
     */
    private void initControllers() {
        driveController = new XboxController(0);
        manipController = new XboxController(1);
    }

    public OI() {
        initControllers();
        JoystickButton manipAButton = new JoystickButton(manipController,1);
        final ShooterSubsystem shooterSub = new ShooterSubsystem();
        final ElevatorSubsystem elevator = new ElevatorSubsystem();
        manipAButton.whileTrue(new runShoot(shooterSub));
        elevator.setDefaultCommand(new ElevatorUpDown(elevator, () -> -getManipRightY()));
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
    public double getDriveLeftX() {
        return driveController.getRawAxis(0);
        
    }
    public double getDriveRightY(){
        return driveController.getRawAxis(4);
    }
    public double getDriveRightX(){
        return driveController.getRawAxis(3);
    }
    //Minip Control axis valu grabbers

    public double getManipLeftY() {
        return driveController.getRawAxis(1);
        
    }
    public double getManipLeftX() {
        return driveController.getRawAxis(0);
        
    }
    public double getManipRightY(){
        return driveController.getRawAxis(4);
    }
    public double getManipRightX(){
        return driveController.getRawAxis(3);
    }


}