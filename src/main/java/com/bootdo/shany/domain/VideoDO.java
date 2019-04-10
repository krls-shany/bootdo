/**
 * @author shany
 * @date 2019年1月4日 上午10:36:16 
 * @version V1.0  
 */
package com.bootdo.shany.domain;

import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.Date;

public class VideoDO implements Serializable{

	private static final long serialVersionUID = -305643352546956245L;
	
	//id
	private Long videoId;
	//视频名
	private String videoTitle;
	//视频观看状态（用于控制视频是否可观看）
	private Integer watchStatus;
	//视频类型(是服务器存储的视频文件，还是网上的视频链接，可拓展)
	private String videoType;
	//视频标签（对于视频内容分类用）
	private String videoTags;
	//视频内容介绍
	private String videoContent;
	//视频封面图片路径
	private String picturePath;
	
	//创建人ID
	private Long createId;
	//创建时间
	private Date createTime;
	//最后修改人ID
	private Long modifieId;
	
	//最后观看位置
	private String watchPlace;
	//最后观看时间
	private Date watchTime;
	//观看次数
	private Long watchNums;
	
	//视频文件存放物理路径
	private String filePath;
	//视频文件系统存放路径
	private String videoPath;
	//视频网上url地址链接
	private String videoUrl;
	
	public Long getVideoId() {
		return videoId;
	}
	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public Integer getWatchStatus() {
		return watchStatus;
	}
	public void setWatchStatus(Integer watchStatus) {
		this.watchStatus = watchStatus;
	}
	public String getVideoType() {
		return videoType;
	}
	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}
	public String getVideoTags() {
		return videoTags;
	}
	public void setVideoTags(String videoTags) {
		this.videoTags = videoTags;
	}
	public String getVideoContent() {
		return videoContent;
	}
	public void setVideoContent(String videoContent) {
		this.videoContent = videoContent;
	}
	public Long getCreateId() {
		return createId;
	}
	public void setCreateId(Long createId) {
		this.createId = createId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getModifieId() {
		return modifieId;
	}
	public void setModifieId(Long modifieId) {
		this.modifieId = modifieId;
	}
	public String getWatchPlace() {
		return watchPlace;
	}
	public void setWatchPlace(String watchPlace) {
		this.watchPlace = watchPlace;
	}
	public Date getWatchTime() {
		return watchTime;
	}
	public void setWatchTime(Date watchTime) {
		this.watchTime = watchTime;
	}
	public Long getWatchNums() {
		return watchNums;
	}
	public void setWatchNums(Long watchNums) {
		this.watchNums = watchNums;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getVideoPath() {
		return videoPath;
	}
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	@Override
	public String toString() {
		return "VideoDO{" +
				"videoId=" + videoId +
				", videoTitle='" + videoTitle + '\'' +
				", watchStatus=" + watchStatus +
				", videoType='" + videoType + '\'' +
				", videoTags='" + videoTags + '\'' +
				", videoContent='" + videoContent + '\'' +
				", picturePath='" + picturePath + '\'' +
				", createId=" + createId +
				", createTime=" + createTime +
				", modifieId=" + modifieId +
				", watchPlace='" + watchPlace + '\'' +
				", watchTime=" + watchTime +
				", watchNums=" + watchNums +
				", filePath='" + filePath + '\'' +
				", videoPath='" + videoPath + '\'' +
				", videoUrl='" + videoUrl + '\'' +
				'}';
	}
}
