package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.CubeShooterConstants;

public class CubeShooter extends SubsystemBase {
    // TODO: make safeguards for methods | some other things | ????????
    private static CubeShooter instance;

    private static CANSparkMax feederMotor = new CANSparkMax(CubeShooterConstants.feederMotorCANID, MotorType.kBrushless);
    private static CANSparkMax shooterMotor = new CANSparkMax(CubeShooterConstants.shooterMotorCANID, MotorType.kBrushless);
    private RelativeEncoder feederEncoder = feederMotor.getEncoder();
    private RelativeEncoder shooterEncoder = feederMotor.getEncoder();

    private CubeShooter() {
        feederMotor.restoreFactoryDefaults();
        shooterMotor.restoreFactoryDefaults();

        feederMotor.setIdleMode(IdleMode.kCoast);
        shooterMotor.setIdleMode(IdleMode.kCoast);

        feederMotor.setInverted(CubeShooterConstants.kIsFeederMotorInverted);
        shooterMotor.setInverted(CubeShooterConstants.kIsShooterMotorInverted);

        feederMotor.burnFlash();
        shooterMotor.burnFlash();
    }

    public static CubeShooter getInstance() {
        if(instance == null) {
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

    public static void runShooter() {
        shooterMotor.set(CubeShooterConstants.kShooterSpeed);
    }

    public static void stopFeeder() {
        feederMotor.stopMotor();
    }

    public static void stopShooter(double speed) {
        shooterMotor.stopMotor();
    }
}
