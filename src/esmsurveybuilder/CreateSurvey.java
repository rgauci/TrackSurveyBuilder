/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esmsurveybuilder;

import informatics.uk.ac.ed.track.lib.AnswerOption;
import informatics.uk.ac.ed.track.lib.MultipleChoiceMultipleAnswer;
import informatics.uk.ac.ed.track.lib.LikertScaleQuestion;
import informatics.uk.ac.ed.track.lib.MultipleChoiceSingleAnswer;
import informatics.uk.ac.ed.track.lib.TrackQuestion;
import informatics.uk.ac.ed.track.lib.BranchableAnswerOption;
import informatics.uk.ac.ed.track.lib.DatabaseHelper;
import informatics.uk.ac.ed.track.lib.FreeTextQuestionMultiLine;
import informatics.uk.ac.ed.track.lib.SurveyHelper;
import java.util.ArrayList;

/**
 *
 * @author Rachel
 */
public class CreateSurvey {

    public static void main(String[] args) {
        
        ArrayList<BranchableAnswerOption> likert_options = new ArrayList<>();
        likert_options.add(new BranchableAnswerOption(1, "Not at all"));
        likert_options.add(new BranchableAnswerOption(2, "A little bit"));
        likert_options.add(new BranchableAnswerOption(3, "Moderately"));
        likert_options.add(new BranchableAnswerOption(4, "Quite a bit"));
        likert_options.add(new BranchableAnswerOption(5, "Extremely"));
        
        ArrayList<BranchableAnswerOption> likert_options_level_of_agreement = new ArrayList<>();
        likert_options_level_of_agreement.add(new BranchableAnswerOption(1, "Strongly disagree"));
        likert_options_level_of_agreement.add(new BranchableAnswerOption(2, "Disagree"));
        likert_options_level_of_agreement.add(new BranchableAnswerOption(3, "Neither agree or disagree"));
        likert_options_level_of_agreement.add(new BranchableAnswerOption(4, "Agree"));
        likert_options_level_of_agreement.add(new BranchableAnswerOption(5, "Strongly agree"));
        
        ArrayList<TrackQuestion> questions = new ArrayList<TrackQuestion>();
        
        int questionNum = 1;
        
        String emotionAffectTitle = "Emotion / Affect";
        String yes = "Yes";
        String no = "No";
        String columnPrefix = "Emotion_";
        
        String emotion = "happy";
        ArrayList<TrackQuestion> q1_reg_questions = getRegulationStrategiesQuestions(questionNum, likert_options, emotion);
        ArrayList<BranchableAnswerOption> q1_1_options = new ArrayList<>();
        q1_1_options.add(new BranchableAnswerOption(1, yes, questionNum + 1));
        q1_1_options.add(new BranchableAnswerOption(2, no, questionNum + q1_reg_questions.size() + 1));
        MultipleChoiceSingleAnswer q1_1 = new MultipleChoiceSingleAnswer(questionNum, columnPrefix + emotion, true, q1_1_options, false);
        //q1_1.setTitle(emotionAffectTitle);
        q1_1.setQuestionText("Right now, I feel " + emotion + ".");
        questions.add(q1_1);
        questions.addAll(q1_reg_questions);
        questionNum += q1_reg_questions.size() + 1;
        
        emotion = "satisfied";
        ArrayList<TrackQuestion> q2_reg_questions = getRegulationStrategiesQuestions(questionNum, likert_options, emotion);
        ArrayList<BranchableAnswerOption> q1_2_options = new ArrayList<>();
        q1_2_options.add(new BranchableAnswerOption(1, yes, questionNum + 1));
        q1_2_options.add(new BranchableAnswerOption(2, no, questionNum + q2_reg_questions.size() + 1));
        MultipleChoiceSingleAnswer q1_2 = new MultipleChoiceSingleAnswer(questionNum, columnPrefix + "satisfied", true, q1_2_options, false);
        //q1_2.setTitle(emotionAffectTitle);
        q1_2.setQuestionText("Right now, I feel " + emotion + ".");
        questions.add(q1_2);
        questions.addAll(q2_reg_questions);
        questionNum += q1_reg_questions.size() + 1;
        
        emotion = "enthusiastic";
        ArrayList<TrackQuestion> q3_reg_questions = getRegulationStrategiesQuestions(questionNum, likert_options, emotion);
        ArrayList<BranchableAnswerOption> q1_3_options = new ArrayList<>();
        q1_3_options.add(new BranchableAnswerOption(1, yes, questionNum + 1));
        q1_3_options.add(new BranchableAnswerOption(2, no, questionNum + q3_reg_questions.size() + 1));
        MultipleChoiceSingleAnswer q1_3 = new MultipleChoiceSingleAnswer(questionNum, columnPrefix + emotion, true, q1_3_options, false);
        //q1_3.setTitle(emotionAffectTitle);
        q1_3.setQuestionText("Right now, I feel " + emotion + ".");
        questions.add(q1_3);
        questions.addAll(q3_reg_questions);
        questionNum += q1_reg_questions.size() + 1;
        
        emotion = "relaxed";
        ArrayList<TrackQuestion> q4_reg_questions = getRegulationStrategiesQuestions(questionNum, likert_options, emotion);
        ArrayList<BranchableAnswerOption> q1_4_options = new ArrayList<>();
        q1_4_options.add(new BranchableAnswerOption(1, yes, questionNum + 1));
        q1_4_options.add(new BranchableAnswerOption(2, no, questionNum + q4_reg_questions.size() + 1));
        MultipleChoiceSingleAnswer q1_4 = new MultipleChoiceSingleAnswer(questionNum, columnPrefix + emotion, true, q1_4_options, false);
        //q1_4.setTitle(emotionAffectTitle);
        q1_4.setQuestionText("Right now, I feel " + emotion + ".");
        questions.add(q1_4);
        questions.addAll(q4_reg_questions);
        questionNum += q1_reg_questions.size() + 1;
        
        emotion = "sad";
        ArrayList<TrackQuestion> q5_reg_questions = getRegulationStrategiesQuestions(questionNum, likert_options, emotion);
        ArrayList<BranchableAnswerOption> q1_5_options = new ArrayList<>();
        q1_5_options.add(new BranchableAnswerOption(1, yes, questionNum + 1));
        q1_5_options.add(new BranchableAnswerOption(2, no, questionNum + q5_reg_questions.size() + 1));
        MultipleChoiceSingleAnswer q1_5 = new MultipleChoiceSingleAnswer(questionNum, columnPrefix + emotion, true, q1_5_options, false);
        //q1_5.setTitle(emotionAffectTitle);
        q1_5.setQuestionText("Right now, I feel " + emotion + ".");
        questions.add(q1_5);
        questions.addAll(q5_reg_questions);
        questionNum += q1_reg_questions.size() + 1;
        
        emotion = "guilty";
        ArrayList<TrackQuestion> q6_reg_questions = getRegulationStrategiesQuestions(questionNum, likert_options, emotion);
        ArrayList<BranchableAnswerOption> q1_6_options = new ArrayList<>();
        q1_6_options.add(new BranchableAnswerOption(1, yes, questionNum + 1));
        q1_6_options.add(new BranchableAnswerOption(2, no, questionNum + q6_reg_questions.size() + 1));
        MultipleChoiceSingleAnswer q1_6 = new MultipleChoiceSingleAnswer(questionNum, columnPrefix + emotion, true, q1_6_options, false);
        //q1_6.setTitle(emotionAffectTitle);
        q1_6.setQuestionText("Right now, I feel " + emotion + ".");
        questions.add(q1_6);
        questions.addAll(q6_reg_questions);
        questionNum += q1_reg_questions.size() + 1;
        
        emotion = "irritated";
        ArrayList<TrackQuestion> q7_reg_questions = getRegulationStrategiesQuestions(questionNum, likert_options, emotion);
        ArrayList<BranchableAnswerOption> q1_7_options = new ArrayList<>();
        q1_7_options.add(new BranchableAnswerOption(1, yes, questionNum + 1));
        q1_7_options.add(new BranchableAnswerOption(2, no, questionNum + q7_reg_questions.size() + 1));
        MultipleChoiceSingleAnswer q1_7 = new MultipleChoiceSingleAnswer(questionNum, columnPrefix + emotion, true, q1_7_options, false);
        //q1_7.setTitle(emotionAffectTitle);
        q1_7.setQuestionText("Right now, I feel " + emotion + ".");
        questions.add(q1_7);
        questions.addAll(q7_reg_questions);
        questionNum += q1_reg_questions.size() + 1;
        
        emotion = "lonely";
        ArrayList<TrackQuestion> q8_reg_questions = getRegulationStrategiesQuestions(questionNum, likert_options, emotion);
        ArrayList<BranchableAnswerOption> q1_8_options = new ArrayList<>();
        q1_8_options.add(new BranchableAnswerOption(1, yes, questionNum + 1));
        q1_8_options.add(new BranchableAnswerOption(2, no, questionNum + q8_reg_questions.size() + 1));
        MultipleChoiceSingleAnswer q1_8 = new MultipleChoiceSingleAnswer(questionNum, columnPrefix + emotion, true, q1_8_options, false);
        //q1_8.setTitle(emotionAffectTitle);
        q1_8.setQuestionText("Right now, I feel " + emotion + ".");
        questions.add(q1_8);
        questions.addAll(q8_reg_questions);
        questionNum += q1_reg_questions.size() + 1;
        
        emotion = "anxious";
        ArrayList<TrackQuestion> q9_reg_questions = getRegulationStrategiesQuestions(questionNum, likert_options, emotion);
        ArrayList<BranchableAnswerOption> q1_9_options = new ArrayList<>();
        q1_9_options.add(new BranchableAnswerOption(1, yes, questionNum + 1));
        q1_9_options.add(new BranchableAnswerOption(2, no, questionNum + q9_reg_questions.size() + 1));
        MultipleChoiceSingleAnswer q1_9 = new MultipleChoiceSingleAnswer(questionNum, columnPrefix + emotion, true, q1_9_options, false);
        //q1_9.setTitle(emotionAffectTitle);
        q1_9.setQuestionText("Right now, I feel " + emotion + ".");
        questions.add(q1_9);
        questions.addAll(q9_reg_questions);
        questionNum += q1_reg_questions.size() + 1;
        
        String eventStressTitle = "Event Stress";
        
        FreeTextQuestionMultiLine question8 = new FreeTextQuestionMultiLine(
                questionNum, "ImportantEvent",
                "What is the most important event that has happened since your last report?");
        //question8.setTitle(eventStressTitle);
        questions.add(question8);
        questionNum++;
        
        LikertScaleQuestion question9 = new LikertScaleQuestion(questionNum, "EventPleasure",  false, likert_options);
        //question9.setTitle(eventStressTitle);
        question9.setQuestionText("How pleasant was this event?");
        questions.add(question9);
        questionNum++;
        
        String activityStressTitle = "Activity Stress";
        String activityStressPrefix = "In relation to this activity:";
        
        FreeTextQuestionMultiLine question10 = new FreeTextQuestionMultiLine(
                questionNum, "CurrentActivity",
                "What are you currently doing?");
        //question10.setTitle(activityStressTitle);
        questions.add(question10);
        questionNum++;
        
        String actColumnPrefix = "Activity_";
        
        LikertScaleQuestion question11 = new LikertScaleQuestion(questionNum, actColumnPrefix + "Like", false, likert_options);
        //question11.setTitle(activityStressTitle);
        question11.setQuestionPrefix(activityStressPrefix);
        question11.setQuestionText("I like what I am doing right now.");
        questions.add(question11);
        questionNum++;
        
        LikertScaleQuestion question12 = new LikertScaleQuestion(questionNum, actColumnPrefix + "Effort", false, likert_options_level_of_agreement);
        //question12.setTitle(activityStressTitle);
        question12.setQuestionPrefix(activityStressPrefix);
        question12.setQuestionText("It takes a lot of effort to do this activity.");
        questions.add(question12);
        questionNum++;
        
        LikertScaleQuestion question13 = new LikertScaleQuestion(questionNum, actColumnPrefix + "Ability", false, likert_options_level_of_agreement);
        //question13.setTitle(activityStressTitle);
        question13.setQuestionPrefix(activityStressPrefix);
        question13.setQuestionText("I have the ability to do this activity.");
        questions.add(question13);
        questionNum++;
        
        LikertScaleQuestion question14 = new LikertScaleQuestion(questionNum, actColumnPrefix + "Prefer_Other", false, likert_options_level_of_agreement);
        //question14.setTitle(activityStressTitle);
        question14.setQuestionPrefix(activityStressPrefix);
        question14.setQuestionText("I would prefer to be doing something else right now.");
        questions.add(question14);
        questionNum++;
        
        ArrayList<BranchableAnswerOption> q15_options = new ArrayList<>();
        q15_options.add(new BranchableAnswerOption(1, "Alone", questionNum + 1));
        q15_options.add(new BranchableAnswerOption(2, "With others", questionNum + 2));
        
        String socialStressTitle = "Social Stress";
        String socialColumnPrefix = "Social_";
        
        MultipleChoiceSingleAnswer question15 = new MultipleChoiceSingleAnswer(questionNum, socialColumnPrefix + "AreYouAlone", true, q15_options, false);
        //question15.setTitle(socialStressTitle);
        question15.setQuestionText("Are you alone or with others?");
        questions.add(question15);
        questionNum++;
        
        ArrayList<BranchableAnswerOption> q16_options = new ArrayList<>();
        q16_options.add(new BranchableAnswerOption(1, "Right now, I enjoy being alone."));
        q16_options.add(new BranchableAnswerOption(2, "Right now, I'd prefer to be with other people."));
        
        MultipleChoiceSingleAnswer question16 = new MultipleChoiceSingleAnswer(questionNum, socialColumnPrefix + "Alone", false, q16_options, false);
        //question16.setTitle(socialStressTitle);
        question16.setNextQuestionId(-1);
        questions.add(question16);
        questionNum++;      
        
        ArrayList<AnswerOption> q17_options = new ArrayList<>();
        q17_options.add(new BranchableAnswerOption(1, "Partner"));
        q17_options.add(new BranchableAnswerOption(2, "Family"));
        q17_options.add(new BranchableAnswerOption(3, "Friend"));
        q17_options.add(new BranchableAnswerOption(4, "Classmate"));
        q17_options.add(new BranchableAnswerOption(5, "Colleague"));
        q17_options.add(new BranchableAnswerOption(6, "Stranger"));        
        
        MultipleChoiceMultipleAnswer question17 = new MultipleChoiceMultipleAnswer(questionNum, socialColumnPrefix + "WithOthers", q17_options, true);
        //question17.setTitle(socialStressTitle);
        question17.setQuestionText("I am with:");
        question17.setNextQuestionId(-1);
        questions.add(question17);
        questionNum++;
        
        // create survey file
        String json = SurveyHelper.toJson(questions, 
                Config.OutputDirectory + "survey_json.txt");

        // create SQL script and save to file
        DatabaseHelper.createDatabaseSqlFile(questions,
                Config.ExternalDatabaseUsername,
                Config.ExternalDatabasePassword,
                Config.OutputDirectory + "create_track_db.sql");
    }
    
    /**
     * 
     * @param questionNum first question number.
     * @return 
     */
    private static ArrayList<TrackQuestion> getRegulationStrategiesQuestions(
            int currentQuestionNum, 
            ArrayList<BranchableAnswerOption> likert_options,
            String emotionReported) {
        int questionNum = currentQuestionNum + 1;
        
        String requlationStrategiesTitle = "Regulation Strategies";
        //String subTitle = "In relation to feeling " + emotionReported + ".";
        String questionPrefix = "In relation to feeling <b>" + emotionReported + "</b>, how much are you:";
        String colPrefix = "Regulation_" + emotionReported + "_";
        
        ArrayList<TrackQuestion> questions = new ArrayList<>();
        
        LikertScaleQuestion question10 = new LikertScaleQuestion(questionNum, colPrefix + "ThinkingDifferently", false, likert_options);
        //question10.setTitle(requlationStrategiesTitle);
        //question10.setSubTitle(subTitle);
        question10.setQuestionPrefix(questionPrefix);
        question10.setQuestionText("Thinking about a situation differently?");
        questions.add(question10);
        questionNum++;
        
        LikertScaleQuestion question11 = new LikertScaleQuestion(questionNum, colPrefix + "CalmingYourself", false, likert_options);
        //question11.setTitle(requlationStrategiesTitle);
        //question11.setSubTitle(subTitle);
        question11.setQuestionPrefix(questionPrefix);
        question11.setQuestionText("Trying to calm yourself by taking deep breaths or relaxing your muscles?");
        questions.add(question11);
        questionNum++;
        
        LikertScaleQuestion question12 = new LikertScaleQuestion(questionNum, colPrefix + "Talking", false, likert_options);
        //question12.setTitle(requlationStrategiesTitle);
        //question12.setSubTitle(subTitle);
        question12.setQuestionPrefix(questionPrefix);
        question12.setQuestionText("Talking about your feelings and reactions with others?");
        questions.add(question12);
        questionNum++;
        
        LikertScaleQuestion question13 = new LikertScaleQuestion(questionNum, colPrefix + "HidingEmotions", false, likert_options);
        //question13.setTitle(requlationStrategiesTitle);
        //question13.setSubTitle(subTitle);
        question13.setQuestionPrefix(questionPrefix);
        question13.setQuestionText("Trying not to show your feelings on the outside?");
        questions.add(question13);
        questionNum++;
        
        LikertScaleQuestion question14 = new LikertScaleQuestion(questionNum, colPrefix + "TurningAttention", false, likert_options);
        //question14.setTitle(requlationStrategiesTitle);
        //question14.setSubTitle(subTitle);
        question14.setQuestionPrefix(questionPrefix);
        question14.setQuestionText("Turning your attention away from what is making you feel emotional?");
        questions.add(question14);
        questionNum++;
        
        LikertScaleQuestion question15 = new LikertScaleQuestion(questionNum, colPrefix + "ThinkingAboutEmotions", false, likert_options);
        //question15.setTitle(requlationStrategiesTitle);
        //question15.setSubTitle(subTitle);
        question15.setQuestionPrefix(questionPrefix);
        question15.setQuestionText("Thinking about your feelings over and over?");
        questions.add(question15);
        questionNum++;
        
        return questions;
    }
}
