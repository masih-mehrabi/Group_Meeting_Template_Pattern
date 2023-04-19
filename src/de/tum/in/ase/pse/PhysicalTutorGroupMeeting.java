package de.tum.in.ase.pse;

public class PhysicalTutorGroupMeeting extends TutorGroupMeeting {
	private final String room;
	private Student tutor;
	public PhysicalTutorGroupMeeting(TimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractice, String room) {
		super(timeSlot, tutorGroup, skillToPractice);
		this.room = room;
		this.tutor = super.getTutorGroup().getTutor();
		setReminderEnd(" in the room " + room + ".");
		setReminderStart("in person on ");
	}
	@Override
	public void greeting() {
		tutor.say("Welcome to the physical tutor meeting :)");
		tutor.say("Thank you for coming to " + room + " today.");
	}
	
	@Override
	public void thankYou() {
		tutor.say("Thank you that you have participated in " + room + " today.");
		tutor.say("See you next time!");
	}
}
