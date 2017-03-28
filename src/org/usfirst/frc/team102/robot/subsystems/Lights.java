package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lights extends Subsystem {
	protected Relay innerLightRing, outerLightRing;
	
	public Lights() {
		innerLightRing = new Relay(RobotMap.RELAY_INNER_LIGHT_RING, Relay.Direction.kForward);
		outerLightRing = new Relay(RobotMap.RELAY_OUTER_LIGHT_RING, Relay.Direction.kForward);
	}
	
	public void initDefaultCommand() {}
	
	public void setLight(int id, boolean on) {
		Value v = (on ? Value.kForward : Value.kOff);
		Relay r = null;
		
		if(id == RobotMap.RELAY_INNER_LIGHT_RING) r = innerLightRing;
		else if(id == RobotMap.RELAY_OUTER_LIGHT_RING) r = outerLightRing;
		
		if(r != null) r.set(v);
	}
}