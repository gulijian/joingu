package com.gulj.app.blog.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "sys_menu")
@ApiModel
public class SysMenu implements Serializable {
    @Id
    private Integer id;

    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "菜单url")
    private String url;

    /**
     * 所有的父节点
     */
    @Column(name = "parent_id")
    @ApiModelProperty(value = "菜单的父级元素")
    private String parentId;

    @Column(name = "parent_ids")
    private String parentIds;

    /**
     * 是否为父节点（1.是，0.否）
     */
    @Column(name = "is_parent")
    private Byte isParent;

    private Integer sort;

    private String icon;

    @Column(name = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取所有的父节点
     *
     * @return parent_id - 所有的父节点
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置所有的父节点
     *
     * @param parentId 所有的父节点
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * @return parent_ids
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * @param parentIds
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    /**
     * 获取是否为父节点（1.是，0.否）
     *
     * @return is_parent - 是否为父节点（1.是，0.否）
     */
    public Byte getIsParent() {
        return isParent;
    }

    /**
     * 设置是否为父节点（1.是，0.否）
     *
     * @param isParent 是否为父节点（1.是，0.否）
     */
    public void setIsParent(Byte isParent) {
        this.isParent = isParent;
    }

    /**
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}