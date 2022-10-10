package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class App 
{
    private static final Logger logger = LogManager.getLogger(App.class);

    public void doSomething2() throws Exception {
        Thread.sleep(5000);
        throw new Exception("Exception message");
    }
    public void doSomething1() throws Exception {
        doSomething2();
    }

    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello from JSON exception logger!" );
        logger.trace("test message");
        logger.debug("test message");
        logger.info("test message");
        logger.warn("test message");
        logger.error("test message");
        logger.fatal("test message");        
        App app = new App();
        while (true) {
            try {
                app.doSomething1();
            }
            catch (Exception e) {
                logger.error("caught a really bad exception!", e);
            }
        }
    }
}
