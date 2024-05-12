package script;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.testng.IInvokedMethod;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.collections.Lists;
import org.testng.internal.Utils;
import org.testng.log4testng.Logger;
import org.testng.xml.XmlSuite;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;

import generic.AutoConstant;
import generic.Lib;

public class CustomizedEmailableReport implements IReporter, AutoConstant {

	private static final Logger L = Logger.getLogger(CustomizedEmailableReport.class);

	// ~ Instance fields ------------------------------------------------------

	private PrintWriter out;
	private int row;
	private Integer testIndex;
	private int methodIndex;
	private Scanner scanner;

	public void htmlToPdf(String outdir) {

		try {

		File htmlSource = new File(outdir, "Suggi_Automation_Report.html");

		File pdfDest = new File(outdir, "Suggi_Automation_Report.pdf");

		// pdfHTML specific code

		ConverterProperties converterProperties = new ConverterProperties();

		HtmlConverter.convertToPdf(new FileInputStream(htmlSource), new FileOutputStream(pdfDest),converterProperties);

		System.out.println("File convertd to PDF successfully");

		}  catch (Exception e) {
			Thread.currentThread().interrupt();
			Reporter.log(e.getMessage(), true);
		}
		}
	// ~ Methods --------------------------------------------------------------

	/** Creates summary of the run */
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outdir) {
		try {
			out = createWriter(outdir);
			startHtml(out);
			environmentDetails(out);
			generateSuiteSummaryReport(suites);
			generateMethodSummaryReport(suites);
			// generateMethodDetailReport(suites);
			endHtml(out);
			out.flush();
			out.close();
			htmlToPdf(outdir);
		} catch (IOException e) {
			L.error("output file", e);
			return;
		}

	}

	protected PrintWriter createWriter(String outdir) throws IOException {

		new File(outdir).mkdirs();
		/*
		 * File eReport=new File(outdir, "emailable-report.html" );
		 * System.out.println(eReport.toPath());
		 * System.out.println("eReport.exists()  "+eReport.exists());
		 * if(eReport.exists()){ eReport.delete(); System.out.println("Deleted"); }
		 */
		return new PrintWriter(new BufferedWriter(new FileWriter(new File(outdir, "Suggi_Automation_Report.html"))));

	}

	/**
	 * Creates a table showing the highlights of each test method with links to the
	 * method details
	 */
	protected void generateMethodSummaryReport(List<ISuite> suites) {
		methodIndex = 0;
		startResultSummaryTable("methodOverview");
		int testIndex = 1;
		for (ISuite suite : suites) {
			if (suites.size() >= 1) {
				titleRow(suite.getName(), 6);
			}
			Map<String, ISuiteResult> r = suite.getResults();
			for (ISuiteResult r2 : r.values()) {
				ITestContext testContext = r2.getTestContext();
				String testName = testContext.getName();
				this.testIndex = testIndex;
				resultSummary(suite, testContext.getFailedConfigurations(), testName, "failed",
						" (configuration methods)");
				resultSummary(suite, testContext.getFailedTests(), testName, "failed", "");
				resultSummary(suite, testContext.getSkippedConfigurations(), testName, "skipped",
						" (configuration methods)");
				resultSummary(suite, testContext.getSkippedTests(), testName, "skipped", "");
				resultSummary(suite, testContext.getPassedTests(), testName, "passed", "");
				testIndex++;
			}
		}
		out.println("</table>");
	}

	/** Creates a section showing known results for each method */
	protected void generateMethodDetailReport(List<ISuite> suites) {
		methodIndex = 0;
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> r = suite.getResults();
			for (ISuiteResult r2 : r.values()) {
				ITestContext testContext = r2.getTestContext();
				// delete
				System.out.println(testContext.getName());
				if (r.values().size() > 0) {
					out.println("<h1>" + testContext.getName() + "</h1>");
				}
				/*
				 * resultDetail(testContext.getFailedConfigurations());
				 * resultDetail(testContext.getFailedTests());
				 * resultDetail(testContext.getSkippedConfigurations());
				 * resultDetail(testContext.getSkippedTests());
				 * resultDetail(testContext.getPassedTests());
				 */
			}
		}
	}

	/**
	 * @param tests
	 */
	private void resultSummary(ISuite suite, IResultMap tests, String testname, String style, String details) {
		if (tests.getAllResults().size() > 0) {
			StringBuffer buff = new StringBuffer();
			String lastClassName = "";
			int mq = 0;
			int cq = 0;
			for (ITestNGMethod method : getMethodSet(tests, suite)) {
				row += 1;
				methodIndex += 1;
				ITestClass testClass = method.getTestClass();
				String className = testClass.getName().substring(7);
				if (mq == 0) {
					String id = (testIndex == null ? null : "t" + Integer.toString(testIndex));
					titleRow(testname, 6, id);
					testIndex = null;
				}
				if (!className.equalsIgnoreCase(lastClassName)) {
					if (mq > 0) {
						cq += 1;
						out.print("<tr class=\"" + (cq % 2 == 0 ? "even" : "odd") + "\">" + "<td");
						if (mq > 1) {
							out.print(" rowspan=\"" + mq + "\"");
						}
						out.println(">" + lastClassName + "</td>" + buff);
					}
					mq = 0;
					buff.setLength(0);
					lastClassName = className;
				}
				Set<ITestResult> resultSet = tests.getResults(method);
				long end = Long.MIN_VALUE;
				long start = Long.MAX_VALUE;
				long startMS = 0;
				// String firstLine = "";
				// String screenshotLnk="";
				for (ITestResult testResult : tests.getResults(method)) {
					if (testResult.getEndMillis() > end) {
						end = testResult.getEndMillis() / 1000;
					}
					if (testResult.getStartMillis() < start) {
						startMS = testResult.getStartMillis();
						start = startMS / 1000;
					}

					Throwable exception = testResult.getThrowable();
					boolean hasThrowable = exception != null;
					if (hasThrowable) {
						// String str = Utils.stackTrace(exception, true)[0];
						String str = Utils.longStackTrace(exception, true);
						scanner = new Scanner(str);
						// firstLine = scanner.nextLine();

						// for link in exception
						List<String> msgs = Reporter.getOutput(testResult);
						boolean hasReporterOutput = msgs.size() > 0;
						if (hasReporterOutput) {
							for (String line : msgs) {
								// out.println(line + "<br/>");
								// screenshotLnk+=line+"<br/>";
							}
						}

					}
				}

				DateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(startMS);

				mq += 1;
//                if (mq > 1) {
//                    buff.append("<tr class=\"" + style
//                            + (cq % 2 == 0 ? "odd" : "even") + "\">");
//                }
				String description = method.getDescription();
				String testInstanceName = resultSet.toArray(new ITestResult[] {})[0].getTestName();
				buff.append("<td>"
//                       + "<a href=\"#m"
//                        + methodIndex
//                        + "\">"
						+ qualifiedName(method)

//                        + "</a>"
						+ (null == testInstanceName ? "" : "<br>(" + testInstanceName + ")") + "</td>"
						+ "<td style=\"text-align:right\">"
						+ (description != null && description.length() > 0 ? description : "") + "</td>"

						+ "<td style=\"text-align:right\">" + formatter.format(calendar.getTime()) + "</td>"
						+ "<td class=\"numi\">" + millisToTimeConversion(end - start) + "</td>" + "<td class=\"" + style
						+ "even\">" + style + "</td>" + "</tr>");
			}
			if (mq > 0) {
				cq += 1;
				out.print("<tr class=\"" + (cq % 2 == 0 ? "even" : "odd") + "\">" + "<td");
				if (mq > 1) {
					out.print(" rowspan=\"" + mq + "\"");
				}
				out.println(">" + lastClassName + "</td>" + buff);
			}
		}
	}

	private String millisToTimeConversion(long seconds) {

		final int MINUTES_IN_AN_HOUR = 60;
		final int SECONDS_IN_A_MINUTE = 60;

		int minutes = (int) (seconds / SECONDS_IN_A_MINUTE);
		seconds -= minutes * SECONDS_IN_A_MINUTE;

		int hours = minutes / MINUTES_IN_AN_HOUR;
		minutes -= hours * MINUTES_IN_AN_HOUR;

		return prefixZeroToDigit(hours) + ":" + prefixZeroToDigit(minutes) + ":" + prefixZeroToDigit((int) seconds);
	}

	private String prefixZeroToDigit(int num) {
		int number = num;
		if (number <= 9) {
			String sNumber = "0" + number;
			return sNumber;
		} else
			return "" + number;

	}

	/** Starts and defines columns result summary table */
	private void startResultSummaryTable(String style) {
		tableStart(style, "summary");
		out.println("<tr><th>Class</th>"
				+ "<th>Method</th><th>Description</th><th>Method Start Time </th><th>Execution Time<br/>(hh:mm:ss)</th><th>Status</th></tr>");
		row = 0;
	}

	private String qualifiedName(ITestNGMethod method) {
		StringBuilder addon = new StringBuilder();
		String[] groups = method.getGroups();
		int length = groups.length;
		if (length > 0 && !"basic".equalsIgnoreCase(groups[0])) {
//			addon.append("(");
			for (int i = 0; i < length; i++) {
//				if (i > 0) {
//					addon.append(", ");
//				}
//				addon.append(groups[i]);
			}
//			addon.append(")");
		}

		return "<b>" + method.getMethodName() + "</b> " + addon;
	}

	private void generateForResult(ITestResult ans, ITestNGMethod method, int resultSetSize) {
		Object[] parameters = ans.getParameters();
		boolean hasParameters = parameters != null && parameters.length > 0;
		if (hasParameters) {
			tableStart("result", null);
			out.print("<tr class=\"param\">");
			for (int x = 1; x <= parameters.length; x++) {
				out.print("<th>Param." + x + "</th>");
			}
			out.println("</tr>");
			out.print("<tr class=\"param stripe\">");
			for (Object p : parameters) {
				out.println("<td>" + Utils.escapeHtml(Utils.toString(p)) + "</td>");
			}
			out.println("</tr>");
		}

	}

	/**
	 * Since the methods will be sorted chronologically, we want to return the
	 * ITestNGMethod from the invoked methods.
	 */
	private Collection<ITestNGMethod> getMethodSet(IResultMap tests, ISuite suite) {
		List<IInvokedMethod> r = Lists.newArrayList();
		List<IInvokedMethod> invokedMethods = suite.getAllInvokedMethods();
		for (IInvokedMethod im : invokedMethods) {
			if (tests.getAllMethods().contains(im.getTestMethod())) {
				r.add(im);
			}
		}
		Collections.sort(r, new TestSorter());

		List<ITestNGMethod> result = Lists.newArrayList();

		// Add all the invoked methods
		for (IInvokedMethod m : r) {
			for (ITestNGMethod temp : result) {
				if (!temp.equals(m.getTestMethod()))
					result.add(m.getTestMethod());
			}
		}

		Collection<ITestNGMethod> allMethodsCollection = tests.getAllMethods();
		List<ITestNGMethod> allMethods = new ArrayList<ITestNGMethod>(allMethodsCollection);
		Collections.sort(allMethods, new TestMethodSorter());
		for (ITestNGMethod m : allMethods) {
			if (!result.contains(m)) {
				result.add(m);
			}
		}
		return result;
	}

	@SuppressWarnings("unused")
	public void environmentDetails(PrintWriter out) throws IOException {
		tableStart("EnvironmentDetails", null);
		out.print("<tr>");
		tableColumnStart("Executed Environment : QA");
		out.print("</tr>");
		String build_type;
		String url = Lib.getProperty(AutoConstant.CONFIG_PATH, "ApplicationURL");

		summaryCell(url, true);

		out.println("</table>");
	}

	@SuppressWarnings("unused")
	public void generateSuiteSummaryReport(List<ISuite> suites) {
		tableStart("testOverview", null);
		out.print("<tr>");
		tableColumnStart("Suite Name");
		tableColumnStart("# Passed");
		tableColumnStart("# Skipped");
		tableColumnStart("# Failed");
		tableColumnStart("# Total");
		tableColumnStart("Automation<br/>Start Date/Time");
		tableColumnStart("Automation<br/>End Date/Time");
		tableColumnStart("Total<br/>Time(hh:mm:ss)");

		/*
		 * tableColumnStart("Included<br/>Groups");
		 * tableColumnStart("Excluded<br/>Groups");
		 */

		out.println("</tr>");
		NumberFormat formatter = new DecimalFormat("#,##0.0");
		int qty_tests = 0;
		int qty_pass_m = 0;
		int qty_pass_s = 0;
		int qty_skip = 0;
		int qty_fail = 0;
		int mainTotal = 0;
		long time_start = Long.MAX_VALUE;
		long time_end = Long.MIN_VALUE;
		testIndex = 1;
		for (ISuite suite : suites) {
			if (suites.size() >= 1) {
				titleRow(suite.getName(), 8);
			}
			Map<String, ISuiteResult> tests = suite.getResults();
			for (ISuiteResult r : tests.values()) {
				qty_tests += 1;
				ITestContext overview = r.getTestContext();
				startSummaryRow(overview.getName());
				int pass = getMethodSet(overview.getPassedTests(), suite).size();
				qty_pass_m += pass;
				summaryCell(pass, Integer.MAX_VALUE);
				int skip = getMethodSet(overview.getSkippedTests(), suite).size();
				qty_skip += skip;
				summaryCell(skip, 0);
				int fail = getMethodSet(overview.getFailedTests(), suite).size();
				qty_fail += fail;
				summaryCell(fail, 0);
				int total = pass + skip + fail;
				mainTotal += total;
				summaryCell(total, Integer.MAX_VALUE);
				SimpleDateFormat summaryFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
				summaryCell(summaryFormat.format(overview.getStartDate()), true);
				out.println("</td>");

				summaryCell(summaryFormat.format(overview.getEndDate()), true);
				out.println("</td>");

				time_start = Math.min(overview.getStartDate().getTime(), time_start);
				time_end = Math.max(overview.getEndDate().getTime(), time_end);
				summaryCell(millisToTimeConversion(
						(overview.getEndDate().getTime() - overview.getStartDate().getTime()) / 1000), true);

				out.println("</tr>");
				testIndex++;
			}
		}
		if (qty_tests > 1) {
			out.println("<tr class=\"total\"><td># Total</td>");
			summaryCell(qty_pass_m, Integer.MAX_VALUE);
			summaryCell(qty_skip, 0);
			summaryCell(qty_fail, 0);
			summaryCell(mainTotal, Integer.MAX_VALUE);
			summaryCell(" ", true);
			summaryCell(" ", true);
			summaryCell(millisToTimeConversion(((time_end - time_start) / 1000)), true);
			out.println("</tr>");
		}
		out.println("</table>");
	}

	private void summaryCell(String[] val) {
		StringBuffer b = new StringBuffer();
		for (String v : val) {
			b.append(v + " ");
		}
		summaryCell(b.toString(), true);
	}

	private void summaryCell(String v, boolean isgood) {
		out.print("<td class=\"numi" + (isgood ? "" : "_attn") + "\">" + v + "</td>");
	}

	private void startSummaryRow(String label) {
		row += 1;
		out.print(
				"<tr" + (row % 2 == 0 ? " class=\"stripe\"" : "") + "><td style=\"text-align:left;padding-right:2em\">"
//                +"<a href=\"#t"
//                + testIndex + "\">"
						+ "<b>" + label + "</b></a>" + "</td>");

	}

	private void summaryCell(int v, int maxexpected) {
		summaryCell(String.valueOf(v), v <= maxexpected);
	}

	private void tableStart(String cssclass, String id) {
		out.println("<table cellspacing=\"0\" cellpadding=\"0\""
				+ (cssclass != null ? " class=\"" + cssclass + "\"" : " style=\"padding-bottom:2em\"")
				+ (id != null ? " id=\"" + id + "\"" : "") + ">");
		row = 0;
	}

	private void tableColumnStart(String label) {
		out.print("<th>" + label + "</th>");
	}

	private void titleRow(String label, int cq) {
		titleRow(label, cq, null);
	}

	private void titleRow(String label, int cq, String id) {
		System.out.println(label);
		out.print("<tr");
		if (id != null) {
			out.print(" id=\"" + id + "\"");
		}
		out.println("><th colspan=\"" + cq + "\">" + label + "</th></tr>");
		// out.println("><th colspan=\"" + cq + "\">" + label + "</th></tr>");
		row = 0;
	}

	/** Starts HTML stream */
	protected void startHtml(PrintWriter out) {
		out.println(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<title>Automation Report</title>");
		out.println("<style type=\"text/css\">");
		out.println("table {margin-bottom:10px;border-collapse:collapse;empty-cells:show}");
		out.println("td,th {border:1px solid #009;padding:.25em .5em;text-align:center !important;}");
		out.println(".result th {vertical-align:bottom}");
		out.println(".param th {padding-left:1em;padding-right:1em}");
		out.println(".param td {padding-left:.5em;padding-right:2em}");
		out.println(".stripe td,.stripe th {background-color: #E6EBF9}");
		out.println(".numi,.numi_attn {text-align:right}");
		out.println(".total td {font-weight:bold}");
		out.println(".passedodd td {background-color: #0A0}");
		out.println(".passedeven td{background-color: #28CC28}");
		out.println(".passedeven {background-color: #28CC28}");
		out.println(".skippedodd td {background-color: #CCC}");
		out.println(".skippedodd td {background-color: #DDD}");
		out.println(".failedodd td,.numi_attn {background-color: #F33}");
		out.println(".failedeven td,.stripe .numi_attn {background-color: #CC2828}");
		out.println(".failedeven {background-color: #F33}");
		out.println(".stacktrace {white-space:pre;font-family:monospace}");
		out.println(".totop {font-size:85%;text-align:center;border-bottom:2px solid #000}");
		out.println(".methodOverview {word-break:break-all}"); 
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
	}

	/** Finishes HTML stream */
	protected void endHtml(PrintWriter out) {
		// out.println("<center> Falca DSC Automation </center>");

		out.println("</body></html>");
	}

	// ~ Inner Classes --------------------------------------------------------
	/** Arranges methods by classname and method name */
	private class TestSorter implements Comparator<IInvokedMethod> {
		// ~ Methods
		// -------------------------------------------------------------

		/** Arranges methods by classname and method name */
		@Override
		public int compare(IInvokedMethod o1, IInvokedMethod o2) {
			int r = o1.getTestMethod().getTestClass().getName().compareTo(o2.getTestMethod().getTestClass().getName());
			if (r == 0) {
			}
			return r;
		}

	}

	private class TestMethodSorter implements Comparator<ITestNGMethod> {
		@Override
		public int compare(ITestNGMethod o1, ITestNGMethod o2) {
			int r = o1.getTestClass().getName().compareTo(o2.getTestClass().getName());
			if (r == 0) {
				r = o1.getMethodName().compareTo(o2.getMethodName());
			}
			return r;
		}
	}

	private class TestResultsSorter implements Comparator<ITestResult> {
		@Override
		public int compare(ITestResult o1, ITestResult o2) {
			int result = o1.getTestClass().getName().compareTo(o2.getTestClass().getName());
			if (result == 0) {
				result = o1.getMethod().getMethodName().compareTo(o2.getMethod().getMethodName());
			}
			return result;
		}
	}
}