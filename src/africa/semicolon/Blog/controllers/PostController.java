package controllers;

import data.models.Post;
import dtos.request.CreatePostRequest;
import services.PostServiceImpl;

public class PostController {
    private services.postService postService = new PostServiceImpl();
    public String createPost(CreatePostRequest createPostRequest){
        postService.createPost(createPostRequest);
        return "sucessful";
    }
    public Post viewpost(int postId){
        return postService.viewPost(postId);
    }
}