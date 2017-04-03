package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;

public class AutoStrafeLeft extends Command {
	protected RobotDrive drive;
	 
	public AutoStrafeLeft() {
		requires(Robot.driveTrain);
		setTimeout(0.35);
	}
	
	public AutoStrafeLeft(double t) { //where t is the timeout
		requires(Robot.driveTrain);
		setTimeout(t);
		
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override 
	protected void execute (){
		try{
		Robot.driveTrain.basicStrafeLeft(); 
		} catch (Exception ex1) {
			ex1.printStackTrace();
			DriverStation.reportError(ex1.getMessage(), true);

		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}
	
	@Override 
	protected void end() {
		Robot.driveTrain.stop();
	}
	
	
}
