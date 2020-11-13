package news.Subscription.NewSubscription.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import news.Subscription.NewSubscription.model.UserAuth;
import news.Subscription.NewSubscription.repo.UserRepository;



@Service
public class UserServiceImpl implements UserService {
     
	@Autowired
	UserRepository UserRepository;
	
	@Override
	public void  Subscribe(UserAuth user) {
		UserRepository.save(user);

	}
	

	@Override
	public List<UserAuth> findUserSubscribedNews(int id) {
		return UserRepository.findUserSubscribedNews(id);
	}
	
	
	@Override
	public boolean checkUserSubscribedNews(int user_id, int News_id) {
		
		String NewsId = UserRepository.checkUserNews(user_id , News_id);
		if(NewsId!=null) return true;
		return false;
	}
	
	@Override
	public UserAuth findById(int theId) {
		Optional<UserAuth> result=UserRepository.findById(theId);
		UserAuth obj=null;
		  if(result.isPresent()) {
			  obj=result.get();
		  }else {
			throw new RuntimeException("Not find User id : "+theId);
		}
		return obj;
	}
	

	@Override
	public void UnsubscribeNewsType(int user_id, int News_id) {
		UserRepository.UnsubscribeNewsType(user_id, News_id);
		
	}

}