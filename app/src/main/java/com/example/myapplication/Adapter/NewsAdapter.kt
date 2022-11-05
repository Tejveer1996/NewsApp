package com.example.myapplication.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.myapplication.Activities.DetailActivity
import com.example.myapplication.Model.Article
import com.example.myapplication.R
import com.example.myapplication.R.layout.newsitem_layout
import kotlinx.android.synthetic.main.newsitem_layout.view.*


class NewsAdapter(private val context: Context, private val articles: List<Article>) :
    Adapter<NewsAdapter.ArticleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(newsitem_layout,parent,false)    // here, converting the JSON into JAVA objects
        return ArticleViewHolder(view)
    }


    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]    // here, pointing the position of the article
        holder.newsTitle.text = article.title  // Binding title with holder
        holder.newsDescription.text = article.description  // Binding description with holder
        Glide.with(context).load(article.urlToImage)
            .into(holder.newsImage)  // Binding imageUrl with holder using glide library
        holder.itemView.setOnClickListener {
            Toast.makeText(context, article.title, Toast.LENGTH_SHORT).show()
            val intent =
                Intent(context, DetailActivity::class.java)  // intention for detailActivity
            intent.putExtra("URL", article.url) // Calling article's url
            context.startActivity(intent)  // starting the intent

        }
        holder.itemView.shareImage.setOnClickListener {
            val message: String =
                "LATEST NEWS : " + article.title + "\n" + article.description + "\n" + article.url
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            context.startActivity(Intent.createChooser(intent, "SELECT THE APP TO SHARE"))
        }

    }

    override fun getItemCount(): Int {
        return articles.size
    }


    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var newsImage: ImageView = itemView.findViewById(R.id.newsImage)
        var newsTitle = itemView.findViewById<TextView>(R.id.newsTitle)
        var newsDescription = itemView.findViewById<TextView>(R.id.newsDescription)

        var shareImage = itemView.findViewById<ImageView>(R.id.shareImage)


    }


}