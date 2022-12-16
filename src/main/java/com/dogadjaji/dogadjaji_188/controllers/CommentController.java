package com.dogadjaji.dogadjaji_188.controllers;

import com.dogadjaji.dogadjaji_188.requests.CommentRequest;
import com.dogadjaji.dogadjaji_188.services.CommentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    public final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public String addComment(@RequestBody CommentRequest commentRequest){
        commentService.addComment(commentRequest);
        return "You added new comment successfully!";
    }
}
