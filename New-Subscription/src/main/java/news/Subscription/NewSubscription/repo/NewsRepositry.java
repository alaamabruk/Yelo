package news.Subscription.NewSubscription.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import news.Subscription.NewSubscription.model.NewsType;

@Repository
public interface NewsRepositry extends
PagingAndSortingRepository<NewsType, Integer> {

}
