package org.usfirst.frc.team102.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {

	public Autonomous() {

		/*DigitalInput redBlueSwitch = new DigitalInput(RobotMap.DIO_ENABLE_AUTO);// ENABLES
																				// RED
																				// OR
																				// BLUE

		DigitalInput ripSwitch = new DigitalInput(RobotMap.DIO_ENABLE_AUTO_SHOOT); // enables
																					// the
																					// RIP
																					// AUTO

		boolean isRed = !redBlueSwitch.get() // On is Red, Off is Bleu
		boolean shouldRIP = !ripSwitch.get(); // On is RIP, Off is NO RIP

		redBlueSwitch.free();
		RIPSwitch.free();
		
		// DriverStation.Alliance color =
		// DriverStation.getInstance().getAlliance();
		//
		// System.out.println(color);

		System.out.println("IsRed Is " + isRed);

		System.out.println("ShouldRIP Is " + shouldRIP);

		if (isRed) {

			if (shouldRIP) {

				System.out.println("Start RIP AUTO");
				addSequential(new AutoStrafeLeft());
				addSequential(new AutoDriveStraight(2.5));

			} else {
				System.out.println("Start Red");

				System.out.println("IsRed equals: " + isRed + " and we are within the Red conditional.");

				addSequential(new AutoStrafeLeft()); // strafes left at 1/2
														// speed for 0.4 seconds
				addSequential(new AutoDriveStraight(.15));
				addSequential(new AutoLowGoal()); // shoots for 10 seconds
				addSequential(new AutoStrafeLeft(.5));
				addSequential(new AutoRotate(2.5));// needed more
				addSequential(new AutoDriveStraight(1.25));
			}
			// addSequential(new BasicAutonomous()); //drives straight;
			// commented out to test ball shooting autonomous

		} else {

			if (shouldRIP) {

				System.out.println("Start RIP AUTO");
				addSequential(new AutoStrafeLeft());
				addSequential(new AutoDriveBackwards(2.5));

			} else {

				System.out.println("Start Blue");

				addSequential(new AutoStrafeLeft()); // strafes left at 1/2
														// speed for 0.4 seconds
				addSequential(new AutoLowGoal()); // shoots for 10 seconds
				addSequential(new AutoStrafeLeft(.5)); // moves us right, off
														// the wall;
				addSequential(new AutoCounterRotate(1.25));// needed more
				addSequential(new AutoDriveBackwards(2)); // NEEDS TO BE
															// BACKWARDS
			}
		}*/

		addSequential(new BasicAutonomous(2.6));
		
		System.out.println("Climb is ready!");
		addSequential(new ClimbReady());

	}
}