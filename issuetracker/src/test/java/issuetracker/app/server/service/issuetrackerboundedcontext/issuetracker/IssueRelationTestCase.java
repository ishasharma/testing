package issuetracker.app.server.service.issuetrackerboundedcontext.issuetracker;
import issuetracker.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import issuetracker.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueRelationRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueRelation;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueWorkflowRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.CoreContacts;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import issuetracker.app.shared.organizationboundedcontext.location.Timezone;
import issuetracker.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.Title;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.Gender;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import issuetracker.app.shared.organizationboundedcontext.location.Language;
import issuetracker.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import issuetracker.app.shared.organizationboundedcontext.location.Address;
import issuetracker.app.server.repository.organizationboundedcontext.location.AddressRepository;
import issuetracker.app.shared.organizationboundedcontext.location.Country;
import issuetracker.app.server.repository.organizationboundedcontext.location.CountryRepository;
import issuetracker.app.shared.organizationboundedcontext.location.City;
import issuetracker.app.server.repository.organizationboundedcontext.location.CityRepository;
import issuetracker.app.shared.organizationboundedcontext.location.State;
import issuetracker.app.server.repository.organizationboundedcontext.location.StateRepository;
import issuetracker.app.shared.organizationboundedcontext.location.AddressType;
import issuetracker.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationData;
import issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationType;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectFeature;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectFeatureRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectModule;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectModuleRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.CreateProject;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.CreateProjectRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectAccessRights;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectAccessRightsRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectUserMapping;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ModuleUserMapping;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.FeatureUserMapping;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.AddWatchers;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueAssignment;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueHeaders;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueSeverity;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueSeverityRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueFlag;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueFlagRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.IssueCategory;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.IssueCategoryRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueStage;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueStageRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueActivity;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueActivityRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueStatus;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueStatusRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssuePriority;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssuePriorityRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.FeatureCategory;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.FeatureCategoryRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueRelationType;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueRelationTypeRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class IssueRelationTestCase extends EntityTestCriteria {

    @Autowired
    private IssueRelationRepository<IssueRelation> issuerelationRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
    }

    private IssueRelation createIssueRelation() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueWorkflow issueworkflow = new IssueWorkflow();
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setFirstName("hgF1xEop9edQXXIyX2S9qvVyAy938j22ezyeBLFDdFDtfqFk6C");
        corecontacts.setMiddleName("8X7ADQfOeMnDHI0Jh0rrCOW6NSeyzzqZ7iKOxt8SzBsHmkUGzJ");
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("uLusSrDfp7s0ZQnsodCUjaeBAsR5f2E6EctMhxKhKrT2qEVCUn");
        timezone.setTimeZoneLabel("KOz2gfFcTj6LUa1b5zaboRV9VCGjJGS7F0Jbf8tTo35NhJxjjd");
        timezone.setCountry("vHKXSd8elrW3mBoQc4zDl6PBt0j5pZm2mG0QMtWkHoGdWCukP5");
        timezone.setCities("LMiYIT90fXeXMullD1wTaEsSEpv5cZadRQEKChpeiw3u60ruB4");
        timezone.setUtcdifference(2);
        Title title = new Title();
        title.setTitles("YuCWGCHNf43GcPw52rqSRJFyy8y2Pk82fyuFUVduRchXvg1FxE");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("kKOhSq5CgYwVz96jeMEUNGboMQe1MzA5EQEUdBIyeaa6rfwrlm");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setLanguage("YUphz07YdaDzpjLvttPrHyB1L6SDdF1LfurE6h36EMxIHFbJic");
        language.setAlpha4parentid(4);
        language.setAlpha2("FC");
        language.setLanguageIcon("8yf0VboVO0DHGQQvFoMvdu1RINYpWggy8zuVmS8HTYub8aSBVA");
        language.setAlpha4("Z9pn");
        language.setAlpha3("MOj");
        language.setLanguageType("G6wXyXFudYYnsCf63xtcHey01Kxe7ZZN");
        language.setLanguageDescription("00IVbTWMmEcxFRb2XxoaKfVgFW0gJe1uyqW5AuR0VidQ4KMR3i");
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        corecontacts.setFirstName("kuW5BIbZwP3dcBZ8vHjiDQpdfFLpRhPndIPstm8iMXjN2tZVy2");
        corecontacts.setMiddleName("5eOVsh9lMCNJK0BeHKNSzVyBhm2fRHQ5VrhapiJVKDKVBmQkwI");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setNativeLastName("8f7GXkqTquR3PiCE9ZX1pV6G0RGM7TKYFZNlvrntmSi198qLEd");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458127895382l));
        corecontacts.setAge(43);
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("odFtTHRridtiuljPFvYeTuboItnr77b07qK2ZvS7U0AVunBlq7");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("06Yudcm9PVeV8rSiII7x4dDrkosMEeRm7DY0Ok1wNfa9ekKqZ2");
        corecontacts.setPhoneNumber("uEN4HZxYMDBBVpc8Ggey");
        corecontacts.setEmailId("NHFumS3F1u78GKe3aRj7Tlp4QCtxEL2zR35JHmBfT141KAyijR");
        corecontacts.setNativeMiddleName("v4bxIKmNavT6ONj76XBIa8Ibr3hMPj9RDrysROlVqjDQu8t533");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458127895498l));
        corecontacts.setNativeTitle("TgbJ6nqecrhFkTWOxO42vqIUGS6yTFtRI1eq2zorr9GbiCzQY5");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        Country country = new Country();
        country.setCountryName("xQJJEBudSjCZJdSw19Ei7rpaydcrDaxuqxguUBuCsRgjRWOegD");
        country.setCountryCode1("eUB");
        country.setCapitalLongitude(10);
        country.setCurrencyName("gR54liObWCuLrqHOfp2pttdcwTezRxPFH39uodNIVqi9nTEbqI");
        country.setCurrencyCode("9Hb");
        country.setCountryFlag("oXpYNFDnZZ7PG5qeFd9niGQB7HeHrgCFpp1r9QydkuC4lu6Fq5");
        country.setIsoNumeric(10);
        country.setCapitalLatitude(11);
        country.setCapital("ELt5wF22z5Zh4egRR5OgKA3Kog61QqZD");
        country.setCountryCode2("SKd");
        country.setCurrencySymbol("xtOqtCbN9vAiwvTne7ag1MsOfyYAQeWN");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        City city = new City();
        city.setCityFlag("cD4bYdUCQVt4wtEQzAXlobZcdOJ71uFXt3xUQhLnFv21CsRIxS");
        city.setCityLongitude(9);
        city.setCityLatitude(3);
        city.setCityDescription("ftAIJT2ZPANNvekR1XfJxEfsJ5FmyA0pRuy8c9RbGjX6Y9i1n4");
        city.setCityCode(3);
        city.setCityName("nTsxdmNmj9e3wEWWXfqZbNdQBWl4hYNJ4D2nVIDMQFR2NYJhqQ");
        State state = new State();
        state.setStateCodeChar2("BFS2I9FjCnbdrPdOP4WzlnpHB6tNy7py");
        state.setStateCapitalLongitude(9);
        state.setStateCodeChar3("rbRB5lgFVnb4UGziw7dLrMf3WWzE0g5v");
        state.setStateCodeChar2("EqDSehQq8DAeXnBqIeOwkAj3UnuDxIJt");
        state.setStateCapitalLongitude(7);
        state.setStateCodeChar3("MDxxdiEYORuEuN0KNHtUYYvDh7XDcLOs");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("GIkMx5SzK8m7cSi5Q4gGD395LzU3JLpY2XO49iGGNtUaz5EfQx");
        state.setStateFlag("BBVuuWPa8mBrxjIhi7J0t6vhDL8vPKTQru15k69KMFNK39z6R6");
        state.setStateCapital("EMI1oeKH6At1FJAUQremIx8zv3ErYkdyzedCqRHlRPhGsmDnxd");
        state.setStateCapitalLatitude(1);
        state.setStateDescription("4DKV1dX1ZTLYRo7yixB5YkUDNlLGDMrR2V5uk5wEwgc4fNvTw5");
        state.setStateCode(2);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        city.setCityFlag("tyihsMLNwt1FrAR8lvnFh9bS4I2TnpzFFLFWDadn9Br2ynFk14");
        city.setCityLongitude(10);
        city.setCityLatitude(1);
        city.setCityDescription("iXWhQuUbWOCjNiSyplJcvZchYiOJZtAJV7oWjeX2HwhRGOQyKl");
        city.setCityCode(2);
        city.setCityName("rfdFLNTAxSLUyoKEiPJwRaH3QVgNByqse6d1usYXO64HJ8IQuO");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("JUSZt2MH6jPeklVDvyltVCM0cZkcyyBJ");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("3Qt1nW94jseEAfdMIb3iJijdUaLtUhi0kwWWnzGvehDCYYvvpY");
        addresstype.setAddressTypeDesc("K7Co11pjTNpmRHRIXa33Zdk9V1Sm0ubaJqXUmEcBXGZ6JPC9UM");
        addresstype.setAddressType("1wLBSyat8vPJHj8q3y2zvCJZ9wJsbuxJZJD9Uiw9Cn3ebDyixu");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("6BjCOot3oAVt5ex61nXDx73yT7tpPcZwXUG7xT4yNF9DEBhCcL");
        address.setAddress1("YHyfB8M7jeG7gYQkzfCeRTbuEbCdmsgxeQb79bkuPtiOcM9Qpu");
        address.setLatitude("be06XFcJrdpUOX1IZwcCAsB3fcthVKUM1x9IiW07IVpPYNpfOL");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("8ea4HN");
        address.setAddress2("Gd3KpCOUW3Gqurh00w5XZNwrsDar2OVzlYyB8y4NVZTmksBfN2");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("ayB1MC2YDUs");
        address.setAddress3("Q910fO3s7uBO39SUQQLPzyo47RytI0Ew09YWzi91D2dGghkYkQ");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("iaRKBkdGAs98jwpp5Kdj15Sjc0VVJ4G2VoqQnVVNmUCYWB5nSC");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("sMtKiSrUk8tn5hP64rCPadFMukn5647o6e06j0cAUjoS6OBDur");
        communicationgroup.setCommGroupName("xqK2iEQey1XpqZkYxVvlMgIX1krSimbaLEt1PtTPeEnG4Cq6sT");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("OvHxmQvkL30gbA91EjqjRpBeEWUyAKRqtPGMN2irmFRwu48rmQ");
        communicationtype.setCommTypeName("7r2Hd0hm4KGN9SMi6SGCk3DLGLJ2pYOgfdMtiuZrkt2KATraK4");
        communicationtype.setCommTypeDescription("HKP5kw5JZ5ZoUHdEBNQUodLWnXMPxMWo3aGunm0r4HVfLXATka");
        communicationtype.setCommTypeName("C0JwOoj4uCy8M1CxgMPoQXfoiHGIOznQp8CPu8qTOq1tELd8qx");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommData("PuNUT1tCA8enAhyoelKNMNxeo1TnUBnySgPc29swaSNoE51bRI");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
        map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        ProjectFeature projectfeature = new ProjectFeature();
        ProjectModule projectmodule = new ProjectModule();
        projectmodule.setDateOfCreation(new java.sql.Date(123456789));
        CreateProject createproject = new CreateProject();
        ProjectAccessRights projectaccessrights = new ProjectAccessRights();
        projectaccessrights.setProjectAccessName("il4iStY0Yvf6rytQzRYFAurTCPnbfQA6WxhJ31js7022gly34a");
        projectaccessrights.setProjectAccessDesc("VOjkHZSu2ydLOriX66viS9t5NsvrkXdoA6qajVrw1VSy0GDsqt");
        ProjectAccessRights ProjectAccessRightsTest = projectaccessrightsRepository.save(projectaccessrights);
        map.put("ProjectAccessRightsPrimaryKey", projectaccessrights._getPrimarykey());
        createproject.setProjectAccessCode((java.lang.String) ProjectAccessRightsTest._getPrimarykey()); /* ******Adding refrenced table data */
        createproject.setProjectShortName("fzds6o6fl3VZppqMCHuUBSuPsGdsRkOxZuot6gAxf6MXQPpcmZ");
        createproject.setDateOfCreation(new java.sql.Date(123456789));
        createproject.setBuild("eBCbiMibWeNdCvU3pRtXV5W4iCr4vrK8hF0YAFnbXhjiynZ1AG");
        createproject.setVersion("lOgqgtTmP0Gu5S65YeOom8YuNFyArxIbPFV4eCM4R9OD6KG8Am");
        createproject.setProjectName("RXAzul3BFJT3ecL8owNq8FGda0WPMh8NyFZnPADlpeDMWkh6fD");
        createproject.setProjectDescription("6DqiUKOlOKZuhNO60b5QIyETg5pcMKOfIEsRukjElalVonH3kQ");
        createproject.setProjectURL("U60xZBFgnfcQk5ji7WixjYqTjtDeRsSc6Izp4V5D3WvsYOkvy0");
        java.util.List<ProjectUserMapping> listOfProjectUserMapping = new java.util.ArrayList<ProjectUserMapping>();
        ProjectUserMapping projectusermapping = new ProjectUserMapping();
        projectusermapping.setCreateProject(createproject);
        projectusermapping.setIsAdmin(true);
        projectusermapping.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfProjectUserMapping.add(projectusermapping);
        createproject.addAllProjectUserMapping(listOfProjectUserMapping);
        CreateProject CreateProjectTest = createprojectRepository.save(createproject);
        map.put("CreateProjectPrimaryKey", createproject._getPrimarykey());
        projectmodule.setDateOfCreation(new java.sql.Date(123456789));
        projectmodule.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        projectmodule.setModuleShortName("UuO4tSCSZ98n7VrRhZL3FLE4DD8ei3PCIvBCzd8hkAtEjR1nWu");
        projectmodule.setModuleName("pexviwUr09gHz8cQy0HlvV5FQjJ5AW3P4DevmHuVwk3UhOZgJw");
        projectmodule.setVersion("d7os0kNcPYQzo0MOLK5Sv7kGiWtPhIwxQNNRYXrilNrHtAwcpv");
        projectmodule.setBuild("SDETVn6W2kAGP7ao6sytCPxM9VEJguFACpfMtIX9l4emNaHmnG");
        projectmodule.setModuleDescription("moF4njWPf3OYDNBWkOdIjVM5JpdjNbYSOZW9cSWvgPQlWV7BPK");
        java.util.List<ModuleUserMapping> listOfModuleUserMapping = new java.util.ArrayList<ModuleUserMapping>();
        ModuleUserMapping moduleusermapping = new ModuleUserMapping();
        moduleusermapping.setIsAdmin(true);
        moduleusermapping.setIsAdmin(true);
        moduleusermapping.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        moduleusermapping.setProjectModule(projectmodule);
        moduleusermapping.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfModuleUserMapping.add(moduleusermapping);
        projectmodule.addAllModuleUserMapping(listOfModuleUserMapping);
        ProjectModule ProjectModuleTest = projectmoduleRepository.save(projectmodule);
        map.put("ProjectModulePrimaryKey", projectmodule._getPrimarykey());
        projectfeature.setModuleId((java.lang.String) ProjectModuleTest._getPrimarykey()); /* ******Adding refrenced table data */
        projectfeature.setVersion(10);
        projectfeature.setBuild(3);
        projectfeature.setFeatureShortName("xDUccCmVr6kTNHTuqquFZn0y9jVHH2C3VgVbQvD6LIT06yq36y");
        projectfeature.setDateOfCreation(new java.sql.Date(123456789));
        projectfeature.setFeatureDescription("IyLJtMXij9KkkD51QVaN4bJPWkF1tnNbn6L4xxe8PclVlMlF4q");
        projectfeature.setFeatureName("5E9R1vg8HQt8r6vHov8OL3I3PWFcxEme2fUSe2slQocteopQwh");
        projectfeature.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<FeatureUserMapping> listOfFeatureUserMapping = new java.util.ArrayList<FeatureUserMapping>();
        FeatureUserMapping featureusermapping = new FeatureUserMapping();
        featureusermapping.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        featureusermapping.setModuleId((java.lang.String) ProjectModuleTest._getPrimarykey()); /* ******Adding refrenced table data */
        featureusermapping.setProjectFeature(projectfeature);
        featureusermapping.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        featureusermapping.setIsAdmin(true);
        listOfFeatureUserMapping.add(featureusermapping);
        projectfeature.addAllFeatureUserMapping(listOfFeatureUserMapping);
        ProjectFeature ProjectFeatureTest = projectfeatureRepository.save(projectfeature);
        map.put("ProjectFeaturePrimaryKey", projectfeature._getPrimarykey());
        issueworkflow.setCreatorContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setDateCreated(new java.sql.Date(123456789));
        issueworkflow.setoS("92aUjn6ilCUB6SpsfbxZXXDR28HT6FCdJ2riS6b39jHq9IqMcE");
        issueworkflow.setStepsToReproduce("QUfhFRNPFVZQ5MmodwF8AIlt1fKIEUpYeGg5kQImgczMCxxC1G");
        issueworkflow.setFeatureId((java.lang.String) ProjectFeatureTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setModuleId((java.lang.String) ProjectModuleTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setIssueDescription("yRiRH8aVyCjr1UkHGwysho6DhPPv020N0Kpy6v5VfFK0yjaRj8");
        issueworkflow.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setBrowser("xtEr29eb0BXLwyaSHWG9FhGXn3go4y2kiv7ylTWGvyTE3qekyD");
        issueworkflow.setIssueTitle("wPOoaQYKvvW18pdyHzt1o3hovLsa6OcFgdc9SqTJae3Pin9NPJ");
        java.util.List<AddWatchers> listOfAddWatchers = new java.util.ArrayList<AddWatchers>();
        AddWatchers addwatchers = new AddWatchers();
        addwatchers.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        addwatchers.setIssueWorkflow(issueworkflow);
        listOfAddWatchers.add(addwatchers);
        issueworkflow.addAllAddWatchers(listOfAddWatchers);
        IssueAssignment issueassignment = new IssueAssignment();
        issueassignment.setStartTime(new java.sql.Date(123456789));
        issueassignment.setStartTime(new java.sql.Date(123456789));
        issueassignment.setIssueWorkflow(issueworkflow);
        issueassignment.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueassignment.setEndTime(new java.sql.Date(123456789));
        issueassignment.setIssueDate(new java.sql.Date(123456789));
        issueassignment.setComments("rcmQ7RUkOd04e4hB0R4MnQyuG7tgCE8bEUGDYd0pICTZkbWWyB");
        issueworkflow.setIssueAssignment(issueassignment);
        IssueHeaders issueheaders = new IssueHeaders();
        IssueSeverity issueseverity = new IssueSeverity();
        issueseverity.setIssueSeverityName("uVHlds6KBbaCNGj9FOlsyuSvP3cUON8zhzdUwJMeLept2dkeFB");
        issueseverity.setIssueSeverityDesc("3OxtqFkeqoCOMGF0wzBdeP3WJJq2CVai5u2bDweVfXjSKkwv9j");
        IssueSeverity IssueSeverityTest = issueseverityRepository.save(issueseverity);
        map.put("IssueSeverityPrimaryKey", issueseverity._getPrimarykey());
        IssueFlag issueflag = new IssueFlag();
        issueflag.setIssueFlagDesc("Yscwp0f1ljigOjYT2NeTPXUGkIA2Kh34iqrJo2AHNCKQvnoVjG");
        issueflag.setIssueFlagName("Q1sGA7b0k4VkuRuUG8Weq60unIr2ZL6I6t6UNq5hw5FUmq8MYB");
        IssueFlag IssueFlagTest = issueflagRepository.save(issueflag);
        map.put("IssueFlagPrimaryKey", issueflag._getPrimarykey());
        IssueCategory issuecategory = new IssueCategory();
        issuecategory.setIssueCategoryName("aUb7cAcYqk5PEVqQ1GspF3anFRRWS8idb1TCMFTKzqgsOBhmfO");
        issuecategory.setIssueCategoryDesc("0NY2QNt6wlOiWOkqYNQ7PvgSrgvdirQFrBPakFD6rGvzV0g1r4");
        IssueCategory IssueCategoryTest = issuecategoryRepository.save(issuecategory);
        map.put("IssueCategoryPrimaryKey", issuecategory._getPrimarykey());
        IssueStage issuestage = new IssueStage();
        issuestage.setIssueStageName("3wJhBkSKB8HOVL3jkFxMRHEQ0vsW5yShmJTGsCZk7jkno8l3c7");
        issuestage.setIssueStageId("tFj3sBv5B7YICkJZ6NtYbE8pKKoVUSeT2xKdlrCnxa5zFBPLx2");
        issuestage.setIssueStageDesc("hGqMfmxQ7JGNzoVL4olMKziY0nLF1dJ20MTmhchjX8TUqO1INA");
        IssueStage IssueStageTest = issuestageRepository.save(issuestage);
        map.put("IssueStagePrimaryKey", issuestage._getPrimarykey());
        IssueActivity issueactivity = new IssueActivity();
        IssueStatus issuestatus = new IssueStatus();
        issuestatus.setIssueStatusDesc("xkztDYRrvT2pW5MhkAC54WDaxvFZSXHxtnBsJ13UpV9M3OPOpA");
        issuestatus.setIssueStatusId(valueGenerator.randomValueGenerate("String", 64, 0));
        issuestatus.setIssueStatusName("fMc4G0wO7PRBGlJ5jiMwqI7krNbNumwGFy14EmAkpgdx1VQApf");
        issuestatus.setIssueStatusDesc("wQVPDl7kwJtSjaBAl4OtxTMC372Ay0s12zDyB2xbHt19O4ommG");
        issuestatus.setIssueStatusId(valueGenerator.randomValueGenerate("String", 64, 0));
        issuestatus.setIssueStatusName("YLKMDMu2x8zoKbkoHvcwinLm7Jl7pMepnSvNUjeW413psWQfip");
        issuestatus.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        IssueStatus IssueStatusTest = issuestatusRepository.save(issuestatus);
        map.put("IssueStatusPrimaryKey", issuestatus._getPrimarykey());
        issueactivity.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueactivity.setIssueStatusCode((java.lang.String) IssueStatusTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueactivity.setIssueActivityDesc("H5Jnu3WhBdCwOuvPRZujPmFGBtnzDliDYLv2zRzdXx8sNCVJQ2");
        issueactivity.setIssueActivityName("vCi8DFVTPaCMUnjuvGT3KLfp0YHyqsmM3EmNLibtbBp7Y9ysLL");
        issueactivity.setIssueActivityId(valueGenerator.randomValueGenerate("String", 64, 0));
        IssueActivity IssueActivityTest = issueactivityRepository.save(issueactivity);
        map.put("IssueActivityPrimaryKey", issueactivity._getPrimarykey());
        IssuePriority issuepriority = new IssuePriority();
        issuepriority.setIssuePriorityDesc("e8MwPA8rZdaKfZyXclJYAvvZtSUZxACQplnKgAUvlA3yx3un7w");
        issuepriority.setIssuePriorityName("vCoKDrxbO8ZyX49jbyOANNOnSGFcqptBXW0AF8FNPs8MWzOl2V");
        IssuePriority IssuePriorityTest = issuepriorityRepository.save(issuepriority);
        map.put("IssuePriorityPrimaryKey", issuepriority._getPrimarykey());
        FeatureCategory featurecategory = new FeatureCategory();
        featurecategory.setFeatureCategoryName("GbxgnIZyCk4tngKa2idSu4LVQO03nT1DSxxUC2QVmxXEiLcXVI");
        featurecategory.setFeatureCategoryDesc("ilzo2nYZDI5QeCMikk8Jdwf3KDcBsrQiy4Lu0yajsSZ2retI3i");
        FeatureCategory FeatureCategoryTest = featurecategoryRepository.save(featurecategory);
        map.put("FeatureCategoryPrimaryKey", featurecategory._getPrimarykey());
        issueheaders.setIssueSeverityCode((java.lang.String) IssueSeverityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setEffortEstimate(new java.sql.Date(123456789));
        issueheaders.setIssueFlagCode((java.lang.String) IssueFlagTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueCategoryCode((java.lang.String) IssueCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueWorkflow(issueworkflow);
        issueheaders.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueActivityCode((java.lang.String) IssueActivityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueStatusCode((java.lang.String) IssueStatusTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssuePriorityCode((java.lang.String) IssuePriorityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setFeatureCategoryCode((java.lang.String) FeatureCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setComments("yaMFFCF4vnkDqgEon7pQzCZtLUqs3510ZtDGM0T6OxoqPgNFpV");
        issueheaders.setLastUpdated(new java.sql.Date(123456789));
        issueworkflow.setIssueHeaders(issueheaders);
        IssueWorkflow IssueWorkflowTest = issueworkflowRepository.save(issueworkflow);
        map.put("IssueWorkflowPrimaryKey", issueworkflow._getPrimarykey());
        IssueRelationType issuerelationtype = new IssueRelationType();
        issuerelationtype.setRelationDesc("cVTWVMGU7w6HYSMJknD02HzT9uPquNbEemMFLcd1LYq0HoROal");
        issuerelationtype.setRelationName("76epWGApNP2RkBZAqWfpC2LUY5tkwhl5YDPoHYdpT1Z41OyqjX");
        IssueRelationType IssueRelationTypeTest = issuerelationtypeRepository.save(issuerelationtype);
        map.put("IssueRelationTypePrimaryKey", issuerelationtype._getPrimarykey());
        IssueRelation issuerelation = new IssueRelation();
        issuerelation.setIssueRelationId((java.lang.String) IssueWorkflowTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuerelation.setIssueId((java.lang.String) IssueWorkflowTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuerelation.setRelationCode((java.lang.String) IssueRelationTypeTest._getPrimarykey());
        issuerelation.setEntityValidator(entityValidator);
        return issuerelation;
    }

    @Test
    public void test1Save() {
        try {
            IssueRelation issuerelation = createIssueRelation();
            issuerelation.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issuerelation.isValid();
            issuerelationRepository.save(issuerelation);
            map.put("IssueRelationPrimaryKey", issuerelation._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private IssueWorkflowRepository<IssueWorkflow> issueworkflowRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private ProjectFeatureRepository<ProjectFeature> projectfeatureRepository;

    @Autowired
    private ProjectModuleRepository<ProjectModule> projectmoduleRepository;

    @Autowired
    private CreateProjectRepository<CreateProject> createprojectRepository;

    @Autowired
    private ProjectAccessRightsRepository<ProjectAccessRights> projectaccessrightsRepository;

    @Autowired
    private IssueSeverityRepository<IssueSeverity> issueseverityRepository;

    @Autowired
    private IssueFlagRepository<IssueFlag> issueflagRepository;

    @Autowired
    private IssueCategoryRepository<IssueCategory> issuecategoryRepository;

    @Autowired
    private IssueStageRepository<IssueStage> issuestageRepository;

    @Autowired
    private IssueActivityRepository<IssueActivity> issueactivityRepository;

    @Autowired
    private IssueStatusRepository<IssueStatus> issuestatusRepository;

    @Autowired
    private IssuePriorityRepository<IssuePriority> issuepriorityRepository;

    @Autowired
    private FeatureCategoryRepository<FeatureCategory> featurecategoryRepository;

    @Autowired
    private IssueRelationTypeRepository<IssueRelationType> issuerelationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueRelationPrimaryKey"));
            IssueRelation issuerelation = issuerelationRepository.findById((java.lang.String) map.get("IssueRelationPrimaryKey"));
            issuerelation.setVersionId(1);
            issuerelation.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issuerelationRepository.update(issuerelation);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueRelationId() {
        try {
            java.util.List<IssueRelation> listofissueRelationId = issuerelationRepository.findByIssueRelationId((java.lang.String) map.get("IssueWorkflowPrimaryKey"));
            if (listofissueRelationId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueRelationPrimaryKey"));
            issuerelationRepository.findById((java.lang.String) map.get("IssueRelationPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueId() {
        try {
            java.util.List<IssueRelation> listofissueId = issuerelationRepository.findByIssueId((java.lang.String) map.get("IssueWorkflowPrimaryKey"));
            if (listofissueId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByrelationCode() {
        try {
            java.util.List<IssueRelation> listofrelationCode = issuerelationRepository.findByRelationCode((java.lang.String) map.get("IssueRelationTypePrimaryKey"));
            if (listofrelationCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueRelationPrimaryKey"));
            issuerelationRepository.delete((java.lang.String) map.get("IssueRelationPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueRelation(EntityTestCriteria contraints, IssueRelation issuerelation) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issuerelation.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issuerelation.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issuerelationRepository.save(issuerelation);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
    }
}
