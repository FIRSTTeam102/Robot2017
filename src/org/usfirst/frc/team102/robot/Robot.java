package org.usfirst.frc.team102.robot;

import org.usfirst.frc.team102.robot.commands.Autonomous;
import org.usfirst.frc.team102.robot.commands.VisionAuto;
import org.usfirst.frc.team102.robot.subsystems.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import micobyte.frc.visionapi.SubsystemCamera;

public class Robot extends IterativeRobot {
	public static OI oi;
	public static DriveTrain driveTrain;
	public static IntakeRoller intakeRoller;
	public static Shooter shooter;
	public static HopperServo servo;
	public static Climber climber;
	
	// Vision stuff, please don't change me
	public static SubsystemCamera cam;
	public static Lights lights;
	// End of vision stuff
	
	// Autonomous chooser
	//protected static SendableChooser<Command> chooser;
	
	private final Command gearAuto = new VisionAuto(), shootAuto = new Autonomous();
	
	protected Command autonomousCommand;
	
	public void robotInit() {
		driveTrain = new DriveTrain();
		intakeRoller = new IntakeRoller();
		shooter = new Shooter();
		servo = new HopperServo();
		climber = new Climber();
		
		// Vision stuff, please don't change me
		cam = new SubsystemCamera(RobotMap.CAM_VISION_DETECTION, true, 2000);
		lights = new Lights();
		// End of vision stuff
		
		oi = new OI();
		
		//chooser = new SendableChooser<Command>();
		//chooser.addDefault("Autonomous With Vision", new VisionAuto());
		//chooser.addObject("Autonomous Without Vision", new Autonomous());
		//chooser.addObject("Autonomous Disabled", new PrintCommand("Autonomous is selected to be disabled."));
		
		//autonomousCommand = new Autonomous();
		
		// Until Vision API is transferred...
		//CameraServer.getInstance().startAutomaticCapture();
	}
	
	public void autonomousInit() {
		//autonomousCommand = chooser.getSelected();
		
		if(useShootingAuto()) autonomousCommand = shootAuto;
		else autonomousCommand = gearAuto;
		
		if(autonomousCommand != null)
			autonomousCommand.start();
	}
	
	public void teleopInit() {
		if(autonomousCommand != null)
			autonomousCommand.cancel();
	}
	
	public void disabledInit() {
	}
	
	public void testInit() {
	}
	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	private boolean useShootingAuto() {
		DigitalInput shootSwitch = new DigitalInput(RobotMap.DIO_ENABLE_AUTO_SHOOT);
		boolean shoot = !shootSwitch.get();
		shootSwitch.free();
		
		return shoot;
	}
}