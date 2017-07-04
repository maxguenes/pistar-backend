package com.pistar.jpa.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * Created by maxguenes on 27/06/2017.
 */
public interface PistarModelMapper {

    String selectModel(@Param("hash") String hash);

    boolean insertModel(@Param("jsonContent") String jsonContent, @Param("remoteAddr") String remoteAddr);

    String selectLastInsertedHash(@Param("remoteAddr") String remoteAddr);
}
