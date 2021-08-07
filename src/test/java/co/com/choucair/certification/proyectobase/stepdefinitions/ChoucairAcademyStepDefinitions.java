package co.com.choucair.certification.proyectobase.stepdefinitions;


import co.com.choucair.certification.proyectobase.model.AcademyChoucairData;
import co.com.choucair.certification.proyectobase.questions.Answer;
import co.com.choucair.certification.proyectobase.tasks.OpenUp;
import co.com.choucair.certification.proyectobase.tasks.Search;
import co.com.choucair.certification.proyectobase.tasks.login;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

public class ChoucairAcademyStepDefinitions {

    @Before
    public void setStage () { OnStage.setTheStage(new OnlineCast()); }

    @Given("^that Diego wants to learn automation at the choucair academy$")
    public void thatDiegowantstolearnautomationatthechoucairacademy(List<AcademyChoucairData> academyChoucairData) throws Exception {
        OnStage.theActorCalled("Diego").wasAbleTo(OpenUp.thePage(),login.
                onThePage(academyChoucairData.get(0).getStrUser(),academyChoucairData.get(0).getStrPassword()));
    }

    @When("^he searches the platform for the course (.*) on the choucair academy platform$")
    public void hesearchestheplatformforthecourseRecursosAutomatizaciónBancolombiaonthechoucairacademyplatform(List<AcademyChoucairData> academyChoucairData)
            throws Exception {

        OnStage.theActorInTheSpotlight().attemptsTo(Search.the(academyChoucairData.get(0).getStrCourse()));

    }

    @Then("^he finds course called resources Recursos (.*)$")
    public void hefindscoursecalledresourcesRecursosAutomatizaciónBancolombia(List<AcademyChoucairData> academyChoucairData)
            throws Exception {

        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Answer.toThe(academyChoucairData.get(0).getStrCourse())));

    }

}
