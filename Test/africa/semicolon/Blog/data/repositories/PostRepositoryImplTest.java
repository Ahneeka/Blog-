package data.repositories;

import data.models.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryImplTest {
    PostRepository postRepository;
@BeforeEach
    void setUp() {
    postRepository = new PostRepositoryImpl();
}

    @Test
  public  void saveNewPost_countShouldBeOne_Test() {
        Post post = new Post();
        post.setBody("Our post body");
        post.getTitle("Our Post title");

        postRepository.save(post);

        assertEquals(1L,postRepository.count());
    }

    @Test
        public  void savedNewPost_findById_shouldReturnSavedPostTest(){
        Post post = new Post();
        post.setBody("Our post body");
        post.getTitle("Our Post title");
        postRepository.save(post);
        assertEquals(1L
                ,postRepository.count());

        Post savedPost = postRepository.findById(1);
        assertEquals(post, savedPost);
        Post post2 = new Post();
        postRepository.save(post2);
        assertEquals(post2,postRepository.findById(2));
    }
    @Test
    public void  saveNewPost_UpdatePost_CountIsOneTest(){
        Post post = new Post();
        post.setBody("Our post body");
        post.getTitle("Our Post title");
        postRepository.save(post);

        Post updatePost = new Post();
        updatePost.setId(1);
        updatePost.setBody("updated body");
        updatePost.setTitle("updated title");
        postRepository.save(updatePost);
        assertEquals(1L,postRepository.count());
        assertEquals(post, postRepository.findById(1));
        assertEquals("updated body",post.getBody());
        assertEquals("updated title", post.getTitle());
    }
    @Test
    public  void deleteItem_countIsZeroTest(){
        Post post = new Post();
        post.setBody("Our post body");
        post.getTitle("Our Post title");
        postRepository.save(post);

        assertEquals(1L,postRepository.count());
        postRepository.delete(1);
        assertEquals(0L,postRepository.count());
    }

    }
