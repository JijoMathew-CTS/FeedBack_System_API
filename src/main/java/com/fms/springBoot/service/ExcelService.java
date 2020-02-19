package com.fms.springBoot.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Component;

import com.fms.springBoot.RoleRepository;
import com.fms.springBoot.Model.Roles;
import com.fms.springBoot.entity.UserRole;
import com.fms.springBoot.entity.VolunteerAttended;
import com.fms.springBoot.entity.VolunteerNotAttended;
import com.fms.springBoot.entity.VolunteerUnregistered;
import com.fms.springBoot.entity.EventPK;
import com.fms.springBoot.entity.EventSummaryEntity;
import com.fms.springBoot.VolunteerAttendedRepo;
import com.fms.springBoot.VolunteerNotAttendedRepo;
import com.fms.springBoot.VolunteerUnregisteredRepo;
import com.fms.springBoot.EventRptRepository;

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
	
	public void saveExcel(String filePath,String fileName) throws IOException, InvalidFormatException {
	
	System.out.println("fileName = "+fileName);
	
		if (fileName.equals("Volunteer_Not_Attend.xlsx")) {
			readExcel("NOT_ATTENDED",filePath);
		} else if (fileName.equals("Volunteer_Attend.xlsx")) {
			readExcel("ATTENDED",filePath);
		} else if (fileName.equals("Volunteer_Unregistered.xlsx")) {
			readExcel("UNREG",filePath);
		} else if (fileName.equals("Events_Summary.xlsx")) {
			readExcel("SUMMERY",filePath);	
		} else {
			return;
		}
	}

	public void readExcel(String type,String filePath) throws FileNotFoundException, InvalidFormatException {
		System.out.println("type = "+type);
		
		//FileInputStream file = new FileInputStream(filePath);
		
		POIFSFileSystem fis = null;
		XSSFWorkbook  myWorkBook = null;
		try {
			/*fis = new FileInputStream(filePath.toFile());*/
			//fis = new FileInputStream(filePath);
			OPCPackage pkg = OPCPackage.open(new File(filePath));
			
			//fis=new POIFSFileSystem(file);
			myWorkBook = new XSSFWorkbook (pkg);
			//myWorkBook=(HSSFWorkbook) WorkbookFactory.create(fis);
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			Iterator<Row> rowIterator = mySheet.iterator();

			if (rowIterator.hasNext()) {
				rowIterator.next();
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");

			if (type=="ATTENDED") {
				List<VolunteerAttended> eventInfoList = new ArrayList<>();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					
					System.out.println("before get = ");
					
					VolunteerAttended eventInfoEntity = getVolunteerAttended(dateFormat, row);
					System.out.println("after get = ");
					eventInfoEntity.setEmailStatus("I");
					eventInfoList.add(eventInfoEntity);
				}
				volunteerAttendedRepo.saveAll(eventInfoList);
				
			} else if (type=="NOT_ATTENDED") {
				List<VolunteerNotAttended> eventInfoList = new ArrayList<>();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					VolunteerNotAttended eventInfoEntity = getVolunteerNotAttended(dateFormat, row);
					eventInfoEntity.setEmailStatus("I");
					eventInfoList.add(eventInfoEntity);
				}
				volunteerNotAttendedRepo.saveAll(eventInfoList);
				
			} else if (type=="UNREG") {
				List<VolunteerUnregistered> eventInfoList = new ArrayList<>();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					VolunteerUnregistered eventInfoEntity = getVolunteerUnregistered(dateFormat, row);
					eventInfoEntity.setEmailStatus("I");
					eventInfoList.add(eventInfoEntity);
				}
				volunteerUnregisteredRepo.saveAll(eventInfoList);
				
			} else  if (type=="SUMMERY") {
				List<EventSummaryEntity> eventInfoList = new ArrayList<>();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					EventSummaryEntity eventInfoEntity = getEventSummary(row);
					eventInfoList.add(eventInfoEntity);
				}
				saveSummery(eventInfoList);
				
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (myWorkBook != null) {
				/*try {
					myWorkBook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}*/
			}
			if (fis != null) {
				/*try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}*/
			}
		}
	}
	
	private EventSummaryEntity getEventSummary(Row row) {
		EventSummaryEntity eventSummaryEntity = new EventSummaryEntity();
		DataFormatter formatter = new DataFormatter();
		String eventId 			= formatter.formatCellValue(row.getCell(0));
		String pocId			= formatter.formatCellValue(row.getCell(1));
		String pocName			= formatter.formatCellValue(row.getCell(2));
		
		eventSummaryEntity.setEvent_Id(eventId);
		//row.getCell(2).setCellType(CellType.STRING);
		eventSummaryEntity.setPoc_Id(pocId);
		eventSummaryEntity.setPoc_Name(pocName);
		return eventSummaryEntity;
	}
	private VolunteerUnregistered getVolunteerUnregistered(SimpleDateFormat dateFormat, Row row) throws ParseException {
		VolunteerUnregistered eventInfoEntity = new VolunteerUnregistered();
		//row.getCell(1).setCellType(CellType.STRING);
		DataFormatter formatter = new DataFormatter();
		String eventId 			= formatter.formatCellValue(row.getCell(0));
		String employeeId 		= formatter.formatCellValue(row.getCell(1));
		String baseLocation		= formatter.formatCellValue(row.getCell(2));
		String beneficiaryName	= formatter.formatCellValue(row.getCell(3));
		String eventDate 		= formatter.formatCellValue(row.getCell(4));
		String eventname 		= formatter.formatCellValue(row.getCell(5));
		
		eventInfoEntity
				.setEventPK(new EventPK(eventId, employeeId + ""));
		eventInfoEntity.setBaseLocation(baseLocation);
		eventInfoEntity.setBeneficiaryName(beneficiaryName);
		eventInfoEntity.setEventDate(dateFormat.parse(eventDate));
		eventInfoEntity.setEventName(eventname);
		return eventInfoEntity;
	}
		private VolunteerNotAttended getVolunteerNotAttended(SimpleDateFormat dateFormat, Row row) throws ParseException {
			VolunteerNotAttended eventInfoEntity = new VolunteerNotAttended();
			//row.getCell(1).setCellType(CellType.STRING);
			
			DataFormatter formatter = new DataFormatter();
			String eventId 			= formatter.formatCellValue(row.getCell(0));
			String employeeId 		= formatter.formatCellValue(row.getCell(1));
			String baseLocation		= formatter.formatCellValue(row.getCell(2));
			String beneficiaryName	= formatter.formatCellValue(row.getCell(3));
			String eventDate 		= formatter.formatCellValue(row.getCell(4));
			String eventname 		= formatter.formatCellValue(row.getCell(5));
								
			eventInfoEntity
					.setEventPK(new EventPK(eventId, employeeId + ""));
			eventInfoEntity.setBaseLocation(baseLocation);
			eventInfoEntity.setBeneficiaryName(beneficiaryName);
			eventInfoEntity.setEventDate(dateFormat.parse(eventDate));
			eventInfoEntity.setEventName(eventname);
			return eventInfoEntity;
		}
		
		private VolunteerAttended getVolunteerAttended(SimpleDateFormat dateFormat, Row row) throws ParseException {
			VolunteerAttended eventInfoEntity = new VolunteerAttended();
			//row.getCell(1).setCellType(CellType.STRING);
			DataFormatter formatter = new DataFormatter();
			String eventId 			= formatter.formatCellValue(row.getCell(0));
			String employeeId 		= formatter.formatCellValue(row.getCell(1));
			String baseLocation		= formatter.formatCellValue(row.getCell(2));
			String beneficiaryName	= formatter.formatCellValue(row.getCell(3));
			String eventDate 		= formatter.formatCellValue(row.getCell(4));
			String eventname 		= formatter.formatCellValue(row.getCell(5));
			
			eventInfoEntity
					.setEventPK(new EventPK(eventId, employeeId + ""));

			eventInfoEntity.setBaseLocation(baseLocation);
			eventInfoEntity.setBeneficiaryName(beneficiaryName);
			eventInfoEntity.setEventDate(dateFormat.parse(eventDate));
			eventInfoEntity.setEventName(eventname);
			return eventInfoEntity;
		}
		
	/*public void savePmoDetails(String filePath) throws IOException {
		FileInputStream fis = null;
		XSSFWorkbook myWorkBook = null;
		List<UserRole> pmoList = new ArrayList<>();

		try {
			fis = new FileInputStream(filePath);
			myWorkBook = new XSSFWorkbook(fis);
			Row row = null;
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);

			Iterator<Row> rowIterator = mySheet.iterator();

			if (rowIterator.hasNext()) {
				rowIterator.next();
			}
			String associateId = "";
			while (rowIterator.hasNext()) {
				associateId = row.getCell(0).getStringCellValue();
				row = rowIterator.next();
				row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
				pmoList.add(new UserRole(associateId + "@cognizant.com",	// email
						associateId, 										// username
						passwordEncoder.encode(associateId),				// password
						true, true, true, true, Roles.ROLE_PMO));
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			if (myWorkBook != null) {
				//try {
					//myWorkBook.close();
				//} catch (IOException e) {
				//	e.printStackTrace();
				//}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		userRoleRepository.saveAll(pmoList);
		Files.delete(Paths.get(filePath));
	}
	*/
	private void saveSummery(List<EventSummaryEntity> eventInfoList) {
		// TODO Auto-generated method stub
System.out.println("inside save summery = ");
		List<EventSummaryEntity> resultList = new ArrayList<>();
		List<UserRole> userList = new ArrayList<>();

		eventInfoList.stream().forEach(es -> {

			// for multiple poc id
			if (es.getPoc_Id().contains(";")) {
				String[] pocIds = es.getPoc_Id().split(";");
				String[] names = es.getPoc_Name().split(";");
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
			//	resultList.add(new EventSummaryEntity(es.getEventId(), es.getPocId(), es.getPocName()));
				userList.add(new UserRole(es.getPoc_Id() + "@cognizant.com", es.getPoc_Id(),
						passwordEncoder.encode(es.getPoc_Id()), true, true, true, true, Roles.ROLE_POC));
			}

		});

		eventSummaryRepo.saveAll(resultList);
		userRoleRepository.saveAll(userList);

	}

	
}
