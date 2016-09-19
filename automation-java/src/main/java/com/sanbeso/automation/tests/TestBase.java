package com.sanbeso.automation.tests;

import com.sanbeso.automation.configuration.SpringConfiguration;
import com.sanbeso.automation.divermanager.impl.FireFoxDriverManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Abstract TestBase, sets class with all necessary stuff to run automated tests
 *
 * @author Jose Beas
 */
@ContextConfiguration(classes = SpringConfiguration.class)
public abstract class TestBase {

    /**
     * Web driver manager to load pages and interact with them
     */
    @Autowired
    FireFoxDriverManagerImpl webDriver;

}
