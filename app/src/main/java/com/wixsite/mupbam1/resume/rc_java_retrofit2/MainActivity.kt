package com.wixsite.mupbam1.resume.rc_java_retrofit2

//https://www.youtube.com/watch?v=BZ_83Exc5Ko&t=267s

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.wixsite.mupbam1.resume.rc_java_retrofit2.adapter.PostAdapter
import com.wixsite.mupbam1.resume.rc_java_retrofit2.model.Post
import com.wixsite.mupbam1.resume.rc_java_retrofit2.retrofit.IMyAPI
import com.wixsite.mupbam1.resume.rc_java_retrofit2.retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    internal lateinit var jsonApi:IMyAPI
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init API
        val retrofit=RetrofitClient.instace
        jsonApi=retrofit.create(IMyAPI::class.java)

        //view
        recycler_posts.setHasFixedSize(true)
        recycler_posts.layoutManager=LinearLayoutManager(this)
        fetchData()
    }

    private fun fetchData() {
        compositeDisposable.add(jsonApi.posts
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{posts-> displayData(posts)}
        )
    }

    private fun displayData(posts: List<Post>) {
        val adapter=PostAdapter(this,posts!!)
        recycler_posts.adapter=adapter

    }
}