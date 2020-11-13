package news.Subscription.NewSubscription.service;

import java.util.List;

import news.Subscription.NewSubscription.model.NewsType;

public interface NewsService {

	public List<NewsType> getAllNewsType(Integer pageNo, Integer pageSize);

}
