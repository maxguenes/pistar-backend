package com.pistar.jpa.model;

import com.pistar.jpa.util.PiStarConstants;

import java.util.Set;

/**
 * Created by maxguenes on 19/07/2017.
 */
public class PiStarNode extends VisualObject{

    private static final Set<String> VALID_NODE_TYPES = createImutableSet(new String[]{
            PiStarConstants.NODE_GOAL_TYPE,
            PiStarConstants.NODE_RESOURCE_TYPE,
            PiStarConstants.NODE_TASK_TYPE,
            PiStarConstants.NODE_QUALITY_TYPE
    });

    @Override
    Set<String> getValidTypes() {
        return VALID_NODE_TYPES;
    }
}
