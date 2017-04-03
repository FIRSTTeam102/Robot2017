package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.RobotMap;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeRoller extends Subsystem {
	CANTalon intakeRoller;
	protected double lastSpeed;

	public IntakeRoller() {
		intakeRoller = new CANTalon(RobotMap.t2CANTalon);
		intakeRoller.setSafetyEnabled(false);
	}

	public void roll(double speed) {
		intakeRoller.set(speed);
		lastSpeed = speed;
	}

	public void set(boolean reverse) {
		double speed;

		if (reverse) {
			if (lastSpeed >= 0)
				speed = -0.7;
			else
				speed = 0;
		} else {
			if (lastSpeed <= 0)
				speed = 0.7;
			else
				speed = 0;
		}

		roll(speed * RobotMap.ROLLER_SPEED);
	}

	protected void initDefaultCommand() {
	}
}