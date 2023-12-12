package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.CubeShooterConstants;

public class CubeShooter extends SubsystemBase {

    private static CubeShooter instance;

    private static CANSparkMax feederMotor = new CANSparkMax(CubeShooterConstants.kFeederMotorCANID,
            MotorType.kBrushless);
    private static CANSparkMax shooterMotor = new CANSparkMax(CubeShooterConstants.kShooterMotorCANID,
            MotorType.kBrushless);
    private RelativeEncoder shooterEncoder = feederMotor.getEncoder();

    private CubeShooter() {
        feederMotor.restoreFactoryDefaults();
        shooterMotor.restoreFactoryDefaults();

        feederMotor.setIdleMode(IdleMode.kBrake);
        shooterMotor.setIdleMode(IdleMode.kCoast);

        feederMotor.setInverted(CubeShooterConstants.kFeederMotorInverted);
        shooterMotor.setInverted(CubeShooterConstants.kShooterMotorInverted);

        feederMotor.burnFlash();
        shooterMotor.burnFlash();
    }

    public static CubeShooter getInstance() {
        if (instance == null) {
            instance = new CubeShooter();
        }
        return instance;
    }

    public static void feederAcquire() {
        feederMotor.set(CubeShooterConstants.kFeederSpeed);
    }

    public static void feederEject() {
        feederMotor.set(-CubeShooterConstants.kFeederSpeed);
    }

    public static void shooterRun() {
        shooterMotor.set(CubeShooterConstants.kShooterSpeed);
    }

    public static void stopFeeder() {
        feederMotor.stopMotor();
    }

    public static void stopShooter() {
        shooterMotor.stopMotor();
    }
}
