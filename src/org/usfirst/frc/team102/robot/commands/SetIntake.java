package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class SetIntake extends InstantCommand {
	protected boolean reverse;
	
	public SetIntake(boolean reverse) {
		requires(Robot.intakeRoller);
		this.reverse = reverse;
	}
	
	public void initialize() {
		try{
		Robot.intakeRoller.set(reverse);
		} catch (Exception ex1) {
			ex1.printStackTrace();
			DriverStation.reportError(ex1.getMessage(), true);

		}
	}
}