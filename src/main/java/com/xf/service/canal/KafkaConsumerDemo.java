//package com.xf.service.canal;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.Properties;
//
//@Component
//public class KafkaConsumerDemo implements InitializingBean {
//
//    private Properties props;
//
//    public KafkaConsumerDemo(Properties props) {
//        super();
//        this.props = props;
//    }
//
//    public KafkaConsumerDemo() {
//
//    }
//
//    public Properties getProps() {
//        return props;
//    }
//
//    public void setProps(Properties props) {
//        this.props = props;
//    }
//
//    public String receive(){
//
//        KafkaConsumer<String,String> consumer = new KafkaConsumer<String,String>(props);
//        consumer.subscribe(Arrays.asList(props.getProperty("topic")));
//
//        String msg = "";
//        while(true){
//            ConsumerRecords<String,String> consumerRecords = consumer.poll(100);
//            for(ConsumerRecord<String, String> consumerRecord:consumerRecords){
//                String json =  consumerRecord.value();
//                JSONObject jsonObject = JSONObject.parseObject(json);
//                String sqlType = jsonObject.getString("type");
//                JSONArray data = jsonObject.getJSONArray("data");
//                if(data!=null)
//                {
//                    JSONObject userObject = data.getJSONObject(0);
//                    String id = userObject.getString("id");
//                    String database = jsonObject.getString("database");
//                    String table = jsonObject.getString("table");
//                    String key = database + "_" + table + "_" + id;
//                    if ("UPDATE".equals(sqlType) || "INSERT".equals(sqlType)) {
//                        System.out.println("更新数据 === " + json);
//                    }
//                    if ("DELETE".equals(sqlType)) {
//                        System.out.println("删除数据 === " + json);
//                    }
//                }
//
//            }
//            consumer.close();
//            return msg;
//        }
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        receive();
//    }
//}