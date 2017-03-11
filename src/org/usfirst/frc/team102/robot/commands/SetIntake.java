package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class SetIntake extends InstantCommand {
	protected boolean reverse;
	
	public SetIntake(boolean reverse) {
		requires(Robot.intakeRoller);
		this.reverse = reverse;
	}
	
	public void initialize() {
		Robot.intakeRoller.set(reverse);
	}
}