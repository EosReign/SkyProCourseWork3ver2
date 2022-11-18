package prosky.skyprocoursework3ver2.impl;

import prosky.skyprocoursework3ver2.models.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
