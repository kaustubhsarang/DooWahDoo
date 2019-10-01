package com.DooWahDoo.Main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DooWahDoo.Main.Model.DjProfile;

@Repository
public interface DjRepo extends JpaRepository<DjProfile, Long> {

}
