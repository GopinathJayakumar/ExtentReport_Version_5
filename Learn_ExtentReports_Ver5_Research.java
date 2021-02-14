package learnExtentReports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
/**
* author = "Gopinath Jayakumar"
*
*/
public class Learn_ExtentReports_Ver5_Research {

	private static final String CODE1 = "{\n    \"theme\": \"standard\",\n    \"encoding\": \"utf-8\n}";
	private static final String CODE2 = "{\n    \"protocol\": \"HTTPS\",\n    \"timelineEnabled\": false\n}";

	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest test, node;

	@Test
	public void step_level_status() {
		spark = new ExtentSparkReporter("./Spark/Spark1.html");

		extent = new ExtentReports();
		extent.attachReporter(spark);

		test = extent.createTest("CreateLead");
		test.assignAuthor("Gopinath Jayakumar");
		test.assignCategory("Smoke");
		test.assignDevice("Oneplus 7T PRO");

		test.addScreenCaptureFromPath("extent.png");
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath("extent.png").build());

		extent.flush();
	}

	@Test
	public void all_level_reports() {
		spark = new ExtentSparkReporter("./Spark/Spark2.html");

		extent = new ExtentReports();
		extent.attachReporter(spark);

		test = extent.createTest("LogLevels");
		test.assignAuthor("Gopinath Jayakumar");
		test.assignCategory("Smoke");
		test.assignDevice("Oneplus 7T PRO");

		test
		.info("info")
		.pass("pass")
		.warning("warn")
		.skip("skip")
		.fail("fail");

		extent.flush(); 
	}

	@Test
	public void generateLog() {
		spark = new ExtentSparkReporter("./Spark/Spark3.html");

		extent = new ExtentReports();
		extent.attachReporter(spark);

		test = extent.createTest("CodeBlock");
		test.assignAuthor("Gopinath Jayakumar");
		test.assignCategory("Smoke");
		test.assignDevice("Oneplus 7T PRO");

		test.generateLog(Status.PASS, MarkupHelper.createCodeBlock(CODE1, CODE2));

		extent.flush(); 
	}

	@Test
	public void node_module() {
		spark = new ExtentSparkReporter("./Spark/Spark4.html");

		extent = new ExtentReports();
		extent.attachReporter(spark);

		test = extent.createTest("ParentWithChild");
		test.assignAuthor("Gopinath Jayakumar");
		test.assignCategory("Smoke");
		test.assignDevice("Oneplus 7T PRO");

		node = test.createNode("Child");
		node.pass("This test is created as a toggle as part of a child test of 'ParentWithChild'");

		extent.flush(); 

	}

	@Test
	public void raise_exception(){
		spark = new ExtentSparkReporter("./Spark/Spark5.html");

		extent = new ExtentReports();
		extent.attachReporter(spark);

		test = extent.createTest("Exception! <i class='fa fa-frown-o'></i>");
		test.assignAuthor("Gopinath Jayakumar");
		test.assignCategory("Smoke");
		test.assignDevice("Oneplus 7T PRO");


		test.fail(new RuntimeException("A runtime exception occurred!"));

		extent.flush();
	}

}
