package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class StartShooting extends InstantCommand {
	
	public StartShooting() {
		requires(Robot.shooter);
	}
	
	public void initialize() {
		try{
		Robot.shooter.shoot();
		} catch (Exception ex1) {
			ex1.printStackTrace();
			DriverStation.reportError(ex1.getMessage(), true);

		}
	}
}