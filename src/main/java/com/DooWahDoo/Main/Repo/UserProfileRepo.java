package com.DooWahDoo.Main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DooWahDoo.Main.Model.UserProfile;

@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile, Long> {

}
