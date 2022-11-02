package com.poll.quick.poll.controller;

import com.poll.quick.poll.model.Poll;
import com.poll.quick.poll.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PollController {

    @Autowired
    private PollService pollService;


    @GetMapping("/polls")
    public ResponseEntity<Iterable<Poll>> geAllPolls() {
        return pollService.geAllPolls();
    }

    @PostMapping("/polls")
    public void createPoll(@Valid @RequestBody Poll poll) {
          pollService.createPoll(poll);
    }

    @GetMapping("/polls/{pollId}")
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        return pollService.getPoll(pollId);
    }

    @PutMapping("/polls/{pollId}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        return pollService.updatePoll(poll,pollId);
    }

    @DeleteMapping("/polls/{pollId}")
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        return pollService.deletePoll(pollId);
    }



}

