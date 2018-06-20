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

/**	public void setCarbon() {
		int res = Integer.getInteger(this.response);
		if (this.type.equals("plastic")) {
			this.carbon = 1.34 * res;
		}
		if (this.type.equals("bagasse")) {
			this.carbon = 0.124 * res;
		}
		if (this.type.equals("styrofoam")) {
			this.carbon = 0.174 * res;
		}
		if (this.type.equals("paper")) {
			this.carbon = 0.125 * res;
		}
	}
	public void setType() {
		if (this.question.contains("paper")) {
			this.type = "paper";
		}
		if (this.question.contains("plastic")) {
			this.type = "plastic";
		}
		if (this.question.contains("Bagasse")) {
			this.type = "bagasse";
		}
		if (this.question.contains("styrofoam")) {
			this.type = "styrofoam";
		}
	} */
    
}
