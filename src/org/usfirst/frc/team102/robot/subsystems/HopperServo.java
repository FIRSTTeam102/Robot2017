package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HopperServo extends Subsystem {
	protected Servo servo;

	public HopperServo() {
		super("Hopper Servo");

		servo = new Servo(RobotMap.servoPWM);
	}

	protected void initDefaultCommand() {
	}

	public void set(boolean on) {
		servo.set(on ? RobotMap.SERVO_SPEED : 0);
	}
}