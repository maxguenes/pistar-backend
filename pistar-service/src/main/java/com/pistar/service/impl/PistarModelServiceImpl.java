package com.pistar.service.impl;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pistar.jpa.mapper.PistarModelMapper;
import com.pistar.model.PiStarObject;
import com.pistar.service.PistarModelService;

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

        String hash = getUniqueHash(json);

        if(!modelMapper.existsModel(hash)) {
            boolean result = modelMapper.insertModel(hash, json, remoteAddr);

            if (!result) {
                throw new RuntimeException("Failed to save Pistar Model");
            }
        }

        return hash;
    }

    private String getUniqueHash(String content) throws IOException {

        ObjectNode node = (ObjectNode)objectMapper.readTree(content);

        node.remove("saveDate");

        String resultJson = objectMapper.writeValueAsString(node);

        String result = UUID.nameUUIDFromBytes(resultJson.getBytes()).toString();
        return result;
    }

}
