package prosky.skyprocoursework3ver2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import prosky.skyprocoursework3ver2.exceptions.QuestionAlreadyExistsException;
import prosky.skyprocoursework3ver2.exceptions.QuestionNotExistException;
import prosky.skyprocoursework3ver2.impl.QuestionService;
import prosky.skyprocoursework3ver2.models.Question;
import prosky.skyprocoursework3ver2.services.JavaQuestionService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class JavaQuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();

    @BeforeEach
    public void setUp() {}

    @AfterEach
    public void cleanUp() {}

    @Test
    public void addNegativeTest() {
        Question task = new Question("zaraza");
        questionService.add(task);
        assertThrows(QuestionAlreadyExistsException.class, () -> questionService.add(task));
    }

    @Test
    public void addPositiveTest() {
        Question task = new Question("zaraza");
        assertEquals(task, questionService.add(task));
    }

    @Test
    public void removeNegativeTest() {
        Question task = new Question("zaraza");
        assertThrows(QuestionNotExistException.class, () -> questionService.remove(task.getQuestion()));
    }

    @Test
    public void removePositiveTest() {
        Question task = new Question("zaraza");
        questionService.add(task);
        assertEquals(task, questionService.remove(task.getQuestion()));
    }

    @Test
    public void getRandomQuestionNegativeTest() {
        for (int i = 1; i <= 5; i++) {
            questionService.add(new Question("q" + i, "a" + i));
        }
        assertThat(questionService.getRandomQuestion()).isIn(questionService.getAll());
    }

    @Test
    public void getRandomQuestionPositiveTest() {
        assertThat(questionService.getAll()).isEmpty();
        assertThat(questionService.getRandomQuestion()).isNull();
    }

}
