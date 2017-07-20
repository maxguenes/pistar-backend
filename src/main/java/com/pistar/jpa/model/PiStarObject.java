package com.pistar.jpa.model;

import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * Created by maxguenes on 18/06/2017.
 */
public class PiStarObject implements PiStarValidObject {

    @NotNull(message = "Empty tool")
    public String tool;

    @NotNull(message = "Empty istar version")
    public String istar;

    @NotNull(message = "Empty saveDate")
    public String saveDate;

    public List<PiStarActor> actors;
    public PiStarDiagram diagram;
    public List<PiStarLink> links;
    public List<PiStarDependency> dependencies;


    public void checkValidObject(){

        Assert.notNull(tool,"Empty tool");
        Assert.notNull(istar,"Empty istar version");
        Assert.notNull(saveDate,"Empty saveDate");


        Map<String, IdentifiedObject> validNodes = new HashMap<>();

        checkValidDiagram();
        checkValidActors(validNodes);
        checkValidLinks(validNodes);
        checkValidDependencies(validNodes);
    }

    private void checkValidDiagram() {
        Assert.notNull(diagram,"Null diagram object");
        diagram.checkValidObject();
    }

    private void checkValidActors(Map<String, IdentifiedObject> validNodes) {
        Assert.notNull(actors,"Null actor list");
        for (PiStarActor actor : actors){
            actor.checkValidObject();

            validNodes.put(actor.id, actor);

            for(PiStarNode node : actor.nodes){
                validNodes.put(node.id, node);
            }
        }
    }

    private void checkValidDependencies(Map<String, IdentifiedObject> validNodes) {
        Assert.notNull(dependencies,"Null dependencies list");

        for (PiStarDependency dependency : dependencies){
            dependency.checkValidObject();
            Assert.isTrue(validNodes.containsKey(dependency.source), "Dependency Source "+dependency.source+" do not exist");
            Assert.isTrue(validNodes.containsKey(dependency.target), "Dependency Target "+dependency.target+"do not exist");
        }
    }

    private void checkValidLinks(Map<String, IdentifiedObject> validNodes) {
        Assert.notNull(links,"Null link list");

        for(PiStarLink link : links){
            link.checkValidObject();
            Assert.isTrue(validNodes.containsKey(link.source), "Link Source "+link.source+" do not exist");
            Assert.isTrue(validNodes.containsKey(link.target), "Link Target "+link.target+" do not exist");
        }
    }

}
