package news.Subscription.NewSubscription.repo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.validation.annotation.Validated;

import news.Subscription.NewSubscription.model.UserAuth;



public interface UserRepository extends JpaRepository<UserAuth, Integer> {
	
	
	Optional<UserAuth> findByUserName(String userName);
	
    @Transactional
	@Query(value = "SELECT * FROM user INNER JOIN news_type ON user.id=news_type.id where user.id=?1 ; " , nativeQuery = true)
	public List<UserAuth> findUserSubscribedNews(int user_id);
    
    
    @Transactional
	@Query(value = "select news_id from users_news where user_id=?1 and news_id=?2 ; " , nativeQuery = true)
	public String checkUserNews(int user_id ,int News_id);
   
    @Modifying
	@Transactional
	@Query(value= "delete from users_news where user_id=?1 and news_id=?2 ;" , nativeQuery =true )
    public void UnsubscribeNewsType(int user_id ,int News_id);
    
    

}