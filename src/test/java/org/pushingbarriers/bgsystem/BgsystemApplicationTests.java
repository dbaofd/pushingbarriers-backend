package org.pushingbarriers.bgsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.pushingbarriers.bgsystem.util.MyTools;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BgsystemApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void dateUtilTest(){
        System.out.println("jieguo**********************");
        System.out.println(MyTools.getLastWeekSunday()+" "+MyTools.getThisWeekSunday()+" "+MyTools.getNextWeekSunday());
    }



}
