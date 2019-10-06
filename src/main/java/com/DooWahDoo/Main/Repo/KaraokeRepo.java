package com.DooWahDoo.Main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DooWahDoo.Main.Model.KaraokeSession;

@Repository
public interface KaraokeRepo extends JpaRepository<KaraokeSession, Long> {

}
