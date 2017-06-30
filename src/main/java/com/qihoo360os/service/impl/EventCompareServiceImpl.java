package com.qihoo360os.service.impl;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.*;
import java.util.*;

/**
 * Created by i-hexiuyu on 2017/6/28.
 */

public class EventCompareServiceImpl {

    private String basePath = "E:/360/DATA/task1";
    private String sourceFile = basePath +"/hive_shenhe_35163_20170628.txt";
    private String resultFile = basePath + "/result.txt";

    private HashSet<String> eventSet = new HashSet<>();


    public void eventCompare() throws IOException {
        File sourceFile = new File(this.sourceFile);
        File resultFile = new File(this.resultFile);

        HashMap<String, Map<String, String>> map = getM2GroupMapFromFile(sourceFile);
        HashSet<EventSequence> allSameSquece = findAllSameSequence(map);
        HashMap<EventSequence, ValueObject> result = findM2WithCommonSeq(map, allSameSquece);
        List<Map.Entry<EventSequence, ValueObject>> sortedResult = sortByCountDesc(result);
        writeSequenceFile(resultFile, sortedResult);
        System.out.println(" complete ！");


    }


    private List<Map.Entry<EventSequence, ValueObject>> sortByCountDesc(HashMap<EventSequence, ValueObject> result) {
        // 降序比较器
        Comparator<Map.Entry<EventSequence, ValueObject>> valueComparator = (o1, o2) -> o2.getValue().getCount()-o1.getValue().getCount();
        List<Map.Entry<EventSequence, ValueObject>> resultList = new ArrayList<Map.Entry<EventSequence,ValueObject>>(result.entrySet());
        Collections.sort(resultList, valueComparator);
        System.out.println("结果最大值为: "+ resultList.get(0).getValue().getCount());
        return resultList;
    }



    /**
     *  result map format :
     *      {
     *           m2 : {
     *              event1: line
     *              event2: line
     *          },
     *          ...
     *      }
     *  description ： 以M2 为键 分组， 组内每一条记录是另一个Map ，此Map 以event 为键，值为该条完整数据（line为冗余字段）
     */
    public HashMap<String, Map<String, String>> getM2GroupMapFromFile(File file) throws IOException {
        long startTime = System.currentTimeMillis();
        long endTime;
        HashMap<String, Map<String,String>> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null) {
            try {
                String m2Name = getM2(line);
                String event = getEvent(line);
                eventSet.add(event);
                if(map.containsKey(m2Name)){
                    Map<String, String> eventMap = map.get(m2Name);
                    if(!eventMap.containsKey(event)){
                        eventMap.put(event, line);
                    }
                } else {
                    HashMap<String, String> eventMap = new HashMap<>();
                    eventMap.put(event, line);
                    map.put(m2Name, eventMap);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            line = reader.readLine();
        }
        reader.close();
        endTime = System.currentTimeMillis();
        System.out.println("文件读取时间：" + (endTime-startTime) + " ms");
        return map;
    }


    public String getM2(String item) throws Exception{
        String[] columns = item.split("\t");
        if(columns.length != 25)
            throw new Exception("此数据长度不足");
        else
            return columns[3];
    }

    public String getEvent(String item) throws Exception{
        String[] columns = item.split("\t");
        if(columns.length != 25)
            throw new Exception("此数据长度不足");
        else
            return columns[12]+"*"+columns[13];
    }

    /***************/

    /**
     * 得到所有的交集序列
     * @param map
     * @return
     */
    public HashSet<EventSequence> findAllSameSequence(HashMap<String, Map<String,String>> map){
        Iterator<Map.Entry<String, Map<String,String>>> it = map.entrySet().iterator();
        ArrayList<Set<String>> eventSetList = new ArrayList<>();
        HashSet<EventSequence> allCommonSequenceSet = new HashSet<>();
        while(it.hasNext()) {
            Map.Entry<String, Map<String,String>> m2Map = it.next();
            Set<String> currentM2EventSet = m2Map.getValue().keySet();
            eventSetList.add(currentM2EventSet);
        }
        for(int i=0; i<eventSetList.size()-1;i++)
            for(int j=i+1;j< eventSetList.size(); j++){
                Set<String> eventSetI = eventSetList.get(i);
                Set<String> eventSetJ = eventSetList.get(j);
                HashSet<String> intersection = new HashSet<>();
                intersection.addAll(eventSetI);
                intersection.retainAll(eventSetJ);
                if (intersection.size() > 3)
                    //Class  EventSequence has overwrite hashcode() and equals() method
                    allCommonSequenceSet.add(new EventSequence(intersection));
            }
        return allCommonSequenceSet;
    }

    public HashMap<EventSequence, ValueObject> findM2WithCommonSeq(HashMap<String, Map<String,String>> map, HashSet<EventSequence> commonSequence){
        HashMap<EventSequence, ValueObject> resultMap = new HashMap<>();
        Iterator<Map.Entry<String, Map<String,String>>> it;
        for(EventSequence eventSequence : commonSequence){
            int count = 0;
            ArrayList<String> m2s = new ArrayList<>();
            it = map.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry<String, Map<String,String>> m2Map = it.next();
                Set<String> currentM2EventSet = m2Map.getValue().keySet();
                if (currentM2EventSet.containsAll(eventSequence.getSequences())){
                    count ++;
                    m2s.add(m2Map.getKey());
                }
            }
            if(count > 2)
                resultMap.put(eventSequence, new ValueObject(eventSequence,count,m2s));
        }
        return resultMap;
    }


    public void writeSequenceFile(File file, List<Map.Entry<EventSequence, ValueObject>> list) throws IOException {
        long startTime = System.currentTimeMillis();
        long endTime;
        if (!file.exists()){
            file.createNewFile();
        }
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        for(Map.Entry<EventSequence, ValueObject> entry: list){
            printWriter.println(entry.getValue());
        }
        printWriter.flush();
        printWriter.close();
        endTime = System.currentTimeMillis();
        System.out.println("写入文件 时间：" + (endTime-startTime) + " ms");

    }
    public void test() throws IOException {
        File resultFile = new File(this.resultFile);
        BufferedReader reader = new BufferedReader(new FileReader(resultFile));
        int lineNo = (int) (Math.random()*10000)+1;;
        System.out.println("test 的行号："+ lineNo);
        String line;
        while(lineNo -- > 1){
            line = reader.readLine();
        }
        line = reader.readLine();
        System.out.println("test 的数据： \n" + line);
        String[] columns = line.split("\t");
        String[] sequences = columns[0].split(",");
        String[] m2s = columns[2].split(",");
        List<String> sequencesList = Arrays.asList(sequences);
        List<String> m2sList = Arrays.asList(m2s);
        int count  = Integer.parseInt(columns[1]);

        File sourceFile = new File(this.sourceFile);
        HashMap<String, Map<String, String>> map = getM2GroupMapFromFile(sourceFile);
        for (String m2 : m2sList) {
            for(String sequence: sequencesList){
                if(map.containsKey(m2)){
                    Map<String, String> currentM2Map = map.get(m2);
                    if(!currentM2Map.containsKey(sequence)){
                        System.out.println("设备" + m2 + "不包含 ： " + sequence);
                        return;
                    }
                } else{
                    System.out.println("文件不包含设备 ： " +m2);
                    return;
                }
            }
        }
        System.out.println("全部包含！");
    }


    public  class ValueObject{
        private EventSequence eventSequence;
        private int count ;
        private ArrayList<String> m2List;

        @Override
        public String toString() {
            String listString = new String();
            String sequenceStr =new String();

            for(int i=0; i<m2List.size(); i++){
                listString = i == (m2List.size()-1) ? listString+m2List.get(i) : listString+m2List.get(i)+",";
            }

            for(String str: eventSequence.getSequences()){
                sequenceStr = sequenceStr + str + ",";
            }
            return sequenceStr + "\t" + count + "\t" + listString;
        }

        public ValueObject(EventSequence eventSequence, int count, ArrayList<String> m2List) {
            this.setEventSequence(eventSequence);
            this.count = count;
            this.m2List = m2List;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public ArrayList<String> getM2List() {
            return m2List;
        }

        public void setM2List(ArrayList<String> m2List) {
            this.m2List = m2List;
        }

        public EventSequence getEventSequence() {
            return eventSequence;
        }

        public void setEventSequence(EventSequence eventSequence) {
            this.eventSequence = eventSequence;
        }
    }

    public  class EventSequence{
        Set<String> sequences ;

        public EventSequence(Set<String> sequences) {
            this.sequences = sequences;
        }

        @Override
        public int hashCode() {
            return HashCodeBuilder.reflectionHashCode(this,Arrays.asList(sequences));
        }

        @Override
        public boolean equals(Object obj) {
            return EqualsBuilder.reflectionEquals(this, obj, Arrays.asList(sequences));
        }

        public Set<String> getSequences() {
            return sequences;
        }

        public void setSequences(Set<String> sequences) {
            this.sequences = sequences;
        }
    }
}
