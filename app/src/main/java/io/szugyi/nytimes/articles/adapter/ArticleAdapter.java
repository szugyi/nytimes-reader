package io.szugyi.nytimes.articles.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.szugyi.nytimes.R;
import io.szugyi.nytimes.data.model.Article;
import io.szugyi.nytimes.util.ArticleUtil;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private List<Article> items = new ArrayList<>();

    @Inject
    public ArticleAdapter() {

    }

    public Article getItemAt(int position) {
        return items.get(position);
    }

    public void swapItems(List<Article> newItems) {
        items.clear();

        if (newItems != null) {
            items.addAll(newItems);
        }

        notifyDataSetChanged();
    }

    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_article, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Article article = items.get(position);

        holder.author.setText(article.getByline());
        holder.date.setText(article.getPublishedDate());
        holder.title.setText(article.getTitle());
        holder.acrticleAbstract.setText(article.getAbstract());

        String imageUrl = ArticleUtil.getImageUrl(article);

        if (imageUrl != null) {
            holder.image.setVisibility(View.VISIBLE);
            Picasso.with(holder.itemView.getContext())
                    .load(imageUrl)
                    .fit()
                    .into(holder.image);
        } else {
            holder.image.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView author;
        TextView date;
        TextView title;
        TextView acrticleAbstract;

        public ViewHolder(View row) {
            super(row);
            image = row.findViewById(R.id.image);
            author = row.findViewById(R.id.author);
            date = row.findViewById(R.id.date);
            title = row.findViewById(R.id.title);
            acrticleAbstract = row.findViewById(R.id.article_abstract);
        }
    }
}



