package com.gulj.app.blog.api.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "blog_category")
public class BlogCategory implements Serializable {
    @Id
    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类url地址
     */
    private String url;

    /**
     * 分类父ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 是否是父级分类
     */
    @Column(name = "is_parent")
    private Integer isParent;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否显示(1.显示,0.不显示)
     */
    @Column(name = "is_show")
    private Boolean isShow;

    /**
     * 是否删除(1.是，0.否)
     */
    @Column(name = "is_delete")
    private Boolean isDelete;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取分类名称
     *
     * @return name - 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分类名称
     *
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取分类url地址
     *
     * @return url - 分类url地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置分类url地址
     *
     * @param url 分类url地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取分类父ID
     *
     * @return parent_id - 分类父ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置分类父ID
     *
     * @param parentId 分类父ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取是否是父级分类
     *
     * @return is_parent - 是否是父级分类
     */
    public Integer getIsParent() {
        return isParent;
    }

    /**
     * 设置是否是父级分类
     *
     * @param isParent 是否是父级分类
     */
    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取是否显示(1.显示,0.不显示)
     *
     * @return is_show - 是否显示(1.显示,0.不显示)
     */
    public Boolean getIsShow() {
        return isShow;
    }

    /**
     * 设置是否显示(1.显示,0.不显示)
     *
     * @param isShow 是否显示(1.显示,0.不显示)
     */
    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    /**
     * 获取是否删除(1.是，0.否)
     *
     * @return is_delete - 是否删除(1.是，0.否)
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除(1.是，0.否)
     *
     * @param isDelete 是否删除(1.是，0.否)
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }



}