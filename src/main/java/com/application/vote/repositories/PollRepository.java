package com.application.vote.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.vote.model.Poll;

@Repository
public  interface PollRepository extends JpaRepository<Poll, Long> {

}
