/**
 * @author shany
 * @date 2019年1月4日 下午3:11:41 
 * @version V1.0  
 */
package com.bootdo.shany.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootdo.shany.dao.VideoDAO;
import com.bootdo.shany.domain.VideoDO;
import com.bootdo.shany.service.VideoService;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private VideoDAO videoDao;
	
	/* 
	 * @see com.bootdo.shany.service.VideoService#count(java.util.Map)
	 * 统计目前视频的总数量，后期需要加入权限控制
	 */
	@Override
	public int count(Map<String, Object> map) {
		return videoDao.count(map);
	}

	/* 
	 * @see com.bootdo.shany.service.VideoService#update(com.bootdo.shany.domain.VideoDO)
	 * 更改一个视频文件的相关信息。（山羊建议加入修改文件物理或者URL位置的权限控制）
	 */
	@Override
	public int update(VideoDO video) {
		return videoDao.update(video);
	}

	/* 
	 * @see com.bootdo.shany.service.VideoService#remove(java.lang.Long)
	 * 删除一个视频，在这里山羊建议先修改视频文件的状态。在15天后再通过定时器，
	 * 来从硬盘上删除文件，如果是URL链接的视频则不需要删除。
	 */
	@Override
	public int remove(Long videoId) {
		return videoDao.remove(videoId);
	}

	/* 
	 * @see com.bootdo.shany.service.VideoService#batchRemove(java.lang.Long[])
	 * 批量删除视频
	 */
	@Override
	public int batchRemove(Long[] videoIds) {
		return videoDao.batchRemove(videoIds);
	}

	/* 
	 * @see com.bootdo.shany.service.VideoService#save(com.bootdo.shany.domain.VideoDO)
	 * 上传时用于保存一个文件的相关信息
	 */
	@Override
	public int save(VideoDO video) {
		return videoDao.save(video);
	}

	/* 
	 * @see com.bootdo.shany.service.VideoService#list()
	 * 获取所有视频文件信息，暂时没加入权限控制，后期再进行修改
	 */
	@Override
	public List<VideoDO> list() {
		return videoDao.list();
	}

	/* 
	 * @see com.bootdo.shany.service.VideoService#get(java.lang.Long)
	 * 传入video的ID，来或者这个video的相关信息
	 */
	@Override
	public VideoDO get(Long videoId) {
		return videoDao.get(videoId);
	}

}
