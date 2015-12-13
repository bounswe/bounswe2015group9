package org.bounswe2015.group9.universal_access.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.bounswe2015.group9.universal_access.entities.Tag;

/**
 * Created by umut on 12.12.2015.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class TagDTO {
    private String name;

    public TagDTO(){

    }

    public TagDTO(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}

