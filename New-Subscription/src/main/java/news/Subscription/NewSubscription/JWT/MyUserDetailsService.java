package news.Subscription.NewSubscription.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import news.Subscription.NewSubscription.model.UserAuth;
import news.Subscription.NewSubscription.repo.UserRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	
	@Autowired 
	UserRepository userRepository;
    
	private Optional<UserAuth> user;
	
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       
    	
    	 user= userRepository.findByUserName(userName);
    	 
		user.orElseThrow(()->new UsernameNotFoundException("user not found : "+userName));
		
		return new User(user.get().getUserName(),user.get().getPassword() ,new ArrayList<>());
    }

	public Optional<UserAuth> getUser() {
		return user;
	}

	public void setUser(Optional<UserAuth> user) {
		this.user = user;

	}
    
    
    
}
