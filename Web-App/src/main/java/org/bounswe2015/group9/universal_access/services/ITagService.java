package org.bounswe2015.group9.universal_access.services;

import org.bounswe2015.group9.universal_access.dtos.TagDTO;
import org.bounswe2015.group9.universal_access.dtos.ViolationDTO;
import org.bounswe2015.group9.universal_access.entities.Tag;
import org.bounswe2015.group9.universal_access.entities.Violation;
import java.util.List;

/**
 * Created by umut on 12.12.2015.
 */
public interface ITagService  {
    List<Tag> getTags(ViolationDTO violationDTO);
    void createTag(TagDTO tagDTO);

}
