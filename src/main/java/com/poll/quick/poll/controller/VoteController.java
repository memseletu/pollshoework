package com.poll.quick.poll.controller;

import com.poll.quick.poll.Repository.VoteRepository;
import com.poll.quick.poll.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class VoteController {

    @Autowired
    private VoteRepository voteRepository;

    @RequestMapping(value="/polls/{pollId}/votes", method= RequestMethod.POST)
    public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote vote) {
        vote = voteRepository.save(vote);
// Set the headers for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").buildAndExpand(vote.getId()).toUri());
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value="/polls/{pollId}/votes", method=RequestMethod.GET)
    public Iterable<Vote> getAllVotes(@PathVariable Long pollId) {
        return voteRepository. findByPoll(pollId);
    }

//    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.GET)
//    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
//        Poll p = pollRepository.findOne(pollId);
//        if(p == null) {
//            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
}
