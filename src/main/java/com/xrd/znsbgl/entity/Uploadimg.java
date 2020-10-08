package com.xrd.znsbgl.entity;

import java.io.Serializable;

/**
 * (Uploadimg)实体类
 *
 * @author lpq
 * @since 2020-06-24 11:04:35
 */
public class Uploadimg implements Serializable {
    private static final long serialVersionUID = -95210665872695643L;

    private Integer id;
    private String imgbase;
    private String imgurl;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getImgbase() {
        return imgbase;
    }

    public void setImgbase(String imgbase) {
        this.imgbase = imgbase;
    }


    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Override
    public String toString() {
    
        return "Uploadimg{" +
                 "id=" + id+","+     
                 "imgbase='" + imgbase +"'"+","+     
                 "imgurl='" + imgurl +"'"     
              +"}"; 
    }

}