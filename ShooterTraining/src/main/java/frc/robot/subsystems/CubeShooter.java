package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.CubeShooterConstants;

public class CubeShooter extends SubsystemBase {

    private static CubeShooter instance;
    private static CANSparkMax feederMotor = new CANSparkMax(CubeShooterConstants.feederMotorCANID, MotorType.kBrushless);
    private static CANSparkMax shooterMotor = new CANSparkMax(CubeShooterConstants.shooterMotorCANID, MotorType.kBrushless);

    private CubeShooter() {
        feederMotor.restoreFactoryDefaults();
        shooterMotor.restoreFactoryDefaults();

        feederMotor.setIdleMode(IdleMode.kCoast);
        shooterMotor.setIdleMode(IdleMode.kCoast);

        feederMotor.setInverted(CubeShooterConstants.isFeederMotorInverted);
        shooterMotor.setInverted(CubeShooterConstants.isShooterMotorInverted);

        feederMotor.burnFlash();
        shooterMotor.burnFlash();
    }

    public static CubeShooter getInstance() {
        if(instance == null) {
            instance = new CubeShooter();
        }
        return instance;
    }

    public static void runFeeder(double speed) {
        feederMotor.set(speed);
    }

    public static void runShooter(double speed) {
        shooterMotor.set(speed);
    }
}
