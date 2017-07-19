package com.pistar.jpa.model;

import com.pistar.jpa.util.PiStarConstants;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by maxguenes on 19/07/2017.
 */
public class PiStarNode extends VisualObject{

    private static final Set<String> VALID_NODE_TYPES = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(new String[]{
            PiStarConstants.NODE_GOAL_TYPE,
            PiStarConstants.NODE_RESOURCE_TYPE,
            PiStarConstants.NODE_TASK_TYPE,
            PiStarConstants.NODE_QUALITY_TYPE
    })));

    @Override
    public void checkValidModel() {
        super.checkValidModel();

        Assert.isTrue(VALID_NODE_TYPES.contains(type), "Invalid Node Type "+type);

    }
}
