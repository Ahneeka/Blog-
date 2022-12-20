package services;

import data.models.Post;
import dtos.request.CreatePostRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostServiceImplTest {
private postService postService;
    @BeforeEach
   public void setUp() {
       postService = new PostServiceImpl();
    }
    @Test
    public void createPostTest(){
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setBody("Egusi is my best soup");
        createPostRequest.setTitle("New post");
        postService.createPost(createPostRequest);

        assertEquals(1L,postService.viewAllPost().size());
    }
    @Test
    public  void  viewPostTest(){
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setBody("Egusi is my best soup");
        createPostRequest.setTitle("NewPost");
        postService.createPost(createPostRequest);
        assertEquals(1,postService.viewAll().size());

        Post post = postService.viewPost(1);
        assertEquals("NewPost",post.getTitle());
        assertEquals("Egusi is my best soup",post.getBody());
        assertNotNull(post.getCreationTime());

    }
}