package com.epam.test;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;
import org.testng.Reporter;


public class ReportAppender extends AppenderSkeleton {
    @Override
    protected void append(LoggingEvent loggingEvent) {
        Reporter.log("5");
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}