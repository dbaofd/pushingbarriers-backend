package org.pushingbarriers.bgsystem.task;

import lombok.extern.slf4j.Slf4j;
import org.pushingbarriers.bgsystem.dao.TeamDao;
import org.pushingbarriers.bgsystem.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by baodong on 2020/1/21.
 */
@Slf4j
@Component
public class GenerateGameTrips {
    @Autowired
    private TeamDao teamDao;

    @Scheduled(cron="0 19 21 ? * TUE")
    public void schduledTest(){
        System.out.println("你好");
        List<Team> team = teamDao.findTeamByTeamName("KOKOKO");
        for(int i=0;i<team.size();i++){
            System.out.println(team.get(i).getTeamName());
        }
    }
}
