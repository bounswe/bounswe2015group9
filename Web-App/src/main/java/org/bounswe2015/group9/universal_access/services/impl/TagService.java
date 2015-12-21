package org.bounswe2015.group9.universal_access.services.impl;

import org.bounswe2015.group9.universal_access.daos.ITagDao;
import org.bounswe2015.group9.universal_access.dtos.TagDTO;
import org.bounswe2015.group9.universal_access.dtos.ViolationDTO;
import org.bounswe2015.group9.universal_access.entities.Tag;
import org.bounswe2015.group9.universal_access.entities.Violation;
import org.bounswe2015.group9.universal_access.services.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by umut on 12.12.2015.
 */
@Service("tagService")
public class TagService implements ITagService{
    @Autowired
    ITagDao tagDao;

    public List<Tag> getTags(ViolationDTO violationDTO){
        List<Tag> tags = tagDao.getTagsByViolation(violationDTO.getId());
        return tags;
    }



    public void createTag(TagDTO tagDTO){
        Tag tag= new Tag(tagDTO);
        tagDao.create(tag);
    }

}

