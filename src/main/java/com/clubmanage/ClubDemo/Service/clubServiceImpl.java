package com.clubmanage.ClubDemo.Service;


import com.clubmanage.ClubDemo.Pojo.Club;
import com.clubmanage.ClubDemo.mapper.ClubMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class clubServiceImpl implements clubService {
    @Autowired
    private ClubMapper clubMapper;


    @Override
    public Club findClubById(Integer id) {
        return clubMapper.findClubById(id);
    }

    @Override
    public List<Club> selectClubAll() {
        return this.clubMapper.selectClubAll();
    }

    @Override
    public void addClub(Club club) {
        this.clubMapper.addClub(club);
    }

    @Override
    public void updateClub(Club users) {
        this.clubMapper.updateClub(users);

    }

    @Override
    public void deleteClub(Integer id) {
        this.clubMapper.deleteClub(id);
    }

    @Override
    public List<Club> findClubByName(String name) {
        return this.clubMapper.findClubByName(name);

    }

}
