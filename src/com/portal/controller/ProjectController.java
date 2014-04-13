package com.portal.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portal.service.KindLevelService;
import com.portal.vo.KindLevel;
import com.portal.vo.type.LevelType;

/*@Controller
 @RequestMapping("/medicine")*/
@Controller
public class ProjectController {

	private static final Logger LOGGER = Logger
			.getLogger(ProjectController.class);

	@Autowired
	private KindLevelService kindLevelService;

	@RequestMapping(value = { "/", "/index" })
	public String index(Map<String, Object> map) {

		System.out.println("hello");
		KindLevel kindLevel = new KindLevel();
		kindLevel.setType(LevelType.Level1);
		kindLevel.setName("test1");
		map.put("hello", "world");
		LOGGER.debug("saveMedicne start!");

		try {

			kindLevelService.save(kindLevel);
			LOGGER.debug("saveMedicne end!");
		} catch (Exception e) {
			LOGGER.error("save medicine throw", e);
		}
		return "hello";
	}
	
	@RequestMapping("/test01")
	public String test01(Map<String, Object> map) {

		System.out.println("hello");
		KindLevel kindLevel = new KindLevel();
		kindLevel.setType(LevelType.Level1);
		kindLevel.setName("test1");
		
		KindLevel kindLevel02 = new KindLevel();
		kindLevel02.setName("11111");
		kindLevel02.setType(LevelType.Level2);
		
		map.put("hello", "world");
		LOGGER.debug("saveMedicne start!");

		try {

			kindLevelService.save(kindLevel);
			kindLevel02.setKindLevel(kindLevel);
			kindLevelService.save(kindLevel02);
			LOGGER.debug("saveMedicne end!");
		} catch (Exception e) {
			LOGGER.error("save medicine throw", e);
		}
		return "hello";
	}
	
	@RequestMapping("/test02")
	public String test02(Map<String, Object> map) {

		
		
		KindLevel kindLevel02 = new KindLevel();
		kindLevel02.setName("11111");
		kindLevel02.setType(LevelType.Level2);
		
		map.put("hello", "world");
		LOGGER.debug("saveMedicne start!");

		try {
			KindLevel kindLevel =  kindLevelService.loadById(3);
			
			kindLevel02.setKindLevel(kindLevel);
			kindLevelService.save(kindLevel02);
			LOGGER.debug("saveMedicne end!");
		} catch (Exception e) {
			LOGGER.error("save medicine throw", e);
		}
		return "hello";
	}
	
	@RequestMapping("/test03")
	public String test03(Map<String, Object> map) {

		
		
		
		
		map.put("hello", "world");
		LOGGER.debug("saveMedicne start!");

		try {
			KindLevel kindLevel =  kindLevelService.loadById(3);
			
			for(KindLevel item :kindLevel.getKindLevels()) {
				System.out.println(item);
			}
			LOGGER.debug("saveMedicne end!");
		} catch (Exception e) {
			LOGGER.error("save medicine throw", e);
		}
		return "hello";
	}
	@RequestMapping("/manage")
	public String manage(Map<String, Object> map) {

		
		
		
		
		map.put("hello", "world");
		LOGGER.debug("saveMedicne start!");

		try {
			
			LOGGER.debug("saveMedicne end!");
		} catch (Exception e) {
			LOGGER.error("save medicine throw", e);
		}
		return "manage";
	}
	/*
	 * @RequestMapping("/saveMedicne")
	 * 
	 * @ResponseBody public int saveMedicne(@ModelAttribute("medicineForm")
	 * Medicine medicine){
	 * 
	 * LOGGER.debug("saveMedicne start!");
	 * 
	 * try {
	 * 
	 * medicineService.save(medicine); LOGGER.debug("saveMedicne end!"); return
	 * 0; } catch (Exception e) {
	 * 
	 * LOGGER.error("save medicine throw", e); return 1; }
	 * 
	 * }
	 */
}
