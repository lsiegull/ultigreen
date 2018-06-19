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
    
    @Column(name = "response")
    private String response;
    
    
}
