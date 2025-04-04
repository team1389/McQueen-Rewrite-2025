// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.command.AmpCmd;
import frc.command.AmpShootCmd;
import frc.command.ElevatorCmd;
import frc.command.IntakeCmd;
import frc.command.WristCmd;
import frc.command.MoveToShootCmd;
import frc.command.Outtake;
import frc.command.RunIntakeCmd;
import frc.command.newShootCmd;
// import frc.command.ManualElevator;
// import frc.command.exhaleCommand;
import frc.robot.RobotMap.OperatorConstants;
import frc.subsystems.ElevatorSubsystem;
import frc.subsystems.IndexerSubsystem;
import frc.subsystems.IntakeSubsystem;
import frc.subsystems.ShooterSubsystem;
// import frc.subsystems.ClimberSubsystem;
// import frc.subsystems.ElevatorSubsystem;
import frc.subsystems.SwerveSubsystem;

import java.io.File;
import swervelib.SwerveInputStream;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a "declarative" paradigm, very
 * little robot logic should actually be handled in the {@link Robot} periodic methods (other than the scheduler calls).
 * Instead, the structure of the robot (including subsystems, commands, and trigger mappings) should be declared here.
 */
public class OI
{

  // Replace with CommandPS4Controller or CommandJoystick if needed
  final CommandXboxController driveController = new CommandXboxController(0);;
  final CommandXboxController operatorController = new CommandXboxController(1);;
  IndexerSubsystem indexSub = new IndexerSubsystem();
  IntakeSubsystem intakeSub = new IntakeSubsystem();
  ShooterSubsystem shootSub = new ShooterSubsystem();
  ElevatorSubsystem elevatorSub = new ElevatorSubsystem();

  // The robot's subsystems and commands are defined here...
  // private final ClimberSubsystem      climber    = new ClimberSubsystem();
  // private final ElevatorSubsystem elevator = new ElevatorSubsystem();
  private final SwerveSubsystem       drivebase  = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(),
                                                                                "swerve"));
                                                                                
                                                                              
  /**
   * Converts driver input into a field-relative ChassisSpeeds that is controlled by angular velocity.
   */
  SwerveInputStream driveAngularVelocity = SwerveInputStream.of(drivebase.getSwerveDrive(),
                                                                () -> driveController.getLeftY() * -1,
                                                                () -> driveController.getLeftX() * -1)
                                                                //possible change to getRightY if issue persists
                                                            .withControllerRotationAxis(driveController::getRightX)
                                                            .deadband(OperatorConstants.DEADBAND)
                                                            .scaleTranslation(0.8)
                                                            .allianceRelativeControl(true);

  /**
   * Clone's the angular velocity input stream and converts it to a fieldRelative input stream.
   */
  SwerveInputStream driveDirectAngle = driveAngularVelocity.copy().withControllerHeadingAxis(driveController::getRightX,
                                                                                             driveController::getRightY)
                                                           .headingWhile(true);

  /**
   * Clone's the angular velocity input stream and converts it to a robotRelative input stream.
   */
  SwerveInputStream driveRobotOriented = driveAngularVelocity.copy().robotRelative(true)
                                                             .allianceRelativeControl(false);

  SwerveInputStream driveAngularVelocityKeyboard = SwerveInputStream.of(drivebase.getSwerveDrive(),
                                                                        () -> -driveController.getLeftY(),
                                                                        () -> -driveController.getLeftX())
                                                                    .withControllerRotationAxis(() -> driveController.getRawAxis(
                                                                        2))
                                                                    .deadband(OperatorConstants.DEADBAND)
                                                                    .scaleTranslation(0.8)
                                                                    .allianceRelativeControl(true);
  // Derive the heading axis with math!
  SwerveInputStream driveDirectAngleKeyboard     = driveAngularVelocityKeyboard.copy()
                                                                               .withControllerHeadingAxis(() ->
                                                                                                              Math.sin(
                                                                                                                  driveController.getRawAxis(
                                                                                                                      2) *
                                                                                                                  Math.PI) *
                                                                                                              (Math.PI *
                                                                                                               2),
                                                                                                          () ->
                                                                                                              Math.cos(
                                                                                                                  driveController.getRawAxis(
                                                                                                                      2) *
                                                                                                                  Math.PI) *
                                                                                                              (Math.PI *
                                                                                                               2))
                                                                               .headingWhile(true);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public OI()
  {
    // Configure the trigger bindings
    configureBindings();
    DriverStation.silenceJoystickConnectionWarning(true);

  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary predicate, or via the
   * named factories in {@link edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller PS4}
   * controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight joysticks}.
   */
  private void configureBindings()
  {
    //RESERVE DRIVE B FOR AUTO ALIGN
    Command driveFieldOrientedDirectAngle      = drivebase.driveFieldOriented(driveDirectAngle, () -> driveController.b().getAsBoolean());
    Command driveFieldOrientedAnglularVelocity = drivebase.driveFieldOriented(driveAngularVelocity, () -> driveController.b().getAsBoolean());
    Command driveRobotOrientedAngularVelocity  = drivebase.driveFieldOriented(driveRobotOriented, () -> driveController.b().getAsBoolean());
    Command driveFieldOrientedDirectAngleKeyboard      = drivebase.driveFieldOriented(driveDirectAngleKeyboard, () -> driveController.b().getAsBoolean());
    Command driveFieldOrientedAnglularVelocityKeyboard = drivebase.driveFieldOriented(driveAngularVelocityKeyboard, () -> driveController.b().getAsBoolean());

    if (RobotBase.isSimulation())
    {
      drivebase.setDefaultCommand(driveFieldOrientedDirectAngleKeyboard);
    } else
    {
      drivebase.setDefaultCommand(driveFieldOrientedAnglularVelocity);
    }

    if (Robot.isSimulation())
    {
      driveController.start().onTrue(Commands.runOnce(() -> drivebase.resetOdometry(new Pose2d(3, 3, new Rotation2d()))));
      driveController.button(1).whileTrue(drivebase.sysIdDriveMotorCommand());

    }
    if (DriverStation.isTest())
    {
      drivebase.setDefaultCommand(driveFieldOrientedAnglularVelocity); // Overrides drive command above!

      driveController.x().whileTrue(Commands.runOnce(drivebase::lock, drivebase).repeatedly());
      driveController.y().whileTrue(drivebase.driveToDistanceCommand(1.0, 0.2));
      driveController.start().onTrue((Commands.runOnce(drivebase::zeroGyro)));
      driveController.back().whileTrue(drivebase.centerModulesCommand());
      driveController.leftBumper().onTrue(Commands.none());
      driveController.rightBumper().onTrue(Commands.none());
    } else
    {
      //EDIT YOUR COMMANDS HERE_______________________________________________________________________________________________________________________________
      //dont use driver B for aything else, its already used for auto align
      driveController.a().onTrue((Commands.runOnce(drivebase::zeroGyro)));
      driveController.start().whileTrue(Commands.none());
      driveController.back().whileTrue(Commands.none());
      driveController.leftBumper().whileTrue(Commands.runOnce(drivebase::lock, drivebase).repeatedly());
      driveController.rightBumper().onTrue(Commands.none());
      
      /*
      operatorController.a().whileTrue(new newShootCmd(shootSub));
      operatorController.rightBumper().whileTrue(new AmpCmd(intakeSub, indexSub));
      operatorController.y().whileTrue(new RunIntakeCmd(intakeSub));
      operatorController.rightTrigger().whileTrue(new Outtake(intakeSub));
      //ellipsis button - moveshooter, menu button - moveshooter down
      operatorController.x().whileTrue(new MoveShooterCmd(shootSub));
      operatorController.b().whileTrue(new MoveShooterDownCmd(shootSub));
      operatorController.leftBumper().whileTrue(new MoveToShootCmd(indexSub));
       */
      // operatorController.y().whileTrue(new WristCmd(shootSub,.1));
      // operatorController.a().whileTrue(new WristCmd(shootSub,-.1));
      shootSub.setDefaultCommand(new WristCmd(shootSub, () -> getManipLeftY()));
      operatorController.y().whileTrue(new newShootCmd(shootSub));
      operatorController.b().whileTrue(new IntakeCmd(intakeSub, indexSub));
      operatorController.a().whileTrue(new AmpCmd(intakeSub, indexSub));
      // operatorController.leftBumper().whileTrue(new ElevatorCmd(elevatorSub, .2));
      // operatorController.rightBumper().whileTrue(new ElevatorCmd(elevatorSub, -.2));
      elevatorSub.setDefaultCommand(new ElevatorCmd(elevatorSub, () -> getManipRightY()));
      
      
      // Elevator Up & Down = Right Operator Joystick
      // Wrist Up & Down = Left Operator Joystick
      //Intake and move to shooter = B
      //Shoot (rev shooter motors) = Y
      //Amp = A

    }
    
  }

  public double getManipLeftY(){
    return operatorController.getRawAxis(1);
  }
  public double getManipRightY(){
    return operatorController.getRawAxis(4);
  }
  public boolean getManipRightTrigger(){
    return operatorController.rightTrigger().getAsBoolean();
  }
  public boolean getManipLeftTrigger(){
    return operatorController.leftTrigger().getAsBoolean();
  }

  public void setMotorBrake(boolean brake)
  {
    drivebase.setMotorBrake(brake);
  }
}