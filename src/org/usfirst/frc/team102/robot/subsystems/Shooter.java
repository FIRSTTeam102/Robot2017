package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
	CANTalon t4CANTalon;
	CANTalon t5CANTalon;
	
	
	public Shooter() {
		t4CANTalon = new CANTalon(RobotMap.t4CANTalon);
		t4CANTalon = new CANTalon(RobotMap.t5CANTalon);
	}
	
	public void shoot() {
		t4CANTalon.set(.75);
		t5CANTalon.set(.75);
	}
	
	public void stopShooting() {
		t4CANTalon.set(0.0);
		t5CANTalon.set(0.0);
	}
	
	public void initDefaultCommand() {}
}