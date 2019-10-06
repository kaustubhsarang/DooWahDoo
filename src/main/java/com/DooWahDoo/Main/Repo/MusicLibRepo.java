package com.DooWahDoo.Main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DooWahDoo.Main.Model.MusicLibrary;

@Repository
public interface MusicLibRepo extends JpaRepository<MusicLibrary, Long> {

}
