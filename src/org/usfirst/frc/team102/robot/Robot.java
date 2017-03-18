package org.usfirst.frc.team102.robot;

import org.usfirst.frc.team102.robot.commands.Autonomous;
import org.usfirst.frc.team102.robot.commands.BasicAutonomous;
import org.usfirst.frc.team102.robot.subsystems.*;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {
	public static OI oi;
	public static DriveTrain driveTrain;
	public static IntakeRoller intakeRoller;
	public static Shooter shooter;
	public static HopperServo servo;
	public static Climber climber;
	
	protected Command autonomousCommand;
	
	public void robotInit() {
		driveTrain = new DriveTrain();
		intakeRoller = new IntakeRoller();
		shooter = new Shooter();
		servo = new HopperServo();
		climber = new Climber();
		
		oi = new OI();
		
		autonomousCommand = new Autonomous();
		
		// Until Vision API is transferred...
		CameraServer.getInstance().startAutomaticCapture();
	}
	
	public void autonomousInit() {
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
}