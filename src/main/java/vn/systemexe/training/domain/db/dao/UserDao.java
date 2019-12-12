package vn.systemexe.training.domain.db.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import vn.systemexe.training.domain.db.entity.User;
import vn.systemexe.training.domain.db.ext.entity.UserRoleExt;

@ConfigAutowireable
@Dao
public interface UserDao {
	@Select
    List<User> selectAll();
	
	@Select
	User findById(Long id);

	@Select
	User findByUsername(String username);

    @Insert
    int insert(User user);
    
	@Select
	List<UserRoleExt> selectUserRoleById(Long userId);
	
	@Delete
	int deleteById(User user);
	
	@Update
	int updateById(User user);
}
