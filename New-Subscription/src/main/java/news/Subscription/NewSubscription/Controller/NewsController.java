package news.Subscription.NewSubscription.Controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import news.Subscription.NewSubscription.model.NewsType;
import news.Subscription.NewSubscription.service.NewsService;


@RestController
@RequestMapping("/News-Subscription-App")
public class NewsController {
	
		@Autowired
		private NewsService newsService;
		
		//news paginated here ...
		@RequestMapping(value = "/allAvailableNews", method = RequestMethod.GET ,consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<NewsType>> getNewsType(
	                        @RequestParam(defaultValue = "0") Integer pageNo, 
	                        @RequestParam(defaultValue = "20") Integer pageSize
	                       ) 
	    {
	        List<NewsType> list = newsService.getAllNewsType(pageNo, pageSize);
	 
	        return new ResponseEntity<List<NewsType>>(list, new HttpHeaders(), HttpStatus.OK); 
	    }

}
