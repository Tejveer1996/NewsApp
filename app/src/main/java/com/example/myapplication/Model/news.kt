package com.example.myapplication.Model


// Name of the parameter should match exactly to the parameter in the given api
data class News (val totalResults:Int, val articles:List<Article>)
