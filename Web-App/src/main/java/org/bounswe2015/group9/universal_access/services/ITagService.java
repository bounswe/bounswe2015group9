package org.bounswe2015.group9.universal_access.services;

import org.bounswe2015.group9.universal_access.dtos.TagDTO;
import org.bounswe2015.group9.universal_access.dtos.ViolationDTO;
import org.bounswe2015.group9.universal_access.entities.Tag;
<<<<<<< HEAD
import org.bounswe2015.group9.universal_access.entities.Violation;
=======
>>>>>>> 06ae9e0fa8b18afb1f8d99ef1f7465e28be41fb9

import java.util.List;

/**
 * Created by umut on 12.12.2015.
 */
public interface ITagService  {
<<<<<<< HEAD
    List<Tag> getTags(ViolationDTO violationDTO);
    void createTag(TagDTO tagDTO);
=======
    public List<Tag> getTags(ViolationDTO violationDTO);
    public void createTag(ViolationDTO violationDTO, TagDTO tagDTO);
>>>>>>> 06ae9e0fa8b18afb1f8d99ef1f7465e28be41fb9
}
