package com.fms.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.fms.entity.EventPK;
import com.fms.entity.EventSummaryEntity;
import com.fms.entity.UserRole;
import com.fms.entity.VolunteerAttendedEntity;
import com.fms.entity.VolunteerNotAttendedEntity;
import com.fms.entity.VolunteerUnregisteredEntity;
import com.fms.model.Roles;
import com.fms.repo.EventRptRepository;
import com.fms.repo.RoleRepository;
import com.fms.repo.VolunteerAttendedRepo;
import com.fms.repo.VolunteerNotAttendedRepo;
import com.fms.repo.VolunteerUnregisteredRepo;

@Component
public class ExcelService {

	@Autowired
	private RoleRepository userRoleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private VolunteerAttendedRepo volunteerAttendedRepo;

	@Autowired
	private VolunteerNotAttendedRepo volunteerNotAttendedRepo;

	@Autowired
	private VolunteerUnregisteredRepo volunteerUnregisteredRepo;

	@Autowired
	private EventRptRepository eventSummaryRepo;

	public void saveExcel(String filePath, String fileName) throws IOException, InvalidFormatException {

		if (fileName.equals("Volunteer_Not_Attend.xlsx")) {
			readExcel("NOT_ATTENDED", filePath);
		} else if (fileName.equals("Volunteer_Attend.xlsx")) {
			readExcel("ATTENDED", filePath);
		} else if (fileName.equals("Volunteer_Unregistered.xlsx")) {
			readExcel("UNREG", filePath);
		} else if (fileName.equals("Events_Summary.xlsx")) {
			readExcel("SUMMERY", filePath);
		} else {
			return;
		}
	}

	public void readExcel(String type, String filePath) throws FileNotFoundException, InvalidFormatException {


		POIFSFileSystem fis = null;
		XSSFWorkbook myWorkBook = null;
		try {
			OPCPackage pkg = OPCPackage.open(new File(filePath));

			myWorkBook = new XSSFWorkbook(pkg);
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			Iterator<Row> rowIterator = mySheet.iterator();

			if (rowIterator.hasNext()) {
				rowIterator.next();
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");

			if (type == "ATTENDED") {
				List<VolunteerAttendedEntity> eventInfoList = new ArrayList<>();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					VolunteerAttendedEntity eventInfoEntity = getVolunteerAttended(dateFormat, row);
					eventInfoEntity.setEmailStatus("I");
					eventInfoList.add(eventInfoEntity);
				}
				if(!CollectionUtils.isEmpty(eventInfoList)) {
					volunteerAttendedRepo.saveAll(eventInfoList);
				}

			} else if (type == "NOT_ATTENDED") {
				List<VolunteerNotAttendedEntity> eventInfoList = new ArrayList<>();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					VolunteerNotAttendedEntity eventInfoEntity = getVolunteerNotAttended(dateFormat, row);
					eventInfoList.add(eventInfoEntity);
				}
				if(!CollectionUtils.isEmpty(eventInfoList)) {
					volunteerNotAttendedRepo.saveAll(eventInfoList);
				}
				

			} else if (type == "UNREG") {
				List<VolunteerUnregisteredEntity> eventInfoList = new ArrayList<>();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					VolunteerUnregisteredEntity eventInfoEntity = getVolunteerUnregistered(dateFormat, row);
					eventInfoList.add(eventInfoEntity);
				}
				if(!CollectionUtils.isEmpty(eventInfoList)) {
					volunteerUnregisteredRepo.saveAll(eventInfoList);
				}

			} else if (type == "SUMMERY") {
				List<EventSummaryEntity> eventInfoList = new ArrayList<>();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					EventSummaryEntity eventInfoEntity = getEventSummary(row);
					eventInfoList.add(eventInfoEntity);
				}
				if(!CollectionUtils.isEmpty(eventInfoList)) {
					saveSummery(eventInfoList);
				}			

			}
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			if (myWorkBook != null) {
				/*
				 * try { myWorkBook.close(); } catch (IOException e) { e.printStackTrace(); }
				 */
			}
			if (fis != null) {
				/*
				 * try { fis.close(); } catch (IOException e) { e.printStackTrace(); }
				 */
			}
		}
	}

	private EventSummaryEntity getEventSummary(Row row) {
		EventSummaryEntity eventSummaryEntity = new EventSummaryEntity();
		DataFormatter formatter = new DataFormatter();
		String eventId = formatter.formatCellValue(row.getCell(0));
		eventSummaryEntity.setMonth(formatter.formatCellValue(row.getCell(1)));
		eventSummaryEntity.setBaseLocation(formatter.formatCellValue(row.getCell(2)));
		eventSummaryEntity.setBeneficiaryName(formatter.formatCellValue(row.getCell(3)));
		eventSummaryEntity.setVenueAddress(formatter.formatCellValue(row.getCell(4)));
		eventSummaryEntity.setCouncilName(formatter.formatCellValue(row.getCell(5)));
		eventSummaryEntity.setProject(formatter.formatCellValue(row.getCell(6)));
		eventSummaryEntity.setCategory(formatter.formatCellValue(row.getCell(7)));
		eventSummaryEntity.setEventName(formatter.formatCellValue(row.getCell(8)));
		eventSummaryEntity.setEventDescription(formatter.formatCellValue(row.getCell(9)));
		eventSummaryEntity.setEventDate(formatDate(formatter.formatCellValue(row.getCell(10))));
		eventSummaryEntity.setTotalNoOfVolunteers(getNumber(formatter.formatCellValue(row.getCell(11))));
		eventSummaryEntity.setTotalVolHours(getDouble(formatter.formatCellValue(row.getCell(12))));
		eventSummaryEntity.setTotalTravelHours(getDouble(formatter.formatCellValue(row.getCell(13))));
		eventSummaryEntity.setOverAllVolHours(getDouble(formatter.formatCellValue(row.getCell(14))));
		eventSummaryEntity.setLivesImpacted(getNumber(formatter.formatCellValue(row.getCell(15))));
		eventSummaryEntity.setActivityType(formatter.formatCellValue(row.getCell(16)));
		eventSummaryEntity.setStatus(formatter.formatCellValue(row.getCell(17)));
		eventSummaryEntity.setPocId(formatter.formatCellValue(row.getCell(18)));
		eventSummaryEntity.setPocName(formatter.formatCellValue(row.getCell(19)));
		eventSummaryEntity.setPocContactNumber(formatter.formatCellValue(row.getCell(20)));

		eventSummaryEntity.setEventId(eventId);
		// row.getCell(2).setCellType(CellType.STRING);
		
		return eventSummaryEntity;
	}
	
	private Integer getNumber(String value) {
		if(!StringUtils.isEmpty(value)) {
			return Integer.valueOf(value);
		}
		return 0;
	}
	
	private Double getDouble(String value) {
		if(!StringUtils.isEmpty(value)) {
			return Double.valueOf(value);
		}
		return 0.0;
	}
	
	private Date formatDate(String dateValue) {
		String pattern = "MM-dd-yy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = simpleDateFormat.parse(dateValue);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	private VolunteerUnregisteredEntity getVolunteerUnregistered(SimpleDateFormat dateFormat, Row row) throws ParseException {
		VolunteerUnregisteredEntity eventInfoEntity = new VolunteerUnregisteredEntity();
		DataFormatter formatter = new DataFormatter();
		String eventId = formatter.formatCellValue(row.getCell(0));
		String eventname = formatter.formatCellValue(row.getCell(1));
		String beneficiaryName = formatter.formatCellValue(row.getCell(2));
		String baseLocation = formatter.formatCellValue(row.getCell(3));
		String eventDate = formatter.formatCellValue(row.getCell(4));
		String employeeId = formatter.formatCellValue(row.getCell(5));

		eventInfoEntity.setEventPK(new EventPK(eventId, employeeId));
		eventInfoEntity.setBaseLocation(baseLocation);
		eventInfoEntity.setBeneficiaryName(beneficiaryName);
		eventInfoEntity.setEventDate(dateFormat.parse(eventDate));
		eventInfoEntity.setEventName(eventname);
		return eventInfoEntity;
	}

	private VolunteerNotAttendedEntity getVolunteerNotAttended(SimpleDateFormat dateFormat, Row row) throws ParseException {
		VolunteerNotAttendedEntity eventInfoEntity = new VolunteerNotAttendedEntity();
		DataFormatter formatter = new DataFormatter();
		String eventId = formatter.formatCellValue(row.getCell(0));
		String eventname = formatter.formatCellValue(row.getCell(1));
		String beneficiaryName = formatter.formatCellValue(row.getCell(2));
		String baseLocation = formatter.formatCellValue(row.getCell(3));
		String eventDate = formatter.formatCellValue(row.getCell(4));
		String employeeId = formatter.formatCellValue(row.getCell(5));
		eventInfoEntity.setEventPK(new EventPK(eventId, employeeId));
		eventInfoEntity.setBaseLocation(baseLocation);
		eventInfoEntity.setBeneficiaryName(beneficiaryName);
		eventInfoEntity.setEventDate(dateFormat.parse(eventDate));
		eventInfoEntity.setEventName(eventname);
		return eventInfoEntity;
	}

	private VolunteerAttendedEntity getVolunteerAttended(SimpleDateFormat dateFormat, Row row) throws ParseException {
		VolunteerAttendedEntity eventInfoEntity = new VolunteerAttendedEntity();
		DataFormatter formatter = new DataFormatter();
		String eventId = formatter.formatCellValue(row.getCell(0));
		String baseLocation = formatter.formatCellValue(row.getCell(1));
		String beneficiaryName = formatter.formatCellValue(row.getCell(2));
		String eventname = formatter.formatCellValue(row.getCell(4));
		String employeeId = formatter.formatCellValue(row.getCell(7));
		String employeeName = formatter.formatCellValue(row.getCell(8));
		Double volHours = getDouble(formatter.formatCellValue(row.getCell(9)));
		Double travelHours = getDouble(formatter.formatCellValue(row.getCell(10)));
		Integer livesImpacted = getNumber(formatter.formatCellValue(row.getCell(11)));
		String status = formatter.formatCellValue(row.getCell(13));
		String iiepCategory = formatter.formatCellValue(row.getCell(14));		
		eventInfoEntity.setEmployeeName(employeeName);
		eventInfoEntity.setVolHours(volHours);
		eventInfoEntity.setTravelHours(travelHours);
		eventInfoEntity.setLivesImpacted(livesImpacted);
		eventInfoEntity.setStatus(status);
		eventInfoEntity.setIiepCategory(iiepCategory);
		eventInfoEntity.setEventPK(new EventPK(eventId, employeeId ));
		eventInfoEntity.setBaseLocation(baseLocation);
		eventInfoEntity.setBeneficiaryName(beneficiaryName);
		eventInfoEntity.setEventName(eventname);
		return eventInfoEntity;
	}

	private void saveSummery(List<EventSummaryEntity> eventInfoList) {


		//List<EventSummaryEntity> resultList = new ArrayList<>();
		List<UserRole> userList = new ArrayList<>();

		eventInfoList.stream().forEach(es -> {

			// for multiple poc id
			if (es.getPocId().contains(";")) {
				String[] pocIds = es.getPocId().split(";");
				String[] names = es.getPocName().split(";");
				int index = 0;
				// create a new es and user role object
				for (String id : pocIds) {
					//resultList.add(new EventSummaryEntity(es.getEventId(), id, names[index]));
					index++;
					userList.add(new UserRole(id + "@cognizant.com", id, passwordEncoder.encode(id), true, true, true,
							true, Roles.ROLE_POC));
				}

			} else {
				// for non multiple pocId
				//resultList.add(new EventSummaryEntity(es.getEventId(), es.getPocId(), es.getPocName()));
				userList.add(new UserRole(es.getPocId() + "@cognizant.com", es.getPocId(),
						passwordEncoder.encode(es.getPocId()), true, true, true, true, Roles.ROLE_POC));
			}

		});

		eventSummaryRepo.saveAll(eventInfoList);
		userRoleRepository.saveAll(userList);

	}

}
