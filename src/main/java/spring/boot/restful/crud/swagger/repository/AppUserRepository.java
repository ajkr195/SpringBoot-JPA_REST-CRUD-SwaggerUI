package spring.boot.restful.crud.swagger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.boot.restful.crud.swagger.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	@Modifying
	@Transactional
	@Query("UPDATE AppUser au set au.userenabled = true where au.id = ?1")
	void setAppUserAsActiveById(Long id);

	@Modifying
	@Transactional
	@Query("UPDATE AppUser au set au.userenabled = false where au.id = ?1")
	void setAppUserAsInActiveById(Long id);

	List<AppUser> findByUserenabledTrue();

	List<AppUser> findByUserenabledFalse();

	@Query("SELECT u FROM AppUser u WHERE u.useremail LIKE %:useremail%")
	List<AppUser> findByUseremailLike(String useremail);

	List<AppUser> findByUseremailIgnoreCaseContaining(String useremail);

	@Query("SELECT u FROM AppUser u WHERE u.username LIKE %:username%")
	List<AppUser> findByUsernameLike(String username);

	List<AppUser> findByUsernameIgnoreCaseContaining(String username);

	List<AppUser> findByUsernameNotIn(List<String> username);

	List<AppUser> findByUsernameNot(String username);

	AppUser findByUsername(String username);

	@Query("select useremail, userfirstname, userlastname from AppUser")
	List<AppUser> getOnlyThreeFields();

	@Query("select useremail, userfirstname, userlastname from AppUser where userenabled = true")
	List<AppUser> getActiveUsers();

	@Query("select useremail, userfirstname, userlastname from AppUser where userenabled = false")
	List<AppUser> getInActiveUsers();

	@Query("SELECT u.id FROM AppUser u WHERE u.useremail = ?1")
	AppUser getAppuserIdByUseremail(String useremail);

	@Query("SELECT u FROM AppUser u WHERE u.id = ?1")
	AppUser getAppuserByAppUserId(Long id);
	
	@Query("SELECT u FROM AppUser u WHERE u.id in :ids")
	List<AppUser> getAppUserListByIdListIn(@Param("ids") List<Long> UserIdsList);
	
	@Query("SELECT u FROM AppUser u WHERE u.username = ?1")
	AppUser getAppuserIdByUsername(String username);


	AppUser findByUseremailIgnoreCase(String username);

	AppUser findByUseremail(String useremail);

	boolean existsByUseremail(String useremail);

	AppUser findByUsernameIgnoreCase(String username);

	@Query("select username, useremail, userfirstname, userlastname from AppUser")
	List<AppUser> getOnlyFourFields();

	@Query(value = "SELECT * FROM app_user WHERE rownum<=5 ORDER BY username DESC", nativeQuery = true)
	List<AppUser> findTop5ByUsernamenoLessThanOrderByIdAsc();

	
	
}
