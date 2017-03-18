package org.usfirst.frc.team102.robot.commands;

import org.usfirst.frc.team102.robot.Robot;
import org.usfirst.frc.team102.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Autonomous extends CommandGroup {

	public Autonomous() {

		DigitalInput redBlueSwitch = new DigitalInput(RobotMap.DIO_ENABLE_AUTO);// ENABLES
																				// RED
																				// OR
																				// BLUE

		DigitalInput RIPSwitch = new DigitalInput(RobotMap.DIO_ENABLE_AUTO_SHOOT); // enables
																					// the
																					// RIP
																					// AUTO

		boolean isRed = !redBlueSwitch.get(); // On is Red, Off is Bleu
		boolean shouldRIP = !RIPSwitch.get(); // On is RIP, Off is NO RIP

		// DriverStation.Alliance color =
		// DriverStation.getInstance().getAlliance();
		//
		// System.out.println(color);

		System.out.println("IsRed Is " + isRed);

		System.out.println("ShouldRIP Is " + shouldRIP);

		if (isRed) {

//			if (shouldRIP) {
//
//				System.out.println("Start RIP AUTO");
//				addSequential(new AutoStrafeLeft());
//				addSequential(new AutoDriveStraight(2.5));
//
//			} else {
				System.out.println("Start Red");

				System.out.println("IsRed equals: " + isRed + " and we are within the Red conditional.");

				addSequential(new AutoStrafeLeft()); // strafes left at 1/2
														// speed for 0.4 seconds
				addSequential(new AutoDriveStraight(.15));
				addSequential(new AutoLowGoal()); // shoots for 10 seconds
				addSequential(new AutoStrafeLeft(.5));
				addSequential(new AutoRotate(2.5));// needed more
				addSequential(new AutoDriveStraight(1.25));
			//}
			// addSequential(new BasicAutonomous()); //drives straight;
			// commented out to test ball shooting autonomous

		} else {

//			if (shouldRIP) {
//
//				System.out.println("Start RIP AUTO");
//				addSequential(new AutoStrafeLeft());
//				addSequential(new AutoDriveBackwards(2.5));
//
//			} else {

				System.out.println("Start Blue");

				addSequential(new AutoStrafeLeft()); // strafes left at 1/2
														// speed for 0.4 seconds
				addSequential(new AutoLowGoal()); // shoots for 10 seconds
				addSequential(new AutoStrafeLeft(.5)); // moves us right, off
														// the wall;
				addSequential(new AutoCounterRotate(1.25));// needed more
				addSequential(new AutoDriveBackwards(2)); // NEEDS TO BE
															// BACKWARDS
			//}
		}

		System.out.println("Climb is ready!");
		addSequential(new ClimbReady());

	}
}
// super("Autonomous root command");
//
// DigitalInput onOffSwitch = new DigitalInput(RobotMap.DIO_ENABLE_AUTO);
// DigitalInput shootSwitch = new DigitalInput(RobotMap.DIO_ENABLE_AUTO_SHOOT);
// DigitalInput leftSwitch = new DigitalInput(RobotMap.DIO_AUTO_POS_LEFT);
// DigitalInput rightSwitch = new DigitalInput(RobotMap.DIO_AUTO_POS_RIGHT);
//
// // Inverted to deal with internal pullup resistors,
// // so the switch, when on, grounds the DIO (logic 0/false).
// boolean on = !onOffSwitch.get();
// boolean shoot = !shootSwitch.get();
// boolean left = !leftSwitch.get();
// boolean right = !rightSwitch.get();
//
// onOffSwitch.free();
// shootSwitch.free();
// leftSwitch.free();
// rightSwitch.free();
//
// String status;
//
// if(on) {
// EnumPosition pos;
//
// if(left && right) throw new RuntimeException(new
// IllegalStateException("Position switch is both less and right?!?"));
// else if(left) pos = EnumPosition.LEFT;
// else if(right) pos = EnumPosition.RIGHT;
// else pos = EnumPosition.CENTER;
//
// status = "enabled, traveling to the ";
//
// addSequential(new DriveStraight(RobotMap.AUTO_DRIVE_DIST));
//
// switch(pos) {
// case LEFT: {
// status += "left";
//
// addSequential(new Turn(RobotMap.AUTO_TURN_LEFT));
// break;
// }
//
// case CENTER: {
// status += "center";
// break;
// }
//
// case RIGHT: {
// status += "right";
//
// addSequential(new Turn(RobotMap.AUTO_TURN_RIGHT));
// break;
// }
// }
//
// addSequential(new DriveStraight(RobotMap.AUTO_PLACE_GEAR_REVERSE_DIST,
// true));
//
// if(shoot) {
// status += ", and shooting";
//
// addSequential(new WaitCommand(RobotMap.AUTO_WAIT));
//
// switch(pos) {
// case LEFT: {
// //addSequential(new DriveToBoilerFromLeft());
// break;
// }
//
// case CENTER: {
// //addSequential(new DriveToBoilerFromCenter());
// break;
// }
//
// case RIGHT: {
// //addSequential(new DriveToBoilerFromRight());
// break;
// }
//
// //addSequential(new Shoot());
// }
// }
// } else status = "disabled";
//
// System.out.println("Autonomous is " + status + ".");
// }
//
// public static enum EnumPosition { LEFT, RIGHT, CENTER; }
// }