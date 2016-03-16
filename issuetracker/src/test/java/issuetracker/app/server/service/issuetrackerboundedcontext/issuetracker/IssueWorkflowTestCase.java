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
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueWorkflowRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class IssueWorkflowTestCase extends EntityTestCriteria {

    @Autowired
    private IssueWorkflowRepository<IssueWorkflow> issueworkflowRepository;

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

    private IssueWorkflow createIssueWorkflow() throws SpartanPersistenceException, SpartanConstraintViolationException {
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setFirstName("5ureJXVA4pKtJvT3f9z0GPP8rUEGRbTPHifH4t56dpfRvKds0I");
        corecontacts.setMiddleName("0z7XSjbEegFXchhPTOZ5ZbuFeUEz1E92lHH5uQ4xE6TVUokpjK");
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("ZpL2O0E3iAWs7gb1kTvqq1b1VEUsZCVSY20Zy5DaVsF1Vylhn8");
        timezone.setTimeZoneLabel("L8HB91AmiZcYOuoROS0cWPZej5RuUyXO7Xt7yf89yiETmbtWlX");
        timezone.setCountry("WQ2u0uZt8eBiMJwozrBYaIwTFs4TMjInFCEbrzlMidDo02yuxT");
        timezone.setCities("TjAHyXQzHTufnG0F4Lcg28keYsA9jsqbNA8CJjsLwap8DKXj75");
        timezone.setUtcdifference(2);
        Title title = new Title();
        title.setTitles("zDLSeVdYETZdair5WwTDnIVhCgbZw5DTwU5ilOzE9ZZR4TEUAY");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("rBuda4UaTeqcoZrs2pIpoSteeoPdZZVBdqJhcbVmKgJFCfcPHe");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setLanguage("rhSLSJT4HNuMSXwKKe4G2CcuA3wntZQ79bHe9Exw3V8w2TUtFp");
        language.setAlpha4parentid(8);
        language.setAlpha2("GC");
        language.setLanguageIcon("v3LYpGuopb1blqf64GSDckhvBi08P85rR5m01sYv1mRKLiJuRL");
        language.setAlpha4("XuMJ");
        language.setAlpha3("LoI");
        language.setLanguageType("bmuOTVhjzcG6bIdPN9dH3Vw9eQ9VY0E0");
        language.setLanguageDescription("TEjkC64c6ARY20cKGKksswJpImPfTtlhDRDIOtkqcfrgjqTWj6");
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        corecontacts.setFirstName("KObr3pLjopoZzVBoDzglVzdz133aivJX5bUbZsvAn5JTOcnWJe");
        corecontacts.setMiddleName("9WxRkQwXdtjBR4WWaqZ4puvyUYumqlVXlUMJRKBBVaA3do8ogG");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setNativeLastName("TQk63G3awg1CvvgyZin4v3wS1Sg59myj0BgKJvzUowSN2xbDCh");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458127886105l));
        corecontacts.setAge(110);
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("YqGfTzLWb386iIG6KfVbvUpB1pdy90aIQvxXGjFi9qPXKXzswB");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("rgNrQlaGk12FwC11mtK207m4KFsEXWDYjpAOykz36QTi5xSqeT");
        corecontacts.setPhoneNumber("x8SStl4RMF15vS6yoeUR");
        corecontacts.setEmailId("bEuEPrzkai2mJ2rA9PWWv3OlOH3yXq6kAIaBtYgZMTgT1IMNBT");
        corecontacts.setNativeMiddleName("C6cpmiDJHRPsprfQHyNi82JsOkmWO1iC60xkcfKHjhVYbFaoak");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458127886212l));
        corecontacts.setNativeTitle("YXaNHdCMqqmSqYEnsGRxkFendkG5tnmNBAETVUEGdcuU0hsj5o");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        Country country = new Country();
        country.setCountryName("0oklC23KOry9ShT5NfkSLXG6zDH6rMWVAlYOaOnCha694Ksmzd");
        country.setCountryCode1("x0h");
        country.setCapitalLongitude(8);
        country.setCurrencyName("r4WCuvZQxcDbHNZWJo0YeaYrrM1r7cNaYKu60BgFEI22K0jQiw");
        country.setCurrencyCode("krv");
        country.setCountryFlag("9fZBjiibmrcwhQwAgD7nWc6YrnsPXOJzXGgQu3KZ4N5J2b06n0");
        country.setIsoNumeric(3);
        country.setCapitalLatitude(5);
        country.setCapital("cAUJ82NtfGuLtelSEyyMgR4wSKqcByoe");
        country.setCountryCode2("ZZa");
        country.setCurrencySymbol("xFh1RR4hSV88UL06NhSX5LhB9S8onSuk");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        City city = new City();
        city.setCityFlag("fKqHHRg7Fv2fYaGbQNORuMAew1m6MYtO1BJiuLUZLLKIGsUGvj");
        city.setCityLongitude(4);
        city.setCityLatitude(4);
        city.setCityDescription("DbQo2lOIqvcfs8yV5m8ncseBHOpXlBBEvEkSOJIUXIhXXc3SQH");
        city.setCityCode(3);
        city.setCityName("HdzGtxQARO460YkCcjjeCny0QLTzySeuS0qbkTpn9e0WMLarrx");
        State state = new State();
        state.setStateCodeChar2("3nxdBaUdTE0uGGjfiRpacy1VBrvWrt2K");
        state.setStateCapitalLongitude(3);
        state.setStateCodeChar3("j3ulCyBTWGemG4tcnTBHL8FdZjaApyFu");
        state.setStateCodeChar2("zZw58yGILFZl7Sm01c8FWc1w24hd39Ww");
        state.setStateCapitalLongitude(6);
        state.setStateCodeChar3("rahCGs7BaHcTszAItxtoihBZERPXxrUh");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("JtYUMK5FyHq0QDWGBjjH5eyUZT4SoaruVSLwYnVs9Iw9LUzYbL");
        state.setStateFlag("ZOxv9E9WDAu4KaoIFPCX360vvUtSpxxBMn76SIWZ05cjH7T6UR");
        state.setStateCapital("TedIunSqbtBab3u0h751hlYSgO9aosbSepJAdEQY6uTDZSD96N");
        state.setStateCapitalLatitude(1);
        state.setStateDescription("MC80lPOlmASYrU7c2BKj2IMXJ8eIai2qRrY3BwDY3kaZHPyvL0");
        state.setStateCode(1);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        city.setCityFlag("igKk6JGdJx3FvL9F29rYyFcxYr0YVK4dB9T9ZArDm5RiBBfN0h");
        city.setCityLongitude(9);
        city.setCityLatitude(5);
        city.setCityDescription("j1pfUhjZIHBbDSNM5Y92zwMhXkQFbkL1ELGXW2yIKipZ3YqjiE");
        city.setCityCode(2);
        city.setCityName("W595OjvFhVT7EcN9jD9DawDDXqBafsDHY0IPsr11aaIzK1CFAh");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("56amYFG41RC4PT9n4CmusjcmEQg9jF5T");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("j6QQBmpJXnzdBQKB1n3aEK1fdNQiUkpbuqZ71wdPeVMNIujHCw");
        addresstype.setAddressTypeDesc("WBhnqrw0JXZCdH4QjxLX7PzXAkqMOC2DBPoranSGdc5nZOk6LE");
        addresstype.setAddressType("AMRj24fKzMHnHTlyeVVy6TT911TyG5Niw3pf55ecHD1uOXpArr");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("UVffgXOefO0YTGWcyICMeSl9fKbcHOslLPhOJYiaXCnaA9ChV2");
        address.setAddress1("mBX34lcayGlY9tNSxnXRilgnaBaGC0h3lnBGmX2uidFobZ4r0o");
        address.setLatitude("Qn2J4OBlU3yFeUN5jBIQobTc0km7fNTsb0dHEeU11YWpx9HvcZ");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("PHWT8h");
        address.setAddress2("SB7xNasFpIXAGCxEN5PMrDwdmPdlqADGoVCdSKMtQwHOckOPri");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("94LakfjYaNu");
        address.setAddress3("eVxVT4HbTSTcm1Gj64ZoDaFyfZhooQ7wbQvUUSBVSo5z1ZjyEb");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("MgokmjcqNcp9Ca9VNXm060ChrPMLNkNtqhzACZo1nNxfLdOiE3");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("URusrg77FdH12ahkNTYwSZIKfYB6fv7F4Y9FqNDWDcNGQdyyfS");
        communicationgroup.setCommGroupName("120SmchNvv9PnYpnUkQtI0eED7kDqbKvYKdShVjhcUqbNGfvxQ");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("Nc2svs3NMhhnp1YNTt1pONpZ19nNxdx2P7k41b3oJ8h6lPgHYm");
        communicationtype.setCommTypeName("Za8CCQGLVbRs1J1HOOxzkv9zt4XD8maSJ08WvwPYoQikoEpQMQ");
        communicationtype.setCommTypeDescription("fW5zY6HpDlmjc5xohR9LyhQG9zMYwikUy1xPKwpDAyW4s34LFU");
        communicationtype.setCommTypeName("zgjQzxSikS5JU0kAAGn0zERil0cF6sRMENSdm4sAJZq8vmzKhM");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommData("ZpfZlyn8OoPTwxqkyMJ0kX9eRRSL8K6rcXVN4WV3aU4qk8ab4z");
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
        projectaccessrights.setProjectAccessName("KBVB3W3YldJViIzluRc8G9ht1t9ukNRP1zRb8NnbU4RpUFXyyO");
        projectaccessrights.setProjectAccessDesc("T358QbaXue1qAvjNWIMW2nOlqWVlYAArkTvWcnNO3JIRkht04t");
        ProjectAccessRights ProjectAccessRightsTest = projectaccessrightsRepository.save(projectaccessrights);
        map.put("ProjectAccessRightsPrimaryKey", projectaccessrights._getPrimarykey());
        createproject.setProjectAccessCode((java.lang.String) ProjectAccessRightsTest._getPrimarykey()); /* ******Adding refrenced table data */
        createproject.setProjectShortName("VCig4QZtnGcklm97cz7HEWhGkdTfRl1E0i3dBhuHRJIQuCb57H");
        createproject.setDateOfCreation(new java.sql.Date(123456789));
        createproject.setBuild("bexNmhXkNLS9uhx6xmKgKrNOdmwKyaeN1GMw1V5Ud2SSK98uvd");
        createproject.setVersion("gDLAXE36qWWt58p2Q4RI0yXPhau0FnAx174KOb4AOXW5kcdHK1");
        createproject.setProjectName("HpSkRY5l3s8xLQ4PScaV8OxaDUZvYb84Tzu3HR231wMLYRGH9i");
        createproject.setProjectDescription("eBVseVDuhoMO6UIbaSAZxYn6Pnns63FVPw0oAy1GKg5IcH308Z");
        createproject.setProjectURL("GFiTaJltarhBWZ6AuiEq8RsLN5DbIf4057usUnEyWS2rcpCDr9");
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
        projectmodule.setModuleShortName("GGH3tHNlSneJNdq0gWL58cWfDvfL3IlED8AoZYUsX8067vB9cw");
        projectmodule.setModuleName("aB3E1vrEvEAPibAPHpd9WCQAwSgmKEPuBQ3FN8vUmIJwu9CUI1");
        projectmodule.setVersion("ZLbLmoD2g86u5AmZrZWD1ImEIieEGbo138jCfyqszHddLRbd7O");
        projectmodule.setBuild("GAHr9TbaKn5M9v7a2yYzZ8f7BIVkwhxCpX8v9SZMLg98naBoV1");
        projectmodule.setModuleDescription("UWtx4i5ZJm9iKSodOFuSUEF4dgtk0IUaXLRnXx7BU5EDuFWsqK");
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
        projectfeature.setVersion(6);
        projectfeature.setBuild(8);
        projectfeature.setFeatureShortName("TAJng1acOkT2x1AlurkgJAGx7vddn1vgsjBUWHyBBu6H106IG6");
        projectfeature.setDateOfCreation(new java.sql.Date(123456789));
        projectfeature.setFeatureDescription("9pU4NzPRl47YLZT9hHt0lZthmaaM0gnJLpkbKggemKAyjsjhuI");
        projectfeature.setFeatureName("IiKzggozEln2veiJhluYYLUco9rijVqPkTX0doYA22epZbP5CO");
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
        IssueWorkflow issueworkflow = new IssueWorkflow();
        issueworkflow.setCreatorContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setDateCreated(new java.sql.Date(123456789));
        issueworkflow.setoS("qT2wnsh5KCli3Xw1tg7ddMdwJC58lMpVTvSetz8LisZXv2M4Dm");
        issueworkflow.setStepsToReproduce("6pF0WSBThYLiC6ZgXYv9ptBZ3VhO3dI8DmPClC2PjORjp1RwUh");
        issueworkflow.setFeatureId((java.lang.String) ProjectFeatureTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setModuleId((java.lang.String) ProjectModuleTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setIssueDescription("1N6YLRMbDDTuGfpxDYNk7isJWTZtBvHs1lxue9IkIroIe6zyLT");
        issueworkflow.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setBrowser("6lYeQyjpx9QHQRou9x9TWQh93SAnaodahMdqhDgsWXkS7i3yBU");
        issueworkflow.setIssueTitle("Q3n5QgViLtEsyEYMQeVYmeltCjVlnE2VlNXByeJTZToMoVMA3X");
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
        issueassignment.setComments("GteCVEg4ONAzXfkAOWAyVD5OrHrmY5o3cQFilJEVqsmTM1OwhW");
        issueworkflow.setIssueAssignment(issueassignment);
        IssueHeaders issueheaders = new IssueHeaders();
        IssueSeverity issueseverity = new IssueSeverity();
        issueseverity.setIssueSeverityName("NBDLyTnDkzo6kWWMTAFjMPKBsAeIr6ii2h4IksBhYT2RbBJFlS");
        issueseverity.setIssueSeverityDesc("1OKQ0GSKIbvG5vob3ZjX49bzifnG2IuG4vY0Q8wnSbwwjpzF5v");
        IssueSeverity IssueSeverityTest = issueseverityRepository.save(issueseverity);
        map.put("IssueSeverityPrimaryKey", issueseverity._getPrimarykey());
        IssueFlag issueflag = new IssueFlag();
        issueflag.setIssueFlagDesc("4JDaGfQwS1h3ywt0elJ4yHB5Md45ITNRlPQrkRsHvGyQcNvO1n");
        issueflag.setIssueFlagName("t2df8u68mzOjR04X3MykA6YblmC8xfn047hjGdETqQStmTnBAv");
        IssueFlag IssueFlagTest = issueflagRepository.save(issueflag);
        map.put("IssueFlagPrimaryKey", issueflag._getPrimarykey());
        IssueCategory issuecategory = new IssueCategory();
        issuecategory.setIssueCategoryName("T3I21o3Dbud8GCPQpClDZk0mRdTFYnAUUjKsgkzgZri79lkFAt");
        issuecategory.setIssueCategoryDesc("nbWmcqbu6XJsvJnaPbnfqUwJNYf5ry1QhJ6nvQZ1n85HXyzsdv");
        IssueCategory IssueCategoryTest = issuecategoryRepository.save(issuecategory);
        map.put("IssueCategoryPrimaryKey", issuecategory._getPrimarykey());
        IssueStage issuestage = new IssueStage();
        issuestage.setIssueStageName("RDOhPSeiq2afIy2knYdgkwjqCAPnRqmWbFFZsVOefMo4qQhsqx");
        issuestage.setIssueStageId("8aHNOG6F76gnfvnlVIoZkXKuNm7q7STgkABqWQPdZpJhnRi1Kq");
        issuestage.setIssueStageDesc("p30aMQfqP4oKBYg4CLpo77iBgWE6ogtDU1x9p6f6ClZbNs8kva");
        IssueStage IssueStageTest = issuestageRepository.save(issuestage);
        map.put("IssueStagePrimaryKey", issuestage._getPrimarykey());
        IssueActivity issueactivity = new IssueActivity();
        IssueStatus issuestatus = new IssueStatus();
        issuestatus.setIssueStatusDesc("Rt3xuTsat4U1Kz4tkGQ5V9gk17rY8CMEsPZ3jxM5B2eTpzr77M");
        issuestatus.setIssueStatusId(valueGenerator.randomValueGenerate("String", 64, 0));
        issuestatus.setIssueStatusName("cArawRKGg4F2p1wCXbGu9nnxLtzAK53Qvp0v0mhDhDH3eyDDVQ");
        issuestatus.setIssueStatusDesc("lsYFCo276yWD3PnYs9dIBtsvudf4Hr5XOocd2jHjvmoCjrr8Zq");
        issuestatus.setIssueStatusId(valueGenerator.randomValueGenerate("String", 64, 0));
        issuestatus.setIssueStatusName("2caxza1FnPb3l6lmXIBFUpCbbKsD4NyI607g9f4dUoCSWLTFcN");
        issuestatus.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        IssueStatus IssueStatusTest = issuestatusRepository.save(issuestatus);
        map.put("IssueStatusPrimaryKey", issuestatus._getPrimarykey());
        issueactivity.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueactivity.setIssueStatusCode((java.lang.String) IssueStatusTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueactivity.setIssueActivityDesc("uaKhb5OG7ra3pFsXnpjXLZ9e01KHyxiWYTJyjnlLi64xo5ME6J");
        issueactivity.setIssueActivityName("10ByNFqBBc8g1cQsnUEb5vIwaAG8TdR4aqmaAjIPzKwExU5uSb");
        issueactivity.setIssueActivityId(valueGenerator.randomValueGenerate("String", 64, 0));
        IssueActivity IssueActivityTest = issueactivityRepository.save(issueactivity);
        map.put("IssueActivityPrimaryKey", issueactivity._getPrimarykey());
        IssuePriority issuepriority = new IssuePriority();
        issuepriority.setIssuePriorityDesc("6dP1Sajujceg9e4gOHF1zkCTGNrmnAyG70qoUrdpBhEu4ocevX");
        issuepriority.setIssuePriorityName("teyU75aJzmf5zSNQngtOzUHFkYb34mkr9UMi0SpkSDmQud7IS5");
        IssuePriority IssuePriorityTest = issuepriorityRepository.save(issuepriority);
        map.put("IssuePriorityPrimaryKey", issuepriority._getPrimarykey());
        FeatureCategory featurecategory = new FeatureCategory();
        featurecategory.setFeatureCategoryName("si2HtisebChDHOgRB4rCxe78k8NDUsis2ye37WLhXfOYU4d4Nf");
        featurecategory.setFeatureCategoryDesc("2T0TmzjKlBYymPYh9c9fYCV1jfMPLo4pRzjI8QYLRxVUTNq2Ym");
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
        issueheaders.setFeatureCategoryCode((java.lang.String) FeatureCategoryTest._getPrimarykey());
        issueheaders.setComments("y1ype5SezfEk17kGYH1STA01zlG3kSFOmcMiBOgM2eHWIGqGNz");
        issueheaders.setLastUpdated(new java.sql.Date(123456789));
        issueworkflow.setIssueHeaders(issueheaders);
        issueworkflow.setEntityValidator(entityValidator);
        return issueworkflow;
    }

    @Test
    public void test1Save() {
        try {
            IssueWorkflow issueworkflow = createIssueWorkflow();
            issueworkflow.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issueworkflow.isValid();
            issueworkflowRepository.save(issueworkflow);
            map.put("IssueWorkflowPrimaryKey", issueworkflow._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueWorkflowPrimaryKey"));
            IssueWorkflow issueworkflow = issueworkflowRepository.findById((java.lang.String) map.get("IssueWorkflowPrimaryKey"));
            issueworkflow.setDateCreated(new java.sql.Date(123456789));
            issueworkflow.setoS("ZKwwI0QPsXzMAj5jqC8AdDZnfw7FnuSINnreFbnJbGKPZziolU");
            issueworkflow.setStepsToReproduce("Wj7AAxDdtXdeKj0vGAdk87Ucux28ZSC68IMTjmoYY9fihm4e7B");
            issueworkflow.setIssueDescription("spZTkqQlVr68cBuCsCI7mT602nTOudebGzH3QjGJusSeqM1eRg");
            issueworkflow.setBrowser("gaAE9DGCXinfp7VWkUB3b2KHhxHfIv5kx6lDuXMVxgYeMlpNzi");
            issueworkflow.setIssueTitle("7aXEjHXIh0PtXw2HU6QnuYmz8Lto5syYBnzsr5lTxiZ4HQr0AR");
            issueworkflow.setVersionId(1);
            issueworkflow.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issueworkflowRepository.update(issueworkflow);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycreatorContactId() {
        try {
            java.util.List<IssueWorkflow> listofcreatorContactId = issueworkflowRepository.findByCreatorContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcreatorContactId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByfeatureId() {
        try {
            java.util.List<IssueWorkflow> listoffeatureId = issueworkflowRepository.findByFeatureId((java.lang.String) map.get("ProjectFeaturePrimaryKey"));
            if (listoffeatureId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBymoduleId() {
        try {
            java.util.List<IssueWorkflow> listofmoduleId = issueworkflowRepository.findByModuleId((java.lang.String) map.get("ProjectModulePrimaryKey"));
            if (listofmoduleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByprojectId() {
        try {
            java.util.List<IssueWorkflow> listofprojectId = issueworkflowRepository.findByProjectId((java.lang.String) map.get("CreateProjectPrimaryKey"));
            if (listofprojectId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("IssueWorkflowPrimaryKey"));
            issueworkflowRepository.findById((java.lang.String) map.get("IssueWorkflowPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueWorkflowPrimaryKey"));
            issueworkflowRepository.delete((java.lang.String) map.get("IssueWorkflowPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueWorkflow(EntityTestCriteria contraints, IssueWorkflow issueworkflow) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issueworkflow.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issueworkflow.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issueworkflowRepository.save(issueworkflow);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "issueTitle", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "issueTitle", "YUb98C8BatrDJZI5qNB3nAAUv3BhkphHsDj1LfUzzBrR0rvwisezhlKOEZwZUcsH7bJPr4FEJ14JFsbVzaQizO1jcflDJzAHMo0zKY8PxEuBXQ2vfu2sSdUHJZ8zxqULrPgLtScdXLtLp0tQ2DqvMC5sU4oHKpv3jIvszuU1sFbupZ7iXe1QrSzENuZoDwDLFcvHkc0Fol8KWyHebcLOkq3z8AdN21TfnfcS2ih9ueoglW6r1Ar7NCIF7kfkDEKig"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "issueDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "issueDescription", "6tfdxOLpd9GxtCZy7krwrL4sJD1ZhdDRuMaRlQmipay690nG36BypMclk7NcyVYCkxQjbUTKzzDiAiR73VF9aOHwEB6oXjbA96sFJzD3T6V6BmibRyEJxaM9GdwYXjrYu2AguFGZkxTae8T46YLtsEd2fDsA0wBaIBucwfIdsomCOoAYm1eFmnrrmlDmnPsXo7BHZ6rQIQ8w1pSN0YVv9Hf4wax7o66QRKPJPDf1ijd0O5N6EcmQxqlNmCg1oTtPQi8Yer8JLnnLdRHDFJgoa5TCgzZCjTEjuqzBEeTC2E5qC8V6xKfHEzExhAyVb24nZrV39Na7ypPTL6MMLPbCbszz9f9Kgv7ISDsA1V4yImTqasKy45sBxy8YDHVpS7fmv5k8a1GGz6hLn8KUzCMiexY6Zj54tRNEXeyNQuGowIl6Eu9tLerrw60gkHT3Hoc1wsLrtszOOmbavj7stsHCCQkxejvcWgJv7KHP4IT48IGcMynimWtEYVc54Qy98K0RPMQ7nknmPl0GVJ7GO0iorDDjiUORPvXGZRN2zAW6YhPLidBkg4J47zQAhwMHJl1yPuIaychZHicWLhppkEXY7LFbYBBozFF0jkN73FN0him2OMlHnalQbip5eU61OpPdwbXSyReistL5KjRnN4NIqP0Myeg3muPRRIsXrgEIJvhtLbUgt52xPMriNVUDakZl9H800whc0bkMs4viV7miQOZ4Q2zKk1PM7UHnofuE4jdT0LvYO0ldPg04K5wNYgRZBNtn82VoOThClVKZ6ZoWybpCoaCe6TkChCWUIFPkXzAByreGQAcdTsa2udTH5LR0MaDkmv9mkZUt047rjsdCiwhhfm03L6AMwJmIPPjOMq4eBeqf2Hne3fv6tQ8oTWVmKD7gKAvH0wt83g8lAXrdzQtgbVW1X167WYZubN63d3ZaIcA7aGX5xKAhnlI2hOnYdMEA8MjiyTucOAQ2vVLNtwO8oqCJsNuF3K6fpCAvq6EkBcsXbM85a51OlvQWKX2bZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stepsToReproduce", "aPQbPMx6rCX38cayKHjtDmx1oIlMH2Pk4pxqXbtR6RJrBGAdlu6An8aSup34kmZ7mSShyO7apLaiPGk45LS2CJ6iSFfsosUheHBik6APasESPF6dJoLXjKXOp7JIeNRNIymaE3tffq4qindtBKYpJWEH6bBXbCIKDDrlCK2SdeEdEBGGos9srGGNFH1FkY4tFc5beXyE9lIDQMfpcmE8V3Ru52x3SVOt4o3MsCymJvjDz6pjvEYqyZ6LwkMaoxOfEWDONKhaGRJbcCRfB9RW3aEJUcGg97Pa1MtT5mz6Ft0tyzQjDCL2baJNlpQYFIS743JLT56ZmRfjcxxnV1BkrCmtGO65j6IZj5WAgl7kcmyTXU8iQgFXlCuo9SAt4HMI0mUKpOusakhRLhpXZVNR0rVAX6fkqWATZ79JHpH6GGl1DhJH1nHizFsw12VOkGgV6aWZuJMbYLqHOgvlKB76TFkMCM4LUC7zewbjlrWQ46mfMOm13nYXxSSfDiYTeqo5h8mp8TU5UuM5wiGhg3lO7ktKioLilCKorxfWJXzeZq6DeLWK7E2jqgxWeaG1YpsSSkXo46NuNpCzDf77YjVV3kaXJsgj9KesaECUGHrhwAnQFtDrnDwXRGPxLdPgKNoJK7SwRm8N6I7g48HWR7HDvB5l9Hnd10BeIj65VFyl25yItuEl0GzU4etm7UMC1VZK4eKGinYxuyAmqXrzwyrRuIKO6JeV5E8taMnP6ftIuYVVTu0b10BeAPqzvgkzHfkskr3Sebg3kiKdLKwl16znZfgWJ5f6L34VOzmXyaPbMRcVhRMDJQjomEkmLwq9dtHvY9yaTRqJFKHCNUmaZY53AaPybzTsOpOlZlTz8WtGqWBM3cMz5FCIRTqm84VXVlZY3hCSiNhdTAkLIJBtZ40h6MxlYYrGiVpcSeUgqbEZftWJ659LZVzdSlbTLhFD9vjQTiXi5Xu1YJoAeJ2U9z89oNviDbB4NBXZ7TmsF5u6FZd7r8KR5Y3r5vmBWUY3uqCSQ"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "dateCreated", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "browser", "jO7fadDkNYvZaFQuAcwav0CtHSUxv5JHYWTIhMn0R98b2PBq4emD5Cr0ZTkpeQ0Uc2dMKdrkg0m0LlxnI10xaBXFuTtch882bidbdR527FBljOOQXncP9hNoJUgNP04fH4airNm4CB8DQ47xJ1n9lJEbWNDdvoBckXcvdLKLf37Cd2KIyRroO8BV5blVSvuasG7ZfUZ3Fi3pbc4pNduuMsTa9NW0uqD7xWffIdaEswAmqlRWXMQeQsrSUbbzB8k1O"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "oS", "RgZ6ZRgCF3hakGhcKdMv3LrtbfKaZS3PMYieYStIb0oORGy0zxoJKODrnoowKqxJmRPB0CtJXrVjvEEgmANwncMeOP3jYndWftX9gKTLpcL1rlTsZUr202JoltBBzrbYLmZMBj9EPr6ds8ZxSb9DXQQppekB0Dby48MVgs0e4q70teQHfNv1THBGOmH2fDhYkNF54MBASPbAMEOeuljrwZbLIyyRzPBzgWwGNcrZRmJAdHcdqHGEsFNaNNtqZ6EzE"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueWorkflow issueworkflow = createIssueWorkflow();
                java.lang.reflect.Field field = issueworkflow.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issueworkflow, null);
                        validateIssueWorkflow(contraints, issueworkflow);
                        failureCount++;
                        break;
                    case 2:
                        issueworkflow.setIssueTitle(contraints.getNegativeValue().toString());
                        validateIssueWorkflow(contraints, issueworkflow);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(issueworkflow, null);
                        validateIssueWorkflow(contraints, issueworkflow);
                        failureCount++;
                        break;
                    case 4:
                        issueworkflow.setIssueDescription(contraints.getNegativeValue().toString());
                        validateIssueWorkflow(contraints, issueworkflow);
                        failureCount++;
                        break;
                    case 5:
                        issueworkflow.setStepsToReproduce(contraints.getNegativeValue().toString());
                        validateIssueWorkflow(contraints, issueworkflow);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(issueworkflow, null);
                        validateIssueWorkflow(contraints, issueworkflow);
                        failureCount++;
                        break;
                    case 7:
                        issueworkflow.setBrowser(contraints.getNegativeValue().toString());
                        validateIssueWorkflow(contraints, issueworkflow);
                        failureCount++;
                        break;
                    case 8:
                        issueworkflow.setoS(contraints.getNegativeValue().toString());
                        validateIssueWorkflow(contraints, issueworkflow);
                        failureCount++;
                        break;
                }
            } catch (SpartanIncorrectDataException e) {
                e.printStackTrace();
            } catch (SpartanConstraintViolationException e) {
                e.printStackTrace();
            } catch (SpartanPersistenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
