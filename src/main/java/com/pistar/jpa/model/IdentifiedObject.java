package com.pistar.jpa.model;

import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;

/**
 * Created by maxguenes on 19/07/2017.
 */
public abstract class IdentifiedObject implements PiStarValidModel{

    @NotNull(message = "Empty ID value")
    public String id;

    @NotNull(message = "Empty Type value")
    public String type;

    @Override
    public void checkValidModel() {
        Assert.notNull(id, "Empty ID value");
        Assert.notNull(type, "Empty Type value");
    }
}
