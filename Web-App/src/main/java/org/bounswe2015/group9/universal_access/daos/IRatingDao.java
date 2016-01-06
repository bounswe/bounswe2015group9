package org.bounswe2015.group9.universal_access.daos;

import org.bounswe2015.group9.universal_access.entities.Rating;
import java.util.List;


public interface IRatingDao extends IBaseDao<Rating, Long>{
    Rating getRating(Long userId, Long violationId);
    List<Rating> getRatingsByViolation(Long violationId,Boolean score);
}
