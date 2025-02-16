package frc.command;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.subsystems.IntakeSubsystem;

public class IntakeCmd extends SequentialCommandGroup {
    public IntakeCmd(IntakeSubsystem intakeSub) {
        addCommands(
            new RunIntakeCmd(intakeSub),
            new RunOuttakeCmd(intakeSub)
        );
    }
}
