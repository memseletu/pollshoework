package com.poll.quick.poll.controller;

import com.poll.quick.poll.Repository.PollRepository;
import com.poll.quick.poll.model.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PollController {

    @Autowired
    private PollRepository pollRepository;

    @GetMapping(value = "/polls")
    public ResponseEntity<Iterable<Poll>> geAllPolls(){
    Iterable<Poll> allPolls = pollRepository.findAll();
    return new ResponseEntity<>(pollRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping(value="/polls")
    public ResponseEntity<?> createPoll(@RequestBody Poll poll) {
        poll = pollRepository.save(poll);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }


}

