package com.xtt.manager;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        Map<String, List<String>> orderedUrls = zone("c", false, new String[]{"a", "b", "c"});
        System.out.println(JSON.toJSONString(orderedUrls));
    }

    public Map<String, List<String>> zone(String instanceZone, boolean preferSameZone, String[] availZones) {
        Map<String, List<String>> orderedUrls = new LinkedHashMap<>();

        //优先级第一位，我的地区
        int myZoneOffset = getZoneOffset(instanceZone, preferSameZone, availZones);
        String myZone = availZones[myZoneOffset];
        orderedUrls.put(myZone, Lists.newArrayList(myZone + "-1", myZone + "-2"));

        //其他的
        for (String availZone : availZones) {
            if (availZone.equalsIgnoreCase(myZone)) {
                continue;
            }
            orderedUrls.put(availZone, Lists.newArrayList(availZone + "-1", availZone + "-2"));
        }

        return orderedUrls;
    }

    private int getZoneOffset(String myZone, boolean preferSameZone, String[] availZones) {
        if (!preferSameZone) {
            return 0;
        }
        for (int i = 0; i < availZones.length; i++) {
            if (myZone != null && availZones[i].equalsIgnoreCase(myZone.trim())) {
                return i;
            }
        }
        return 0;
    }
}
