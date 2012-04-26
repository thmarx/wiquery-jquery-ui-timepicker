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

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.odlabs.wiquery.core.IWiQueryPlugin;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.core.options.Options;
import org.odlabs.wiquery.ui.commons.WiQueryUIPlugin;
import org.odlabs.wiquery.ui.datepicker.DatePickerJavaScriptResourceReference;
import org.odlabs.wiquery.ui.effects.SlideEffectJavaScriptResourceReference;
import org.odlabs.wiquery.ui.slider.SliderJavaScriptResourceReference;
import org.odlabs.wiquery.ui.widget.WidgetJavaScriptResourceReference;

/**
 * $Id$
 * <p>
 * Extends the {@link TextField} to provide a date picker.
 * </p>
 * 
 * <p>
 * By default, the datepicker calendar opens in a small overlay onFocus and
 * closes automatically onBlur or when a date if selected. For an inline
 * calendar, simply attach the datepicker to a div or span.
 * 
 * 
 * Missing functionnalities
 * <ul>
 * <li>Method : dialog</li>
 * </ul>
 * 
 * @author Lionel Armanet
 * @since 0.6
 */
@WiQueryUIPlugin
public class TimePicker<T> extends TextField<T> implements IWiQueryPlugin {

	// Constants
	/** Constant of serialization */
	private static final long serialVersionUID = 2L;

	// Properties
	private TimePickerOptions options;

	/**
	 * Constructor
	 * 
	 * @param id
	 *            Markup identifiant
	 * @param type
	 *            Class type
	 */
	public TimePicker(String id, Class<T> type) {
		super(id, type);
		options = new TimePickerOptions(this);
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 *            Markup identifiant
	 * @param model
	 *            Model to use
	 * @param type
	 *            Class type
	 */
	public TimePicker(String id, IModel<T> model, Class<T> type) {
		super(id, model, type);
		options = new TimePickerOptions(this);
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 *            Markup identifiant
	 * @param model
	 *            Model to use
	 */
	public TimePicker(String id, IModel<T> model) {
		super(id, model);
		options = new TimePickerOptions(this);
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 *            Markup identifiant
	 */
	public TimePicker(String id) {
		super(id);
		options = new TimePickerOptions(this);
	}

	@Override
	protected void detachModel() {
		super.detachModel();
		options.detach();
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		
		response.renderJavaScriptReference(SliderJavaScriptResourceReference.get());
		response.renderJavaScriptReference(DatePickerJavaScriptResourceReference.get());
		
		response.renderJavaScriptReference(WidgetJavaScriptResourceReference
				.get());
		response.renderJavaScriptReference(TimePickerJavaScriptResourceReference
				.get());
		response.renderCSSReference(TimePickerStyleSheetResourceReference.get());

		TimePickerLanguageResourceReference dpl = TimePickerLanguageResourceReference
				.get(getLocale());
		if (dpl != null)
			response.renderJavaScriptReference(dpl);
	}

	public JsStatement statement() {
		return new JsQuery(this).$().chain("timepicker",
				options.getOptions().getJavaScriptOptions());
	}

	/**
	 * Method retrieving the options of the component
	 * 
	 * @return the options
	 */
	protected Options getOptions() {
		return options.getOptions();
	}

	/*---- Options section ---*/

	

	/*---- Methods section ---*/
	/**
	 * Method to destroy the datepicker This will return the element back to its
	 * pre-init state.
	 * 
	 * @return the associated JsStatement
	 */
	public JsStatement destroy() {
		return new JsQuery(this).$().chain("timepicker", "'destroy'");
	}

	/**
	 * Method to destroy the datepicker within the ajax request
	 * 
	 * @param ajaxRequestTarget
	 */
	public void destroy(AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavaScript(this.destroy().render().toString());
	}

	/**
	 * Method to disable the datepicker
	 * 
	 * @return the associated JsStatement
	 */
	public JsStatement disable() {
		return new JsQuery(this).$().chain("timepicker", "'disable'");
	}

	/**
	 * Method to disable the datepicker within the ajax request
	 * 
	 * @param ajaxRequestTarget
	 */
	public void disable(AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavaScript(this.disable().render().toString());
	}

	/**
	 * Method to enable the datepicker
	 * 
	 * @return the associated JsStatement
	 */
	public JsStatement enable() {
		return new JsQuery(this).$().chain("timepicker", "'enable'");
	}

	/**
	 * Method to enable the datepicker within the ajax request
	 * 
	 * @param ajaxRequestTarget
	 */
	public void enable(AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavaScript(this.enable().render().toString());
	}

	/**
	 * Method to hide the datepicker
	 * 
	 * @param speed
	 *            The speed at which to close the date picker.
	 * @return the associated JsStatement
	 */
	public JsStatement hide(short speed) {
		return new JsQuery(this).$().chain("timepicker", "'hide'",
				Short.toString(speed));
	}

	/**
	 * Method to hide the datepicker within the ajax request
	 * 
	 * @param ajaxRequestTarget
	 * @param speed
	 *            The speed at which to close the date picker.
	 */
	public void hide(AjaxRequestTarget ajaxRequestTarget, short speed) {
		ajaxRequestTarget
				.appendJavaScript(this.hide(speed).render().toString());
	}

	/**
	 * Method to hide the datepicker
	 * 
	 * @return the associated JsStatement
	 */
	public JsStatement hide() {
		return new JsQuery(this).$().chain("timepicker", "'hide'");
	}

	/**
	 * Method to hide the datepicker within the ajax request
	 * 
	 * @param ajaxRequestTarget
	 */
	public void hide(AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavaScript(this.hide().render().toString());
	}



	/**
	 * Method to show the datepicker
	 * 
	 * @return the associated JsStatement
	 */
	public JsStatement show() {
		return new JsQuery(this).$().chain("datepicker", "'show'");
	}

	/**
	 * Method to show the datepicker within the ajax request
	 * 
	 * @param ajaxRequestTarget
	 */
	public void show(AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavaScript(this.show().render().toString());
	}

	/**
	 * Method to returns the .ui-datepicker element
	 * 
	 * @return the associated JsStatement
	 */
	public JsStatement widget() {
		return new JsQuery(this).$().chain("timepicker", "'widget'");
	}

	/**
	 * Method to returns the .ui-datepicker element within the ajax request
	 * 
	 * @param ajaxRequestTarget
	 */
	public void widget(AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavaScript(this.widget().render().toString());
	}
}
