package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class SetServo extends InstantCommand {
	protected boolean on;
	
	public SetServo(boolean on) {
		super("Set Servo");
		
		requires(Robot.servo);
		this.on = on;
	}
	
	public void initialize() {
		try{
		Robot.servo.set(on);
		} catch (Exception ex1) {
			ex1.printStackTrace();
			DriverStation.reportError(ex1.getMessage(), true);

		}
	}
}