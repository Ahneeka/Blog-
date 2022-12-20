package services;

import data.models.Post;
import dtos.request.CreatePostRequest;

import java.util.List;

public interface postService {
    void createPost(CreatePostRequest createPostRequest);
    void updatePost(int id, String title, String body);
    void deletePost(int id);
    Post viewPost(int id);

    List<Post> viewAllPost();

    List<Post> viewAll();
}
