package com.eee.homework3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eee.homework3.databinding.ActivityMainBinding
import com.eee.homework3.databinding.CommentListItemBinding
import com.eee.homework3.databinding.FragmentCommentListBinding
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response


class CommentListFragment : Fragment() {

    lateinit var binding: FragmentCommentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentCommentListBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CommentResponseListAdapter()
        binding.recyclerView.adapter = adapter

        CommentRestApi.getService().getAll().enqueue(object : Callback<List<CommentResponse>> {
            override fun onResponse(
                call: Call<List<CommentResponse>>,
                response: Response<List<CommentResponse>>
            ) {
               if (response.body() != null){
                   adapter.items = response.body()!!
               }
            }

            override fun onFailure(call: Call<List<CommentResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })








    }


}