/******************************************************************************
 * 版权所有 刘大磊 2013-07-01												  *
 *	作者：刘大磊								                                              *
 * 电话：13336390671                                                               * 
 * email:ldlqdsd@126.com						                              *
 *****************************************************************************/
package com.delmar.base;

import com.delmar.base.service.CityService;
import com.delmar.base.service.PortService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 刘大磊 2014年12月29日 下午4:29:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CityAndPortTest {
	@Autowired
	private CityService cityService;
	@Autowired
	private PortService portService;
	@Test
	public void updatePortCityId()
	{
/*		List<City> cityList=cityService.selectByExample(null);
		List<Port> portList=portService.selectByExample(null);
		for(City city:cityList)
		{
			for(Port port:portList)
			{
				if(port.getPortename()!=null)
				{
					if(port.getPortename().equals(city.getEname()))
					{
						System.out.println("update");
						port.setCityId(city.getId());
						portService.save(port);
					}
				}
			
			}
		}*/
	}
	
}
