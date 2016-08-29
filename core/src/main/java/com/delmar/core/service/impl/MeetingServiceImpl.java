/******************************************************************************
 * 德玛国际物流有限公司  2013-07-01												      *
 *	作者：刘大磊								                                      *
 * 电话：0532-66701118                                                          * 
 * email:liua@delmarchina.com						                          *
 *****************************************************************************/

package com.delmar.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delmar.core.dao.MeetingDao;
import com.delmar.core.model.Meeting;
import com.delmar.core.service.MeetingService;
import com.delmar.core.dao.CoreDao;
import com.delmar.core.service.impl.CoreServiceImpl;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.delmar.core.model.MeetingParticipant;
import com.delmar.core.model.MeetingTopic;
import com.delmar.core.dao.MeetingParticipantDao;
import com.delmar.core.dao.MeetingTopicDao;
/**
 * @author 刘大磊 2016-08-27 16:28:14
 */
@Service("meetingService")
public class MeetingServiceImpl extends CoreServiceImpl<Meeting> implements
		MeetingService {
	@Autowired
	private MeetingDao meetingDao;
    @Autowired
    private MeetingParticipantDao meetingParticipantDao;
    @Autowired
    private MeetingTopicDao meetingTopicDao;
	/* (non-Javadoc)
	 * @see CoreService.CoreServiceImpl#getCoreDao()
	 */
	protected CoreDao<Meeting> getCoreDao() {
		return meetingDao;
	}
	public void deleteMeetingList(Integer[] ids)
	{
		if(ids!=null)
		for(Integer id:ids)
		{
			deleteByPrimaryKey(id);
		}
	}


public Integer saveMeeting(Meeting meeting,List<MeetingParticipant> meetingParticipantList,List<MeetingTopic> meetingTopicList) {
	Integer id=save(meeting);
		for(MeetingParticipant meetingParticipant: meetingParticipantList)
		{
			meetingParticipant.setMeetingId(id);
			meetingParticipantDao.save(meetingParticipant);
		}
		for(MeetingTopic meetingTopic: meetingTopicList)
		{
			meetingTopic.setMeetingId(id);
			meetingTopicDao.save(meetingTopic);
		}
	return id;
}


    public Integer deleteByPrimaryKey(Integer id) {
    Map<String,Object> meetingParticipantParam=new HashMap<String,Object>();
meetingParticipantParam.put("meetingId",id);
meetingParticipantDao.deleteByExample(meetingParticipantParam);
    Map<String,Object> meetingTopicParam=new HashMap<String,Object>();
meetingTopicParam.put("meetingId",id);
meetingTopicDao.deleteByExample(meetingTopicParam);
    return super.deleteByPrimaryKey(id);
    }

	public List<MeetingParticipant> getMeetingParticipantListByMeetingId(Integer meetingId)
	{
		Map<String,Object> param=new HashMap<String,Object>();
        param.put("meetingId",meetingId);
		return meetingParticipantDao.selectByExample(param);
	}
	public List<MeetingTopic> getMeetingTopicListByMeetingId(Integer meetingId)
	{
		Map<String,Object> param=new HashMap<String,Object>();
        param.put("meetingId",meetingId);
		return meetingTopicDao.selectByExample(param);
	}
}