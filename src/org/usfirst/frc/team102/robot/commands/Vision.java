package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;
import org.usfirst.frc.team102.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import micobyte.frc.visionapi.CommandAutoDrive;

public class Vision extends CommandGroup {
	
	public Vision() {
		addSequential(new VisionEnableDisable(true));
		
		addSequential(new CommandAutoDrive(Robot.driveTrain, Robot.cam, RobotMap.VISION_INVERT_X, RobotMap.VISION_INVERT_Y, RobotMap.VISION_INVERT_ROT, RobotMap.VISION_SWAP_XY));
		
		addSequential(new VisionEnableDisable(false));
	}
}