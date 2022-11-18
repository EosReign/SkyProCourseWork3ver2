package prosky.skyprocoursework3ver2.services;

import org.springframework.stereotype.Service;
import prosky.skyprocoursework3ver2.exceptions.QuestionAlreadyExistsException;
import prosky.skyprocoursework3ver2.exceptions.QuestionNotExistException;
import prosky.skyprocoursework3ver2.impl.QuestionService;
import prosky.skyprocoursework3ver2.models.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    private Random random = new Random();

    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question task = new Question(question, answer);
        if (questions.contains(task)) {
            throw new QuestionAlreadyExistsException();
        }
        questions.add(task);
        return task;
    }

    @Override
    public Question add(Question task) {
        if (questions.contains(task)) {
            throw new QuestionAlreadyExistsException();
        }
        questions.add(task);
        return task;
    }

    @Override
    public Question remove(String question) {
        Question task = new Question(question);
        if (!questions.contains(task)) {
            throw new QuestionNotExistException();
        }
        questions.remove(task);
        return task;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            return null;
        }
        return questions.stream().skip(random.nextInt(questions.size())).findFirst().orElse(null);
    }
}
