package net.sprakle.homeAutomation.externalSoftware.commandLine.os;

import net.sprakle.homeAutomation.externalSoftware.commandLine.CommandLineInterface;
import net.sprakle.homeAutomation.utilities.logger.LogSource;
import net.sprakle.homeAutomation.utilities.logger.Logger;

public class MacCLI implements CommandLineInterface {

	private Logger logger;

	public MacCLI(Logger logger) {
		this.logger = logger;
	}

	@Override
	public void execute(String command, int num) {
		logger.log("CLI not supported in this operating system", LogSource.ERROR, LogSource.EXTERNAL_SOFTWARE, 1);

	}

}
