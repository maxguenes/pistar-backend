package com.pistar.jpa.model;

import javax.validation.constraints.NotNull;

/**
 * Created by maxguenes on 19/07/2017.
 */
public class PiStarDependency extends VisualObject{

    @NotNull(message = "Empty source")
    public String source;

    @NotNull(message = "Empty target")
    public String target;

}
