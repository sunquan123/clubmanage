package com.clubmanage.ClubDemo.mapper;

import com.clubmanage.ClubDemo.Pojo.Club;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubMapper {
    void addClub(Club club);
    List<Club> selectClubAll();
    Club findClubById(Integer id);
    List<Club> findClubByName(String name);
    void updateClub(Club users);
    void deleteClub(Integer id);
}
