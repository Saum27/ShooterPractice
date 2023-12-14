package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class AcquireCommand extends CommandBase {
    private Shooter shooter = Shooter.getInstance();

    public AcquireCommand() {
        addRequirements(shooter);
    }
}
