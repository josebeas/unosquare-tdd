package com.sanbeso.webapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Home controller, shows initial page
 *
 * @author Jose Beas
 * @version 1.0
 */
@Controller
public class HomeController {

    private static final Log LOGGER = LogFactory.getLog(HomeController.class);

    /**
     * Shows initial page from base web application.
     *
     * @param model spring model to store data.
     * @return transfer object to interact.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView show(Model model) {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        return view;
    }
}
