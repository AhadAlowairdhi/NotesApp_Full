package com.example.notesapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.NoteRowBinding

class NotesAdapter(var notesList: ArrayList <String>): RecyclerView.Adapter<NotesAdapter.ItemViewHolder>() {
    class ItemViewHolder(var binding: NoteRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            NoteRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val aNote = notesList[position]

        holder.binding.apply {
            tvNote.text = aNote
        }
    }

    override fun getItemCount(): Int = notesList.size
}