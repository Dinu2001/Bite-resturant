package com.Bite_resturant.service;

import com.Bite_resturant.dto.FeedbackDto;
import com.Bite_resturant.entity.Feedback;
import com.Bite_resturant.repo.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepo feedbackRepo;


    public String saveFeedback(FeedbackDto feedbackDto) {
        try{
            Feedback feedback = new Feedback(feedbackDto.getId(),feedbackDto.getFirstName(),
                    feedbackDto.getLastName(),feedbackDto.getFeedback(),feedbackDto.getRatting());

            Feedback saved = feedbackRepo.save(feedback);
            if(saved==null){
                return null;
            }else{
                return "feedback save";
            }
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


    public List<FeedbackDto> getAllFeedback() {
        try{
            List<FeedbackDto> feedbackDtos = new ArrayList<>();
            List<Feedback> feedbacks = feedbackRepo.findAll();
            for(Feedback feedback:feedbacks){
                FeedbackDto feedbackDto = new FeedbackDto(
                        feedback.getId(),feedback.getFirstName(),feedback.getLastName(),feedback.getFeedback(),
                        feedback.getRatting()
                );
                feedbackDtos.add(feedbackDto);
            }
            return feedbackDtos;
        }catch (Exception ex){
            System.out.println(ex);
            return null;
        }

    }
}
