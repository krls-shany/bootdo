package com.bootdo.shany.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AlarmUtil {
		
	private static final Logger  log = LoggerFactory.getLogger(AlarmUtil.class);
	
	@Scheduled(cron="0 0 0/2 * * *")
	public void needRelax() {
		AudioUtil.audioPlayer("开发者，你需要休息2分钟来缓解大脑的疲劳");
		log.debug("[INFO]:you need relax 2 min");
	}

	@Scheduled(cron="0 55 23 23 1 *")
	public void z2() {
		AudioUtil.audioPlayer("请注意现在是1月23日23时55分，还有5分钟");
		AudioUtil.audioPlayer("请注意现在是1月23日23时55分，还有5分钟");
		AudioUtil.audioPlayer("请注意现在是1月23日23时55分，还有5分钟");
		log.debug("[INFO]:X 特别时刻，请注意");
	}
	
	@Scheduled(cron="0 55 23 17 7 *")
	public void z3() {
		AudioUtil.audioPlayer("请注意现在是7月17日23时55分，还有5分钟");
		AudioUtil.audioPlayer("请注意现在是7月17日23时55分，还有5分钟");
		AudioUtil.audioPlayer("请注意现在是7月17日23时55分，还有5分钟");
		log.debug("[INFO]:X 特别时刻，请注意");
	}
}
