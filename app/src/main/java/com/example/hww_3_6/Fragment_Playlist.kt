package com.example.hww_3_6


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import com.example.hww_3_6.databinding.FragmentPlaylistBinding


class PlaylistFragment : Fragment(), OnItemClick {

    private lateinit var binding: FragmentPlaylistBinding
    private lateinit var songList: ArrayList<SongData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlaylistBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        val adapter = PlaylistAdapter(songList, this)
        binding.recyclerView.adapter = adapter
    }

    private fun loadData() {
        songList = ArrayList<SongData>()

        songList.apply {
            add(SongData("1"," I got love", " Miyga/Эндшпиль","4:35"))
            add(SongData("2","Патрон", "Miyga/Andy Panda","3:35"))
            add(SongData("3"," Рапапам", "Miyga/ Эндшпиль","5:35"))
            add(SongData("4","Fire man", "Miyga/ Эндшпиль","3:38"))
            add(SongData("5","Самая", "Miaga/ Эндшпиль","4:52"))

        }
    }

    override fun onClick(tittle: String) {
        val bundle = Bundle()
        bundle.putString("", tittle)
        val songInfoFragment = SongInfoFragment()
        songInfoFragment.arguments = bundle
        requireActivity().supportFragmentManager.findFragmentById(R.id.container)?.view?.isGone = true
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container_second, songInfoFragment)
            .addToBackStack(null).commit()
    }
}