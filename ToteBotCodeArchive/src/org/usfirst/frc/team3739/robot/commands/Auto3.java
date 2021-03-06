package org.usfirst.frc.team3739.robot.commands;

import autoCommands.Close;
import autoCommands.DriveForward;
import autoCommands.LiftUp;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto3 extends CommandGroup {
    
    public Auto3() {
    	
    	addSequential(new DriveForward(1.7));
    	addSequential(new Close(1));
    	addSequential(new LiftUp(3));
    	addSequential(new DriveForward(2));
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
