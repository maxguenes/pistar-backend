package com.pistar.jpa.model;

import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;

/**
 * Created by maxguenes on 19/07/2017.
 */
public abstract class TargetedObject extends IdentifiedObject {

    @NotNull(message = "Empty source")
    public String source;

    @NotNull(message = "Empty target")
    public String target;

    @Override
    public void checkValidObject() {
        super.checkValidObject();
        Assert.notNull(source, "Empty source Value");
        Assert.notNull(target, "Empty target Value");
    }
}
