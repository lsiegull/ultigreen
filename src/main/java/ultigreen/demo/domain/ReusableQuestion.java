package ultigreen.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "reusables_footprint")
public class ReusableQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    private String user;

    private String plastic;

    private String paper;
    
    private String styrofoam;
    
    private String bagasse;
    
    private Date date;
    
    public ReusableQuestion() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPlastic() {
		return plastic;
	}

	public void setPlastic(String plastic) {
		this.plastic = plastic;
	}

	public String getPaper() {
		return paper;
	}

	public void setPaper(String paper) {
		this.paper = paper;
	}

	public String getStyrofoam() {
		return styrofoam;
	}

	public void setStyrofoam(String styrofoam) {
		this.styrofoam = styrofoam;
	}

	public String getBagasse() {
		return bagasse;
	}

	public void setBagasse(String bagasse) {
		this.bagasse = bagasse;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
}
