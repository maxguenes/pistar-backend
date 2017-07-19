package com.pistar.jpa.model;

import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by maxguenes on 19/07/2017.
 */
public class PiStarActor extends VisualObject{

    public List<PiStarNode> nodes;

    @Override
    public void checkValidModel() {
        Assert.notNull(nodes, "Null node list");
        for (PiStarNode node : nodes){
            node.checkValidModel();
        }
    }
}
