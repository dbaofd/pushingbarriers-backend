package org.pushingbarriers.bgsystem.task;

import lombok.extern.slf4j.Slf4j;
import org.pushingbarriers.bgsystem.dao.*;
import org.pushingbarriers.bgsystem.model.*;
import org.pushingbarriers.bgsystem.util.MyTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by baodong on 2020/1/21.
 */
@Slf4j
@Component
public class SchedulingTasks {
    @Autowired
    private GameDao gameDao;

    @Autowired
    private GameTripDao gameTripDao;

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private UpdatetimeDao updatetimeDao;

    @Autowired
    private TrainingtemplateDao trainingtemplateDao;

    @Autowired
    private TrainingDao trainingDao;

    @Autowired
    private TripDao tripDao;

    @Scheduled(cron="0 25 02 ? * SAT")
    public void generateWeeklyTraining(){
        List<Training> trainingtemplates=trainingtemplateDao.findAllTrainingTemplate();
        for(int i=0;i<trainingtemplates.size();i++){
            if(trainingtemplates.get(i).getTrainingDay().equals("Monday")){
                trainingtemplates.get(i).setTrainingDate(MyTools.getNextWeekMonday());
            }else if(trainingtemplates.get(i).getTrainingDay().equals("Tuesday")){
                trainingtemplates.get(i).setTrainingDate(MyTools.getNextWeekTuesday());
            }else if(trainingtemplates.get(i).getTrainingDay().equals("Wednesday")){
                trainingtemplates.get(i).setTrainingDate(MyTools.getNextWeekWednesday());
            }else if(trainingtemplates.get(i).getTrainingDay().equals("Thursday")){
                trainingtemplates.get(i).setTrainingDate(MyTools.getNextWeekThursday());
            }else if(trainingtemplates.get(i).getTrainingDay().equals("Friday")){
                trainingtemplates.get(i).setTrainingDate(MyTools.getNextWeekFriday());
            }
        }
        List<Trip> tripsFromTraining=trainingDao.findAllTrainings();
        if(tripsFromTraining.size()>0) {
            tripDao.saveAll(tripsFromTraining);//before truncating the training table, insert all the trainings into trip table
        }else{
            System.out.println("No training trip this week.");
        }
        if(updatetimeDao.existsGameUpdateTimeByGameupdatetimeId(2)){
            GameUpdateTime gameUpdateTime=updatetimeDao.findGameUpdateTimeByGameupdatetimeId(2);
            gameUpdateTime.setGameupdatetimeDate(new Date());
            updatetimeDao.save(gameUpdateTime);
        }else{
            GameUpdateTime gameUpdateTime=new GameUpdateTime();
            gameUpdateTime.setGameupdatetimeDate(new Date());
            updatetimeDao.save(gameUpdateTime);
        }
        trainingDao.truncateMyTable();
        trainingDao.saveAll(trainingtemplates);
        System.out.println("Weekly trainings have been generated");
    }

    @Scheduled(cron="0 30 16 ? * THU")
    public void generateWeeklyGameTrip(){
        Date startDate=MyTools.getLastWeekSunday();
        Date endDate=MyTools.getThisWeekSunday();
        List<Game> games=gameDao.findGamesByGameDateBetween(startDate,endDate);
        List<Team> teams=teamDao.findAll();
        Map<Integer,Team> teamsMap=new HashMap<>();
        List<GameTrip> gameTripList=new ArrayList<>();
        int i,j;
        Integer teamId;
        for(i=0;i<teams.size();i++){
            teamsMap.put(teams.get(i).getTeamId(),teams.get(i));
        }
        //List<Player> players=playerDao.findAll();
        //gameTripDao.truncateMyTable();
        //get day of the week for the date
        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
        for(i=0;i<games.size();i++){
            teamId=games.get(i).getGameTeamId();
            //System.out.println("*********************************");
            if(teamsMap.containsKey(teamId)) {
                for (j = 0; j < teamsMap.get(teamId).getPlayerList().size(); j++) {
                    Player player = teamsMap.get(teamId).getPlayerList().get(j);
//                System.out.println(games.get(i).getGameDate()+" "+dateFm.format(games.get(i).getGameDate())+" "
//                +games.get(i).getGameTime()+" "+games.get(i).getGameTeam()+" "+games.get(i).getGameAddress()+
//                " "+player.getPlayerName()+ " "+player.getPlayerId()+" "+player.getPlayerGender()+" "+player.getPlayerAddress());
                    GameTrip gameTrip = new GameTrip();
                    gameTrip.setTripDate(games.get(i).getGameDate());
                    gameTrip.setTripDay(dateFm.format(games.get(i).getGameDate()));
                    gameTrip.setTripTime(games.get(i).getGameTime());
                    gameTrip.setTripTeam(games.get(i).getGameTeam());
                    gameTrip.setTripAddress(games.get(i).getGameAddress());

                    gameTrip.setTripPlayer(player.getPlayerName());
                    gameTrip.setTripPlayerId(player.getPlayerId());
                    gameTrip.setTripPlayerGender(player.getPlayerGender());
                    gameTrip.setTripPlayerAddress(player.getPlayerAddress());
                    gameTripList.add(gameTrip);
                }
            }else{
                System.out.println("Can't find the team with "+teamId+" id!");
            }
        }
        List<Trip> tripsFromGameTrip=gameTripDao.findAllGameTrips();
        if(tripsFromGameTrip.size()>0) {
            tripDao.saveAll(tripsFromGameTrip);
        }else{
            System.out.println("No game trip this week");
        }
        if(updatetimeDao.existsGameUpdateTimeByGameupdatetimeId(2)){
            GameUpdateTime gameUpdateTime=updatetimeDao.findGameUpdateTimeByGameupdatetimeId(2);
            gameUpdateTime.setGameupdatetimeDate(new Date());
            updatetimeDao.save(gameUpdateTime);
        }else{
            GameUpdateTime gameUpdateTime=new GameUpdateTime();
            gameUpdateTime.setGameupdatetimeDate(new Date());
            updatetimeDao.save(gameUpdateTime);
        }
        gameTripDao.truncateMyTable();
        gameTripDao.saveAll(gameTripList);
        System.out.println("Weekly game trips have been generated");
    }

    @Scheduled(cron="0 18 02 ? * WED")
    public void grapGameScheduleByPython(){
        Process proc;
        try {
            proc = Runtime.getRuntime().exec("python3 /usr/local/python-demo/startup.py");
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
            System.out.println("Successfully executed python web crawler!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



//    @Scheduled(cron="0/5 * * * * *")
//    public void schduledTest(){
//        System.out.println("Hello World");
//    }
}
