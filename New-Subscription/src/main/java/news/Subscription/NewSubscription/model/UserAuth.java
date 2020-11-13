package news.Subscription.NewSubscription.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class UserAuth implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@Column
    private String userName;
	
	@Column
    private String password;
	
	
	@ManyToMany(fetch=FetchType.LAZY,
	cascade= {CascadeType.PERSIST, CascadeType.MERGE,
	 CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name="users_news",
	joinColumns=@JoinColumn(name="user_id" , referencedColumnName = "id",
	nullable = false ,updatable = false),
	inverseJoinColumns=@JoinColumn(name="news_id" ,referencedColumnName = "id",
	nullable = false ,updatable = false)
	             )
    private List<NewsType> newsTypeslist;

	
    public UserAuth()
    {

    }

    public UserAuth(String username, String password) {
        this.setUserName(username);
        this.setPassword(password);
    }
	
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

        
    public List<NewsType> getNewsTypeslist() {
		return newsTypeslist;
	}

	public void setNewsTypeslist(List<NewsType> newsTypeslist) {
		this.newsTypeslist = newsTypeslist;
	}
	
	public void addNewsTypeslist(NewsType theNewsType) {
		
		if(newsTypeslist == null) {
			newsTypeslist=new ArrayList<>();
		}
			
		newsTypeslist.add(theNewsType);	
	}
	
}