/*
 * Copyright (c) 2009 WiQuery team
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.odlabs.wiquery.ui.timepicker;

import org.apache.wicket.Component;
import org.odlabs.wiquery.core.options.Options;

/**
 * An options class to store date picker info so that both InlineDatePiker and
 * datePicker can share them.
 * 
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 * @since 1.0.2
 */
public class TimePickerOptions extends Options {

	private static final long serialVersionUID = 1L;
	
	private short hour 			= 0;
	private short minute 		= 0;
	private short second		= 0;
	private short millisec		= 0;

	/**
	 * Constructor
	 */
	public TimePickerOptions(Component owner) {
		super(owner);
	}

	
	

	public short getHour() {
		return hour;
	}




	public void setHour(short hour) {
		this.hour = hour;
	}




	public short getMinute() {
		return minute;
	}




	public void setMinute(short minute) {
		this.minute = minute;
	}




	public short getSecond() {
		return second;
	}




	public void setSecond(short second) {
		this.second = second;
	}




	public short getMillisec() {
		return millisec;
	}




	public void setMillisec(short millisec) {
		this.millisec = millisec;
	}




	public Options getOptions() {
		return this;
	}
}
