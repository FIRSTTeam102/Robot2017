package org.usfirst.frc.team102.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class AutoLowGoal extends Command {
	Command shooterInit = new StartShooting();
	Command shooterEnd = new StopShooting(); //stop and start the shooter, respectively
	public AutoLowGoal() {
		//Add boolean for alliance color
		setTimeout(9); 
		
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		try{
		Scheduler.getInstance().add(shooterInit);
		Scheduler.getInstance().add(new SetServo(true));//turns on the shooter
		} catch (Exception ex1) {
			ex1.printStackTrace();
			DriverStation.reportError(ex1.getMessage(), true);

		}
		}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		
		return isTimedOut();
	}
	
	public void end() {
		Scheduler.getInstance().add(new SetServo(false));
		Scheduler.getInstance().add(shooterEnd);
		
	}
	
	
}