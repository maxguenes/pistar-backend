package com.pistar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pistar.jpa.mapper.PistarModelMapper;
import com.pistar.jpa.model.PiStarModel;
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
    private PistarModelMapper modelMapper;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping(value = "/version", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String saveModel(){
        return "1.0.0";
    }

    @Transactional
    @RequestMapping(value = "/model/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String saveModel(@Valid @RequestBody PiStarModel pistarModel, HttpServletRequest request) throws Exception {
        String remoteAddr = request.getRemoteAddr();

        pistarModel.checkValidModel();

        String json = objectMapper.writeValueAsString(pistarModel);

        boolean result = modelMapper.insertModel(json, remoteAddr);

        if(!result){
            throw new RuntimeException("Failed to save Pistar Model");
        }

        String hash = modelMapper.selectLastInsertedHash(remoteAddr);

        return hash;
    }

    @RequestMapping(value = "/model/{hash}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getModel(@PathVariable("hash") String hash){
        return modelMapper.selectModel(hash);
    }
}
