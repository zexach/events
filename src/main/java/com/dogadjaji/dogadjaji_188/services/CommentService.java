package com.dogadjaji.dogadjaji_188.services;

import com.dogadjaji.dogadjaji_188.models.Comment;
import com.dogadjaji.dogadjaji_188.models.Event;
import com.dogadjaji.dogadjaji_188.models.User;
import com.dogadjaji.dogadjaji_188.repositories.CommentRepository;
import com.dogadjaji.dogadjaji_188.repositories.EventsRepository;
import com.dogadjaji.dogadjaji_188.repositories.UserRepository;
import com.dogadjaji.dogadjaji_188.requests.CommentRequest;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final EventsRepository eventsRepository;
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, EventsRepository eventsRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.eventsRepository = eventsRepository;
        this.userRepository = userRepository;
    }

    public void addComment(CommentRequest commentRequest){
        Event event = eventsRepository.findById(commentRequest.getEventID()).orElseThrow();
        User user = userRepository.findById(commentRequest.getUserID()).orElseThrow();

        Comment comment = new Comment();
        comment.setText(commentRequest.getText());
        comment.setDate(commentRequest.getDate());
        comment.setEvent(event);
        comment.setUser(user);

        commentRepository.save(comment);
    }
}
