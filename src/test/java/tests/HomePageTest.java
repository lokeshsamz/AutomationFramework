package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.Test;
import Hooks.WebHooks;
import LoggingHooks.Log;
import pages.HomePage;
import pages.MoviesPage;
import pages.SeatSelectionsPage;
import testBase.BrowserUtils;
import testBase.FunctionUtils;

public class HomePageTest extends WebHooks
{
	private HomePage homePage;
	private BrowserUtils browserUtils = new BrowserUtils();
	private MoviesPage moviePage;
	private SeatSelectionsPage seatSelectionsPage;

	private HomePageTest() 
	{
		homePage = new HomePage(browserUtils, extentReportUtils);
		moviePage = new MoviesPage(browserUtils, extentReportUtils);
		seatSelectionsPage = new SeatSelectionsPage(browserUtils, extentReportUtils);
	}

	@Test
	public void launchchrome() throws InterruptedException
	{		
		Log.startLogging();
		List<String> theatres = new ArrayList<String>();
		List<String> seatsNames = new ArrayList<String>();
		String testcase = ThreadContext.get("LogFileName");
		Log.Info("This testcase is executing : " + testcase);

		this.browserUtils.MaximizeScreen();
		Thread.sleep(2000);
		this.homePage.LaunchHomePage("https://www.ticketnew.com/online-advance-booking/Movies/C/Chennai");
		Thread.sleep(3000);

		this.homePage.ClickMovieName("Enemy");
		Thread.sleep(3000);

		moviePage.SelectFromAmenities("F&B", false);
		Thread.sleep(3000);

		//moviePage.SelectFromExperience("Sofa", true);
		Thread.sleep(3000);

		Log.Info("Available dates : ");
		moviePage.GetAvailableDates().forEach(x -> System.out.println(x));

		Log.Info("Available Theatres : ");
		theatres = moviePage.GetAvailableTheatres();
		theatres.removeIf(emp -> emp.isEmpty() || emp.isBlank());
		theatres.forEach(x -> Log.Info(x));

		int randomNumber = FunctionUtils.GenerateRandomNumber(theatres.size());
		Log.Info("Random Theatre: " + theatres.get(randomNumber));
		List<String> theatreTimings = moviePage.GetAvailableTheatreTimingDetails(theatres.get(randomNumber));
		Log.Info("Available Theatres Timings: ");
		theatreTimings.forEach(x -> Log.Info(x));

		moviePage.ClickTheatreTime(theatres.get(randomNumber), theatreTimings.stream().findFirst().get());
		Thread.sleep(3000);

		Log.Info("Available Seat Names : ");
		seatsNames = seatSelectionsPage.GetAvailableSeats();
		Thread.sleep(3000);
		seatsNames.removeIf(emp -> emp.isEmpty() || emp.isBlank());
		seatsNames.forEach(Log::Info);


		List<String> SeatRowVariables =  List.copyOf(seatsNames).stream().map(x -> x.replaceAll("[^A-Za-z]", "")).distinct().collect(Collectors.toList());
		Log.Info("Available Seat Row Variables : ");
		SeatRowVariables.forEach(Log::Info);

		String row = SeatRowVariables.get(FunctionUtils.GenerateRandomNumber(SeatRowVariables.size())).toString();
		Log.Info("Selected Seat Row Variable : " + row);

		List<String> seatsToClick = seatsNames.stream().filter(x -> x.contains(row)).distinct().collect(Collectors.toList());
		seatSelectionsPage.ClickSeats(seatsToClick);
		Log.Info("Selected Seat(s): ");
		seatsToClick.forEach(Log::Info);
		Thread.sleep(3000);

		seatSelectionsPage.ClickContinueButton();
		Thread.sleep(3000);
	}

	@Test
	public void launchchrome1() throws InterruptedException
	{
		Log.startLogging();
		List<String> theatres = new ArrayList<String>();
		List<String> seatsNames = new ArrayList<String>();
		String testcase = ThreadContext.get("LogFileName");
		Log.Info("This testcase is executing : " + testcase);

		this.browserUtils.MaximizeScreen();
		Thread.sleep(2000);
		this.homePage.LaunchHomePage("https://www.ticketnew.com/online-advance-booking/Movies/C/Chennai");
		Thread.sleep(3000);

		this.homePage.ClickMovieName("Doctor");
		Thread.sleep(3000);

		moviePage.SelectFromAmenities("F&B", false);
		Thread.sleep(3000);

		//moviePage.SelectFromExperience("Sofa", true);
		Thread.sleep(3000);

		Log.Info("Available dates : ");
		moviePage.GetAvailableDates().forEach(x -> System.out.println(x));

		Log.Info("Available Theatres : ");
		theatres = moviePage.GetAvailableTheatres();
		theatres.removeIf(emp -> emp.isEmpty() || emp.isBlank());
		theatres.forEach(x -> Log.Info(x));

		int randomNumber = FunctionUtils.GenerateRandomNumber(theatres.size());
		Log.Info("Random Theatre: " + theatres.get(randomNumber));
		List<String> theatreTimings = moviePage.GetAvailableTheatreTimingDetails(theatres.get(randomNumber));
		Log.Info("Available Theatres Timings: ");
		theatreTimings.forEach(x -> Log.Info(x));

		moviePage.ClickTheatreTime(theatres.get(randomNumber), theatreTimings.stream().findFirst().get());
		Thread.sleep(3000);

		Log.Info("Available Seat Names : ");
		seatsNames = seatSelectionsPage.GetAvailableSeats();
		Thread.sleep(3000);
		seatsNames.removeIf(emp -> emp.isEmpty() || emp.isBlank());
		seatsNames.forEach(Log::Info);


		List<String> SeatRowVariables =  List.copyOf(seatsNames).stream().map(x -> x.replaceAll("[^A-Za-z]", "")).distinct().collect(Collectors.toList());
		Log.Info("Available Seat Row Variables : ");
		SeatRowVariables.forEach(Log::Info);

		String row = SeatRowVariables.get(FunctionUtils.GenerateRandomNumber(SeatRowVariables.size())).toString();
		Log.Info("Selected Seat Row Variable : " + row);

		List<String> seatsToClick = seatsNames.stream().filter(x -> x.contains(row)).distinct().collect(Collectors.toList());
		seatSelectionsPage.ClickSeats(seatsToClick);
		Log.Info("Selected Seat(s): ");
		seatsToClick.forEach(Log::Info);
		Thread.sleep(3000);

		seatSelectionsPage.ClickContinueButton();
		Thread.sleep(3000);
	}

	@Test
	public void launchchrome2() throws InterruptedException
	{
		Log.startLogging();
		List<String> theatres = new ArrayList<String>();
		List<String> seatsNames = new ArrayList<String>();
		String testcase = ThreadContext.get("LogFileName");
		Log.Info("This testcase is executing : " + testcase);

		this.browserUtils.MaximizeScreen();
		Thread.sleep(2000);
		this.homePage.LaunchHomePage("https://www.ticketnew.com/online-advance-booking/Movies/C/Chennai");
		Thread.sleep(3000);

		this.homePage.ClickMovieName("Doctor");
		Thread.sleep(3000);

		moviePage.SelectFromAmenities("F&B", false);
		Thread.sleep(3000);

		//moviePage.SelectFromExperience("Sofa", true);
		Thread.sleep(3000);

		Log.Info("Available dates : ");
		moviePage.GetAvailableDates().forEach(x -> System.out.println(x));

		Log.Info("Available Theatres : ");
		theatres = moviePage.GetAvailableTheatres();
		theatres.removeIf(emp -> emp.isEmpty() || emp.isBlank());
		theatres.forEach(x -> Log.Info(x));

		int randomNumber = FunctionUtils.GenerateRandomNumber(theatres.size());
		Log.Info("Random Theatre: " + theatres.get(randomNumber));
		List<String> theatreTimings = moviePage.GetAvailableTheatreTimingDetails(theatres.get(randomNumber));
		Log.Info("Available Theatres Timings: ");
		theatreTimings.forEach(x -> Log.Info(x));

		moviePage.ClickTheatreTime(theatres.get(randomNumber), theatreTimings.stream().findFirst().get());
		Thread.sleep(3000);

		Log.Info("Available Seat Names : ");
		seatsNames = seatSelectionsPage.GetAvailableSeats();
		Thread.sleep(3000);
		seatsNames.removeIf(emp -> emp.isEmpty() || emp.isBlank());
		seatsNames.forEach(Log::Info);


		List<String> SeatRowVariables =  List.copyOf(seatsNames).stream().map(x -> x.replaceAll("[^A-Za-z]", "")).distinct().collect(Collectors.toList());
		Log.Info("Available Seat Row Variables : ");
		SeatRowVariables.forEach(Log::Info);

		String row = SeatRowVariables.get(FunctionUtils.GenerateRandomNumber(SeatRowVariables.size())).toString();
		Log.Info("Selected Seat Row Variable : " + row);

		List<String> seatsToClick = seatsNames.stream().filter(x -> x.contains(row)).distinct().collect(Collectors.toList());
		seatSelectionsPage.ClickSeats(seatsToClick);
		Log.Info("Selected Seat(s): ");
		seatsToClick.forEach(Log::Info);
		Thread.sleep(3000);

		seatSelectionsPage.ClickContinueButton();
		Thread.sleep(3000);
	}
}

