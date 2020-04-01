package dev.emrizkiem.myblog.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dev.emrizkiem.myblog.data.db.MyBlogDao;
import dev.emrizkiem.myblog.data.db.MyBlogDatabase;
import dev.emrizkiem.myblog.data.model.Post;

public class PostRepository {

    private MyBlogDao myBlogDao;
    private ExecutorService executorService;

    public PostRepository(Application application) {
        MyBlogDatabase database = MyBlogDatabase.getDatabase(application);
        myBlogDao = database.myBlogDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insert(Post post) {
        executorService.execute(() -> myBlogDao.insert(post));
    }

    public void insert(List<Post> posts) {
        executorService.execute(() -> myBlogDao.insert(posts));
    }

    public void update(Post post) {
        executorService.execute(() -> myBlogDao.update(post));
    }

    public void delete(Post post) {
        executorService.execute(() -> myBlogDao.delete(post));
    }

    public LiveData<List<Post>> getAllPost() {
        return myBlogDao.getAllPost();
    }

}
