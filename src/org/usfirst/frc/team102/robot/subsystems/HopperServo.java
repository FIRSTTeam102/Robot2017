package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HopperServo extends Subsystem {
	protected Servo servo;
	protected double prevValue;

	public HopperServo() {
		super("Hopper Servo");

		servo = new Servo(RobotMap.ServoPWM);
	}

	protected void initDefaultCommand() {
	}

	public void set(boolean on) {
		set(on ? RobotMap.SPEED_SERVO : 0);
	}

	public void set(double speed) {
		servo.set(speed);
	}
}