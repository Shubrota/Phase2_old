import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable

public class Address {
	@Column(name="street")
	private String street;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="pin")
	private int pin;
	public Address() {
		super();
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Address(String street, String city, String state, int pin) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.pin = pin;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
}
