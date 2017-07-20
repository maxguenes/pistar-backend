package com.pistar.service;

import com.pistar.jpa.model.PiStarObject;

/**
 * Created by maxguenes on 19/07/2017.
 */
public interface PistarModelService {

    PiStarObject getModel(String hash) throws Exception;

    String saveModel(PiStarObject piStarModel, String remoteAddr) throws Exception;

}
