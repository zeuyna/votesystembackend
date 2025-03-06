package com.application.vote.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.vote.model.Poll;
import com.application.vote.request.Vote;
import com.application.vote.services.PollService;

@RestController
@RequestMapping("/api/polls")
public class PollController {

    private  final PollService pollService;                                                      

    
   public PollController(PollService pollService) {
        this.pollService = pollService;
    }
    
    @PostMapping // Ajout de l'annotation pour exposer la méthode en POST
    public Poll createPoll(@RequestBody Poll poll){
    return pollService.createPoll(poll);
   }
   
   @GetMapping
   public List<Poll> getAllPolls(){
    return pollService.getAllPolls();
}

@GetMapping("/{id}")
public ResponseEntity<Poll> getPoll(@PathVariable Long id){
 return pollService.getPollById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.noContent().build());
}

//POST
//VOTE
// SERVICE
@PostMapping("/vote")
public void vote(@RequestBody Vote vote){
    pollService.vote(vote.getPollId(),vote.getGetOptionIndex());
}


}
