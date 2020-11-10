package com.quiz.kingpowerclickquiz.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.quiz.kingpowerclickquiz.R
import com.quiz.kingpowerclickquiz.api.model.response.Photo
import com.quiz.kingpowerclickquiz.utils.FragmentTAG
import com.quiz.kingpowerclickquiz.utils.FragmentUtil
import com.quiz.kingpowerclickquiz.view.ActivityNavigation
import com.quiz.kingpowerclickquiz.view.adapter.PhotosAdapter
import com.quiz.kingpowerclickquiz.view.fragment.ToolbarFragment
import com.quiz.kingpowerclickquiz.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity(),PhotosAdapter.OnPhotoListener {
    private lateinit var  viewModel : MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        toolbar()
        initView()
    }

    private fun toolbar(){
        FragmentUtil.replace(
            this,
            FragmentTAG.TAG_TOOLBAR_FRAGMENT.TAG,
            R.id.toolbar,
            ToolbarFragment.newInstance(title = resources.getString(R.string.toolbar_lorem_ipsum))
        )
    }

    private fun initView(){
        recyclerViewPhotos.layoutManager = GridLayoutManager(this,2)
        viewModel.getPhotos(this@MainActivity).observe(this, Observer {
            recyclerViewPhotos.adapter = PhotosAdapter(it as ArrayList<Photo>,this)
        })
    }

    override fun onItemSelect(photo: Photo) {
        ActivityNavigation.gotoWebViewActivity(this,photo)
    }

    override fun onBackPressed() {
        finish()
    }
}