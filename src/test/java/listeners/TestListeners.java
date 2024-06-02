package listeners;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
    Logger logger = LogManager.getLogger(TestListeners.class);

    @Override
    public void onTestFailure(ITestResult testResult) {
        ITestListener.super.onTestFailure(testResult);
        logger.info("---------------------------------------------------------------");
        logger.info("Failed because of - " + testResult.getThrowable());
        logger.info("---------------------------------------------------------------");
    }

    @Override
    public void onTestStart(ITestResult testResult) {
        ITestListener.super.onTestStart(testResult);
        logger.info("---------------------------------------------------------------");
        logger.info(testResult.getMethod().getMethodName() + " Started");
        logger.info("---------------------------------------------------------------");
        logger.info(testResult.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        ITestListener.super.onTestSuccess(testResult);
        logger.info("---------------------------------------------------------------");
        logger.info(testResult.getMethod().getMethodName() + " Passed");
        logger.info("---------------------------------------------------------------");
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {
        ITestListener.super.onTestSkipped(testResult);
        logger.info("---------------------------------------------------------------");
        logger.info("Skipped because of - " + testResult.getName());
        logger.info("---------------------------------------------------------------");
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        logger.info("===============================================================");
        logger.info("     On Start :-" + context.getName() + "                      ");
        logger.info("===============================================================");
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        logger.info("===============================================================");
        logger.info("     On Finish :-" + context.getName() + "                     ");
        logger.info("===============================================================");
    }
}
