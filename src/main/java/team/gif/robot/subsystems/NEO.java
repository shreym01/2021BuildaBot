package team.gif.robot.subsystems;

import com.revrobotics.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Constants;
import team.gif.robot.Robot;
import team.gif.robot.RobotMap;

public class NEO extends SubsystemBase {
    private static NEO instance = null;

    // creates a singleton class (only 1 instance can be instantiated)
    public static NEO getInstance() {
        if (instance == null) {
            instance = new NEO();
        }
        return instance;
    }

    private static final CANSparkMax NEO = new CANSparkMax(RobotMap.MOTOR_SPARKMAX_ONE, CANSparkMaxLowLevel.MotorType.kBrushless);
    private static final CANEncoder NEOEncoder = NEO.getEncoder();
    private static final CANPIDController NEOPIDController = NEO.getPIDController();

    int stallMaxAmps = 40;

    public NEO(){
        super();
        NEO.restoreFactoryDefaults();
        NEO.enableVoltageCompensation(12);
        NEO.setIdleMode(CANSparkMax.IdleMode.kCoast);
        NEO.setSmartCurrentLimit(stallMaxAmps,stallMaxAmps);
        NEOPIDController.setP(0.0007); //0.0007
        NEOPIDController.setFF(0.000175); //0.000175
        NEOPIDController.setOutputRange(0, 1);

        NEOPIDController.setOutputRange(0, 1);
    }
    public void setVoltage(double voltage) {
        NEO.setVoltage(voltage);
    }


    public double getVelocity () { return NEOEncoder.getVelocity();}
    public void setPID (double setPoint) {
        NEOPIDController.setReference(setPoint, ControlType.kVelocity);
    }

    public String getVelocity_Shuffleboard(){ return String.format("%12.0f",getVelocity());}

}
