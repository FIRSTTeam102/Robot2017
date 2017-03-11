package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.Robot;
import org.usfirst.frc.team102.robot.RobotMap;
import org.usfirst.frc.team102.robot.commands.CommandUpdate;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class DriveTrain extends PIDSubsystem implements CommandUpdate.IUpdate {
	protected RobotDrive drive;
	protected Gyro gyro;
	protected boolean isDrivingStraight = false;
	protected int encoderZeroPos = 0;
	protected boolean reverse;

	/**
	 * Front right tal. has the encoder connected to it.<br>
	 * These object instances are <b>ONLY</b> used for that purpose.<br>
	 * <b>DO NOT</b> set the speeds of these motor controllers directly.<br>
	 * Use the RobotDrive object.
	 */
	protected CANTalon frontLeftTal, rearLeftTal, frontRightTal, rearRightTal;

	public DriveTrain() {
		super(RobotMap.PID_P_CONST, RobotMap.PID_I_CONST, RobotMap.PID_D_CONST);

		drive = new RobotDrive(frontLeftTal = new CANTalon(RobotMap.t0CANTalon),
				rearLeftTal = new CANTalon(RobotMap.t1CANTalon), frontRightTal = new CANTalon(RobotMap.t7CANTalon),
				rearRightTal = new CANTalon(RobotMap.t8CANTalon));

		// These inversions were commented out on purpose!! Do not change!!!
		// drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		// drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);

		drive.setSafetyEnabled(true);

		gyro = new ADXRS450_Gyro();
		gyro.calibrate();
		gyro.reset();
	}

	protected void initDefaultCommand() {
		setDefaultCommand(new CommandUpdate(this, "Drive Train"));
	}

	public void update() {
		try {
			// MotorAmperageHelper.update();

			if (RobotState.isOperatorControl()) {
				double leftX = Robot.oi.getDriverJSAxis(RobotMap.xBoxLeftXAxis);
				double leftY = Robot.oi.getDriverJSAxis(RobotMap.xBoxLeftYAxis);
				double rightX = Robot.oi.getDriverJSAxis(RobotMap.xBoxRightXAxis);

				// drive(leftX, leftY, -rightY);
				// DO NOT CHANGE THIS!!! DRIVE TRAIN WORKS NOW!!
				drive.mecanumDrive_Cartesian(leftX, -rightX, -leftY, 0);
			}
		} catch (Exception ex1) {
			ex1.printStackTrace();
			DriverStation.reportError(ex1.getMessage(), true);
		}
	}

	protected double returnPIDInput() {
		return gyro.getAngle();
	}

	protected void usePIDOutput(double output) {
		double speed = isDrivingStraight ? RobotMap.AUTO_MODE_SPEED : 0;
		if (reverse)
			speed *= -1;

		// drive(0, speed, output);
		drive.mecanumDrive_Cartesian(0, speed, output, 0);
	}

	public void enableDriveStraight(boolean reverse) {
		isDrivingStraight = true;
		this.reverse = reverse;
		setSetpoint(0);

		enable();
	}

	public void disableDriveStraight() {
		isDrivingStraight = false;
		reverse = false;

		disable();
	}

	public int getEncoderTicksRaw() {
		return frontRightTal.getEncPosition();
	}

	public int getEncoderTicks() {
		return getEncoderTicksRaw() - encoderZeroPos;
	}

	public void resetEncoder() {
		encoderZeroPos = getEncoderTicksRaw();
	}

	public double getEncoderDistance() {
		return Math.abs((double) getEncoderTicks()) / RobotMap.ENCODER_TICKS_PER_INCH;
	}

	public boolean hasDriven(double dist) {
		return getEncoderDistance() >= dist;
	}

	public void basicForward() {
		
		drive.mecanumDrive_Cartesian(.75, 0, 0, 0);
		
//		frontLeftTal.set(-.75);
//		frontRightTal.set(.75);
//		rearLeftTal.set(-.75);
//		rearRightTal.set(.75);
		
	}
	
	public void stop(){
	
		frontLeftTal.set(0);
		frontRightTal.set(0);
		rearLeftTal.set(0);
		rearRightTal.set(0);
		
	}
}
