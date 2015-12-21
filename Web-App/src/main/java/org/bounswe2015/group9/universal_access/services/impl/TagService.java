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

<<<<<<< HEAD


    public void createTag(TagDTO tagDTO){
        Tag tag= new Tag(tagDTO);
=======
    public void createTag(ViolationDTO violationDTO, TagDTO tagDTO){
        Violation v = new Violation();
        v.setId(violationDTO.getId());
        Tag tag = new Tag(v,tagDTO);
>>>>>>> 06ae9e0fa8b18afb1f8d99ef1f7465e28be41fb9
        tagDao.create(tag);
    }

}

