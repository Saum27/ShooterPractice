package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class EjectCommand extends CommandBase {
    private Shooter shooter = Shooter.getInstance();
    private Timer timer = new Timer();

    public EjectCommand() {
        addRequirements(shooter);
    }

    @Override
    public void execute() {
        shooter.feederEject();
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= 5.0;
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stopFeeder();
    }
}
