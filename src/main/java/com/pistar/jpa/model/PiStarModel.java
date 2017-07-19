package com.pistar.jpa.model;

import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by maxguenes on 18/06/2017.
 */
public class PiStarModel implements PiStarValidModel{

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


    public void checkValidModel(){

        Assert.notNull(tool,"Empty tool");
        Assert.notNull(istar,"Empty istar version");
        Assert.notNull(saveDate,"Empty saveDate");
        checkValidActors();

    }

    private void checkValidActors() {
        Assert.isTrue(actors!=null,"Null actor list");
        for (PiStarActor actor : actors){
            actor.checkValidModel();
        }
    }

}
