package com.music.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.demo.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{

	List<Album> findByGenreId(Long genreId);
	
}
