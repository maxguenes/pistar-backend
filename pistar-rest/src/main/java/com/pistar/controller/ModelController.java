package com.pistar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pistar.model.PiStarObject;
import com.pistar.service.PistarModelService;

/**
 * Created by maxguenes on 18/06/2017.
 */

@RestController
public class ModelController {

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
