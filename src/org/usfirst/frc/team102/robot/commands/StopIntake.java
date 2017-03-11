package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class StopIntake extends InstantCommand {
	
	public StopIntake() {
		requires(Robot.intakeRoller);
	}
	
	public void intialize() {
		Robot.intakeRoller.roll(0);
	}
}