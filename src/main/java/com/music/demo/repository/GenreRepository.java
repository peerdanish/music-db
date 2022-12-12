package com.music.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.demo.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{
	
}
