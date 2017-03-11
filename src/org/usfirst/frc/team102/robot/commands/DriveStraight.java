package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/*public class DriveStraight extends Command {
	protected double dist;
	protected boolean reverse;
	
	public DriveStraight(double dist) { this(dist, false); }
	
	public DriveStraight(double dist, boolean reverse) {
		super("Drive straight");
		
		this.dist = dist;
		this.reverse = reverse;
		requires(Robot.driveTrain);
	}
	
	public void initialize() { Robot.driveTrain.enableDriveStraight(reverse); }
	
	protected boolean isFinished() { return Robot.driveTrain.hasDriven(dist); }
	
	public void end() {
		Robot.driveTrain.disableDriveStraight();
		Robot.driveTrain.resetEncoder();
	}
}*/