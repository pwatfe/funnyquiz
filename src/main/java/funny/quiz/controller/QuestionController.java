package funny.quiz.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import funny.quiz.configuration.QuestionProperties;
import funny.quiz.forms.Question;

@Controller
public class QuestionController {

	private QuestionProperties questions;
	
	@Autowired
	public QuestionController(QuestionProperties prop) {
		this.questions = prop;
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("passwordText", questions.getPasswordText());
		return "welcome";
	}

	@RequestMapping(value = { "/welcome" }, method = RequestMethod.POST)
	public String acceder(Model model, @RequestParam(value = "param", required = false) String param) {
		if (questions.getPassword().equals(param)) {
			return "redirect:/question/1";
		} else {
			model.addAttribute("passwordText", questions.getPasswordText());
			model.addAttribute("message", "Que va, esa no es!");
			return "welcome";
		}
	}

	@RequestMapping(value = { "/question/{id}", }, method = RequestMethod.GET)
	public String question(@PathVariable Integer id, Model model) {
		
		if (id != null && id <= questions.getQuestions().size()) {
			model.addAttribute("question", questions.getQuestions().get(id-1));

			return "question";
		} else {
			return "redirect:/errors/404";
		}
		
	}
	
	
	@RequestMapping(value = { "/question/{id}", }, method = RequestMethod.POST)
	public String response(@PathVariable Integer id, Model model, @RequestParam(value = "param", required = false) String param
			, final RedirectAttributes redirectAttributes) {
		model.addAttribute("question", questions.getQuestions().get(id-1));

		Question question = questions.getQuestions().get(id-1);
		if (checkAnwser(question, param)) {
			
			if (id >= questions.getQuestions().size()) {
				return "redirect:/congrats";
			} else {
				redirectAttributes.addFlashAttribute("success", question.getSuccess());
				return "redirect:/question/" + (id + 1);
			}
			
		} else {
			model.addAttribute("message", question.getError());
			return "question";
		}
	}

	private Boolean checkAnwser(Question question, String response) {

		if (response != null) {

			String responseProccess = StringUtils.trimWhitespace(response);

			if (Arrays.asList(question.getResponse().toLowerCase().split("##"))
					.contains(responseProccess.toLowerCase())) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}
	

	@RequestMapping(value = { "/congrats", }, method = RequestMethod.GET)
	public String congrats(Model model) {
		model.addAttribute("congrats", questions.getCongratsText());
		return "congrats";
	}
	

	
	// Not working on heroku
//	@RequestMapping(path = "/download", method = RequestMethod.GET)
//	public ResponseEntity<InputStreamResource> download(@RequestParam(defaultValue = "awards.pdf") String fileName)
//			throws IOException {
//
//		MediaType mediaType = MediaType.APPLICATION_PDF;
//		System.out.println("fileName: " + fileName);
//		System.out.println("mediaType: " + mediaType);
//		
//		File file = resourceLoader.getResource("classpath:awards.pdf").getFile();
//		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//
//		return ResponseEntity.ok()
//				// Content-Disposition
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
//				// Content-Type
//				.contentType(mediaType)
//				// Contet-Length
//				.contentLength(file.length()) //
//				.body(resource);
//	}

}