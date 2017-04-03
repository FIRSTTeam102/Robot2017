package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class Turn extends Command {
	protected double degrees;

	public Turn(double degrees) {
		super("Turn");

		this.degrees = degrees;
		requires(Robot.driveTrain);
	}

	public void initialize() {
		try{
		Robot.driveTrain.setSetpoint(degrees);
		Robot.driveTrain.enable();
		} catch (Exception ex1) {
			ex1.printStackTrace();
			DriverStation.reportError(ex1.getMessage(), true);

		}
		}

	protected boolean isFinished() {
		return Robot.driveTrain.onTarget();
	}

	public void end() {
		Robot.driveTrain.disable();
	}
}