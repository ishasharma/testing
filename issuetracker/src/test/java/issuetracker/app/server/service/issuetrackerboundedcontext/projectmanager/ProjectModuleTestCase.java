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
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectModuleRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectModule;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class ProjectModuleTestCase extends EntityTestCriteria {

    @Autowired
    private ProjectModuleRepository<ProjectModule> projectmoduleRepository;

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

    private ProjectModule createProjectModule() throws SpartanPersistenceException, SpartanConstraintViolationException {
        CreateProject createproject = new CreateProject();
        ProjectAccessRights projectaccessrights = new ProjectAccessRights();
        projectaccessrights.setProjectAccessName("oalDEQWmcmlUUfW23qKgOIqfSbrGeOLIDT56UFv1nChYxl3Jy9");
        projectaccessrights.setProjectAccessDesc("D36LolDwqwrA2zzgytH5GpsdZjhbhuDGQ9KU5qV5g9ZEtdGoI4");
        ProjectAccessRights ProjectAccessRightsTest = projectaccessrightsRepository.save(projectaccessrights);
        map.put("ProjectAccessRightsPrimaryKey", projectaccessrights._getPrimarykey());
        createproject.setProjectAccessCode((java.lang.String) ProjectAccessRightsTest._getPrimarykey()); /* ******Adding refrenced table data */
        createproject.setProjectShortName("5wEtb0PkkNKtejwgILDzBPZs0hZfkKrr7mihJIeOFAbNj5oESI");
        createproject.setDateOfCreation(new java.sql.Date(123456789));
        createproject.setBuild("b750YTfaEHo1Lg4ZTQpEWZarZ36SFcx4GyyvDKxbrM38jp9L9E");
        createproject.setVersion("NhqJ3MaD2AZSTfNAHfErL1TIy93TKQTLQszHTqF3s0f4i8p8WX");
        createproject.setProjectName("n37mXwL3GQV7XiVQ4OI57spgzoqDp1ACYdhfNXJyvE0bFSsHoQ");
        createproject.setProjectDescription("sUBHRILkfO5FkJSLBaenfXnPCy7eOERLAzCuVLyW8PQR83J1q6");
        createproject.setProjectURL("lpXmDQGb3O6ZoIIrny4AmqCPdhtxu2lpZBCAJEnqIemLBL0QEo");
        java.util.List<ProjectUserMapping> listOfProjectUserMapping = new java.util.ArrayList<ProjectUserMapping>();
        ProjectUserMapping projectusermapping = new ProjectUserMapping();
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setFirstName("2zY2wI7R4eCGBNt7bjIdDionhSKumeMwW5G8Q1dN0buHQuEYlX");
        corecontacts.setMiddleName("MieLak4bFybZs6ncgKc3T9PD5Q7KOJ23SdO09kX5F3sjpxU1yS");
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("YyBHRuYQmtdY1QxSTVF3YuJlJEV9jG04JJyU5QfDmWEzF5wgeF");
        timezone.setTimeZoneLabel("JgBvytczHPtyOu5kUIPM68XbVkuEz5xW3ZxH77iF2iUdiiDlAH");
        timezone.setCountry("vfk1AdG8iBqmhYyUdUEcCu4IxfbdUHDk6NCEssEmApic1SjtNz");
        timezone.setCities("Mfje3Luf5BDOjX6LN8T2ZE88El8ctPHwSegMb83A1mMfMihzIW");
        timezone.setUtcdifference(9);
        Title title = new Title();
        title.setTitles("CZ4KS52bccL7DObd1XVzuhuDcUuMMUXeVBMsoKuo9W4inLCxcN");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("Wht0pgacnTcdazlJIOoyb0qrQIBRekGhLWF42bKOa3aEtK9PKT");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setLanguage("z4AoK4GbVCG9jrbiszt8AyKzgrUTJenMLb1j9Z9j6hmHN9WQEE");
        language.setAlpha4parentid(4);
        language.setAlpha2("7z");
        language.setLanguageIcon("APkLYV5Mm6wJQeC96UNMHEM3gLJ5648S20FrN1r3PVJrYWzRye");
        language.setAlpha4("DUzS");
        language.setAlpha3("pAu");
        language.setLanguageType("tjJvnKyy1Y4dGIRizJwbgkJ4WaxiVFaL");
        language.setLanguageDescription("xSt88oks3XxkzWs7OxXThMlg4tXFO1h2DfQjUS99Dz6jJqlYcf");
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        corecontacts.setFirstName("qKQNifHw7BUN0FI8AxFvdLqdf8UazRNTb4fpY4T1q3LyW7dQ0G");
        corecontacts.setMiddleName("xJFOSmxiVvZx5PyfRPNQpnIku4MGwFkxZn0vXyjvRn5D7WwNz9");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setNativeLastName("wYVYe9pOLPlvpqvSKS28dgD5m75g2AhOsOcvj88U65zPv8W2rM");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458127870910l));
        corecontacts.setAge(89);
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("H3VsT3gs3dd41EyhRXPze0ciRa2EUVoG1oEpGwvFBg8pklNMIt");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("zc076yN7Avz5W4rFOJS6EufbYPzioxch4iKFLEANdOR0epP3J1");
        corecontacts.setPhoneNumber("GqEu2iqkH5R7rwVxBUUx");
        corecontacts.setEmailId("Lf98tH99j6ujc2vtAV2fa8RaDqVdukPp90nKqw7Uqgugnq2Lwy");
        corecontacts.setNativeMiddleName("u7mLaplcWKjrmUQbbanvCgwK53ygbsAwvZ4kJACT4YXtAjimdy");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458127870992l));
        corecontacts.setNativeTitle("Vv1yApurUUOJhCSgw2jXA7wdaxQ09oWjNxRZm8H24N3rdtzU5L");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        Country country = new Country();
        country.setCountryName("Kb6PDPlhSBDBFqgVQTr2EkSYX9WOLkz3OfACn5wpmSeE8ZzGAs");
        country.setCountryCode1("N0H");
        country.setCapitalLongitude(10);
        country.setCurrencyName("rWSLhy2ooIafIYHof5evokzFHxWfa2pyoHvhv9xiRNW0JthRt5");
        country.setCurrencyCode("qKK");
        country.setCountryFlag("9OzGnAQNM9BBy2mVX2TgWPStDvdOMYFDpi1X7EsKU3MEEnuXgq");
        country.setIsoNumeric(2);
        country.setCapitalLatitude(9);
        country.setCapital("49lXvrhWJneF4lYPT1yBjbBMbsNCfyIQ");
        country.setCountryCode2("UVB");
        country.setCurrencySymbol("LPmDoDZ17bmu8IOkazqp80Ucd4nBj6XX");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        City city = new City();
        city.setCityFlag("wZENp83eDXimCsI4H9hheiNrvuofVX7TCBMZMQrt7SA3fMao6r");
        city.setCityLongitude(7);
        city.setCityLatitude(8);
        city.setCityDescription("OCjsTc6bCmsI69Lq18cefukhcDBWZKVEDvG0ZwEmHw877kmFnO");
        city.setCityCode(1);
        city.setCityName("ICa56xpq8zM1BRFYoJVsAGtszPjWLvBtwIrhGGxEGXVmMGgkkA");
        State state = new State();
        state.setStateCodeChar2("gBnSb3nUD68PgRe1eoWKhTOtHO11ImpO");
        state.setStateCapitalLongitude(10);
        state.setStateCodeChar3("9mNAomoXCGaaiQ5mZDHFvLWhDa1nqCSw");
        state.setStateCodeChar2("cLDmuisRdY0GQalQosB7GXpsssKAycqL");
        state.setStateCapitalLongitude(6);
        state.setStateCodeChar3("5JQfSHwWM6UUBihmBBAAOTAq6fTK9Ydu");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("7Q0JuIHARHBcb9XvjyvwXUf5sbN3BTOAI6CwbrdE7NYxVdyDOh");
        state.setStateFlag("jMVgUh8N3ibJ9DiZz70LSE8tCFekJuiOAvcXxySbDVU2uhla4f");
        state.setStateCapital("TZF5GzmAyjHyUmfd6odpswAjVljRoCSXPodd8YJ8CpdO8BJvVQ");
        state.setStateCapitalLatitude(10);
        state.setStateDescription("EJf8B99YCnL5tF5ScuOKoHLjFl8q7RbVu1xfl3imAF0cszdYr9");
        state.setStateCode(2);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        city.setCityFlag("kndE5ikmDO6r3L5Prn3P3Su7l3Jf6edff9VdhYtL1hywlQ3qBo");
        city.setCityLongitude(9);
        city.setCityLatitude(4);
        city.setCityDescription("5OVhyKknvbuOraJDaKTbAQPVtgIQMDtY5CJHCmAy3GfyMdJVpH");
        city.setCityCode(3);
        city.setCityName("zXqtbIzWYGKQg7usKQT6mhtcLIs0KxYdnPVoMtwCAydQ3oDTER");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("bvwyO6jVEZO2pmoTNpv3orDeuIluGcRZ");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("wpB9hEqBFdcz1BjUmjBw6ax4ulPGeLidgFR59GcYbR5pg5ThlI");
        addresstype.setAddressTypeDesc("YbIPfBveCRJCUmL05MYHvCy0vTuzREwQgk8vIsU7zhrshgiW8F");
        addresstype.setAddressType("Gi7qO8q34ZykqPGHK2orva4mVCyg0Z1uOkXxIdxlMKcH3Ph1kt");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("JwlVod8DU34F3HLAp3gMwEVbKbMfJ7CjZx2L7eiZPVYXmqnsqU");
        address.setAddress1("tCwhTc9LlnnBUdkddFPr7r6RHE2XFP2qnH8IxGdvErklyOYCSy");
        address.setLatitude("d5mhFjsdHb2iN1zwT2KvMdN2JrTK0YLsjeHGgYFYsp0wRilwah");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("kFmHkS");
        address.setAddress2("rlQAfZ2lnojP0Zrzb4yNOyU1JbErJURYpKbpLwCxSIRRa8cjaM");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("aVmm8DmZIL6");
        address.setAddress3("JUXyAjfw8yUOr199whWK25F2RdvQQUXqYU3D6joRYr8T6x7Tvm");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("QmhdK2eQkVmu0FlSq7TPzVWoBPaAO5dT8OPd4et2rOfnWEqbXc");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("HnKRwLiYoAKrgLJZYZD1KtBg6BG5CATJW0vQggQcXyryrqa9uZ");
        communicationgroup.setCommGroupName("vevKYkuB5YDEvixDYdmyMnyL3ZN9vdihAPFObWdw3r3QX5XWOn");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("VH5BddsJKTLyAclzJyj5WptHo4yezPwZT8Ltg2R0l3U6dloJcK");
        communicationtype.setCommTypeName("Y6bKTP5PJ5sgGEwekBv7w5eN996FxR07kBMSB418fwYnmLGNHb");
        communicationtype.setCommTypeDescription("PaKlJ8TGxIq2dq0SEEjigp6P3r0aFGIpe9jzeN7k4OztLidFlf");
        communicationtype.setCommTypeName("gCoy5VyvUg32bTORfsdY3pkJ6q8PYuqHEty0mEH7i09obkqM22");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommData("kLhbtHsdfv8f44fMHQDdHAzyi3htVppBGDMBrHdeDO81693XQe");
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
        ProjectModule projectmodule = new ProjectModule();
        projectmodule.setDateOfCreation(new java.sql.Date(123456789));
        projectmodule.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        projectmodule.setModuleShortName("CMJoPylyA5dehmaQHTY6OtUnYIz6uAmSuzSpzsNCuHhbcGwa9l");
        projectmodule.setModuleName("NpZJvwtw2LS9Lz7U3twYbzY7griwkyzMORBB47Skt9j0vg4Eam");
        projectmodule.setVersion("KQHcjJZsQsmcqCXJ1WPpdJAy0iMeIBhvxuISeZKe0aRjiTNrLf");
        projectmodule.setBuild("XZq7PDuNwj13lDBoViDnkGUdZu7zezOfq068VqWFmg0lf6KzOa");
        projectmodule.setModuleDescription("sjUU1x7tKk9HEid901EEis7C8H0Cu5UNE3RQbDpeWglr7M4eLN");
        java.util.List<ModuleUserMapping> listOfModuleUserMapping = new java.util.ArrayList<ModuleUserMapping>();
        ModuleUserMapping moduleusermapping = new ModuleUserMapping();
        moduleusermapping.setIsAdmin(true);
        moduleusermapping.setIsAdmin(true);
        moduleusermapping.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        moduleusermapping.setProjectModule(projectmodule);
        moduleusermapping.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey());
        listOfModuleUserMapping.add(moduleusermapping);
        projectmodule.addAllModuleUserMapping(listOfModuleUserMapping);
        projectmodule.setEntityValidator(entityValidator);
        return projectmodule;
    }

    @Test
    public void test1Save() {
        try {
            ProjectModule projectmodule = createProjectModule();
            projectmodule.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            projectmodule.isValid();
            projectmoduleRepository.save(projectmodule);
            map.put("ProjectModulePrimaryKey", projectmodule._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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
            org.junit.Assert.assertNotNull(map.get("ProjectModulePrimaryKey"));
            ProjectModule projectmodule = projectmoduleRepository.findById((java.lang.String) map.get("ProjectModulePrimaryKey"));
            projectmodule.setDateOfCreation(new java.sql.Date(123456789));
            projectmodule.setModuleShortName("2eaWNWbBcKl21IMLuOyxlm1LDDQvMIFP6nsSfjvGGLPBzJFXog");
            projectmodule.setModuleName("5iGfINEK2w58oyQwgiSiNxurjAYJVjcll7EgldZA1chBIsHB5i");
            projectmodule.setVersion("oqGCz3pzzoKxdNqdAAwlDB32yepbkNtJMDgQLj5yoXx9egOGhL");
            projectmodule.setBuild("x1cF50ughMS8ifuuKK9oYgIk35DqcWFWGAnqb2Ls5EVNfYGII8");
            projectmodule.setModuleDescription("GIOMTZkR7H0inVJdw5HM1uT8lElZ4hKr7wbHcnk2WSYWcc4ymo");
            projectmodule.setVersionId(1);
            projectmodule.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            projectmoduleRepository.update(projectmodule);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByprojectId() {
        try {
            java.util.List<ProjectModule> listofprojectId = projectmoduleRepository.findByProjectId((java.lang.String) map.get("CreateProjectPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("ProjectModulePrimaryKey"));
            projectmoduleRepository.findById((java.lang.String) map.get("ProjectModulePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProjectModulePrimaryKey"));
            projectmoduleRepository.delete((java.lang.String) map.get("ProjectModulePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateProjectModule(EntityTestCriteria contraints, ProjectModule projectmodule) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            projectmodule.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            projectmodule.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            projectmoduleRepository.save(projectmodule);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "moduleName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "moduleName", "K0iDSXrAukIK4iV77tfolwNVpKmNFKwrtbMqB16WG3avGKBTwYb39tU1wb76oMZYQoT1ElpiUFyCioCmWCkQCce35gfC253f1xbJ8kh8WgCxjC7TUogX7MhAOMi3tEVHl"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "moduleShortName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "moduleShortName", "WtDHuMEiQegAIDaQVVhnReb4C80mVkE2ttIhq2GzP66Mt2FyWOaaoPSzxV0kIrPcu"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "moduleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "moduleDescription", "M1orsrEqO7biMaDpZreynEWsMW7UPhAaI5ILjdJaaoDaQBBelg5YNFtUU1ZV3nHZ097BqU6u5WP6QwUpukvNCDY55lZXohj9SFD83sQ8RMdoWdZcFIyLV5F9270s1mSjVwgkvuFepfstqTZcq0DTNpEc9AqjVqzfcTiOLK2sNh93502GVRO5NO2AKvQ5rqItBBavuJ1dMfIDFQMByWm4zj6AwnjbgDwuclkHw6cEiWkOwMoBlmK198Tk3an3r97G5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "version", "fztQg0K0bTGXUVMm6KoiHFkYxieBLjjamVqCEw9PbOtJzrKHppogzdJb1rxYoFmtV"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "build", "98L6EdtYJD9Dw428qkfKJfkvZWnAmdIjSImLm88NpmAENj7TV3yi7nFCKD6n04U9G"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                ProjectModule projectmodule = createProjectModule();
                java.lang.reflect.Field field = projectmodule.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(projectmodule, null);
                        validateProjectModule(contraints, projectmodule);
                        failureCount++;
                        break;
                    case 2:
                        projectmodule.setModuleName(contraints.getNegativeValue().toString());
                        validateProjectModule(contraints, projectmodule);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(projectmodule, null);
                        validateProjectModule(contraints, projectmodule);
                        failureCount++;
                        break;
                    case 4:
                        projectmodule.setModuleShortName(contraints.getNegativeValue().toString());
                        validateProjectModule(contraints, projectmodule);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(projectmodule, null);
                        validateProjectModule(contraints, projectmodule);
                        failureCount++;
                        break;
                    case 6:
                        projectmodule.setModuleDescription(contraints.getNegativeValue().toString());
                        validateProjectModule(contraints, projectmodule);
                        failureCount++;
                        break;
                    case 7:
                        projectmodule.setVersion(contraints.getNegativeValue().toString());
                        validateProjectModule(contraints, projectmodule);
                        failureCount++;
                        break;
                    case 8:
                        projectmodule.setBuild(contraints.getNegativeValue().toString());
                        validateProjectModule(contraints, projectmodule);
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
