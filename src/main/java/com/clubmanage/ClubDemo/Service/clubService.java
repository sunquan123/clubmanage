package com.clubmanage.ClubDemo.Service;

import com.clubmanage.ClubDemo.Pojo.Club;

import java.util.List;

public interface clubService {
    Club findClubById(Integer id);

    List<Club> selectClubAll();

    void addClub(Club club);

    void updateClub(Club users);

    void deleteClub(Integer id);

    List<Club> findClubByName(String name);
}
