package com.upskills.elearning.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\com.upskills.elearning.featurFiles",
                 monochrome = true,
                 dryRun = false,
                 strict= true,
                glue = {"com.upskills.elearning.stepdefinitions"},
               //  tags = "@run1",
                plugin = {"html:Reports/cucumber_html",
                	   "json:Reports/cucumber_json.json",
                      "pretty:Reports/cucumber_pretty.txt",
                  	  "junit:Reports/cucumber_junit.xml"
                  }
		)


public class TestRunner {

}