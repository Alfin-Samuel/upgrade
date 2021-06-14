package ui.framework;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class Listeners implements ITestListener {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Listeners.class));
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Test Passed");
        LOGGER.info(String.format(":-):-):-):-):-):-):-):-):-):-):-):-):-):-):-):-):-):-):-):-):-):-):-):-)"));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info("Test Failed");
        LOGGER.info(String.format(":-(:-(:-(:-(:-(:-(:-(:-(:-(:-(:-(:-(:-(:-(:-(:-(:-(:-(:-(:-(:-(:-("));
    }

    @Override
    public void onStart(ITestContext context) {

        LOGGER.info("===========================================================================================");
        LOGGER.info(String.format("Test got started ------> %s",context.getName()));
    }

    @Override
    public void onFinish(ITestContext context) {
        LOGGER.info(String.format("Test Ended ------> %s",context.getName()));
        LOGGER.info("===========================================================================================");
    }
}
