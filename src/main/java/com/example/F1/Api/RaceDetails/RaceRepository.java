package com.example.F1.Api.RaceDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {

//    @Query("SELECT s FROM s race s WHERE s.email = ?1")
//    Optional<Race> findRaceByName(String racename);


    //not needed as its already written
//    @Query("DELETE s FROM s race WHERE s.name = ?1")
//    Optional<Race> deleteRaceByName(String racename);
   // @Query("UPDATE s RACE ")



}
