package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;



public class StatisticManager {
    private static final StatisticManager INSTANCE = new StatisticManager();
    private  StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        return INSTANCE;
    }

    public void register(EventDataRow data) {
        this.statisticStorage.put(data);
    }


    public TreeMap<String, Double> advertisementProfitStatistic() {
        TreeMap<String,Double> resultMap = new TreeMap<>(Collections.reverseOrder());
        Map<EventType, List<EventDataRow>> map = new HashMap<>(statisticStorage.get());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "dd-MMM-yyyy", Locale.ENGLISH);
        for (Map.Entry<EventType, List<EventDataRow>> entry : map.entrySet() ) {
            if (entry.getKey() == EventType.SELECTED_VIDEOS) {
                for (EventDataRow row : entry.getValue()) {
                    VideoSelectedEventDataRow newRow = (VideoSelectedEventDataRow) row;
                    String date = simpleDateFormat.format(row.getDate());
                    if (!resultMap.containsKey(date))
                    resultMap.put(date,(double) newRow.getAmount());
                    else resultMap.put(date, resultMap.get(date) + newRow.getAmount());
                }
            }
        }
        return  resultMap;
    }

    public TreeMap<String, TreeMap<String, Integer>> cooksStatistics() {
        TreeMap<String, Integer> cooks;
        TreeMap<String, TreeMap<String, Integer>>  resultMap = new TreeMap<>(Collections.reverseOrder());
        Map<EventType, List<EventDataRow>> map = new HashMap<>(statisticStorage.get());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "dd-MMM-yyyy", Locale.ENGLISH);
        for (Map.Entry<EventType, List<EventDataRow>> entry : map.entrySet() ){
            if (entry.getKey() == EventType.COOKED_ORDER) {
                for (EventDataRow row : entry.getValue()){
                    CookedOrderEventDataRow newRow = (CookedOrderEventDataRow) row;
                    String date = simpleDateFormat.format(row.getDate());
                    cooks = resultMap.get(date);
                   if (!resultMap.containsKey(date)){
                       resultMap.put(date,getTreeMap(newRow.getCookName(), (newRow.getTime())/60));
                    } else if (!cooks.containsKey(newRow.getCookName())) {
                       cooks.put(newRow.getCookName(), newRow.getTime()/60);
                       resultMap.put(date, cooks);
                    } else {
                       cooks.put(newRow.getCookName(),cooks.get(newRow.getCookName()) + newRow.getTime()/60);
                       resultMap.put(date, cooks);
                   }
                }
            }
        }
        return resultMap;
    }

    private TreeMap<String, Integer> getTreeMap(String name, Integer time) {
        TreeMap<String,Integer> treeMap = new TreeMap<>(Comparator.naturalOrder());
        treeMap.put(name,time);
        return treeMap;
    }




   private class StatisticStorage {
      private  Map<EventType, List<EventDataRow>> storage = new HashMap<>();

       public StatisticStorage() {
           for (EventType eventType : EventType.values())
               storage.put(eventType, new ArrayList<EventDataRow>());
       }

       private void put(EventDataRow data) {
           EventType type = data.getType();
           if (!this.storage.containsKey(type))
               throw new UnsupportedOperationException();

           this.storage.get(type).add(data);
       }

       private Map<EventType, List<EventDataRow>> get() {
           return storage;
       }
   }
}
