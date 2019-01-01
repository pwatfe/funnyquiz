package funny.quiz.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import funny.quiz.forms.Question;

@Component("questions")
@PropertySource("classpath:quiz.properties")
@ConfigurationProperties("quiz") // prefix quiz, find quiz.* values
public class QuestionProperties {
	
	private String awardFileName;
	private String targetPerson;
	
	private String passwordText;
	private String password;
	
	private String congratsText;
	
    private List<Question> questions = new ArrayList<>();

	public String getAwardFileName() {
		return awardFileName;
	}

	public void setAwardFileName(String awardFileName) {
		this.awardFileName = awardFileName;
	}

	public String getTargetPerson() {
		return targetPerson;
	}

	public void setTargetPerson(String targetPerson) {
		this.targetPerson = targetPerson;
	}

	public String getPasswordText() {
		return passwordText;
	}

	public void setPasswordText(String passwordText) {
		this.passwordText = passwordText;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCongratsText() {
		return congratsText;
	}

	public void setCongratsText(String congratsText) {
		this.congratsText = congratsText;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}