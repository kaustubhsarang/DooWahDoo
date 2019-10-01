package com.DooWahDoo.Main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DooWahDoo.Main.Model.GigInfo;

@Repository
public interface GigInfoRepo extends JpaRepository<GigInfo, Long> {

}
