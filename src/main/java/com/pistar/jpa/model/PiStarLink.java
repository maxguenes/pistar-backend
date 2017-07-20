package com.pistar.jpa.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pistar.jpa.util.PiStarConstants;

import java.util.Set;

/**
 * Created by maxguenes on 19/07/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PiStarLink extends TargetedObject{

    private static final Set<String> VALID_LINK_TYPES = createImutableSet(new String[]{
            PiStarConstants.LINK_AND_REFINEMENT_TYPE,
            PiStarConstants.LINK_OR_REFINEMENT_TYPE,
            PiStarConstants.LINK_NEEDED_BY_TYPE,
            PiStarConstants.LINK_CONTRIBUTION_TYPE,
            PiStarConstants.LINK_QUALIFICATION_TYPE,
            PiStarConstants.LINK_DEPENDENCY_TYPE,
            PiStarConstants.LINK_IS_A_TYPE,
            PiStarConstants.LINK_PARTICIPATES_IN_TYPE,
    });

    public String label;


    @Override
    public void checkValidObject() {
        super.checkValidObject();
    }

    @Override
    Set<String> getValidTypes() {
        return VALID_LINK_TYPES;
    }
}
