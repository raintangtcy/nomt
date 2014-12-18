package org.nomt.master.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class NomtMasterApp
{
    private static Logger logger = LoggerFactory.getLogger(NomtMasterApp.class);

    public static void main(String[] args)
    {
        logger.debug("NomtMasterApp start.");

        final String SPRING_CONTEXT_XML = "server-spring-all.xml";

        logger.debug("Spring context XML file is {}.", SPRING_CONTEXT_XML);

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
                SPRING_CONTEXT_XML);
    }
}
