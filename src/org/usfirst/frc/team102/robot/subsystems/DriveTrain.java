package org.usfirst.frc.team102.robot.subsystems;

import org.usfirst.frc.team102.robot.Robot;
import org.usfirst.frc.team102.robot.RobotMap;
import org.usfirst.frc.team102.robot.commands.CommandUpdate;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DriveTrain extends PIDSubsystem implements CommandUpdate.IUpdate {
	protected RobotDrive drive;

	public DriveTrain() {
		super(RobotMap.PID_P_CONST, RobotMap.PID_I_CONST, RobotMap.PID_D_CONST);

		drive = new RobotDrive(new CANTalon(RobotMap.t0CANTalon), new CANTalon(RobotMap.t1CANTalon),
				new CANTalon(RobotMap.t7CANTalon), new CANTalon(RobotMap.t8CANTalon));

		drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
	}

	protected void initDefaultCommand() {
		setDefaultCommand(new CommandUpdate(this, "Drive Train"));
	}

	public void update() {
		try {
			if (RobotState.isOperatorControl()) {
				double leftX = Robot.oi.getDriverJSAxis(RobotMap.xBoxLeftXAxis);
				double leftY = Robot.oi.getDriverJSAxis(RobotMap.xBoxLeftYAxis);
				double rightX = Robot.oi.getDriverJSAxis(RobotMap.xBoxRightXAxis);

				// drive(leftX, leftY, -rightY);
				drive.mecanumDrive_Cartesian(leftY, leftX, -rightX, 0);
			}
		} catch (Exception ex1) {
			ex1.printStackTrace();
			DriverStation.reportError(ex1.getMessage(), true);
		}
	}

	protected double returnPIDInput() {
		return 0;
	}

	protected void usePIDOutput(double output) {
	}
}