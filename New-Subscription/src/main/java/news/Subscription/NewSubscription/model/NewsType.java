package news.Subscription.NewSubscription.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table
public class NewsType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	@Column
    private String Name;
	@Column
    private String IconURL;
	
	@ManyToMany(mappedBy = "newsTypeslist" ,fetch = FetchType.LAZY)
	@JsonIgnore
	private List<UserAuth> UserAuthlist;
	
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getIconURL() {
		return IconURL;
	}
	public void setIconURL(String iconURL) {
		IconURL = iconURL;
	}
	

	public void setUserAuthlist(List<UserAuth> userAuthlist) {
		UserAuthlist = userAuthlist;
	}


	public void AddUserAuthlist(UserAuth userAuth) {
		if(UserAuthlist == null) {
			UserAuthlist=new ArrayList<>();
		}
		UserAuthlist.add(userAuth);
	}
}