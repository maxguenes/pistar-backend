package com.pistar.model;

import java.util.Set;

import com.pistar.util.PiStarConstants;

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
