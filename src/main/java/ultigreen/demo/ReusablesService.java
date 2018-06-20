package ultigreen.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import ultigreen.demo.domain.ReusableQuestion;

@Service
public class ReusablesService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity addQuestions(ReusableQuestion question) {
    		String cols = "INSERT INTO reusables_footprint(user,plastic,paper,styrofoam,bagasse,date)" +
                    "values (?,?,?,?,?,?)";
    		jdbcTemplate.update(cols, question.getUser(), question.getPlastic(), question.getPaper(), question.getStyrofoam(), question.getBagasse(), question.getDate());
    		return new ResponseEntity("Successfully added", HttpStatus.OK);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity getUpdatedData(String username) {
    		String sql = "SELECT * FROM reusables_footprint tf WHERE tf.user = ? ";
    		RowMapper<ReusableQuestion> mapper = new BeanPropertyRowMapper<ReusableQuestion>(ReusableQuestion.class);
    		List<ReusableQuestion> ans = jdbcTemplate.query(sql, mapper, username);
    		return new ResponseEntity(ans.get(0), HttpStatus.OK);
    }
}
