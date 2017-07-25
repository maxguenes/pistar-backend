package com.pistar.jpa.model;

import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * Created by maxguenes on 19/07/2017.
 */
public abstract class VisualObject extends IdentifiedObject {

    @NotNull(message = "Empty X value")
    public Integer x;

    @NotNull(message = "Empty Y value")
    public Integer y;

    @NotNull(message = "Empty Text")
    public String text;

    public Map<String, String> customProperties;

    @Override
    public void checkValidObject() {
        super.checkValidObject();
        Assert.notNull(x, "Empty X value");
        Assert.notNull(y, "Empty Y value");
        Assert.notNull(text, "Empty text value");
    }
}
