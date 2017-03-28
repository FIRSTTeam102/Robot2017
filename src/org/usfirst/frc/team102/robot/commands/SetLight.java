package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class SetLight extends InstantCommand {
	
	protected int lightID;
	protected boolean on;
	
	public SetLight(int lightID, boolean on) {
		requires(Robot.lights);
		
		this.lightID = lightID;
		this.on =  on;
	}
	
	public void initialize() {
		Robot.lights.setLight(lightID, on);
	}
}