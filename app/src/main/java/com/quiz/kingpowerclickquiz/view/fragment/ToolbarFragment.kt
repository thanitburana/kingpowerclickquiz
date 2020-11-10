package com.quiz.kingpowerclickquiz.view.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.quiz.kingpowerclickquiz.R
import kotlinx.android.synthetic.main.toolbar_fragment.*

class ToolbarFragment : Fragment() {
    private var onToolbarListener:OnToolbarListener?=null
    private lateinit var title : String
    companion object {
        fun newInstance(onToolbarListener:OnToolbarListener?=null,title : String) = ToolbarFragment().apply {
            this.onToolbarListener = onToolbarListener
            this.title = title
        }
    }

    private lateinit var viewModel: ToolbarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.toolbar_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ToolbarViewModel::class.java)
        // TODO: Use the ViewModel
        initView()
    }

    private fun initView(){
        textView_title.text = title
        if (onToolbarListener == null){
            imageView_icon_back.visibility = View.GONE
        }else{
            imageView_icon_back.visibility = View.VISIBLE
            imageView_icon_back.setOnClickListener {
                onToolbarListener!!.onBank()
            }
        }
    }

    interface OnToolbarListener{
        fun onBank()
    }
}