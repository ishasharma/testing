package issuetracker.app.server.service.issuetrackerboundedcontext.projectmanager;
import issuetracker.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import issuetracker.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectFeatureRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectFeature;
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
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectModule;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectModuleRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.CreateProject;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.CreateProjectRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectAccessRights;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectAccessRightsRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectUserMapping;
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
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ModuleUserMapping;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.FeatureUserMapping;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class ProjectFeatureTestCase extends EntityTestCriteria {

    @Autowired
    private ProjectFeatureRepository<ProjectFeature> projectfeatureRepository;

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

    private ProjectFeature createProjectFeature() throws SpartanPersistenceException, SpartanConstraintViolationException {
        ProjectModule projectmodule = new ProjectModule();
        projectmodule.setDateOfCreation(new java.sql.Date(123456789));
        CreateProject createproject = new CreateProject();
        ProjectAccessRights projectaccessrights = new ProjectAccessRights();
        projectaccessrights.setProjectAccessName("5yzKDNGPtLKqjjqHYPyOvlIvDQqyNalXGf2W93LfOgFan14Em6");
        projectaccessrights.setProjectAccessDesc("f7NT9ejEvqy7KRRuc6dHF5a8qXMcynDp3ZHSCscvBxwmbRt5ZX");
        ProjectAccessRights ProjectAccessRightsTest = projectaccessrightsRepository.save(projectaccessrights);
        map.put("ProjectAccessRightsPrimaryKey", projectaccessrights._getPrimarykey());
        createproject.setProjectAccessCode((java.lang.String) ProjectAccessRightsTest._getPrimarykey()); /* ******Adding refrenced table data */
        createproject.setProjectShortName("5NzhwnTzrgj0bBSndouDPKZMOd73m1UhY3nJ49LzhPvIbIjWKh");
        createproject.setDateOfCreation(new java.sql.Date(123456789));
        createproject.setBuild("D4IJV0eswqpTOdigbh3aFCLRafDdrCNWpzYJxLhA64Ih1s4g9S");
        createproject.setVersion("2yFNwBSV8LaII9P8ONcwgXvOAZgwibepHYDF7Z0WAx3nHctXQ0");
        createproject.setProjectName("vocgOcT9lkAXTpUOwGXbINUe7snpcYoBOhLLyo6Q8xfAIudpHX");
        createproject.setProjectDescription("hLUN2ksppYWG2MswpS5Ee9jIjD3W4Gu0EXhl6km5euFsMeaO9E");
        createproject.setProjectURL("xmjqQn6Of95V0CV00VMrufKdMAkgiHNzVHH7x3nvUei7LmAU4B");
        java.util.List<ProjectUserMapping> listOfProjectUserMapping = new java.util.ArrayList<ProjectUserMapping>();
        ProjectUserMapping projectusermapping = new ProjectUserMapping();
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setFirstName("ck1ZMzE2eDaS31E6OtzRtOKkBDxWEBuRwshYSiNu7q3w76QpAA");
        corecontacts.setMiddleName("S9z9SoQUYkbpysEHx5TGBIsls236D31gxQoO34EfimJSsLSeQS");
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("XL9z6TgbudNOLqUFHKgEYg1DgZYvPedy8E7Ta1lWRHqQQ86Su5");
        timezone.setTimeZoneLabel("UXFoNd9zJUTygAYSUB677TzuIz4gKZaNy8HGXZvhqtEnDDD41f");
        timezone.setCountry("IHpK78eKvI32aPnaDXNUn3FVfDlv7VyE7CktRYXzEQqV8FadWD");
        timezone.setCities("e0wZg95stZOQuhMmMCECRHmQyAXeTWPaSfUztzZX1fQY7kqXCY");
        timezone.setUtcdifference(5);
        Title title = new Title();
        title.setTitles("dZu0bv58w2bUMCeUJQelklwqaGp5ADXKqfqtWvwjTdvBj8Ydny");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("G95VJPk33imZr35ykGtjqd9d6FfAaztAxCb1WKnUobKyUXMBAw");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setLanguage("nRNvwVwu5ZVCJE4NkLweeXhIUTx8mqIVaV2OEFygqUgVvtisTg");
        language.setAlpha4parentid(9);
        language.setAlpha2("8g");
        language.setLanguageIcon("qfDPADHky9rKSPWFwuEumOC1n5SLAT4nQkT7tiqqR6t96uGFoQ");
        language.setAlpha4("qQPH");
        language.setAlpha3("Dl2");
        language.setLanguageType("IolE5F72yErr5sxBFiqWB4VGTcYC4vpF");
        language.setLanguageDescription("ScMAfiFxHBCnTQhJsnxnfF0TRdr3rVpPmXiAxHeL3FuVe8xJgA");
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        corecontacts.setFirstName("xIBLnpHQEJpV7mNTGHdmY91KZq8LEwo4VKrF5vLp8b32ycWcU9");
        corecontacts.setMiddleName("uyOtiB3EOG6MhCOkcy3cX2JZa2gLHAoglJzpWqrCzi0n0Qvusr");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setNativeLastName("8qfL6SEkFly0MIUByWVqOxBjvOuOQLoM40PKFcRIqW6ssx50nq");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458127872721l));
        corecontacts.setAge(18);
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("StbLqhw6E18wedV7KujgqmxNuQTwSJrJ6iJc2s5kH5SzasmTb3");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("se5bQICjfvN2of8USnWu8nIx11rZ0MlYw3ZJjINooC0ArKKvQk");
        corecontacts.setPhoneNumber("Jis3v3JukCfGTV8WKQIQ");
        corecontacts.setEmailId("WlxDwqRbyCcZDQVmutboUDCGMrpRdIguJkqmGnd08yHydfri1V");
        corecontacts.setNativeMiddleName("PI7jKbu5zApiyrCdrd0DfxsPhd9Dfvquhr4qC6SdM3xmR7f0n2");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458127872827l));
        corecontacts.setNativeTitle("hsaXMZamGWyALXqFkNIJ4Q8QYiHjFT4AhlF7bRxN39aiPpUAVy");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        Country country = new Country();
        country.setCountryName("EkIbyDXJRY06cjO1UILOEk954yCVrwWUdWwi7kwIQiXchSNESY");
        country.setCountryCode1("E6N");
        country.setCapitalLongitude(7);
        country.setCurrencyName("CNKtbSi8f48nO2lkCGKKyvTYagP6Qzz9spU2khQhZwEasSmn2m");
        country.setCurrencyCode("pmI");
        country.setCountryFlag("3b9NSv4JK82akFtU1a0avts4mKmQUlEySUQmJOTcMRexXxSH5w");
        country.setIsoNumeric(6);
        country.setCapitalLatitude(7);
        country.setCapital("88RnRPzlF97ztz0L2jyUMw5kgUtSrrlG");
        country.setCountryCode2("rJf");
        country.setCurrencySymbol("MPsLv7ubSOACxDy6WpCLsOxjRTJmHVES");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        City city = new City();
        city.setCityFlag("bnzcgslbSAznwp0OfxjzcPKkAet32tI7eIGWXo50nQhItGMd6N");
        city.setCityLongitude(6);
        city.setCityLatitude(11);
        city.setCityDescription("hax1dxJgUKMFk8Ed3xciFeBFrtfViYkGIO8nt1ipbca3NbNcmk");
        city.setCityCode(3);
        city.setCityName("8yCAwr2n9XWkzHrArKA1q4ZzVjFN1aUe0jEknzi7WYKDvuIXRY");
        State state = new State();
        state.setStateCodeChar2("PzkTZ7K4HkoixUFKvfePExX7tZyDHGQu");
        state.setStateCapitalLongitude(1);
        state.setStateCodeChar3("q9LPamhqWOfI9UIZ48riTyR5hnAPO9jN");
        state.setStateCodeChar2("J9r5pGqeAbN2GUvFO8zFSVPNWuH25sbK");
        state.setStateCapitalLongitude(1);
        state.setStateCodeChar3("ScoJMhinqN4dscJI8nbfiNITrrruvuOD");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("Q6k8pjWgf2E9qb2pvKTXGbkdMGZjwjtRvLpCkhf0IPo9sYtH7h");
        state.setStateFlag("xaMaoQamlF7ow2C1xB37vhgaVR9bZwcobn2N7FP2NPRS7Gq24I");
        state.setStateCapital("6g8921UL1WGPZeGluicaPtom6uc3G5SaF5qVcdO0VBGh61vX2o");
        state.setStateCapitalLatitude(1);
        state.setStateDescription("u4Di10rb9k98fvQgPxJJmOz7O3H0cB0EubYXcZrnYOelBeL8ZB");
        state.setStateCode(1);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        city.setCityFlag("CpRUFyvlIqMCulh6ng0KuA1IOu4ushOajP1nlBVt3WgscqML3v");
        city.setCityLongitude(11);
        city.setCityLatitude(1);
        city.setCityDescription("RlNLn3XMyYh1rQaacg44s7dSNlsT6ivv6VVIRpCpZZWG40lI8J");
        city.setCityCode(3);
        city.setCityName("WGTH5WXP5xMHqYTTmpULTRkGQ3i5w2EKAU0OGETQc7lW07rk5x");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("YFszNoJLGdVobGFTKyNtdgKzmyMe4ONd");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("bzkXzl9TvK5d0jNm191TS3eGKilO8OrnrUDLXrHqgKvJFOWuHy");
        addresstype.setAddressTypeDesc("rIY86CCJh09zl49s7T3Xh51Zx38Rj9PeMBv1uz7iN6FmoNYKKz");
        addresstype.setAddressType("vggaPTLk9fCsUqqD5zWiQc4MTkDDm4jD7kiYVP3697hoCeMX92");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("pmgyma5aGlGkiNL39jqoYajbQkzxIKbbj0znq8fnS8GIrtUclZ");
        address.setAddress1("KDW2YgQ86rHlXHJYAy5murTH5BUBIKxHPqSfyAgkAdYsmhB2Fr");
        address.setLatitude("qmsMezoJFZZInegUvvJVQio7Az1mL0nc9UnLK5MHD0SLEfxFAy");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("RzEJ7k");
        address.setAddress2("FGaoN7mqsybGLjlbXmJyntNL0Tk1TJwNYc378U7qOB6gnPIKrH");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("FLKIfz2U85i");
        address.setAddress3("an1yrhnNV1FQhgniTbd8agXhh0FUzhQBw3qho7O8ods23D8l6y");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("HoCWGNkRypuFSzSeJ8eSHE85vGmMJXg36HVZVwuAVjBNlkekGz");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("RMls0ZUoQOqtMcf49lrpP79hafeyiqcGgw6n01L6fFOvcSy0tx");
        communicationgroup.setCommGroupName("bCFatp2WSnEJIuueUi3FvcrLOA290TihfDMmCnUDlfmBM8kl1z");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("Yt6wiQTtpnQbfmNnljvq9nquCsrt9kJkxX3YVynEf6QgFFsK1N");
        communicationtype.setCommTypeName("dDN0zAPMWCXSVxkvQaqGm0nHnG32lg1wrGHDW9GhDJi6h2o57C");
        communicationtype.setCommTypeDescription("QPqXSsuzocMob41mwi0ZsNJrXvntjxDbYtDrQ8EwCYNRF7S1Qg");
        communicationtype.setCommTypeName("xuS8uCcWc7V1dUpEM55nwC75PT9BHyIbQGdNQhfqW2yZfeqHDy");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommData("Yc9WUTQlvBtRIv89B5d13rbfBE5duOjNij4o4eeNnPPC7EK0w6");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
        map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        projectusermapping.setCreateProject(createproject);
        projectusermapping.setIsAdmin(true);
        projectusermapping.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfProjectUserMapping.add(projectusermapping);
        createproject.addAllProjectUserMapping(listOfProjectUserMapping);
        CreateProject CreateProjectTest = createprojectRepository.save(createproject);
        map.put("CreateProjectPrimaryKey", createproject._getPrimarykey());
        projectmodule.setDateOfCreation(new java.sql.Date(123456789));
        projectmodule.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        projectmodule.setModuleShortName("SBCneNwEyeD2BU40OOzvm0G01j1hTOGijd9fQ90it3H5lOTeQw");
        projectmodule.setModuleName("BDNe6q9DRtaPj30RsSmlNOZdU9PeZS9rLyQ1mBxzXJKRqQB28i");
        projectmodule.setVersion("IgXDNEOFuhL9xqV2jrA9DMNndYsVQleZ9X49FvmeVIpYR7uDyr");
        projectmodule.setBuild("nyMGiib7NuOceMoSqsPnrssYNHXsllpnRkxsA7e2D8JsljPrap");
        projectmodule.setModuleDescription("9kkchIvGvr9zESLGaKaazvsexm17rtOrP9kTx9nJ8ArhXDZ3Tt");
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
        ProjectFeature projectfeature = new ProjectFeature();
        projectfeature.setModuleId((java.lang.String) ProjectModuleTest._getPrimarykey()); /* ******Adding refrenced table data */
        projectfeature.setVersion(6);
        projectfeature.setBuild(4);
        projectfeature.setFeatureShortName("d4jrGKteQHB0Oy9afpyDfjsD5wRFpFl7av7EAwGMeFs8dIxlmO");
        projectfeature.setDateOfCreation(new java.sql.Date(123456789));
        projectfeature.setFeatureDescription("GxWlVYmVYUc2Fe20j2y7ST1gQSwx800rdLI74JBiAMqZCmM1OQ");
        projectfeature.setFeatureName("8HU6y9jEtaoNsFqqHTrCJ7SwVaDna1ThssF5b4uP3oK4VOsO9m");
        projectfeature.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<FeatureUserMapping> listOfFeatureUserMapping = new java.util.ArrayList<FeatureUserMapping>();
        FeatureUserMapping featureusermapping = new FeatureUserMapping();
        featureusermapping.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        featureusermapping.setModuleId((java.lang.String) ProjectModuleTest._getPrimarykey()); /* ******Adding refrenced table data */
        featureusermapping.setProjectFeature(projectfeature);
        featureusermapping.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey());
        featureusermapping.setIsAdmin(true);
        listOfFeatureUserMapping.add(featureusermapping);
        projectfeature.addAllFeatureUserMapping(listOfFeatureUserMapping);
        projectfeature.setEntityValidator(entityValidator);
        return projectfeature;
    }

    @Test
    public void test1Save() {
        try {
            ProjectFeature projectfeature = createProjectFeature();
            projectfeature.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            projectfeature.isValid();
            projectfeatureRepository.save(projectfeature);
            map.put("ProjectFeaturePrimaryKey", projectfeature._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private ProjectModuleRepository<ProjectModule> projectmoduleRepository;

    @Autowired
    private CreateProjectRepository<CreateProject> createprojectRepository;

    @Autowired
    private ProjectAccessRightsRepository<ProjectAccessRights> projectaccessrightsRepository;

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProjectFeaturePrimaryKey"));
            ProjectFeature projectfeature = projectfeatureRepository.findById((java.lang.String) map.get("ProjectFeaturePrimaryKey"));
            projectfeature.setVersion(5);
            projectfeature.setBuild(4);
            projectfeature.setFeatureShortName("k9jDv7FfF193iOQxEYdrjbAboTM70qwpYcv7FHgu7kMzOw2tXd");
            projectfeature.setDateOfCreation(new java.sql.Date(123456789));
            projectfeature.setFeatureDescription("h7sLYJEm5dksZQHYOfLieRLgDQ2L1C2BnJDzSnArBQtjE5vrzy");
            projectfeature.setFeatureName("ydHIFTQoUThetqGpIwu9QwbOGBJsVa5WN5y56cUvdbUuKjm5zJ");
            projectfeature.setVersionId(1);
            projectfeature.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            projectfeatureRepository.update(projectfeature);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBymoduleId() {
        try {
            java.util.List<ProjectFeature> listofmoduleId = projectfeatureRepository.findByModuleId((java.lang.String) map.get("ProjectModulePrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProjectFeaturePrimaryKey"));
            projectfeatureRepository.findById((java.lang.String) map.get("ProjectFeaturePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByprojectId() {
        try {
            java.util.List<ProjectFeature> listofprojectId = projectfeatureRepository.findByProjectId((java.lang.String) map.get("CreateProjectPrimaryKey"));
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProjectFeaturePrimaryKey"));
            projectfeatureRepository.delete((java.lang.String) map.get("ProjectFeaturePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateProjectFeature(EntityTestCriteria contraints, ProjectFeature projectfeature) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            projectfeature.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            projectfeature.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            projectfeatureRepository.save(projectfeature);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "featureName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "featureName", "7XPZPk7HSCpnByhNH5MS50GxqqiQv4u7WXo97tzirilzz94HS98jccr1DRkyw7Lrapjy63vNmmr2C1mkBuisgID24wAxcyoWy56t8BUBIWu2opCgixUIBUBQtzSJpE91S"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "featureShortName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "featureShortName", "LXGKDUbR9Kbl1H2WDZ5AgLEwA6q7mE7ZlaUVoRWD5rfTNQu7E1g8gQBRfo6a0FpXR"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "featureDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "featureDescription", "S5JXT6Q24IiCarBtqJOq5cEFPVEkY6E9zM9OZay71gvRfcUqS2bqBMxOPzT157Od8MFlhSK1o3SvSmWPxdULS4fkcw0cV0a6jVLtPLEwGH2abm27wOknbs4Z9WtHckyIuZlRODYeZgmg9zmu2DDbBQwjePB1k1GXSQztbRca106CR8Ovs44KM0SYmvQlOyka5yI2DBUdZff91g4oFfAubIjMvSyFfnUMfrO06enFfjPyDk8d0GpNn5jaTN9L5TdZ8"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 7, "version", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "version", 16));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 9, "build", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "build", 16));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "dateOfCreation", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                ProjectFeature projectfeature = createProjectFeature();
                java.lang.reflect.Field field = projectfeature.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(projectfeature, null);
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 2:
                        projectfeature.setFeatureName(contraints.getNegativeValue().toString());
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(projectfeature, null);
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 4:
                        projectfeature.setFeatureShortName(contraints.getNegativeValue().toString());
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(projectfeature, null);
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 6:
                        projectfeature.setFeatureDescription(contraints.getNegativeValue().toString());
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 7:
                        field.setAccessible(true);
                        field.set(projectfeature, null);
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 8:
                        projectfeature.setVersion(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 9:
                        field.setAccessible(true);
                        field.set(projectfeature, null);
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 10:
                        projectfeature.setBuild(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateProjectFeature(contraints, projectfeature);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(projectfeature, null);
                        validateProjectFeature(contraints, projectfeature);
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
