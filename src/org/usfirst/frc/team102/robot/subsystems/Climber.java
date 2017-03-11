package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.Robot;
import org.usfirst.frc.team102.robot.RobotMap;
import org.usfirst.frc.team102.robot.commands.CommandUpdate;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem implements CommandUpdate.IUpdate {
	public static final String NAME = "Climber";
	
	public CANTalon climberTal;
	
	public Climber() {
		super(NAME);
		
		climberTal = new CANTalon(RobotMap.t3CANTalon);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new CommandUpdate(this, NAME));
	}
	
	public void climbFast(){
		
		climberTal.set(-1);
		
	}
	
	public void climbSlow(){
		
		climberTal.set(-.20);
		
	}
	
	public void climberStops(){
		
		climberTal.set(0);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
//	public void update() {
//		double val = Robot.oi.getDriverJSAxis(RobotMap.xBoxRightTrigger);
//		climberTal.set(-val);
//		System.out.println(val);
//	}
	
}