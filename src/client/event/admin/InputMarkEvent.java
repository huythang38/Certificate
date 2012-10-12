package client.event.admin;

import client.action.record.InputMarks;

public class InputMarkEvent {
	public void inputMark(String students_name, int subjects_id, String mark) {
		InputMarks inputMark = new InputMarks(students_name, subjects_id, mark);
		inputMark.start();
	}
}
