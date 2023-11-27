package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.constants.CubeShooterConstants;

public class CubeShooter {

    private static CubeShooter instance;
    private static CANSparkMax leftMotor = new CANSparkMax(CubeShooterConstants.leftMotorCANID, MotorType.kBrushless);
    private static CANSparkMax rightMotor = new CANSparkMax(CubeShooterConstants.rightMotorCANID, MotorType.kBrushless);

    private CubeShooter() {

    }

    public static CubeShooter getInstance() {
        if(instance == null) {
            instance = new CubeShooter();
        }
        return instance;
    }
}
