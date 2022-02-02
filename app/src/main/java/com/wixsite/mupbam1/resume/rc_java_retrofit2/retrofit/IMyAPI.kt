package com.wixsite.mupbam1.resume.rc_java_retrofit2.retrofit

import com.wixsite.mupbam1.resume.rc_java_retrofit2.model.Post
import com.wixsite.mupbam1.resume.rc_java_retrofit2.model.PostItem
import io.reactivex.Observable
import retrofit2.http.GET

interface IMyAPI {
    @get:GET("posts")
    val posts:Observable<List<Post>>

}