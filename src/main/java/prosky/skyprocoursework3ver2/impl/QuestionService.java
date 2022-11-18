package prosky.skyprocoursework3ver2.impl;

import prosky.skyprocoursework3ver2.models.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question task);

    Question remove(String task);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
