package news.Subscription.NewSubscription.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.impl.DefaultClaims;
import news.Subscription.NewSubscription.JWT.JwtUtil;
import news.Subscription.NewSubscription.JWT.MyUserDetailsService;
import news.Subscription.NewSubscription.model.AuthResponse;
import news.Subscription.NewSubscription.model.BaseResponse;
import news.Subscription.NewSubscription.model.UserAuth;
import news.Subscription.NewSubscription.service.UserService;


@RestController
@RequestMapping("/News-Subscription-App")
class UserConroller {
	

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;
 
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private UserService UserService;
	

	@RequestMapping({ "/welcome" })
	public String home() {
		return "welcome Page";
		
	}

	
	
	@RequestMapping(value = "/refreshtoken", method = RequestMethod.GET)
	public ResponseEntity<?> refreshtoken(HttpServletRequest request) throws Exception {
		// From the HttpRequest get the claims
		DefaultClaims claims = (io.jsonwebtoken.impl.DefaultClaims) request.getAttribute("claims");

		Map<String, Object> expectedMap = getMapFromIoJsonwebtokenClaims(claims);
		String token = jwtTokenUtil.doGenerateRefreshToken(expectedMap, expectedMap.get("sub").toString());
		return ResponseEntity.ok(new AuthResponse(token));
	}

	public Map<String, Object> getMapFromIoJsonwebtokenClaims(DefaultClaims claims) {
		Map<String, Object> expectedMap = new HashMap<String, Object>();
		for (Entry<String, Object> entry : claims.entrySet()) {
			expectedMap.put(entry.getKey(), entry.getValue());
		}
		return expectedMap;
	}
	
	

	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserAuth userAuth) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userAuth.getUserName(), userAuth.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
          
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(userAuth.getUserName());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(jwt));
	}
		
	
	@RequestMapping(value = "/subscribe", method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse subscribe(@RequestBody UserAuth User) {
		   User.setId(User.getId());
		   UserService.Subscribe(User);
		   return new BaseResponse("News subscribed successfuly", true);
		 }
	
	
	
	@RequestMapping(value = "/userSubscribedNews", method = RequestMethod.GET ,consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserAuth> findUserSubscribedNews() {
		return UserService.findUserSubscribedNews(userDetailsService.getUser().get().getId());
	}
	
	
	@RequestMapping(value = "/unsubscribe/{UserId}/{NewsId}", method = RequestMethod.DELETE)
	public BaseResponse UnsubscribeNewsType(@PathVariable(value = "UserId") int UserId ,
			        @PathVariable(value = "NewsId") int NewsId ) {
		System.out.println(UserService.checkUserSubscribedNews(UserId, NewsId));
		 if(UserService.checkUserSubscribedNews(UserId, NewsId)) {
		 UserService.UnsubscribeNewsType(UserId, NewsId);
		 return new BaseResponse("Deleted News_id = "+ NewsId +" successfuly from User_Id = "+ UserId, true);
		 }
		 return new BaseResponse("Deleted News Fails not Found News_id = "+ NewsId +"  from User_Id = "+ UserId, false);
		 
	}

}