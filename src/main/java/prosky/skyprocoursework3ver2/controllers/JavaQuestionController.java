package prosky.skyprocoursework3ver2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import prosky.skyprocoursework3ver2.impl.QuestionService;
import prosky.skyprocoursework3ver2.models.Question;

@RestController
@RequestMapping(path = "/exam")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/java/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/java/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        return questionService.remove(question);
    }

    @GetMapping
    public Question getQuestion() {
        return questionService.getRandomQuestion();
    }

}
