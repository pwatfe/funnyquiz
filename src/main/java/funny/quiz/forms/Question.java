package funny.quiz.forms;

public class Question {
	
    private String question;
    private String help;
    private String error;
    private String success;
    private String response;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "Question [question=" + question + '\'' + 
				", help=" + help + '\'' +
				", error=" + error + '\'' +
				", success=" + success + '\'' +
				", response=" + response + "]";
	}
	  

	
	
}