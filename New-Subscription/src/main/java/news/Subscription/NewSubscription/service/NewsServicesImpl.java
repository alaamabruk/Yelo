package news.Subscription.NewSubscription.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import news.Subscription.NewSubscription.model.NewsType;
import news.Subscription.NewSubscription.repo.NewsRepositry;


@Service
public class NewsServicesImpl implements NewsService {

	@Autowired
	NewsRepositry newsRepository;
	
	
	@Override
	public List<NewsType> getAllNewsType(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		
        Page<NewsType> pagedResult = newsRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<NewsType>();
        }
	}

}
