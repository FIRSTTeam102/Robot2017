package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.RobotMap;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeRoller extends Subsystem {
	CANTalon intakeRoller;

	public IntakeRoller() {
		intakeRoller = new CANTalon(RobotMap.t2CANTalon);
	}

	public void roll(double speed) {
		intakeRoller.set(speed);

	}

	public void toggle(boolean isReverse) {
		// TODO implement
	}

	protected void initDefaultCommand() {
	}
}