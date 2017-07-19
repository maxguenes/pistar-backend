package com.pistar.jpa.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by maxguenes on 19/07/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PiStarLink extends TargetedObject{
    public String label;
}
