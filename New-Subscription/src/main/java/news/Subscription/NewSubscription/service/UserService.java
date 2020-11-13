package news.Subscription.NewSubscription.service;

import java.util.List;
import news.Subscription.NewSubscription.model.UserAuth;

public interface UserService {

    public void Subscribe(UserAuth user);

    public boolean checkUserSubscribedNews(int user_id ,int News_id);
	public List<UserAuth> findUserSubscribedNews(int id);
	public UserAuth findById(int theId);
	
	public void UnsubscribeNewsType(int user_id ,int News_id);

	
}
