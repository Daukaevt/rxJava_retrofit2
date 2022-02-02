package com.wixsite.mupbam1.resume.rc_java_retrofit2.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post_layout.view.*

class PostViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    val txt_title=itemView.txt_title
    val txt_autor=itemView.txt_autor
    val txt_content=itemView.txt_content
}