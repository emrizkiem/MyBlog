package dev.emrizkiem.myblog.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import dev.emrizkiem.myblog.data.model.Post;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<Post>> getPost() {
        MutableLiveData<List<Post>> ldPostList = new MutableLiveData<>();
        List<Post> postList = new ArrayList<>();
        Post post = new Post();
        post.setUsername("emrizkiem");
        post.setCaption("Don't be shy to mistake because learn from mistake");
        post.setImagePath("https://i.ytimg.com/vi/zAGVQLHvwOY/maxresdefault.jpg");
        post.setAvatarPath("https://i.ytimg.com/vi/zAGVQLHvwOY/maxresdefault.jpg");
        postList.add(post);
        ldPostList.setValue(postList);
        return ldPostList;
    }
}