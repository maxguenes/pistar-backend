package com.pistar.model;

import org.springframework.util.Assert;

import com.pistar.util.PiStarConstants;

import java.util.List;
import java.util.Set;

/**
 * Created by maxguenes on 19/07/2017.
 */
public class PiStarActor extends VisualObject{


    private static final Set<String> VALID_ACTORS_TYPES = createImutableSet(new String[]{
            PiStarConstants.ACTORS_ACTOR_TYPE,
            PiStarConstants.ACTORS_AGENT_TYPE,
            PiStarConstants.ACTORS_ROLE_TYPE
    });

    public List<PiStarNode> nodes;

    @Override
    public void checkValidObject() {
        super.checkValidObject();
        Assert.notNull(nodes, "Null node list");
        for (PiStarNode node : nodes){
            node.checkValidObject();
        }
    }

    @Override
    Set<String> getValidTypes() {
        return VALID_ACTORS_TYPES;
    }
}
