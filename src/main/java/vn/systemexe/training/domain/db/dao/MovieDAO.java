package vn.systemexe.training.domain.db.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import vn.systemexe.training.domain.db.entity.Movie;

import vn.systemexe.training.domain.db.ext.entity.UserRoleExt;

@ConfigAutowireable
@Dao
public interface MovieDAO {
	@Select
    List<Movie> selectAll();
	
	@Select
	Movie findById(Long id);

	@Select
	Movie findByUsername(String username);

    @Insert
    int insert(Movie movie);
    
	@Select
	List<UserRoleExt> selectUserRoleById(Long movieId);
}

