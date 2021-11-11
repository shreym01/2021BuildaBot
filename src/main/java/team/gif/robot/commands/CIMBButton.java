package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.Globals;
import team.gif.robot.subsystems.CIM;
import team.gif.robot.subsystems.LimitSwitch;

public class CIMBButton extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    public CIMBButton() {
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        Globals.g_buttonControl = true;
        if(LimitSwitch.getInstance().getState()){
            CIM.getInstance().setSpeed(0.1);
        }
        else{
            CIM.getInstance().setSpeed(0.2);
        }

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        CIM.getInstance().setSpeed(0);
        Globals.g_buttonControl = false;
    }
}
