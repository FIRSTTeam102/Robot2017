package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BasicAutonomous extends Command {

//	public BasicAutonomous() {
//		// Use requires() here to declare subsystem dependencies
//		// eg. requires(chassis);
//		requires(Robot.driveTrain);
//		setTimeout(3);
//	}
	private double speed;
	public BasicAutonomous(double t) {
		requires(Robot.driveTrain);
		setTimeout(t);
		speed = 0.5;
	}
	
	public BasicAutonomous(double t, double speed) {
		requires(Robot.driveTrain);
		setTimeout(t);
		this.speed = speed;
	}
	

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//Robot.driveTrain.basicStrafe(); 
		
		try{
		
		Robot.driveTrain.strafeGyro(speed);
		
		} catch (Exception ex1) {
			ex1.printStackTrace();
			DriverStation.reportError(ex1.getMessage(), true);

		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
