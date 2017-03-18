package org.usfirst.frc.team102.robot;

import org.usfirst.frc.team102.robot.commands.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

@SuppressWarnings("unused")
public class OI {
	private Joystick xBoxDriver;
	private Joystick xBoxTest;
	private JoystickButton xBoxA;
	private JoystickButton xBoxB;
	private JoystickButton xBoxY;
	private JoystickButton xBoxX;
	private JoystickButton xBoxRightBump;
	private JoystickButton xBoxLeftBump;
	private JoystickButton xBoxStart;
	private JoystickButton xBoxBack;
	private JoystickButton xBoxRightJoyPress;
	private JoystickButton xBoxLeftJoyPress;
	private JoystickButton xBoxTestA;
	private JoystickButton xBoxTestB;
	private JoystickButton xBoxTestY;
	private JoystickButton xBoxTestX;
	private JoystickButton xBoxTestRightBump;
	private JoystickButton xBoxTestLeftBump;
	private JoystickButton xBoxTestStart;
	private JoystickButton xBoxTestBack;
	private JoystickButton xBoxTestRightJoyPress;
	private JoystickButton xBoxTestLeftJoyPress;

	public static boolean isHalfSpeed = false;
	
	public OI() {
		xBoxDriver = new Joystick(RobotMap.xBoxDriverJoystick);

		// Driver Joystick Button Actions
		xBoxA = new JoystickButton(xBoxDriver, RobotMap.xBoxAIndex);
		xBoxA.whenPressed(new StartShooting());
		xBoxA.whenReleased(new StopShooting());

		xBoxB = new JoystickButton(xBoxDriver, RobotMap.xBoxBIndex);
		xBoxB.whenPressed(new InvertIsHalfSpeed());
		
		xBoxY = new JoystickButton(xBoxDriver, RobotMap.xBoxYIndex);
		xBoxY.whenPressed(new ClimbSlow());
		xBoxY.whenReleased(new ClimbStop());
		
		xBoxX = new JoystickButton(xBoxDriver, RobotMap.xBoxXIndex);
		xBoxX.whenPressed(new ClimbFast());
		xBoxX.whenReleased(new ClimbStop());
		
		xBoxRightBump = new JoystickButton(xBoxDriver, RobotMap.xBoxRightBumperIndex);
		xBoxRightBump.whenPressed(new SetIntake(true));
		xBoxRightBump.whenReleased(new StopIntake());

		xBoxLeftBump = new JoystickButton(xBoxDriver, RobotMap.xBoxLeftBumperIndex);
		xBoxLeftBump.whenPressed(new SetIntake(false));
		xBoxLeftBump.whenReleased(new StopIntake());

		xBoxStart = new JoystickButton(xBoxDriver, RobotMap.xBoxStartButtonIndex);
		xBoxStart.whenPressed(new SetServo(true));

		xBoxBack = new JoystickButton(xBoxDriver, RobotMap.xBoxBackButtonIndex);
		xBoxBack.whenPressed(new SetServo(false));

		xBoxRightJoyPress = new JoystickButton(xBoxDriver, RobotMap.xBoxRightJoystickPressIndex);

		xBoxLeftJoyPress = new JoystickButton(xBoxDriver, RobotMap.xBoxLeftJoystickPressIndex);
		//xBoxLeftJoyPress.whenReleased(new AutoDriveStraight(10));
		
		// Test Joystick Button Action
		xBoxTest = new Joystick(RobotMap.xBoxTestJoystick);

		xBoxTestA = new JoystickButton(xBoxTest, RobotMap.xBoxAIndex);

		xBoxTestB = new JoystickButton(xBoxTest, RobotMap.xBoxBIndex);

		xBoxTestX = new JoystickButton(xBoxTest, RobotMap.xBoxXIndex);

		xBoxTestY = new JoystickButton(xBoxTest, RobotMap.xBoxYIndex);

		xBoxTestRightBump = new JoystickButton(xBoxTest, RobotMap.xBoxRightBumperIndex);

		xBoxTestLeftBump = new JoystickButton(xBoxTest, RobotMap.xBoxLeftBumperIndex);

		xBoxTestStart = new JoystickButton(xBoxTest, RobotMap.xBoxStartButtonIndex);

		xBoxTestBack = new JoystickButton(xBoxTest, RobotMap.xBoxBackButtonIndex);

		xBoxTestRightJoyPress = new JoystickButton(xBoxTest, RobotMap.xBoxRightJoystickPressIndex);

		xBoxTestLeftJoyPress = new JoystickButton(xBoxTest, RobotMap.xBoxLeftJoystickPressIndex);

	}

	public double getDriverJSAxis(int id) {
		double value = xBoxDriver.getRawAxis(id);
		
		if (isHalfSpeed) { //so half the deadband
			if (Math.abs(value) < (RobotMap.joystickDeadband / 2))
				return 0;
			else
				return value;
			
		} else {
			if (Math.abs(value) < RobotMap.joystickDeadband)
				return 0;
			else
				return value; }
		}
}