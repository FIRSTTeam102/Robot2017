package org.usfirst.frc.team102.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {

	public Autonomous() {

		DriverStation.Alliance color;
		
		// DigitalInput redBlueSwitch = new
		// DigitalInput(RobotMap.DIO_ENABLE_AUTO);// ENABLES
		// // RED
		// // OR
		// // BLUE
		//
		// DigitalInput ripSwitch = new
		// DigitalInput(RobotMap.DIO_ENABLE_AUTO_SHOOT); // enables
		// // the
		// // RIP
		// // AUTO

		// boolean isRed = !redBlueSwitch.get() // On is Red, Off is Bleu
		// boolean shouldRIP = !ripSwitch.get(); // On is RIP, Off is NO RIP
		//
		// redBlueSwitch.free();
		// RIPSwitch.free();

		color = DriverStation.getInstance().getAlliance();
		System.out.println(color);

		if (color == DriverStation.Alliance.Red) {

			System.out.println("Started Shooting Autonomous for the Red Alliance");
			
				addSequential(new AutoStrafeLeft()); // strafes left at 1/2
														// speed for 0.4 seconds
				addSequential(new AutoDriveStraight(.15));
				addSequential(new AutoLowGoal()); // shoots for 10 seconds
				addSequential(new AutoStrafeLeft(.5));
				addSequential(new AutoRotate(2.5));// needed more
				addSequential(new AutoDriveStraight(1.25));
			
		}else if (color == DriverStation.Alliance.Blue){

			System.out.println("Started Shooting Autonomous for the Blue Alliance");

				System.out.println("Start Blue");

				addSequential(new AutoStrafeLeft()); // strafes left at 1/2
														// speed for 0.4 seconds
				addSequential(new AutoLowGoal()); // shoots for 10 seconds
				addSequential(new AutoStrafeLeft(.5)); // moves us right, off
														// the wall;
				addSequential(new AutoCounterRotate(1.25));// needed more
				addSequential(new AutoDriveBackwards(2)); // NEEDS TO BE
															// BACKWARDS
			}else{

					System.out.println("Could not get alliance color lol");
				
			}

		System.out.println("Climb is ready!");
		addSequential(new ClimbReady());

	}
}