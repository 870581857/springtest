//package com.xf.service.canal;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//
//public class KafkaClient {
//    @KafkaListener(topics = "maikt-topic")
//    public void receive(ConsumerRecord<?, ?> consumer) {
//        System.out.println("topic名称:" + consumer.topic() + ",key:" +
//                consumer.key() + "," +
//                "分区位置:" + consumer.partition()
//                + ", 下标" + consumer.offset() + "," + consumer.value());
//
//        String json = (String) consumer.value();
//        JSONObject jsonObject = JSONObject.parseObject(json);
//        String sqlType = jsonObject.getString("type");
//        JSONArray data = jsonObject.getJSONArray("data");
//        if(data!=null)
//        {
//            JSONObject userObject = data.getJSONObject(0);
//            String id = userObject.getString("id");
//            String database = jsonObject.getString("database");
//            String table = jsonObject.getString("table");
//            String key = database + "_" + table + "_" + id;
//            if ("UPDATE".equals(sqlType) || "INSERT".equals(sqlType)) {
////                redisUtils.setString(key, userObject.toJSONString());
//                return;
//            }
//            if ("DELETE".equals(sqlType)) {
////                redisUtils.deleteKey(key);
//            }
//        }
//    }
//}
