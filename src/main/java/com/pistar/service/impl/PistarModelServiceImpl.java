package com.pistar.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pistar.jpa.mapper.PistarModelMapper;
import com.pistar.jpa.model.PiStarObject;
import com.pistar.service.PistarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by maxguenes on 19/07/2017.
 */
@Service
public class PistarModelServiceImpl implements PistarModelService {

    @Autowired
    private PistarModelMapper modelMapper;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public PiStarObject getModel(String hash) throws Exception {
        String content = modelMapper.selectModel(hash);
        return objectMapper.readValue(content, PiStarObject.class);
    }

    @Override
    public String saveModel(PiStarObject piStarModel, String remoteAddr) throws Exception{
        piStarModel.checkValidObject();

        String json = objectMapper.writeValueAsString(piStarModel);

        boolean result = modelMapper.insertModel(json, remoteAddr);

        if(!result){
            throw new RuntimeException("Failed to save Pistar Model");
        }

        String hash = modelMapper.selectLastInsertedHash(remoteAddr);

        return hash;
    }
}
