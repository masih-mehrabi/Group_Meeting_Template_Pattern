package de.tum.in.ase.pse;


public class PrivateTutorGroupMeeting extends TutorGroupMeeting {
	private final String address;
	private Student tutor;
	public PrivateTutorGroupMeeting(TimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractice, String address) {
		super(timeSlot, tutorGroup, skillToPractice);
		this.address = address;
		this.tutor = super.getTutor();
		setReminderStart("at " + address + " on ");
		setReminderEnd(".");
	}
	@Override
	public void greeting() {
		tutor.say("Welcome to the private tutor meeting :)");
		tutor.say("Thank you for coming to " + address + " today.");
		tutor.say("Please don't forget to wash your hands.");
	}

	@Override
	public void thankYou() {
		tutor.say("Thank you that you have participated today.");
		tutor.say("See you next time at " + address + "!");
	}
}

