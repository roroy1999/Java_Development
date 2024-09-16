package com.telusko.questionservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
	private String difficultylevel;
    private String category;
    @Override
    public String toString() {
    	return "Question [id=" + id + ", questionTitle=" + questionTitle + ", option1=" + option1 + ", option2="
    			+ option2 + ", option3=" + option3 + ", option4=" + option4 + ", rightAnswer=" + rightAnswer
    			+ ", difficultylevel=" + difficultylevel + ", category=" + category + "]";
    }
    


}
