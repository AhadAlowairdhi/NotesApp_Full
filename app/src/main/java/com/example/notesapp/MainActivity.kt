package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var rvNotes: RecyclerView
    lateinit var notesList: ArrayList <String>
    lateinit var edtNote: EditText

    var note = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNote=findViewById(R.id.edtNote)

        rvNotes=findViewById(R.id.rvNotes)
        notesList = arrayListOf()
        rvNotes.adapter = NotesAdapter(notesList)
        rvNotes.layoutManager = LinearLayoutManager(this)



        var subBtn=findViewById(R.id.submBtn) as Button
        subBtn.setOnClickListener {
           addNote()
        }
    }

    fun addNote(){
        note=edtNote.text.toString()

        var dbh = DBhlpr(applicationContext)
        var status = dbh.saveData(note)
        Toast.makeText(applicationContext, "Note submitted successfully! "+status, Toast.LENGTH_LONG).show();

        rvNotes.adapter?.notifyDataSetChanged()
        edtNote.text.clear()
        edtNote.clearFocus()
    }
}