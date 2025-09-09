package com.example.notifications;

public abstract class NotifierDecorator implements Notifier {
	protected final Notifier next;

	protected NotifierDecorator(Notifier next) {
		this.next = next;
	}
}
