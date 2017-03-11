package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShootWithTimeout extends Command {
	
	public ShootWithTimeout(double timeout) {
		requires(Robot.shooter);
		setTimeout(timeout);
	}
	
	protected void initialize() {
		Robot.shooter.shoot();
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