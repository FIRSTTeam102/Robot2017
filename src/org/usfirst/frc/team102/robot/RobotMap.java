package org.usfirst.frc.team102.robot;

public class RobotMap {
	
	// Can Talons
	public final static int t0CANTalon = 0;
	public final static int t1CANTalon = 1;
	public final static int t2CANTalon = 2;
	public final static int t3CanTalon = 3;
	public final static int t4CANTalon = 4;
	public final static int t5CANTalon = 5;
	public final static int t6CANTalon = 6;
	public final static int t7CANTalon = 7;
	public final static int t8CANTalon = 8;
	
	//PWM IDs
	public final static int ServoPWM = 0;
	
	// Joysticks
	public final static int xBoxDriverJoystick = 0;
	public final static int xBoxTestJoystick = 1;
	
	// Joystick Axis Indices
	public static final int xBoxLeftXAxis = 0;
	public static final int xBoxLeftYAxis = 1;
	public static final int xBoxRightYAxis = 4;
	public static final int xBoxRightXAxis = 5;
	
	// Joystick Button Indices
	public static final int xBoxAIndex = 1;
	public static final int xBoxBIndex = 2;
	public static final int xBoxXIndex = 3;
	public static final int xBoxYIndex = 4;
	public static final int xBoxLeftBumperIndex = 5;
	public static final int xBoxRightBumperIndex = 6;
	public static final int xBoxBackButtonIndex = 7;
	public static final int xBoxStartButtonIndex = 8;
	public static final int xBoxLeftJoystickPressIndex = 9;
	public static final int xBoxRightJoystickPressIndex = 10;
	
	// Other Joystick Sutff
	public final static double joystickDeadband = 0.2;
	
	// DIO IDs
	public static final int DIO_ENABLE_AUTO = 0;
	public static final int DIO_ENABLE_AUTO_SHOOT = 1;
	public static final int DIO_AUTO_POS_RIGHT = 2;
	public static final int DIO_AUTO_POS_LEFT = 3;
	
	// Config
	public static final boolean CONFIG_IS_TEST_BED = false;
	public static final double CONFIG_AUTO_WAIT = .5;
	public static final int CONFIG_AUTO_TURN_LEFT = 60;
	public static final int CONFIG_AUTO_TURN_RIGHT = -CONFIG_AUTO_TURN_LEFT;
	
	// Speeds
	public static final double SPEED_SERVO = 1;
	
	// PID constants
	public static final double PID_P_CONST = 1;
	public static final double PID_I_CONST = .01;
	public static final double PID_D_CONST = 0;
}