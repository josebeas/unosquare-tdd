package com.sanbeso.automation.tests;

import com.sanbeso.automation.configuration.SpringConfiguration;
import com.sanbeso.automation.divermanager.impl.FireFoxDriverManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by user on 12/09/16.
 */
@ContextConfiguration(classes = SpringConfiguration.class)
public abstract class TestBase {

    @Autowired
    FireFoxDriverManagerImpl webDriver;

}
