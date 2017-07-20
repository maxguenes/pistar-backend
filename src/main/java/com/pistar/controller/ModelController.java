package com.pistar.controller;

import com.pistar.jpa.model.PiStarObject;
import com.pistar.service.PistarModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * Created by maxguenes on 18/06/2017.
 */

@RestController
public class ModelController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModelController.class);

    @Autowired
    private PistarModelService pistarModelService;

    @RequestMapping(value = "/version", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String saveModel(){
        return "1.0.0";
    }

    @Transactional
    @RequestMapping(value = "/model/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String saveModel(@Valid @RequestBody PiStarObject pistarModel, HttpServletRequest request) throws Exception {
        return pistarModelService.saveModel(pistarModel, request.getRemoteAddr());
    }

    @RequestMapping(value = "/model/{hash}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PiStarObject getModel(@PathVariable("hash") String hash) throws Exception {
        return pistarModelService.getModel(hash);
    }
}
