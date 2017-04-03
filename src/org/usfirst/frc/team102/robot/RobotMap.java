package org.usfirst.frc.team102.robot;

public class RobotMap {
	
	
	
	
	// Can Talons
	public final static int t0CANTalon = 0;
	public final static int t1CANTalon = 1;
	public final static int t2CANTalon = 2;
	public final static int t3CANTalon = 3;
	public final static int t4CANTalon = 4; // This one doesn't physically exist
	public final static int t5CANTalon = 5;
	public final static int t6CANTalon = 6;
	public final static int t7CANTalon = 7;
	public final static int t8CANTalon = 8;
	
	//PWM IDs
	public final static int servoPWM = 0;
	
	// Joysticks
	public final static int xBoxDriverJoystick = 0;
	public final static int xBoxTestJoystick = 1;
	
	// Joystick Axis Indices
	public static final int xBoxLeftXAxis = 0;
	public static final int xBoxLeftYAxis = 1;
	public static final int xBoxLeftTrigger = 2;
	public static final int xBoxRightTrigger = 3;
	public static final int xBoxRightXAxis = 4;
	public static final int xBoxRightYAxis = 5;
	
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
	public final static double joystickDeadband = 0.25;
	
	
	
	// DIO IDs
	public static final int DIO_ENABLE_AUTO = 0;// RED OR BLUE
	public static final int DIO_ENABLE_AUTO_SHOOT = 1; // RIP
	public static final int DIO_AUTO_POS_RIGHT = 3;
	public static final int DIO_AUTO_POS_LEFT = 2;
	
	// Config
	public static final boolean IS_TEST_BED = false;
	public static final double ENCODER_TICKS_PER_INCH = 1; // TODO get actual value
	
	// Auto Mode Distances, etc... TODO get actual values
	//public static final double AUTO_WAIT = .5;
	public static final double AUTO_TURN_LEFT = 60;
	public static final double AUTO_TURN_RIGHT = -AUTO_TURN_LEFT;
	//public static final double AUTO_DRIVE_DIST = 1;
	//public static final double AUTO_PLACE_GEAR_REVERSE_DIST = 1;
	
	// Speeds
	public static final double SERVO_SPEED = 1;
	public static final double ROLLER_SPEED = .4;
	public static final double SHOOTER_SPEED = .75;
	public static final double AUTO_MODE_SPEED = .8;
	
	// PID constants
	public static final double PID_P_CONST = .003;
	public static final double PID_I_CONST = 1e-8;
	public static final double PID_D_CONST = 0;
	
	// Power constants
	public static final double MAX_MOTOR_CURRENT = 10;
	
	// Vision-related constants
	
	public static final boolean useVision = false; //disabled due to crashes
	
	public static final int CAM_VISION_DETECTION = 0;
	public static final int RELAY_INNER_LIGHT_RING = 1, RELAY_OUTER_LIGHT_RING = 0;
	public static final boolean USE_INNER_LIGHT_RING = true, USE_OUTER_LIGHT_RING = false;
	public static final boolean VISION_INVERT_X = true, VISION_INVERT_Y = false, VISION_INVERT_ROT = true, VISION_SWAP_XY = true;
}