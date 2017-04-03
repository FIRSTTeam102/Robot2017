package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {
	protected double dist;
	protected boolean reverse;

	public DriveStraight(double dist) {
		this(dist, false);
	}

	public DriveStraight(double dist, boolean reverse) {
		super("Drive straight");

		this.dist = dist;
		this.reverse = reverse;
		requires(Robot.driveTrain);
	}

	public void initialize() {
		try{
		Robot.driveTrain.enableDriveStraight(reverse);
		} catch (Exception ex1) {
			ex1.printStackTrace();
			DriverStation.reportError(ex1.getMessage(), true);

		}
	}

	protected boolean isFinished() {
		return Robot.driveTrain.hasDriven(dist);
	}

	public void end() {
		Robot.driveTrain.disableDriveStraight();
		Robot.driveTrain.resetEncoder();
	}
}