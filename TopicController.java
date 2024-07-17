package com.example.forumhub.controller;

import com.example.forumhub.model.Topic;
import com.example.forumhub.model.User;
import com.example.forumhub.repository.TopicRepository;
import com.example.forumhub.repository.UserRepository;
import com.example.forumhub.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping
    public List<Topic> listTopics() {
        return topicRepository.findAll();
    }

    @PostMapping
    public Topic createTopic(@RequestBody Topic topic, Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName()).orElseThrow();
        topic.setUser(user);
        return topicRepository.save(topic);
    }

    @PutMapping("/{id}")
    public Topic updateTopic(@PathVariable Long id, @RequestBody Topic topicDetails) {
        Topic topic = topicRepository.findById(id).orElseThrow();
        topic.setTitle(topicDetails.getTitle());
        topic.setMessage(topicDetails.getMessage());
        return topicRepository.save(topic);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicRepository.deleteById(id);
    }
}
