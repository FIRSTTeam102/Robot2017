package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class StopShooting extends InstantCommand {
	
	public StopShooting() {
		requires(Robot.shooter);
	}
	
	public void initialize() {
		Robot.shooter.stopShooting();
	}
}