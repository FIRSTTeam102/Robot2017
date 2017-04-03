package org.usfirst.frc.team102.robot;

import org.usfirst.frc.team102.robot.commands.Autonomous;
import org.usfirst.frc.team102.robot.commands.ClimbEasy;
import org.usfirst.frc.team102.robot.commands.VisionAuto;
import org.usfirst.frc.team102.robot.subsystems.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
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
	protected SendableChooser<Command> chooser;
	
	Command climbingEz;
	
	//private Command gearAuto, shootAuto; 
	//private Command blindAuto; 
	
	protected Command autonomousCommand;
	
	public void robotInit() {
		driveTrain = new DriveTrain();
		intakeRoller = new IntakeRoller();
		shooter = new Shooter();
		servo = new HopperServo();
		climber = new Climber();
		
		if (RobotMap.useVision) {
			// Vision stuff, please don't change me
			cam = new SubsystemCamera(RobotMap.CAM_VISION_DETECTION, true, 2000);
			lights = new Lights();
		}
		
		climbingEz = new ClimbEasy(95.0);
		
		oi = new OI();
		
		//chooser = new SendableChooser<Command>();
		//chooser.addDefault("Autonomous With Vision", new VisionAuto());
		//chooser.addObject("Autonomous Without Vision", new Autonomous());
		//chooser.addObject("Autonomous Disabled", new PrintCommand("Autonomous is selected to be disabled."));
		
	}
	
	private void setAutonomousCommand() {

		autonomousCommand = new Autonomous();
		
		//		if (RobotMap.useVision) { 
//			if(chooser == null) {
//				// If switch #0 is enabled, autonomous is active
//				DigitalInput onOffSwitch = new DigitalInput(RobotMap.DIO_ENABLE_AUTO);
//				boolean on = !onOffSwitch.get();
//				onOffSwitch.free();
//				
//				// If switch #1 is: on = shoot, off = gear
//				DigitalInput shootSwitch = new DigitalInput(RobotMap.DIO_ENABLE_AUTO_SHOOT);
//				boolean shoot = !shootSwitch.get();
//				shootSwitch.free();
//			
//				if(on) {
//					if(shoot) {
//						autonomousCommand = new Autonomous();//shootAuto;
//					
//						System.out.println("Using shooting-autonomous");
//					} else {
//						autonomousCommand = new VisionAuto();//gearAuto;
//					
//						System.out.println("Using gear-autonomous.");
//					}
//				} else {
//					autonomousCommand = null;
//				
//					System.out.println("Autnomous disabled.");
//				}
//			} else autonomousCommand = chooser.getSelected(); 
//		} 
//		else {//going blind
//			autonomousCommand = new Autonomous();//blindAuto;
//		}
	}
	
	public void autonomousInit() {
		//autonomousCommand = chooser.getSelected();
		
		setAutonomousCommand(); //blindAuto for now
		
		if(autonomousCommand != null)
			autonomousCommand.start();
	}
	
	public void teleopInit() {
		if(autonomousCommand != null)
			autonomousCommand.cancel();
		
		climbingEz.start();
	}
	
	public void disabledInit() {
	
		climbingEz.cancel();
		
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
	
	
	
		
}