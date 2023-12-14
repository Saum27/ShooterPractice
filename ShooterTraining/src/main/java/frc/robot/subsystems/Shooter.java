package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.ShooterConstants;

public class Shooter extends SubsystemBase {

    private static Shooter instance;

    private static CANSparkMax feederMotor = new CANSparkMax(ShooterConstants.kFeederMotorCANID,
            MotorType.kBrushless);
    private static CANSparkMax shooterMotor = new CANSparkMax(ShooterConstants.kShooterMotorCANID,
            MotorType.kBrushless);
    private RelativeEncoder shooterEncoder = feederMotor.getEncoder();

    private Shooter() {
        feederMotor.restoreFactoryDefaults();
        shooterMotor.restoreFactoryDefaults();

        feederMotor.setIdleMode(IdleMode.kBrake);
        shooterMotor.setIdleMode(IdleMode.kCoast);

        feederMotor.setInverted(ShooterConstants.kFeederMotorInverted);
        shooterMotor.setInverted(ShooterConstants.kShooterMotorInverted);

        feederMotor.burnFlash();
        shooterMotor.burnFlash();
    }

    public static Shooter getInstance() {
        if (instance == null) {
            instance = new Shooter();
        }
        return instance;
    }

    public void feederAcquire() {
        feederMotor.set(ShooterConstants.kFeederSpeed);
    }

    public void feederEject() {
        feederMotor.set(-ShooterConstants.kFeederSpeed);
    }

    public void shooterRun() {
        shooterMotor.set(ShooterConstants.kShooterSpeed);
    }

    public void stopFeeder() {
        feederMotor.stopMotor();
    }

    public void stopShooter() {
        shooterMotor.stopMotor();
    }
}
