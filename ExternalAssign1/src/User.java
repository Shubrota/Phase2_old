import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table (name ="user")
public class User {
	@Id  
    @GeneratedValue(strategy=GenerationType.TABLE)  
      
    private int id;   

	@Column(name="name")
	private String name;
	@Column(name="family")
	private String family;
	
	Account Acct;
	Address Add;
	public User() {
		super();
	}

	public User(String name, String family, Account acct, Address add) {
		super();
		this.name = name;
		this.family = family;
		Acct = acct;
		Add = add;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public Account getAcct() {
		return Acct;
	}

	public void setAcct(Account acct) {
		Acct = acct;
	}

	public Address getAdd() {
		return Add;
	}

	public void setAdd(Address add) {
		Add = add;
	}

	
}
