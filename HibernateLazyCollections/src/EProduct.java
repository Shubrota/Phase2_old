
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;



public class EProduct {
	private long ID;
    private String name;
    private BigDecimal price;
    private Date dateAdded;
    private List<Color> colors;
    private Set<OS> OS;
    
    public Set<OS> getOs() {
		return OS;
	}

	public void setOs(Set<OS> oS) {
		this.OS = oS;
	}
	private Set<Finance> finance;
   // private PDescription pdescrip;
    private Collection<ScreenSizes> screenSizes;
    public EProduct() {
            
    }
    
    public long getID() {return this.ID; }
    public String getName() { return this.name;}
    public BigDecimal getPrice() { return this.price;}
    public Date getDateAdded() { return this.dateAdded;}
    public List<Color> getColor() { return this.colors;}
    public Set<Finance> getFinance() { return this.finance;}
   // public PDescription getPdescrip() { return this.pdescrip;}
    public Collection<ScreenSizes> getScreenSizes() { return this.screenSizes;}
    
    public void setID(long id) { this.ID = id;}
    public void setName(String name) { this.name = name;}
    public void setPrice(BigDecimal price) { this.price = price;}
    public void setDateAdded(Date date) { this.dateAdded = date;}
    public void setColor(List<Color> colors) { this.colors = colors;}
    public void setFinance(Set<Finance> finance) { this.finance = finance;}
    //public void setPdescrip(PDescription pdescrip) { this.pdescrip = pdescrip;}
    public void setScreenSizes(Collection<ScreenSizes> sizes) { this.screenSizes = sizes;}

}
