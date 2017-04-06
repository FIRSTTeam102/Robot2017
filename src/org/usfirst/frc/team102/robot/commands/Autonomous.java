package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {

	public Autonomous() {

		DriverStation.Alliance color;
		
		 DigitalInput redBlueSwitch = new DigitalInput(RobotMap.DIO_ENABLE_AUTO);
		 // ENABLES
		// // RED
		// // OR
		// // BLUE
		//
		DigitalInput gearSwitch = new DigitalInput(RobotMap.DIO_ENABLE_AUTO_SHOOT); // enables
		// // the
		// // RIP
		// // AUTO

		 boolean isRed = !redBlueSwitch.get(); // On is Red, Off is Bleu, switch #1
		 boolean doGear = !gearSwitch.get(); // On is gear, Off is shoot, switch #2
		
		 redBlueSwitch.free();
		 gearSwitch.free();

		color = DriverStation.getInstance().getAlliance();
		System.out.println(color);
		
		//Our straight-up gear attempt from center start
		
		if (doGear) {
			
			System.out.println("Doing Gear Wiggle");
			
			//new code to build up speed and prevent drift
			addSequential(new BasicAutonomous(0.2, 0.125)); //timeout, speed
			addSequential(new BasicAutonomous(0.2, 0.325));
			addSequential(new BasicAutonomous(0.2, 0.5));
			
			
			addSequential(new BasicAutonomous(3.58));//strafe right @ half speed; used to be 3.98
			
			//rotate wiggle wip
			
			addSequential(new AutoRotate(.1)); 
			addSequential(new BasicAutonomous(.1));
			addSequential(new AutoCounterRotate(.1));
			addSequential(new BasicAutonomous(.1));
			
			addSequential(new AutoRotate(.1));
			addSequential(new BasicAutonomous(.1));
			addSequential(new AutoCounterRotate(.1));
			addSequential(new BasicAutonomous(.1));
			//end rotate wiggle
			
			
			// front-back wiggle wip
			/*
			addSequential(new AutoDriveStraight(.1));
			addSequential(new BasicAutonomous(.1));
			addSequential(new AutoDriveBackwards(.2));
			addSequential(new BasicAutonomous(.1));
			addSequential(new AutoDriveStraight(.1));
			addSequential(new BasicAutonomous(.1));
			addSequential(new AutoDriveBackwards(.2));
			addSequential(new BasicAutonomous(.1));
			*/
			//end wiggle
		}
		
		
		// Shooting auto; 
		else if (isRed) { 

			System.out.println("Started Shooting Autonomous for the Red Alliance");
			
				addSequential(new AutoStrafeLeft()); // strafes left at 1/2 speed for 0.4 seconds
				addSequential(new AutoDriveStraight(.15));
				addSequential(new AutoLowGoal()); // shoots for 10 seconds
				addSequential(new AutoStrafeLeft(.5));
				addSequential(new AutoRotate(2.5));// needed more
				addSequential(new AutoDriveStraight(1.25));
			
		}else if (!isRed){

			System.out.println("Started Shooting Autonomous for the Blue Alliance");

				addSequential(new AutoStrafeLeft()); // strafes left at 1/2
														// speed for 0.4 seconds
				addSequential(new AutoLowGoal()); // shoots for 10 seconds
				addSequential(new AutoStrafeLeft(.5)); // moves us right, off the wall;
				addSequential(new AutoCounterRotate(1.25));// needed more
				addSequential(new AutoDriveBackwards(2)); // NEEDS TO BE
															// BACKWARDS
			}else{

					System.out.println("Could not get alliance color -- check switches?");
				
			} 

		
		//commented for rope funnel
	/*	System.out.println("Climb is ready!");
		addSequential(new ClimbReady()); */

	}

}