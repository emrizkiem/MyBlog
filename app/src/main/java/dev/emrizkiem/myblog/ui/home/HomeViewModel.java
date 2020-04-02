package dev.emrizkiem.myblog.ui.home;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import dev.emrizkiem.myblog.data.model.Post;
import dev.emrizkiem.myblog.data.repository.PostRepository;

public class HomeViewModel extends ViewModel {

    private PostRepository postRepository;

    public HomeViewModel(Application mApplication) {
        postRepository = new PostRepository(mApplication);
    }

    public LiveData<List<Post>> getPost() {
        return postRepository.getAllPost();
    }

    public List<Post> getMock() {
        List<Post> postList = new ArrayList<>();
        Post post = new Post();
        post.setUsername("emrizkiem");
        post.setCaption("Don't be shy to mistake because learn from mistake");
        post.setImagePath("https://avatars0.githubusercontent.com/u/26673503?s=400&u=0e18d02456aba966bb18f7724aaf82c49d7de451&v=4");
        post.setAvatarPath("https://avatars0.githubusercontent.com/u/26673503?s=400&u=0e18d02456aba966bb18f7724aaf82c49d7de451&v=4");
        postList.add(post);
        return postList;
    }
}