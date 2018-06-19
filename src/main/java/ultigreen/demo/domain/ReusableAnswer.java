package ultigreen.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ReusableAnswer")
public class ReusableAnswer {

	@Id
	@Column(name="answer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;
    
    @ManyToOne
    @JoinColumn(name = "question_id")
    private ReusableQuestion question;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "response")
    private String response;
    
    @Column(name = "carbon_effect")
    private double carbon;
    
    public ReusableAnswer() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	public ReusableQuestion getQuestion() {
		return question;
	}

	public void setQuestion(ReusableQuestion question) {
		this.question = question;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public double getCarbon() {
		return carbon;
	}

	public void setCarbon() {
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
		if (this.question.getQuestion().contains("paper")) {
			this.type = "paper";
		}
		if (this.question.getQuestion().contains("plastic")) {
			this.type = "plastic";
		}
		if (this.question.getQuestion().contains("Bagasse")) {
			this.type = "bagasse";
		}
		if (this.question.getQuestion().contains("styrofoam")) {
			this.type = "styrofoam";
		}
	}
	
	public String getType() {
		return this.type;
	}
    
}
