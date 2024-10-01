package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sumScore = 0;
        double numberPupilsAndSubjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
                numberPupilsAndSubjects++;
            }
        }
        return sumScore / numberPupilsAndSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> averageScoreByOnePupil = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sumScore = 0;
            double numberSubjects = 0;
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
                numberSubjects++;
            }
            double averageScore = sumScore / numberSubjects;
            averageScoreByOnePupil.add(new Label(pupil.name(), averageScore));
        }
        return averageScoreByOnePupil;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Double> sumSubjectScores = new HashMap<>();
        Map<String, Integer> numberSubjectScores = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumSubjectScores.put(subject.name(),
                        sumSubjectScores.getOrDefault(subject.name(), 0.0) + subject.score());
                numberSubjectScores.put(subject.name(),
                        numberSubjectScores.getOrDefault(subject.name(), 0) + 1);
            }
        }
        List<Label> averageScoreByOneSubject = new ArrayList<>();
        for (String subjectName : sumSubjectScores.keySet()) {
            double averageScore = sumSubjectScores.get(subjectName) / numberSubjectScores.get(subjectName);
            averageScoreByOneSubject.add(new Label(subjectName, averageScore));
        }

        return averageScoreByOneSubject;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> sumScoreByOnePupil = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sumScore = 0;
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
            sumScoreByOnePupil.add(new Label(pupil.name(), sumScore));
        }
        sumScoreByOnePupil.sort(Comparator.naturalOrder());
        return sumScoreByOnePupil.get(sumScoreByOnePupil.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Double> sumSubjectScoresForPeoples = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumSubjectScoresForPeoples.put(subject.name(),
                        sumSubjectScoresForPeoples.getOrDefault(subject.name(), 0.0) + subject.score());
            }
        }
        List<Label> sumSubjectScores = new ArrayList<>();
        for (String subjectName : sumSubjectScoresForPeoples.keySet()) {
            double averageScore = sumSubjectScoresForPeoples.get(subjectName);
            sumSubjectScores.add(new Label(subjectName, averageScore));
        }
        sumSubjectScores.sort(Comparator.naturalOrder());
        return sumSubjectScores.get(sumSubjectScores.size() - 1);
    }
}