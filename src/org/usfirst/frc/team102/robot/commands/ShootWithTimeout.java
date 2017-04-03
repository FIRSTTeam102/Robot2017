package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class ShootWithTimeout extends Command {
	
	public ShootWithTimeout(double timeout) {
		requires(Robot.shooter);
		setTimeout(timeout);
	}
	
	protected void initialize() {
		try{
		Robot.shooter.shoot();
		} catch (Exception ex1) {
			ex1.printStackTrace();
			DriverStation.reportError(ex1.getMessage(), true);

		}
	}
	
	protected void execute() {
	}
	
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	protected void end() {
		Robot.shooter.stopShooting();
	}
	
	protected void interrupted() {
	}
}