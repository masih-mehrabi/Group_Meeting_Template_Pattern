package de.tum.in.ase.pse;
import java.net.URL;
public class VirtualTutorGroupMeeting extends TutorGroupMeeting {
	private final URL url;
	private Student tutor;
	public VirtualTutorGroupMeeting(TimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractice, URL url) {
		super(timeSlot, tutorGroup, skillToPractice);
		this.url = url;
		this.tutor = super.getTutor();
		setReminderStart("online on ");
		setReminderEnd(", you can join it with the link " + url.toString() + ".");
	}
	@Override
	public void greeting() {
		tutor.say("Welcome to the virtual tutor meeting :)");
		tutor.say("Thank you for joining using " + url.toString() + " today.");
		tutor.say("Please turn on your cameras.");
	}
	
	@Override
	public void thankYou() {
		tutor.say("Thank you that you have participated using the " + url + " today.");
		tutor.say("See you next time!");
	}
}
