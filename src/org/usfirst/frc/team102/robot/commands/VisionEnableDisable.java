package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;
import org.usfirst.frc.team102.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import micobyte.frc.visionapi.CommandDisablePIDs;
import micobyte.frc.visionapi.CommandEnablePIDs;

public class VisionEnableDisable extends CommandGroup {
	
	public VisionEnableDisable(boolean enable) {
		if(RobotMap.USE_INNER_LIGHT_RING) addSequential(new SetLight(RobotMap.RELAY_INNER_LIGHT_RING, enable));
		if(RobotMap.USE_OUTER_LIGHT_RING) addSequential(new SetLight(RobotMap.RELAY_OUTER_LIGHT_RING, enable));
		
		if(enable) addSequential(new CommandEnablePIDs(Robot.cam));
		else addSequential(new CommandDisablePIDs(Robot.cam));
	}
}