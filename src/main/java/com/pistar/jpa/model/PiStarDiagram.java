package com.pistar.jpa.model;

import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;

/**
 * Created by maxguenes on 19/07/2017.
 */
public class PiStarDiagram implements PiStarValidObject {
    @NotNull(message = "Empty width value")
    public Integer width;

    @NotNull(message = "Empty height value")
    public Integer height;

    @Override
    public void checkValidObject() {
        Assert.notNull(width, "Empty width value");
        Assert.notNull(height, "Empty height value");
    }
}
