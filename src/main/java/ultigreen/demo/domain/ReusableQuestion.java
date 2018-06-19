package ultigreen.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReusableQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String question;
	
	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public static String getQuestionFromId( int id ) {
		if (id == 1 ) {
			return "How many single-use styrofoam products do you use per week at work?";
		}
		if (id == 2) {
			return "How many single-use plastic products do you use per week at work?";
		}
		if (id == 3) {
			return "How many single-use Bagasse products do you use per week at work?";
		}
		if (id == 4) {
			return "How many single-use paper products do you use per week at work?";
		}
		return "";
	}
}
