package pers.eter.core.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Eter on 17-6-8.
 */
public class Navigation implements Serializable{
    private Integer id;
    private Date createDate;
    private Date modifyDate;
    private Integer version;
    private Integer orders;
    private Integer isBlankTarget;
    private String name;
    private Integer position;
    private String url;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getModifyDate() {
        return modifyDate;
    }
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
    public Integer getVersion() {
        return version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }
    public Integer getOrders() {
        return orders;
    }
    public void setOrders(Integer orders) {
        this.orders = orders;
    }
    public Integer getIsBlankTarget() {
        return isBlankTarget;
    }
    public void setIsBlankTarget(Integer isBlankTarget) {
        this.isBlankTarget = isBlankTarget;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPosition() {
        return position;
    }
    public void setPosition(Integer position) {
        this.position = position;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
