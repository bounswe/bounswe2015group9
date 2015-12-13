package org.bounswe2015.group9.universal_access.services;

import org.bounswe2015.group9.universal_access.dtos.TagDTO;
import org.bounswe2015.group9.universal_access.dtos.ViolationDTO;
import org.bounswe2015.group9.universal_access.entities.Tag;

import java.util.List;

/**
 * Created by umut on 12.12.2015.
 */
public interface ITagService  {
    public List<Tag> getTags(ViolationDTO violationDTO);
    public void createTag(ViolationDTO violationDTO, TagDTO tagDTO);
}
