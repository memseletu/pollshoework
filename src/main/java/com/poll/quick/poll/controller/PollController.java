package com.poll.quick.poll.controller;

import com.poll.quick.poll.Repository.PollRepository;
import com.poll.quick.poll.model.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PollController {

    @Autowired
    private PollRepository pollRepository;

    @GetMapping(value = "/polls")
    public ResponseEntity<Iterable<Poll>> geAllPolls() {
        Iterable<Poll> allPolls = pollRepository.findAll();
        return new ResponseEntity<>(pollRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/polls")
    public ResponseEntity<?> createPoll(@RequestBody Poll poll) {
        poll = pollRepository.save(poll);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping(value = "/polls/{pollId}")
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        Optional <Poll> poll = pollRepository.findById(pollId);
        return new ResponseEntity<>(poll, HttpStatus.OK);

    }
    @PutMapping(value="/polls/{pollId}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        // Save the entity
        Poll p = pollRepository.save(poll);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/polls/{pollId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        pollRepository.deleteById(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

