package com.bayu.submission1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bayu.submission1.databinding.ActivityUserDetailBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetail : AppCompatActivity() {
    private lateinit var bindingD: ActivityUserDetailBinding
    private lateinit var viewModel: UserDetailViewModel

    companion object {
        var EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingD = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(bindingD.root)

        supportActionBar?.setDisplayShowHomeEnabled(true)


        val username = intent.getStringExtra(EXTRA_DATA)
        val bundle = Bundle()
        bundle.putString(EXTRA_DATA, username)


        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(UserDetailViewModel::class.java)

        if (username != null) {
            viewModel.setUserDetail(username)
        }
        viewModel.getUserDetail().observe(this, {
            if (it != null) {
                bindingD.apply {
                    tvName.text = it.name
                    tvUsername.text = it.login
                    tvCompany.text = it.company
                    tvLocation.text = it.location
                    tvFollowers.text = "${it.followers}\n${getString(R.string.followers)}"
                    tvFollowing.text = "${it.following}\n${getString(R.string.following)}"
                    tvRepository.text = "${it.public_repos}\n${getString(R.string.repository)}"
                    Glide.with(this@UserDetail)
                        .load(it.avatar_url)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .centerCrop()
                        .into(ivAvatar)

                    title = tvUsername.text

                }
            }
        })
        val PagerAdapter = PagerAdapter(this, supportFragmentManager, bundle)
        bindingD.apply {
            viewPager.adapter = PagerAdapter
            tab.setupWithViewPager(viewPager)
        }
    }
}