/**
  * Copyright 2019 bejson.com 
  */
package com.hie2j.news_client;
import java.util.List;

/**
 * Auto-generated: 2019-06-17 14:49:51
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Result {

    private String stat;
    private List<Data> data;
    public void setStat(String stat) {
         this.stat = stat;
     }
     public String getStat() {
         return stat;
     }

    public void setData(List<Data> data) {
         this.data = data;
     }
     public List<Data> getData() {
         return data;
     }

}