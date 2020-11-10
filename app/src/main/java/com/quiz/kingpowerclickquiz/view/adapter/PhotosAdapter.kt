package com.quiz.kingpowerclickquiz.view.adapter

import android.annotation.SuppressLint
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.quiz.kingpowerclickquiz.R
import com.quiz.kingpowerclickquiz.api.model.response.Photo
import kotlinx.android.synthetic.main.activity_web_viw.*
import kotlinx.android.synthetic.main.item_photo.view.*


class PhotosAdapter(val photos: ArrayList<Photo>, val onPhotoListener: OnPhotoListener) : BaseAdapter<Photo>(
    items = photos
) {

    override fun render(holder: RecyclerView.ViewHolder, position: Int) {
        val photo = photos[position]
      //  Glide.with(holder.itemView.context).load(photo.url).into(holder.itemView.imageView)
        holder.itemView.textViewName.text = photo.title
        holder.itemView.webview.loadUrl(photo.thumbnailUrl)
        holder.itemView.webview.setOnTouchListener { v, event ->
            if (v.id == R.id.webview && event.action == MotionEvent.ACTION_UP){
                onPhotoListener.onItemSelect(photo)
            }
            return@setOnTouchListener false
        }
    }
    override fun getItemViewType(position: Int): Int {
        return R.layout.item_photo
    }

    interface OnPhotoListener{
        fun onItemSelect(photo: Photo)
    }
}