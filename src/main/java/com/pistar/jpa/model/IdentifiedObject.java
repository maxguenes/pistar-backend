package com.pistar.jpa.model;

import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by maxguenes on 19/07/2017.
 */
public abstract class IdentifiedObject implements PiStarValidObject {

    @NotNull(message = "Empty ID value")
    public String id;

    @NotNull(message = "Empty Type value")
    public String type;

    @Override
    public void checkValidObject() {
        Assert.notNull(id, "Empty ID value");
        Assert.notNull(type, "Empty Type value");
        Assert.isTrue(getValidTypes().contains(type), "Invalid Node Type "+type+" in valid types "+getValidTypes());
    }

    abstract Set<String> getValidTypes();


    protected static Set<String> createImutableSet(String[] values){
        return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(values)));
    }
}
