package vn.systemexe.training.domain.db.ext.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class UserRoleExt {

	@Column(name = "user_id")
	private Long userId;
	@Column(name = "role_id")
	private Long roleId;
	@Column(name = "role_name")
	private String roleName;
	@Column(name = "movie_id")
	private Long movieId;
}
