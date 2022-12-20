package services;

import data.models.Post;
import data.repositories.PostRepository;
import data.repositories.PostRepositoryImpl;
import dtos.request.CreatePostRequest;

import java.util.List;

public class PostServiceImpl implements postService {
 private PostRepository postRepository = new PostRepositoryImpl();

    @Override
    public void createPost(CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setBody(createPostRequest.getBody());
        post.setTitle(createPostRequest.getTitle());
        postRepository.save(post);
    }

    @Override
    public void updatePost(int id, String title, String body) {

    }

    @Override
    public void deletePost(int id) {

    }

    @Override
    public Post viewPost(int id) {

        return postRepository.findById(id);
    }

    @Override
    public List<Post> viewAllPost() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> viewAll() {
        return postRepository.findAll();
    }
}
