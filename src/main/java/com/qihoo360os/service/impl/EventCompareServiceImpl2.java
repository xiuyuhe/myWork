//package com.qihoo360os.service.impl;
//
//import org.apache.commons.lang.builder.EqualsBuilder;
//import org.apache.commons.lang.builder.HashCodeBuilder;
//
//import java.io.*;
//import java.util.*;
//
///**
// * Created by i-hexiuyu on 2017/6/28.
// */
//
//public class EventCompareServiceImpl2 {
//
//    private String basePath = "E:/360/DATA/task1";
//    private String sourceFile = basePath +"/hive_shenhe_35163_20170628.txt";
//    private String resultFile = basePath + "/result.txt";
//
//    private HashSet<String> eventSet = new HashSet<>();
//
//
//    public void eventCompare() throws IOException {
//        File sourceFile = new File(this.sourceFile);
//        File resultFile = new File(this.resultFile);
//
//        HashMap<String, Map<String, String>> map = new EventCompareServiceImpl().getM2GroupMapFromFile(sourceFile);
//        HashMap<String, ValueObject> result = findSameEvent(map, eventSet);
//        List<Map.Entry<String, ValueObject>> sortedResult = sortByCountDesc(result);
//        write2File(resultFile, sortedResult);
//        System.out.println(" complete ！");
//
//
//    }
//
//    private List<Map.Entry<String, ValueObject>> sortByCountDesc(HashMap<String, ValueObject> result) {
//        // 降序比较器
//        Comparator<Map.Entry<String, ValueObject>> valueComparator = new Comparator<Map.Entry<String,ValueObject>>() {
//            @Override
//            public int compare(Map.Entry<String, ValueObject> o1,
//                               Map.Entry<String, ValueObject> o2) {
//                return o2.getValue().getCount()-o1.getValue().getCount();
//            }
//        };
//        List<Map.Entry<String, ValueObject>> resultList = new ArrayList<Map.Entry<String,ValueObject>>(result.entrySet());
//        Collections.sort(resultList, valueComparator);
//        System.out.println("结果最大值为: "+ resultList.get(0).getValue().getCount());
//        return resultList;
//    }
//
//
//    /**
//     *  result map format :
//     *      {
//     *           m2 : {
//     *              event1: line
//     *              event2: line
//     *          },
//     *          ...
//     *      }
//     *  description ： 以M2 为键 分组， 组内每一条记录是另一个Map ，此Map 以event 为键，值为该条完整数据（line为冗余字段）
//     */
//
//
//    public String getM2(String item) throws Exception{
//        String[] columns = item.split("\t");
//        if(columns.length != 25)
//            throw new Exception("此数据长度不足");
//        else
//            return columns[3];
//    }
//
//    public String getEvent(String item) throws Exception{
//        String[] columns = item.split("\t");
//        if(columns.length != 25)
//            throw new Exception("此数据长度不足");
//        else
//            return columns[12]+"*"+columns[13];
//    }
//
//    public HashMap<String, ValueObject> findSameEvent(HashMap<String, Map<String,String>> map, HashSet<String> eventSet){
//        long startTime = System.currentTimeMillis();
//        long endTime;
//        HashMap<String, ValueObject> result = new HashMap<>();
//        for(String event: eventSet){
//            int count = 0;
//            ArrayList<String> m2List = new ArrayList<>();
//            Iterator<Map.Entry<String, Map<String,String>>> it = map.entrySet().iterator();
//            while(it.hasNext()) {
//                Map.Entry<String, Map<String,String>> m2Map = it.next();
//                if (m2Map.getValue().containsKey(event)){
//                    count ++;
//                    m2List.add(m2Map.getKey());
////                    m2Map.getValue().remove(event);
//                }
//            }
//            if(count > 2)
//                result.put(event,new ValueObject(event, count, m2List));
//        }
//        endTime = System.currentTimeMillis();
//        System.out.printf("result 有 %d 条\n" , result.size());
//        System.out.println("处理时间：" + (endTime-startTime) + " ms");
//        return result;
//    }
//
//    public void write2File(File file, List<Map.Entry<String, ValueObject>> list) throws IOException {
//        long startTime = System.currentTimeMillis();
//        long endTime;
//        if (!file.exists()){
//            file.createNewFile();
//        }
//        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
//        for(Map.Entry<String, ValueObject> entry: list){
//            printWriter.println(entry.getValue());
//        }
//        printWriter.flush();
//        printWriter.close();
//        endTime = System.currentTimeMillis();
//        System.out.println("写入文件 时间：" + (endTime-startTime) + " ms");
//
//    }
//
//
//    public  class ValueObject{
//        private String event;
//        private int count ;
//        private ArrayList<String> m2List;
//
//        @Override
//        public String toString() {
//            String listString = new String();
//
//            for(int i=0; i<m2List.size(); i++){
//                listString = i == (m2List.size()-1) ? listString+m2List.get(i) : listString+m2List.get(i)+",";
//            }
//
//            return event + "\t" + count + "\t" + listString;
//        }
//
//        public ValueObject(String event, int count, ArrayList<String> m2List) {
//            this.event = event;
//            this.count = count;
//            this.m2List = m2List;
//        }
//
//        public String getEvent() {
//            return event;
//        }
//
//        public void setEvent(String event) {
//            this.event = event;
//        }
//
//        public int getCount() {
//            return count;
//        }
//
//        public void setCount(int count) {
//            this.count = count;
//        }
//
//        public ArrayList<String> getM2List() {
//            return m2List;
//        }
//
//        public void setM2List(ArrayList<String> m2List) {
//            this.m2List = m2List;
//        }
//    }
//}
