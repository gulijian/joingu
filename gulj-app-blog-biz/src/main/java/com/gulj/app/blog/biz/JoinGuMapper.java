package com.gulj.app.blog.biz;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author gulj
 * @create 2017-05-04 上午11:48
 **/
public interface JoinGuMapper<T> extends Mapper<T>, MySqlMapper<T> {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错


}
