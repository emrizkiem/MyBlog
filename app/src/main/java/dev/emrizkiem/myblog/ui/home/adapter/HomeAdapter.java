package dev.emrizkiem.myblog.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import dev.emrizkiem.myblog.R;
import dev.emrizkiem.myblog.data.model.Post;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Holder> {

    private List<Post> posts;

    public HomeAdapter(List<Post> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Context context = holder.itemView.getContext();
        Post post = posts.get(position);
        holder.tvUsername.setText(post.getUsername());
        String captionDisplay = getCaptionDisplay(post);
        holder.tvCaption.setText(HtmlCompat.fromHtml(captionDisplay, HtmlCompat.FROM_HTML_MODE_COMPACT));
        Glide.with(context)
                .load(post.getAvatarPath())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.ivAvatar);
        Glide.with(context)
                .load(post.getImagePath())
                .into(holder.ivPostImage);
    }

    private String getCaptionDisplay(Post post) {
        return "<b>" + post.getUsername() + "</b>" + " " + post.getCaption();
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        TextView tvUsername;
        TextView tvCaption;
        ImageView ivPostImage;
        ImageView ivAvatar;

        public Holder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.post_owner_username);
            tvCaption = itemView.findViewById(R.id.post_caption);
            ivPostImage = itemView.findViewById(R.id.post_image);
            ivAvatar = itemView.findViewById(R.id.post_owner_avatar);
        }
    }
}
