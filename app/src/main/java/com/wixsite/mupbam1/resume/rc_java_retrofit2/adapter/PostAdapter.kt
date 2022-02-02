package com.wixsite.mupbam1.resume.rc_java_retrofit2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wixsite.mupbam1.resume.rc_java_retrofit2.R
import com.wixsite.mupbam1.resume.rc_java_retrofit2.model.Post
import com.wixsite.mupbam1.resume.rc_java_retrofit2.model.PostItem
import java.lang.StringBuilder

class PostAdapter(internal var context: Context, internal var postList: List<Post>)
    :RecyclerView.Adapter<PostViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.post_layout,parent,false)

        return PostViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.txt_autor.text = postList[position].userId.toString()
        holder.txt_title.text = postList[position].title
        holder.txt_content.text = StringBuilder(postList[position].body.substring(0,20))
            .append("...").toString()
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}