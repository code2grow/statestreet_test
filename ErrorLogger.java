
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ErrorLogger {
	private Logger logger;

	public ErrorLogger(String logString) {
		logger = Logger.getLogger(logString);
		logger.setUseParentHandlers(false);
		configure();
	}

	private void configure() {
		try {
			String logsDirectoryFolder = "/preetham/logs";
			// Files.createDirectories(Paths.get(logsDirectoryFolder));
			File file = new File(logsDirectoryFolder);
			if (!file.exists()) {
				if (file.mkdirs()) {
					System.out.println("Directory is created!");
				} else {
					System.out.println("Failed to create directory!");
				}
			}
			String yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			// System.out.println("getPath: "+folder.getPath());
			// System.out.println("getAbsolutePath: "+folder.getAbsolutePath());
			FileHandler fileHandler = new FileHandler(logsDirectoryFolder + File.separator + "footc-properties_"+yyyyMMdd + ".log");
			logger.addHandler(fileHandler);
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		 addCloseHandlersShutdownHook();
	}

	private void addCloseHandlersShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				// Close all handlers to get rid of empty .LCK files
				for (Handler handler : logger.getHandlers()) {
					handler.close();
				}
			}
		}));
	}

	private String getCurrentTimeString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		return dateFormat.format(new Date());
	}

	public void log(Level l,String methodName,String msg) {
//		logger.log(l, msg);
		logger.logp(l, logger.getName(), methodName, msg);
	}
}
