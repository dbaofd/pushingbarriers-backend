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
        for(int i=0;i<20;i++) {
            System.out.println(MyTools.generateInvitationCode());
        }
    }



}
