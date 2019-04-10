/**
 * @author shany
 * @date 2019年1月4日 上午11:16:24 
 * @version V1.0  
 */
package com.bootdo.shany.dao;

import java.util.List;
import java. util.Map;

import com.bootdo.shany.domain.VideoDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VideoDAO {

	// 视频总量
	int count(Map<String, Object> map);

	// 更新
	int update(VideoDO video);

	// 删除
	int remove(Long videoId);

	// 批量删除
	int batchRemove(Long[] videoIds);

	// 新增
	int save(VideoDO video);

	// 获取全部
	List<VideoDO> list();

	// 获取一个
	VideoDO get(Long videoId);

}
