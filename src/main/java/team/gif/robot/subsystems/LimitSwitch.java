package team.gif.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class LimitSwitch extends SubsystemBase {
    private static LimitSwitch instance = null;

    public static LimitSwitch getInstance() {
        if (instance == null) {
            instance = new LimitSwitch();
        }
        return instance;
    }
    private static final DigitalInput limit = new DigitalInput(RobotMap.LIMIT_SWITCH);

    public LimitSwitch(){
    super();
    }


    public boolean getState(){
        boolean state = !(limit.get());
        return state;
    }
}
