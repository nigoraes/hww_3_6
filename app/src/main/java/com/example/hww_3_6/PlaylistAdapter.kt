package com.example.hww_3_6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.hww_3_6.databinding.ItemPlaylistBinding

class PlaylistAdapter(private val songList: List<SongData>, private val onItemClick: OnItemClick):
    Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(ItemPlaylistBinding.inflate(LayoutInflater.
        from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = songList.size


    inner class PlaylistViewHolder(private val binding: ItemPlaylistBinding) : ViewHolder(binding.root) {
        fun bind(){

            val item = songList[adapterPosition]

            itemView.setOnClickListener {
                onItemClick.onClick(tittle = binding.tvSongName.text.toString())
            }

            binding.apply {
                tvNumber.text = item.number
                tvSongName.text = item.name
                tvSinger.text = item.singer
                tvTime.text = item.time
            }
        }
    }
}