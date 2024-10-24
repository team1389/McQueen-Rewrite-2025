package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class OI {


    public XboxController driveController, manipController;

    public OI() {
        initControllers();

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
    private double getDriveLeftY() {
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