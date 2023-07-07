package com.java.framework.core.reporting.factory;

import com.java.framework.core.logging.logger.exceptions.ArgumentNotSupportedException;
import com.java.framework.core.reporting.HTMLReportObserver;
import com.java.framework.core.reporting.extent.ExtentHTMLReportObserver;
import com.java.framework.core.reporting.reportportal.ReportPortalObserver;

public class ReporterFactory {

	private static HTMLReportObserver reporter = null;

	private ReporterFactory() {
	}

	public static HTMLReportObserver getReporter(ReporterType reporterType) {
		if (reporter == null) {
			createReporter(reporterType);
		}
		return reporter;
	}

	private static void createReporter(ReporterType reporterType) {
		switch (reporterType) {
		case ExtentReport:
			reporter = new ExtentHTMLReportObserver();
			break;
		case ReportPortal:
			reporter = new ReportPortalObserver();
			break;
		default:
			throw new ArgumentNotSupportedException("Currently Supported  Reporters - Extent  and  ReportPortal");
		}
	}
}
