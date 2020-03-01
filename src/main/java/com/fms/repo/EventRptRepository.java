package com.fms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fms.entity.EventDetails;
import com.fms.entity.EventSummaryEntity;
import com.fms.entity.IEventReport;
import com.fms.entity.IFeedbackStatus;
import com.fms.entity.UserMasterDetails;

public interface EventRptRepository  extends CrudRepository<EventSummaryEntity, Long> {

	@Query(value = "SELECT vea.event_name as name, avg(vf.score) as averageScore FROM vol_event_attended vea inner join volunteer_feedback vf on vea.event_id = vf.event_id group by vea.event_id", nativeQuery = true)
	List<IEventReport> findAllByEvents();

	@Query(value = "SELECT vea.event_name as name, avg(vf.score) as averageScore FROM vol_event_attended vea inner join volunteer_feedback vf on vea.event_id = vf.event_id and vf.event_id in (select event_id from event_summary where poc_id= ?1) group by vea.event_id", nativeQuery = true)
	List<IEventReport> findAllByPocEvents(String pocId);

	@Query(value = "SELECT vea.base_location as name, avg(vf.score) as averageScore FROM vol_event_attended vea inner join	volunteer_feedback vf on vea.event_id = vf.event_id group by vea.base_location", nativeQuery = true)
	List<IEventReport> findAllByBaseLocation();

	@Query(value = "SELECT vea.base_location as name, avg(vf.score) as averageScore FROM vol_event_attended vea inner join	volunteer_feedback vf on vea.event_id = vf.event_id and vf.event_id in (select event_id from event_summary where poc_id= ?1) group by vea.base_location", nativeQuery = true)
	List<IEventReport> findAllByPocBaseLocation(String pocId);

	@Query(value = "SELECT vea.beneficiary_name as name, avg(vf.score) as averageScore FROM vol_event_attended vea inner join volunteer_feedback vf on vea.event_id = vf.event_id group by vea.beneficiary_name", nativeQuery = true)
	List<IEventReport> findAllByBenificiary();

	@Query(value = "SELECT vea.beneficiary_name as name, avg(vf.score) as averageScore FROM vol_event_attended vea inner join volunteer_feedback vf on vea.event_id = vf.event_id and vf.event_id in (select event_id from event_summary where poc_id= ?1) group by vea.beneficiary_name", nativeQuery = true)
	List<IEventReport> findAllByPocBenificiary(String pocId);
	
	
	@Query(value = "SELECT vf.event_id as eventId, vf.employee_id as employeeId, vea.email_status as emailStatus, vf.status as feedbackStatus FROM vol_event_attended vea inner join volunteer_feedback vf on vea.event_id = vf.event_id and vea.employee_id = vf.employee_id", nativeQuery = true)
	List<IFeedbackStatus> findAllByVaStatus();
	
	@Query(value = "SELECT vf.event_id as eventId, vf.employee_id as employeeId, vea.email_status as emailStatus, vf.status as feedbackStatus FROM vol_event_not_attended vea inner join volunteer_feedback_nonpart vf on vea.event_id = vf.event_id and vea.employee_id = vf.employee_id", nativeQuery = true)
	List<IFeedbackStatus> findAllByVnaStatus();
	
	@Query(value = "SELECT vf.event_id as eventId, vf.employee_id as employeeId, vea.email_status as emailStatus, vf.status as feedbackStatus FROM vol_event_unregistered vea inner join volunteer_feedback_unreg vf on vea.event_id = vf.event_id and vea.employee_id = vf.employee_id;", nativeQuery = true)
	List<IFeedbackStatus> findAllByVunStatus();
	
	@Query(value="SELECT distinct event_id FROM fmsdb.event_summary", nativeQuery=true)
	List<String> findDistinctEvents();
	@Query(value="SELECT event_id,poc_id,poc_name,month,base_location,beneficiary_name,venue_address,council_name,project,catagory,event_name,event_description,event_date,total_vol_no,total_vol_hrs,total_travel_hrs,overall_vol_hrs,lives_impact,activity_type,status,poc_contact FROM event_summary", nativeQuery=true)
	List<EventDetails> findEventDetails();
	@Query(value="SELECT event_id,poc_id,poc_name,month,base_location,beneficiary_name,venue_address,council_name,project,catagory,event_name,event_description,event_date,total_vol_no,total_vol_hrs,total_travel_hrs,overall_vol_hrs,lives_impact,activity_type,status,poc_contact FROM event_summary where poc_id=?1", nativeQuery=true)
	List<EventDetails> findEventDetailsByPOC(String id);
	@Query(value="SELECT event_id,poc_id,poc_name,month,base_location,beneficiary_name,venue_address,council_name,project,catagory,event_name,event_description,event_date,total_vol_no,total_vol_hrs,total_travel_hrs,overall_vol_hrs,lives_impact,activity_type,status,poc_contact FROM event_summary where event_id=?1", nativeQuery=true)
	List<EventDetails> findEventBeneficiary(String eid);
	@Query(value="SELECT um.user_id,um.first_name,um.last_name,um.email_address from user_role_access ura inner join user_master um on ura.associate_id=um.user_id  where ura.role=?1",nativeQuery=true)
	List<UserMasterDetails> retrievePMODetailsByRole(String role);
/*Optional<EventSummaryEntity> findByEventIdAndPocId(String event_Id, String poc_Id);
	
	@Override
	@Query
	default <S extends EventSummaryEntity> Iterable<S> saveAll(Iterable<S> list) {
		list.forEach(ele -> {

			if (!findByEventIdAndPocId(ele.getEvent_Id(), ele.getPoc_Id()).isPresent()) {
				save(ele);
			}
		});

		return null;
	}*/
}
