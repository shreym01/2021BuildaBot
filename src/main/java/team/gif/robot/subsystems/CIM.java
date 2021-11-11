package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class CIM extends SubsystemBase {
    private static CIM instance = null;

    // creates a singleton class (only 1 instance can be instantiated)
    public static CIM getInstance() {
        if (instance == null) {
            instance = new CIM();
        }
        return instance;
    }
    private static final TalonSRX CIM = new TalonSRX(RobotMap.MOTOR_TALON_ONE);

    public CIM(){
        CIM.setNeutralMode(NeutralMode.Brake);
    }

    public void setSpeed(double speed){
        CIM.set(ControlMode.PercentOutput, speed);
    }
}
