package org.usfirst.frc.team102.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CommandUpdate extends Command {
	protected IUpdate update;
	protected String name;

	public CommandUpdate(IUpdate update, String name) {
		super("Update: " + name);

		if (update instanceof Subsystem)
			requires((Subsystem) update);

		this.update = update;
		this.name = name;
	}

	public void execute() {
		try {
			update.update();
		} catch (Exception e) {
			System.err.println("Error while updating \"" + name + "\".");
			e.printStackTrace();
		}
	}

	protected boolean isFinished() {
		return false;
	}

	public static interface IUpdate {
		void update();
	}
}