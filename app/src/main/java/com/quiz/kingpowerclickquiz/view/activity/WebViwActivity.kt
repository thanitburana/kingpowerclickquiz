package com.quiz.kingpowerclickquiz.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quiz.kingpowerclickquiz.R
import com.quiz.kingpowerclickquiz.api.model.response.Photo
import com.quiz.kingpowerclickquiz.utils.FragmentTAG
import com.quiz.kingpowerclickquiz.utils.FragmentUtil
import com.quiz.kingpowerclickquiz.view.ActivityNavigation
import com.quiz.kingpowerclickquiz.view.fragment.ToolbarFragment
import kotlinx.android.synthetic.main.activity_web_viw.*

class WebViwActivity : AppCompatActivity(),ToolbarFragment.OnToolbarListener {
    private lateinit var photo: Photo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_viw)

        FragmentUtil.replace(
            this,
            FragmentTAG.TAG_TOOLBAR_FRAGMENT.TAG,
            R.id.toolbar,
            ToolbarFragment.newInstance(title = resources.getString(R.string.toolbar_lorem_ipsum),onToolbarListener = this)
        )

        photo = intent.getParcelableExtra(ActivityNavigation.TAG_PHOTO)
        webview.loadUrl(photo.thumbnailUrl)

    }

    override fun onBank() {
        finish()
    }

    override fun onBackPressed() {
        finish()
    }

}