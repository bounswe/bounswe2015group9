package org.bounswe2015.group9.universal_access.daos;

import org.bounswe2015.group9.universal_access.entities.Rating;
import org.bounswe2015.group9.universal_access.entities.Tag;

import java.util.List;


public interface ITagDao extends IBaseDao<Tag, Long>{
    List<Tag> getTagsByViolation(Long violationId);
}
