package com.example.myapplication.Activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Adapter.NewsAdapter
import com.example.myapplication.Model.Article
import com.example.myapplication.Model.NewServices
import com.example.myapplication.Model.News
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsActivity : AppCompatActivity() {
    lateinit var adapter: NewsAdapter
    var articles = mutableListOf<Article>()
    var pageNum = 1
    var totalResults = -1
    var articlesLength=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        getNews()

        adapter = NewsAdapter(this@NewsActivity, articles)
        newsList.adapter = adapter // accessing recyclerView
        newsList.layoutManager = LinearLayoutManager(this@NewsActivity) // setting orientation of itemView in recycler view
    }

    private fun getNews() {
        val news = NewServices.newsInstance.getHeadline("in", pageNum)
        //Enqueuing the pages of news
        news.enqueue(object : Callback<News> {

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("News", "Error occurred", t)
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()

                if (news != null) {
                     Log.d("News", news.toString())
                    totalResults = news.totalResults // here , we get the total no. of pages there in the api
                    articles.addAll(news.articles)   // adding articles to above mutable list of  Article
                    adapter.notifyDataSetChanged()  // telling the adapter that item is changed

                    Log.d("result","totalResult - ${totalResults}-\n total article - ${articles.size}")
                   // articlesLength = news.articles.size
                    if (totalResults > articles.size ){


                        pageNum++
                        getNews()
                    }


                }

            }


        })
    }
}