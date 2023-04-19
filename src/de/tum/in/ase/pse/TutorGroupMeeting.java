package de.tum.in.ase.pse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class TutorGroupMeeting {
	private static final int HOME_WORK_SLOTS = 3;
	private final TimeSlot timeSlot;
	private final TutorGroup tutorGroup;
	private final Skill skillToPractice;
	
	private String reminderEnd;
	
	private String reminderStart;
	private Student tutor;
	public TutorGroupMeeting(TimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractice) {
		this.timeSlot = timeSlot;
		this.tutorGroup = tutorGroup;
		this.skillToPractice = skillToPractice;
		this.tutor = tutorGroup.getTutor();
	}
	
	public TutorGroup getTutorGroup() {
		return tutorGroup;
	}
	
	public Skill getSkillToPractice() {
		return skillToPractice;
	}
	
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}
	

	public Student getTutor() {

		return tutor;
	}
	
	public abstract void greeting();
	

	
	public void homeWorkPresentation(int homeWorkSlots) {
		tutor.say("We start with the homework presentation.");
		List<Student> homeworkPresentationCandidates = new ArrayList<>(getTutorGroup().getStudents());
		for (int i = 0; i < homeWorkSlots; i++) {
			if (homeworkPresentationCandidates.isEmpty()) {
				break;
			}
			int randomIndex = ThreadLocalRandom.current().nextInt(homeworkPresentationCandidates.size());
			Student randomStudent = homeworkPresentationCandidates.get(randomIndex);
			randomStudent.presentHomework();
			homeworkPresentationCandidates.remove(randomIndex);
		}
	}
	
	public void reminder() {
		tutor.say("By the way I wanted to remind you this meeting happens regularly " + reminderStart
				          + getTimeSlot().getDayOfWeek() + " starting at " + getTimeSlot().getStartTime() + " and finishing at "
				          + getTimeSlot().getEndTime() + reminderEnd);
	}
	public void practiceSkills() {
		tutor.say("Next is the group work!");
		Skill skill = getSkillToPractice();
		skill.apply();
		for (Student student : getTutorGroup().getStudents()) {
			student.learnSkill(skill);
		}
		tutor.say("Let's have a look at the new homework :)");
	}
	
	public abstract void thankYou();
	
	public void practice() {
		greeting();
		homeWorkPresentation(HOME_WORK_SLOTS);
		reminder();
		practiceSkills();
		thankYou();
	}
	
	public void setReminderEnd(String reminder) {
		this.reminderEnd = reminder;
	}
	
	public void setReminderStart(String reminderStart) {
		this.reminderStart = reminderStart;
	}
}
