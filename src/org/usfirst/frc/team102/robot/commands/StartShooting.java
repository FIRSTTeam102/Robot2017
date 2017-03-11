package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class StartShooting extends InstantCommand {
	
	public StartShooting() {
		requires(Robot.shooter);
	}
	
	public void initialize() {
		Robot.shooter.shoot();
	}
}