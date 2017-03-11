package org.usfirst.frc.team102.robot;

import java.util.ArrayList;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DriverStation;

public class MotorAmperageHelper {
	private static ArrayList<CANTalon> toBeHelped = new ArrayList<CANTalon>();
	private static int updateCount = 0;
	
	public static void addAmperageStoppedMotor(CANTalon toBeAdded) { toBeHelped.add(toBeAdded); }
	
	private static void doUpdate() {
		for(CANTalon tal : toBeHelped.toArray(new CANTalon[toBeHelped.size()])) {
			double amps = tal.getOutputCurrent();
			
			if(tal.getSpeed() != 0 && amps >= RobotMap.MAX_MOTOR_CURRENT) {
				tal.set(0);
				
				String msg = String.format("CANTalon #%1$d is overloaded!! Current draw is %2$fA!!", tal.getDeviceID(), amps);
				DriverStation.reportWarning(msg, false);
			}
		}
	}
	
	public static void update() {
		if(updateCount >= 20) {
			doUpdate();
			updateCount = 0;
		} else updateCount++;
	}
}