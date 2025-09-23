package com.Bite_resturant.controller;

import com.Bite_resturant.dto.FeedbackDto;
import com.Bite_resturant.repo.FeedbackRepo;
import com.Bite_resturant.service.FeedbackService;
import com.Bite_resturant.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/feedback")
@CrossOrigin(origins = "http://localhost:5173")
public class FeedbackController {
    @Autowired
    private FeedbackRepo feedbackRepo;

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> feedbackSave(@RequestBody FeedbackDto feedbackDto){
        String message = feedbackService.saveFeedback(feedbackDto);
        StandardResponse response;
        if(message==null){
            response = new StandardResponse(404,message,null);
        }else{
            response = new StandardResponse(200,message,null);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<StandardResponse> getAllFeedback(){
        List<FeedbackDto> allFeedback = feedbackService.getAllFeedback();
        StandardResponse response;
        if(allFeedback==null){
            response = new StandardResponse(404,null,null);
        }else{
            response = new StandardResponse(200,"all feedback",allFeedback);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}
