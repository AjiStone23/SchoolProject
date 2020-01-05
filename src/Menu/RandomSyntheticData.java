/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import PrivateSchoolPackage.ClassRoom;
import PrivateSchoolPackage.Course;
import PrivateSchoolPackage.CourseAssignment;
import PrivateSchoolPackage.PrivateSchool;
import PrivateSchoolPackage.Stream;
import PrivateSchoolPackage.Student;
import PrivateSchoolPackage.Subject;
import PrivateSchoolPackage.TimeType;
import PrivateSchoolPackage.Trainer;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ajist
 */
public class RandomSyntheticData {
	
	private static PrivateSchool rdmSchool;

	public static PrivateSchool getRdmSchool() {
		return rdmSchool;
	}
	
	
	
	
	public static void createSytheticData() {
		rdmSchool = new PrivateSchool("A School");
		String[] names = {"ROMAN", "UMBERTO", "FRITZ", "WERNER", "LUIS", "CHRIS", "ANDREI", "INGMAR", "LEOS", "SOPHIA", "CLAIRE", "AKI", "DAVID", "BELA"};
		String[] surNames = {"LANG", "CRONENBERG", "TARKOVSKI", "JARMUSCH", "BRESSON", "MELLVILE", "BUNUEL", "LYNCH", "TARR", "CARAX", "KOBAYASHI", "EGGERS", "KAURISMAKI"};
		String[] courseNames = {"cb10", "cdd13", "tre11", "ger12", "kio89", "kol90", "tio89", "gty01"};
		String[] assignmentNames = {"ass01", "ass02", "ass03", "ass04", "ass05", "prj1", "prj2", "prj3", "prj5", "prj8", "prj9", "prj10", "prj12"};
		Random rd = new Random();

		List<String> namesList = new ArrayList<>(Arrays.asList(names));
		List<String> surNamesList = new ArrayList<>(Arrays.asList(surNames));
		List<String> courseNamesList = new ArrayList<>(Arrays.asList(courseNames));
		List<String> assignmentNamesList = new ArrayList<>(Arrays.asList(assignmentNames));

		List<String> classroomNames = new ArrayList<>();
		classroomNames.add("class32");
		classroomNames.add("class22");
		classroomNames.add("class144");
		classroomNames.add("class5");
		classroomNames.add("class52");
		classroomNames.add("class55");
		classroomNames.add("class45");

		List<Stream> streamsList = new ArrayList<>();
		streamsList.add(new Stream("StreamNumber1"));
		streamsList.add(new Stream("StreamNumber2"));
		streamsList.add(new Stream("StreamNumber3"));
		streamsList.add(new Stream("StreamNumber4"));

		List<CourseAssignment> assignmentsList = new ArrayList<>();
		List<Course> coursesList = new ArrayList<>();
		List<ClassRoom> classroomsList = new ArrayList<>();
             HashSet<ClassRoom> hashRoom=new HashSet<>();
		for (int i = 0; i < 30; i++) {
			LocalDate ld=UtilRdmGen.createRandomDate(2020, 2020, 3, 7);
			if(ld.getDayOfWeek().equals(DayOfWeek.SUNDAY))ld=ld.plusDays(1);
			if(ld.getDayOfWeek().equals(DayOfWeek.SATURDAY))ld=ld.plusDays(2);
			
			CourseAssignment ca = new CourseAssignment(UtilRdmGen.getRandomElement(assignmentNamesList), ld);
			assignmentsList.add(ca);
			rdmSchool.getAssignments().add(ca);

		}

		for (int i = 0; i < 7; i++) {
			Course co = new Course(UtilRdmGen.getRandomElement(courseNamesList), UtilRdmGen.createRandomDate(2020, 2020, 2, 2), UtilRdmGen.createRandomDate(2020, 2020, 8,8));
			
			co.addToStream(UtilRdmGen.getRandomElement(streamsList));
			int r = rd.nextInt(4) + 1;
			for (int j = 0; j < r; j++) {
				co.addAssignment(UtilRdmGen.getRandomElement(assignmentsList),hashRoom);

			}
            int t = rd.nextInt(4) + 1;
			if (t < 3) {
				co.setTimetype(TimeType.FULL_TIME);
			} else {
				co.setTimetype(TimeType.PART_TIME);
			}

			coursesList.add(co);
			rdmSchool.getSchoolCourses().add(co);

		}

		for (int i = 0; i < 5; i++) {
			ClassRoom cl = new ClassRoom(UtilRdmGen.getRandomElement(classroomNames), UtilRdmGen.getRandomElement(coursesList));
			classroomsList.add(cl);
			rdmSchool.getSchoolClassrooms().add(cl);

		}

		for (int i = 0; i < 40; i++) {
			Student st = new Student(UtilRdmGen.getRandomElement(namesList), UtilRdmGen.getRandomElement(surNamesList), UtilRdmGen.createRandomDate(1965, 2000, 1, 12));
			st.setTuitionFees(rd.nextFloat() * 1000);
			int r = rd.nextInt(3) + 1;
			for (int j = 0; j < r; j++) {
				st.attendClassRoom(UtilRdmGen.getRandomElement(classroomsList));

			}

			rdmSchool.getSchoolPopulation().add(st);
			rdmSchool.getSchoolStudents().add(st);

		}

		for (int i = 0; i < 10; i++) {
			Trainer tr = new Trainer(UtilRdmGen.getRandomElement(namesList), UtilRdmGen.getRandomElement(surNamesList), UtilRdmGen.createRandomDate(1965, 2000, 1, 12));
			
			int t = rd.nextInt(4) + 1;
			
			if (t < 2) {
				tr.setSubject(Subject.MATH);
			} else {
				tr.setSubject(Subject.COMPUTER_SCIENCE);
			}
			int r = rd.nextInt(3) + 1;
			for (int j = 0; j < r; j++) {
				tr.assignClassRoom(UtilRdmGen.getRandomElement(classroomsList));

			}

			rdmSchool.getSchoolPopulation().add(tr);
			rdmSchool.getSchoolTrainers().add(tr);

		}

	}
	
}
