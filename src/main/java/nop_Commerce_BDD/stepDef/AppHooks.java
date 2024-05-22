package nop_Commerce_BDD.stepDef;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import Base.Keyword;
import Exceptions.InvalidBrowserNameError;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utilities.Config;

public class AppHooks {
	Keyword keyword = new Keyword();// to create a single and constant copy
	// in test case instead of driver we have to use "keyword.driver"
	
	@Before
	public void setup() {
		Config config=new Config();
		keyword.openBrowser(config.getBrowserName());
		keyword.launchUrl(config.getAppUrl());
		keyword.driver.manage().window().maximize();
	}

	@After(order = 0)
	public void tearDown() {
		keyword.quitBrowser();// if you make keyword object here,you will get "Null pointer Exception"
	}

	@After(order = 1)
	public void takeScreenshot(Scenario scenario) throws IOException {
		String scenarioName=scenario.getName();
		if (scenario.isFailed()) {
			AShot ashot = new AShot();
			ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000));
			Screenshot sc = ashot.takeScreenshot(keyword.driver);
			BufferedImage image = sc.getImage();
			Calendar cal = Calendar.getInstance();
			Date time = cal.getTime();
			String timestamp = time.toString().replace(":", "").replace(" ", "");
			ImageIO.write(image, "jpg", new File(
					System.getProperty("user.dir") + "\\screenshots\\"+scenarioName + timestamp + ".png"));

		}
	}
}
