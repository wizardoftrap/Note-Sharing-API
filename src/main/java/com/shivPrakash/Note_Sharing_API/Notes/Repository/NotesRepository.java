package com.shivPrakash.Note_Sharing_API.Notes.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivPrakash.Note_Sharing_API.Notes.bean.Note;

public interface NotesRepository extends JpaRepository<Note,Long> {
	public List<Note> findByTitle(String title);
	public List<Note> findByDepartment(String department );
	public List<Note> findByField(String field);
	public List<Note> findByOwner(String owner);

}
