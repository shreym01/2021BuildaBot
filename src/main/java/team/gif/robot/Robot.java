
package team.gif.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import team.gif.robot.commands.CIMJoystickCommand;
import team.gif.robot.commands.NEOCommand;
import team.gif.robot.subsystems.LimitSwitch;
import team.gif.robot.subsystems.NEO;
import team.gif.robot.subsystems.drivers.Pigeon;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */


public class Robot extends TimedRobot {

  public static OI oi;
  public static Command CIMCommand = null;
  public static WPI_TalonSRX CIMTalon = null;
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    System.out.println("robot init");
    CIMTalon = new WPI_TalonSRX(RobotMap.MOTOR_TALON_ONE);
    Pigeon pigeon = new Pigeon(CIMTalon);
    // autonomous chooser on the dashboard.
    Pigeon.getInstance().addToShuffleboard("Pigeon");
    CIMCommand = new CIMJoystickCommand();
    NEO.getInstance().getVelocity_Shuffleboard();

  }

  /**
   * This function is call
   * ed every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

    CommandScheduler.getInstance().run();

    System.out.println("Limit Switch State:" + LimitSwitch.getInstance().getState());
    System.out.println("Yaw:" + Pigeon.getInstance().getCompassHeading());

    //Smart Dashboard
    SmartDashboard.putBoolean("Limit Switch", LimitSwitch.getInstance().getState());
    SmartDashboard.putNumber("RPM", NEO.getInstance().getVelocity());
    //NEO.getInstance().getVelocity_Shuffleboard();



  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    System.out.println("teleop init");

    oi = new OI();
    CIMCommand.schedule();

  }

  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void simulationInit() {
  }

  @Override
  public void simulationPeriodic(){
  }
}