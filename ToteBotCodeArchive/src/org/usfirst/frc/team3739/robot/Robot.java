
package org.usfirst.frc.team3739.robot;

import org.usfirst.frc.team3739.robot.commands.Auto2;
import org.usfirst.frc.team3739.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3739.robot.subsystems.LiftTrain;
import org.usfirst.frc.team3739.robot.subsystems.OpenCloseTrain;
import org.usfirst.frc.team3739.robot.subsystems.TestSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.CameraServer;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
       
    //define public static 
    public static TestSubsystem subsystem;
    public static DriveTrain driveTrain;
    public static OI oi;
    public static LiftTrain liftTrain;
    public static OpenCloseTrain opencloseTrain;
    public static CameraServer server;
        
    //Needed    
    Command autonomousCommand;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    

    public Robot() {
    	//camera stuff - use USB Camera HW
        server = CameraServer.getInstance();
        server.setQuality(50);
        //the camera name (ex "cam0") can be found through the roborio web interface
        server.startAutomaticCapture("cam0");
    }
    
    public void robotInit() {
        subsystem = new TestSubsystem();
        driveTrain = new DriveTrain();
        liftTrain = new LiftTrain();
        opencloseTrain = new OpenCloseTrain();       
        oi = new OI();
        
        
        // instantiate the command used for the autonomous period
        autonomousCommand = new Auto2();//use Auto[n],  n being the different autonomous scenarios
        
    }
       
    public void disabledPeriodic() {
           Scheduler.getInstance().run();
    }
 
    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }
 
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }
 
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }
 
    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
 
    }
 
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run(); // Get instance for the motor feedback
    }
   
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}