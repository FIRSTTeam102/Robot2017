package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OldSetIntake extends Command {
	double x;
	
    public OldSetIntake(double x) {
        requires(Robot.intakeRoller);
    	this.x = x;
    }

    protected void initialize() {
    	Robot.intakeRoller.roll(x);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
