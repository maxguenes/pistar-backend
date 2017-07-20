package com.pistar.jpa.model;

import com.pistar.jpa.util.PiStarConstants;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by maxguenes on 19/07/2017.
 */
public class PiStarDependency extends VisualObject{

    private static final Set<String> VALID_DEPENDENCY_TYPES = createImutableSet(new String[]{
            PiStarConstants.DEPENDENCY_GOAL_TYPE,
            PiStarConstants.DEPENDENCY_RESOURCE_TYPE,
            PiStarConstants.DEPENDENCY_TASK_TYPE,
            PiStarConstants.DEPENDENCY_QUALITY_TYPE
    });


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

    @Override
    Set<String> getValidTypes() {
        return VALID_DEPENDENCY_TYPES;
    }
}
