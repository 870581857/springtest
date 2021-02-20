//package com.xf.service.canal;
//
//import com.alibaba.otter.canal.client.CanalConnector;
//import com.alibaba.otter.canal.client.CanalConnectors;
//import com.alibaba.otter.canal.protocol.CanalEntry;
//import com.alibaba.otter.canal.protocol.Message;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.stereotype.Component;
//
//import java.net.InetSocketAddress;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class TestCanal implements InitializingBean {
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        getEntries();
//    }
//
//    public void getEntries() {
//        CanalConnector connector = CanalConnectors
//                .newSingleConnector(new InetSocketAddress("192.168.213.130", 11111), "example", "", "");//写入正确的ip和端口以及destination
//        int batchSize = 1000;
//        connector.connect();//获取连接
//        connector.subscribe("b2b2ctmp.shop_order");//通配此处不做更改
//        connector.rollback();
//        try {
//            while (true) {
//                Message message = connector.getWithoutAck(batchSize);//获取指定数量的数据
//                long batchId = message.getId();
//                int size = message.getEntries().size();
//                if (batchId == -1 || size == 0) {//当message.getId不等于-1或0时代表监控到了数据
//                } else {
//                    printEntry(message.getEntries());//具体分析数据类，可根据自己需求进行修改
//                }
//                connector.ack(batchId); // 提交确认
//            }
//        } finally {
//            connector.disconnect();
//        }
//    }
//
//    private void printEntry(List<CanalEntry.Entry> list) {
//        for (CanalEntry.Entry entry : list) {
//            if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN
//                    || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
//                continue;//如果是事务跳过
//            }
//            CanalEntry.RowChange rowChage = null;
//            try {
//                rowChage = CanalEntry.RowChange.parseFrom(entry.getStoreValue());//获取修改的数据row
//            } catch (Exception e) {
//            }
//            CanalEntry.EventType eventType = rowChage.getEventType();//获取类型 增删改
//            if (entry.getHeader().getSchemaName().equals("mdata_dashboard")) {//库名
//                if (entry.getHeader().getTableName().equals("import_second_request_volume")) {//表名
//                    System.out.println("changed.");
//                    //取值根据表数据自行定义修改
//                    List<String> deleteUserId = new ArrayList<String>();
//                    List<String> updateUserId = new ArrayList<String>();
//                    for (CanalEntry.RowData rowData : rowChage.getRowDatasList()) {
//                        if (eventType == eventType.DELETE) {
//                            deleteUserId.add(rowData.getBeforeColumnsList().get(1).getValue());
//                        } else if (eventType == eventType.INSERT || eventType == eventType.UPDATE) {
//                            updateUserId.add(rowData.getAfterColumnsList().get(1).getValue());
//                            updateUserId.add(rowData.getBeforeColumnsList().get(1).getValue());
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//
//}